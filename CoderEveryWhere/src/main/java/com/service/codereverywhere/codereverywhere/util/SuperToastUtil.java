package com.service.codereverywhere.codereverywhere.util;

import com.service.codereverywhere.codereverywhere.Application.MainApplication;
import android.app.Activity;
import com.service.codereverywhere.codereverywhere.R;
import com.github.johnpersano.supertoasts.SuperActivityToast;
import com.github.johnpersano.supertoasts.SuperCardToast;
import com.github.johnpersano.supertoasts.SuperToast;
import com.github.johnpersano.supertoasts.SuperToast.Animations;
import com.github.johnpersano.supertoasts.SuperToast.IconPosition;
import com.github.johnpersano.supertoasts.util.OnClickWrapper;

/**
 * Created by uncle_charlie on 30/9/15.
 */
public class SuperToastUtil {
    // SuperToast
    static final Animations SUPER_TOAST_ANIMATION = SuperToast.Animations.POPUP;
    static final int SUPER_TOAST_DURATION = SuperToast.Duration.MEDIUM;
    static final int SUPER_TOAST_BACKGROUND = SuperToast.Background.GRAY;
    static final int SUPER_TOAST_TEXT_SIZE = SuperToast.TextSize.MEDIUM;

    // Toast
    static final int TOAST_DEFAULT_ICON = R.drawable.icon_toast;
    static final IconPosition TOAST_ICON_POSITION = SuperToast.IconPosition.LEFT;

    // ActivityToast
    static final int ACTIVITY_TOAST_DEFAULT_ICON = SuperToast.Icon.Light.SHARE;

    // CardToast
    public static final int CARD_TOAST_DISMISS_TYPE_SWIPE = 0;
    public static final int CARD_TOAST_DISMISS_TYPE_TOUCH = 1;

    private static SuperToast toast;
    private static SuperActivityToast activityToast;
    private static SuperCardToast cardToast;

    // 初始化
    private static void initToast() {
        if (toast == null) {
            toast = new SuperToast(MainApplication.getApplicationInstance().getApplicationContext());
            toast.setAnimations(SUPER_TOAST_ANIMATION);
            toast.setBackground(SUPER_TOAST_BACKGROUND);
            toast.setDuration(SUPER_TOAST_DURATION);
            toast.setTextSize(SUPER_TOAST_TEXT_SIZE);
        }
    }

    // 初始化(Activity类型)
    private static void initActivityToast() {
        if (activityToast == null) {
            activityToast = new SuperActivityToast((Activity) MainApplication.getApplicationInstance().getApplicationContext(), SuperToast.Type.BUTTON);
            activityToast.setAnimations(SUPER_TOAST_ANIMATION);
            activityToast.setBackground(SUPER_TOAST_BACKGROUND);
            activityToast.setDuration(SUPER_TOAST_DURATION);
            activityToast.setTextSize(SUPER_TOAST_TEXT_SIZE);
        }
    }

    // 初始化(Card类型)
    private static void initCardToast() {
        if (cardToast == null) {
            cardToast = new SuperCardToast((Activity) MainApplication.getApplicationInstance().getApplicationContext());
            cardToast.setAnimations(SUPER_TOAST_ANIMATION);
            cardToast.setBackground(SUPER_TOAST_BACKGROUND);
            cardToast.setDuration(SUPER_TOAST_DURATION);
            cardToast.setTextSize(SUPER_TOAST_TEXT_SIZE);
        }
    }

    /**
     * 显示一个正常的Toast
     *
     * @param context
     * @param text
     */
    public static void showNormalToasts(String text) {
        initToast();
        toast.setText(text);
        toast.show();
        toast.setIcon(TOAST_DEFAULT_ICON, TOAST_ICON_POSITION);
    }

    /**
     * 显示一个带图标的Toast 图标默认位置在左
     *
     * @param context
     * @param text
     * @param icon
     */
    public static void showNormalToasts(String text, int icon) {
        initToast();
        toast.setText(text);
        if (icon == 0)
            toast.setIcon(TOAST_DEFAULT_ICON, TOAST_ICON_POSITION);
        else
            toast.setIcon(icon, TOAST_ICON_POSITION);
        toast.show();
    }

    /**
     * 显示一个带图标并可相应按钮的Toast
     *
     * @param c
     * @param text
     * @param button_name
     * @param button_icon
     * @param icon
     * @param auto_dismiss
     * @param click
     */
    public static void showButtonToasts(String text, String button_name, int button_icon, int icon, boolean auto_dismiss, OnClickWrapper click) {
        initActivityToast();
        activityToast.setText(text);
        activityToast.setButtonText(button_name);
        if (button_icon == 0)
            activityToast.setButtonIcon(ACTIVITY_TOAST_DEFAULT_ICON);
        else
            activityToast.setButtonIcon(button_icon);
        if (icon == 0)
            activityToast.setIcon(TOAST_DEFAULT_ICON, TOAST_ICON_POSITION);
        else
            activityToast.setIcon(icon, TOAST_ICON_POSITION);
        if (click != null)
            activityToast.setOnClickWrapper(click);
        activityToast.setIndeterminate(auto_dismiss);
        activityToast.show();
    }

    /**
     * 显示一个带图标并在顶端Card型的Toast
     *
     * @param c
     * @param text
     * @param icon
     * @param dismiss
     * @param dismiss_type
     */
    public static void showCardToasts(String text, int icon, boolean dismiss, int dismiss_type) {
        initCardToast();
        cardToast.setText(text);
        if (icon == 0)
            cardToast.setIcon(TOAST_DEFAULT_ICON, TOAST_ICON_POSITION);
        else
            cardToast.setIcon(icon, TOAST_ICON_POSITION);
        if (dismiss)
            switch (dismiss_type) {
                case CARD_TOAST_DISMISS_TYPE_SWIPE:
                    cardToast.setSwipeToDismiss(true);
                    break;
                case CARD_TOAST_DISMISS_TYPE_TOUCH:
                    cardToast.setTouchToDismiss(true);
                    break;
            }
        cardToast.show();
    }

    /**
     * 关闭已显示的Toast
     */
    public static void cleanAllToasts() {
        if (toast != null && toast.isShowing())
            toast.dismiss();
        if (activityToast != null && activityToast.isShowing())
            activityToast.dismiss();
        if (cardToast != null && cardToast.isShowing())
            cardToast.dismiss();
    }
}
