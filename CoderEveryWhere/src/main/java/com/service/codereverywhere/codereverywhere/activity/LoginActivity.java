package com.service.codereverywhere.codereverywhere.activity;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import com.github.johnpersano.supertoasts.SuperToast;
import com.service.codereverywhere.codereverywhere.BaseActivity;
import com.service.codereverywhere.codereverywhere.R;

public class LoginActivity extends BaseActivity implements View.OnClickListener {

    private Button _weiboButton;
    private Button _weixinButton;
    private Button _emailSignupButton;
    private Button _serviceTermsButton;
    private Button _loginButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    @Override
    public void onClick(View v) {
        Intent i = null;
        if (v.equals(_weiboButton)) {

        } else if (v.equals(_weixinButton)) {

        } else if (v.equals(_emailSignupButton)) {
            i = new Intent(LoginActivity.this, SignupActivity.class);
            overridePendingTransition(R.anim.hold, R.anim.in_from_bottom);
        } else if (v.equals(_serviceTermsButton)) {
            i = new Intent(LoginActivity.this, ServiceTermsActivity.class);
            i.putExtra("from", "login");
            overridePendingTransition(R.anim.hold, R.anim.in_from_bottom);
        } else if (v.equals(_loginButton)) {
            i = new Intent(LoginActivity.this, EmailLoginActivity.class);
            overridePendingTransition(R.anim.hold, R.anim.in_from_bottom);
        }

        if (i != null) {
            startActivity(i);
        }
    }

    @Override
    protected int getLayout() {
        return R.layout.activity_login;
    }

    @Override
    protected void generateUIComponents() {
        _weiboButton = (Button) findViewById(R.id.weiboSigninButton);
        _weixinButton = (Button) findViewById(R.id.weixinSignupButton);
        _emailSignupButton = (Button) findViewById(R.id.emailSignupButton);
        _serviceTermsButton = (Button) findViewById(R.id.serviceTermsButton);
        _loginButton = (Button) findViewById(R.id.loginButton);

        _weiboButton.setOnClickListener(this);
        _weixinButton.setOnClickListener(this);
        _emailSignupButton.setOnClickListener(this);
        _serviceTermsButton.setOnClickListener(this);
        _loginButton.setOnClickListener(this);
    }
}
