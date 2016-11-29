package gui.components;

import gui.utils.Settings;
import gui.utils.StringConstants;

import java.awt.event.ActionListener;

/**
 * Created by oTk on 29.11.2016.
 */
public final class StdComponents {
    private StdComponents(){};

    public static TextFieldBox  getUsernameBox(){
        return new TextFieldBox(StringConstants.USERNAME , Settings.USERNAME_MAX_LENGTH);
    }

    public static PasswordFieldBox getPasswordFieldBox(){
       return new PasswordFieldBox(StringConstants.PASSWORD, Settings.PASSWORD_MAX_LENGTH);
    }

    public static ButtonBox getButtonBox(String leftButtonText, ActionListener leftButtonActionListener, ActionListener rightButtonActionListener){
        return new ButtonBox(
                leftButtonText,
                leftButtonActionListener,
                StringConstants.CANCEL,
                rightButtonActionListener);
    }

    public static TextFieldBox getMoneyBox(){
        return new TextFieldBox(StringConstants.MONEY, Settings.MONEY_MAX_CHAR_LENGTH);
    }

    public static TextFieldBox getProductNameBox(){
        return new TextFieldBox(StringConstants.PRODUCT_NAME, Settings.PRODUCT_NAME_MAX_LENGTH);
    }

    public static TextFieldBox getCountBox() {
        return new TextFieldBox(StringConstants.COUNT, Settings.COUNT_MAX_CHAR_LENGTH);
    }
}
