package gui.components;

import gui.utils.Settings;

import javax.swing.*;

/**
 * Created by oTk on 29.11.2016.
 */
public class PasswordFieldBox {
    public JPasswordField jPasswordField;
    public JLabel jLabel;
    public Box box;

    public PasswordFieldBox(String labelText, int maxPasswordLenght) {
        box = Box.createHorizontalBox();
        jPasswordField = new JPasswordField(Settings.PASSWORD_MAX_LENGTH);
        jLabel = new JLabel(labelText);
        box.add(jLabel);
        box.add(Box.createHorizontalStrut(6));
        box.add(jPasswordField);
    }
}
