package com.service.codereverywhere.codereverywhere.activity;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.transition.Visibility;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.service.codereverywhere.codereverywhere.BaseActivity;
import com.service.codereverywhere.codereverywhere.R;

public class EmailLoginActivity extends BaseActivity {

    private Button _leftButton;
    private TextView _titleTextview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    protected int getLayout() {
        return R.layout.activity_email_login;
    }

    @Override
    protected void generateUIComponents() {
        RelativeLayout layoutView = (RelativeLayout)findViewById(R.id.titleLayout);
        _leftButton = (Button)layoutView.findViewById(R.id.leftButton);
        _titleTextview = (TextView)layoutView.findViewById(R.id.titleTextView);

        _leftButton.setVisibility(View.VISIBLE);
        _leftButton.setText("x");
        _titleTextview.setText(R.string.login_title);
    }
}
