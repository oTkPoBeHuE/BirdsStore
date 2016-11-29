package gui.users;

import exceptions.UserException;
import gui.components.ButtonBox;
import gui.components.PasswordFieldBox;
import gui.components.StdComponents;
import gui.components.TextFieldBox;
import gui.utils.GuiUtilities;
import gui.utils.StringConstants;
import services.UserService;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

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
        loginBox = StdComponents.getUsernameBox();
        passwordFieldBox = StdComponents.getPasswordFieldBox();

        buttonBox = StdComponents.getButtonBox(
                StringConstants.CREATE,
                e -> addUser(loginBox.jTextField.getText(),
                        passwordFieldBox.jPasswordField.getPassword()),
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
        try {
            UserService.addUser(username, String.valueOf(password));
        } catch (UserException e) {
            GuiUtilities.printErrorMessage(e);
        } catch (Exception e) {
            GuiUtilities.printErrorMessage(e);
        }
    }


}
