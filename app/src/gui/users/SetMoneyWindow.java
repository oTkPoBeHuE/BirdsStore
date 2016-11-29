package gui.users;

import gui.components.ButtonBox;
import gui.components.TextFieldBox;
import gui.utils.Settings;
import gui.utils.StringConstants;
import services.UserService;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.text.NumberFormatter;
import java.text.NumberFormat;

/**
 * Created by oTk on 29.11.2016.
 */
public class SetMoneyWindow extends JFrame {


    TextFieldBox loginBox;
    TextFieldBox moneyBox;
    ButtonBox buttonBox;
    Box mainBox;

    public SetMoneyWindow() {
        super(StringConstants.ADD_MONEY);
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
       // setLoginBox();
      //  setMoneyBox();
       // setButtonBox();

        loginBox = new TextFieldBox(StringConstants.USERNAME , Settings.USERNAME_MAX_LENGTH);
        moneyBox = new TextFieldBox(StringConstants.MONEY , Settings.MONEY_MAX_CHAR_LENGTH);
        buttonBox = new ButtonBox(
                StringConstants.OK,
                e -> addMoney(loginBox.jTextField.getText(), moneyBox.jTextField.getText()),
                StringConstants.CANCEL,
                e -> setVisible(false));
        loginBox.jLabel.setPreferredSize(moneyBox.jLabel.getPreferredSize());

        mainBox = Box.createVerticalBox();
        mainBox.setBorder(new EmptyBorder(12, 12, 12, 12));
        mainBox.add(loginBox.box);
        mainBox.add(Box.createVerticalStrut(12));
        mainBox.add(moneyBox.box);
        mainBox.add(Box.createVerticalStrut(17));
        mainBox.add(buttonBox.box);
    }
//
//    private static NumberFormat getMoneyFormat() {
//        NumberFormat format = NumberFormat.getCurrencyInstance();
//        // format.setMaximumFractionDigits(0);
//        NumberFormatter formatter = new NumberFormatter(format);
//        formatter.setMinimum(0.01);
//        formatter.setMaximum(999999999.0);
//        formatter.setAllowsInvalid(false);
//        formatter.setOverwriteMode(true);
//        return format;
//    }


    private void addMoney(String username, String money) {
        UserService.setMoney(username, money);
    }

}
