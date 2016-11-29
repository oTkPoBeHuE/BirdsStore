package gui.components;

import gui.utils.Settings;

import javax.swing.*;

public class PasswordFieldBox {
    public JPasswordField jPasswordField;
    public JLabel jLabel;
    public Box box;

    public PasswordFieldBox(String labelText, int minPasswordLength) {
        box = Box.createHorizontalBox();
        jPasswordField = new JPasswordField(minPasswordLength);
        jLabel = new JLabel(labelText);
        box.add(jLabel);
        box.add(Box.createHorizontalStrut(6));
        box.add(jPasswordField);
    }
}
