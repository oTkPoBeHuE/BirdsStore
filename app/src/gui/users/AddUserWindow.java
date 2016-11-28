package gui.users;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

/**
 * Created by oTk on 28.11.2016.
 */
public class AddUserWindow  extends JFrame {
    private Box loginBox;
    private Box passwordBox;
    private Box buttonBox;

    private Box mainBox;

    public AddUserWindow() {
        super("Add User");
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        setLoginBox();
        setPasswordBox();
        setButtonBox();
        setMainBox();
    }

    private void setLoginBox(){
        loginBox = Box.createHorizontalBox();

        JLabel loginLabel  = new JLabel("Username :"); // TODO: const;
        JTextField loginField = new JTextField(15);

        loginBox.add(loginLabel);
        loginBox.add(Box.createHorizontalStrut(6));   // отступ от края для кнопок
        loginBox.add(loginField);

       // loginLabel.setPreferredSize(passwordLabel.getPreferredSize());
    }

    private void setPasswordBox(){
        passwordBox = Box.createHorizontalBox();

        JLabel passwordLabel = new JLabel("Password:"); // TODO: const;
        JPasswordField passwordField = new JPasswordField(15); // TODO: password size const;

        passwordBox.add(passwordLabel);
        passwordBox.add(Box.createHorizontalStrut(6));
        passwordBox.add(passwordField);

    }
    private void setButtonBox(){
        buttonBox = Box.createHorizontalBox();

        JButton ok = new JButton("OK"); // TODO: const
        JButton cancel = new JButton("Cancel"); // TODO: const

        buttonBox.add(ok);
        buttonBox.add(Box.createHorizontalStrut(12));
        buttonBox.add(cancel);
    }

    private void setMainBox() {
        mainBox = Box.createVerticalBox();
        mainBox.setBorder(new EmptyBorder(12,12,12,12));
        mainBox.add(loginBox);
        mainBox.add(Box.createVerticalStrut(12));
        mainBox.add(passwordBox);
        mainBox.add(Box.createVerticalStrut(17));
        mainBox.add(buttonBox);
        setContentPane(mainBox);
        pack();
        setResizable(false);
    }
}
