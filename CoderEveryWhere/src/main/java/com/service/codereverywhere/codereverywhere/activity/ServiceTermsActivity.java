package com.service.codereverywhere.codereverywhere.activity;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import com.service.codereverywhere.codereverywhere.BaseActivity;
import com.service.codereverywhere.codereverywhere.R;

public class ServiceTermsActivity extends BaseActivity implements View.OnClickListener {

    private RelativeLayout _commonTitleLayout;
    private Button _leftButton;
    private Button _rightButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public void onClick(View v) {
        Intent i = getIntent();
        String from = i.getStringExtra("from");
        if (from.equals("login")) {
            Intent loginIntent = new Intent(ServiceTermsActivity.this, LoginActivity.class);
            startActivity(loginIntent);
        } else {
            Intent signupIntent = new Intent(ServiceTermsActivity.this, SignupActivity.class);
            startActivity(signupIntent);
        }
    }

    @Override
    protected int getLayout() {
        return R.layout.activity_service_terms;
    }

    @Override
    protected void generateUIComponents() {
        _commonTitleLayout = (RelativeLayout) findViewById(R.id.commonTitleView);
        _leftButton = (Button) _commonTitleLayout.findViewById(R.id.leftButton);
        _leftButton.setVisibility(View.VISIBLE);
        _leftButton.setText("x");
        _rightButton = (Button) _commonTitleLayout.findViewById(R.id.rightButton);
        _rightButton.setVisibility(View.VISIBLE);
        _rightButton.setText("Create");

        _leftButton.setOnClickListener(this);
        _rightButton.setOnClickListener(this);
    }
}
