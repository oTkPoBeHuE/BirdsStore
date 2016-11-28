package gui.users;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

/**
 * Created by oTk on 28.11.2016.
 */
public class AddUserWindow  extends JFrame {
    public AddUserWindow() {
        super("Add User");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        init();
    }

    private void init(){
        setContentPane(getMainBox());
        pack();
        setResizable(false);
    }

    private Box getMainBox(){
        Box  mainBox = Box.createVerticalBox();
        mainBox.setBorder(new EmptyBorder(12,12,12,12));
        mainBox.add(getLoginBox());
        mainBox.add(Box.createVerticalStrut(12));
        mainBox.add(getPasswordBox());
        mainBox.add(Box.createVerticalStrut(17));
        mainBox.add(getButtonBox());

        return  mainBox;
    }

    private Box getLoginBox(){
        Box loginBox = Box.createHorizontalBox();

        JLabel loginLabel  = new JLabel("Username :"); // TODO: const;
        JTextField loginField = new JTextField(15);

        loginBox.add(loginLabel);
        loginBox.add(Box.createHorizontalStrut(6));   // отступ от края для кнопок
        loginBox.add(loginField);

        return loginBox;
       // loginLabel.setPreferredSize(passwordLabel.getPreferredSize());
    }

    private Box  getPasswordBox(){
        Box  passwordBox = Box.createHorizontalBox();

        JLabel passwordLabel = new JLabel("Password:"); // TODO: const;
        JPasswordField passwordField = new JPasswordField(15); // TODO: password size const;

        passwordBox.add(passwordLabel);
        passwordBox.add(Box.createHorizontalStrut(6));
        passwordBox.add(passwordField);

        return passwordBox;

    }
    private Box  getButtonBox(){
        Box buttonBox = Box.createHorizontalBox();

        JButton ok = new JButton("OK"); // TODO: const
        JButton cancel = new JButton("Cancel"); // TODO: const

        buttonBox.add(ok);
        buttonBox.add(Box.createHorizontalStrut(12));
        buttonBox.add(cancel);

        return buttonBox;
    }




}
