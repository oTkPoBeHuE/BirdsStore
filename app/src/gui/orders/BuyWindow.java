package gui.orders;

import gui.components.ButtonBox;
import gui.components.PasswordFieldBox;
import gui.components.StdComponents;
import gui.components.TextFieldBox;
import gui.utils.Settings;
import gui.utils.StringConstants;
import services.UserService;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

/**
 * Created by oTk on 29.11.2016.
 */
public class BuyWindow extends JFrame {
    TextFieldBox loginBox;
    PasswordFieldBox passwordFieldBox;

    TextFieldBox productNameBox;
    TextFieldBox countBox;

    ButtonBox buttonBox;
    Box mainBox;

    public BuyWindow() {
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
        productNameBox = StdComponents.getProductNameBox();
        countBox = StdComponents.getCountBox();

//       buttonBox = StdComponents.getButtonBox(
//               "Buy",
//               e -> null,
//               e -> setVisible(false));


        mainBox = Box.createVerticalBox();
        mainBox.setBorder(new EmptyBorder(12, 12, 12, 12));
        mainBox.add(loginBox.box);
        mainBox.add(Box.createVerticalStrut(7));
        mainBox.add(passwordFieldBox .box);
        mainBox.add(Box.createVerticalStrut(7));
        mainBox.add(productNameBox .box);
        mainBox.add(Box.createVerticalStrut(7));
        mainBox.add(countBox.box);
        mainBox.add(Box.createVerticalStrut(17));
       // mainBox.add(buttonBox.box);
    }
}
