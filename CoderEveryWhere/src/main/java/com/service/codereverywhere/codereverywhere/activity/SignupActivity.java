package com.service.codereverywhere.codereverywhere.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.service.codereverywhere.codereverywhere.BaseActivity;
import com.service.codereverywhere.codereverywhere.R;
import com.service.codereverywhere.codereverywhere.util.PreferenceUtil;
import com.service.codereverywhere.codereverywhere.view.ButtonRadio;

public class SignupActivity extends BaseActivity implements View.OnClickListener {

    private Button _leftButton;
    private Button _rightButton;
    private TextView _titleTextView;
    private ButtonRadio _genderButtonRadio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    @Override
    public void onClick(View v) {
        if (v.equals(_leftButton)) {
            Intent i = new Intent(SignupActivity.this, LoginActivity.class);
            startActivity(i);
//            overridePendingTransition(R.anim.in_from_bottom, R.anim.out_to_bottom);
        } else if (v.equals(_rightButton)) {
            Toast.makeText(SignupActivity.this, "Account Created", Toast.LENGTH_LONG).show();

            SharedPreferences.Editor editor = PreferenceUtil.getPreferences().edit();
            editor.putString("UserInfoLogin", "Login");
            editor.commit();

            Intent i = new Intent(SignupActivity.this, TempActivity.class);
            startActivity(i);
            finish();
        }
    }


    @Override
    protected int getLayout() {
        return R.layout.activity_signup;
    }

    @Override
    protected void generateUIComponents() {
        RelativeLayout relativeLayout = (RelativeLayout) findViewById(R.id.commonTitleView);
        _leftButton = (Button) relativeLayout.findViewById(R.id.leftButton);
        _rightButton = (Button) relativeLayout.findViewById(R.id.rightButton);
        _titleTextView = (TextView) relativeLayout.findViewById(R.id.titleTextView);

        _leftButton.setVisibility(View.VISIBLE);
        _leftButton.setText("x");
        _leftButton.setOnClickListener(this);
//
        _rightButton.setVisibility(View.VISIBLE);
        _rightButton.setText(R.string.login_create);
//        _rightButton.setBackgroundColor(getResources().getColor(R.color.create_button_background));
//        _rightButton.setTextColor(getResources().getColor(R.color.white));
        _rightButton.setOnClickListener(this);

        _genderButtonRadio = (ButtonRadio) findViewById(R.id.buttonRadio);
        _genderButtonRadio.setLeftButtonText(getResources().getString(R.string.register_male));
        _genderButtonRadio.setRightButtonText(getResources().getString(R.string.register_female));
        _genderButtonRadio.setButtonRadioListener(new ButtonRadio.ButtonRadioClickListener() {
            @Override
            public void onButtonRadioClicked(int clickIndex) {
                if (clickIndex == 0) {

                } else if (clickIndex == 1) {

                }
            }
        });

        Button termServiceButton = (Button) findViewById(R.id.termServiceButton);
        termServiceButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent termsIntent = new Intent(SignupActivity.this, ServiceTermsActivity.class);
                termsIntent.putExtra("from", "singup");
                startActivity(termsIntent);
            }
        });
    }
}
