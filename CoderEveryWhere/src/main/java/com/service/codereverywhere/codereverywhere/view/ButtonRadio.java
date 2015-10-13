package com.service.codereverywhere.codereverywhere.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import com.service.codereverywhere.codereverywhere.R;
import org.w3c.dom.Attr;

import java.util.ArrayList;

/**
 * Created by uncle_charlie on 5/10/15.
 */
public class ButtonRadio extends LinearLayout implements View.OnClickListener {
    private Button _leftButton;
    private Button _rightButton;
    private ButtonRadioClickListener _buttonRadioListener;

    public ButtonRadio(Context context) {
        this(context, null);
    }

    public ButtonRadio(Context context, AttributeSet attrs) {
        super(context, attrs);
        LayoutInflater.from(context).inflate(R.layout.button_radio, this, true);

        _leftButton = (Button) findViewById(R.id.leftButton);
        _leftButton.setOnClickListener(this);
        _rightButton = (Button) findViewById(R.id.rightButton);
        _rightButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.equals(_leftButton)) {
            _rightButton.setBackgroundColor(getResources().getColor(R.color.white));
            _leftButton.setBackgroundColor(getResources().getColor(R.color.gender_button_background));
            _buttonRadioListener.onButtonRadioClicked(0);

        } else if (v.equals(_rightButton)) {
            _leftButton.setBackgroundColor(getResources().getColor(R.color.white));
            _rightButton.setBackgroundColor(getResources().getColor(R.color.gender_button_background));
            _buttonRadioListener.onButtonRadioClicked(1);
        }
    }

    public void setLeftButtonText(String leftText) {
        _leftButton.setText(leftText);
    }

    public void setRightButtonText(String rightText) {
        _rightButton.setText(rightText);
    }

    public void setButtonRadioListener(ButtonRadioClickListener callback) {
        _buttonRadioListener = callback;
    }

    public interface ButtonRadioClickListener {
        void onButtonRadioClicked(int clickIndex);
    }
}
