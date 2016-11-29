package gui.users;

import gui.utils.StringConstants;
import services.UserService;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import static gui.utils.StringConstants.USERNAME;

/**
 * Created by oTk on 28.11.2016.
 */
public class AddUserWindow extends JFrame {


    JTextField loginField;
    JPasswordField passwordField;

    JLabel loginLabel;
    JLabel passwordLabel;

    JButton ok;
    JButton cancel;

    Box loginBox;
    Box passwordBox;
    Box buttonBox;
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
        setLoginBox();
        setPasswordBox();
        setButtonBox();

        loginLabel.setPreferredSize(passwordLabel.getPreferredSize());

        mainBox = Box.createVerticalBox();
        mainBox.setBorder(new EmptyBorder(12, 12, 12, 12));
        mainBox.add(loginBox);
        mainBox.add(Box.createVerticalStrut(12));
        mainBox.add(passwordBox);
        mainBox.add(Box.createVerticalStrut(17));
        mainBox.add(buttonBox);
    }

    private void setLoginBox() {
        loginBox = Box.createHorizontalBox();

        loginLabel = new JLabel(StringConstants.USERNAME); // TODO: const;
        loginField = new JTextField(15);

        loginBox.add(loginLabel);
        loginBox.add(Box.createHorizontalStrut(6));   // отступ от края для кнопок
        loginBox.add(loginField);
    }

    private void setPasswordBox() {
        passwordBox = Box.createHorizontalBox();

        passwordLabel = new JLabel(StringConstants.PASSWORD); // TODO: const;
        passwordField = new JPasswordField(15); // TODO: password size const;

        passwordBox.add(passwordLabel);
        passwordBox.add(Box.createHorizontalStrut(6));
        passwordBox.add(passwordField);
    }

    private void setButtonBox() {
        buttonBox = Box.createHorizontalBox();

        ok = new JButton(StringConstants.OK); // TODO: const
        cancel = new JButton(StringConstants.CANCEL); // TODO: const
        cancel.addActionListener(e -> setVisible(false));
        ok.addActionListener(e -> addUser(loginField.getText(), passwordField.getPassword()));
        buttonBox.add(ok);
        buttonBox.add(Box.createHorizontalStrut(12));
        buttonBox.add(cancel);
        }



    private void addUser(String username, char[] password) {
        UserService.addUser(username, String.valueOf(password));
    }


}
