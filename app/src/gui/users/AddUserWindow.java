package gui.users;

import gui.components.ButtonBox;
import gui.components.PasswordFieldBox;
import gui.components.TextFieldBox;
import gui.utils.Settings;
import gui.utils.StringConstants;
import javafx.scene.control.PasswordField;
import services.UserService;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.*;

import static gui.utils.StringConstants.USERNAME;

/**
 * Created by oTk on 28.11.2016.
 */
public class AddUserWindow extends JFrame {


    TextFieldBox loginBox;
    PasswordFieldBox passwordFieldBox;
    ButtonBox buttonBox;
    Box mainBox;

    public AddUserWindow() {
        super(StringConstants.ADD_USER);
        setDefaultCloseOperation(HIDE_ON_CLOSE);
        init();
    }

    private void init() {
        setMainBox();
        setContentPane(mainBox);
        pack();
        setResizable(false);
    }

    private void setMainBox() {
        loginBox = new TextFieldBox(StringConstants.USERNAME , Settings.USERNAME_MAX_LENGTH);
        passwordFieldBox = new PasswordFieldBox(StringConstants.PASSWORD, Settings.PASSWORD_MAX_LENGTH);

        buttonBox = new ButtonBox(
                StringConstants.CREATE,
                e -> addUser(loginBox.jTextField.getText(), passwordFieldBox.jPasswordField.getPassword()),
                StringConstants.CANCEL,
                e -> setVisible(false));

        loginBox.jLabel.setPreferredSize(passwordFieldBox.jLabel.getPreferredSize());

        mainBox = Box.createVerticalBox();
        mainBox.setBorder(new EmptyBorder(12, 12, 12, 12));
        mainBox.add(loginBox.box);
        mainBox.add(Box.createVerticalStrut(12));
        mainBox.add(passwordFieldBox.box);
        mainBox.add(Box.createVerticalStrut(17));
        mainBox.add(buttonBox.box);
    }




    private void addUser(String username, char[] password) {
        UserService.addUser(username, String.valueOf(password));
    }


}
