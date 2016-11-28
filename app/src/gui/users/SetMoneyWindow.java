package gui.users;

import model.abstractstore.Money;
import services.UserService;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.text.NumberFormatter;
import java.text.NumberFormat;
import java.util.Locale;

/**
 * Created by oTk on 29.11.2016.
 */
public class SetMoneyWindow extends JFrame {
    JTextField loginField;
    JTextField moneyField;

    JLabel loginLabel;
    JLabel moneyLabel;

    JButton ok;
    JButton cancel;

    Box loginBox;
    Box moneyBox;
    Box buttonBox;
    Box mainBox;

    public SetMoneyWindow() {
        super("Add Money");
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
        setMoneyBox();
        setButtonBox();

        loginLabel.setPreferredSize(moneyLabel.getPreferredSize());

        mainBox = Box.createVerticalBox();
        mainBox.setBorder(new EmptyBorder(12, 12, 12, 12));
        mainBox.add(loginBox);
        mainBox.add(Box.createVerticalStrut(12));
        mainBox.add(moneyBox);
        mainBox.add(Box.createVerticalStrut(17));
        mainBox.add(buttonBox);
    }

    private void setLoginBox() {
        loginBox = Box.createHorizontalBox();

        loginLabel = new JLabel("Username :"); // TODO: const;
        loginField = new JTextField(15);

        loginBox.add(loginLabel);
        loginBox.add(Box.createHorizontalStrut(6));   // отступ от края для кнопок
        loginBox.add(loginField);
    }

    private void setMoneyBox() {


        moneyBox = Box.createHorizontalBox();
        moneyLabel = new JLabel("Money:"); // TODO: const;

        moneyField = new JTextField();

        moneyBox.add(moneyLabel);
        moneyBox.add(Box.createHorizontalStrut(6));
        moneyBox.add(moneyField);
    }

    private void setButtonBox() {
        buttonBox = Box.createHorizontalBox();

        ok = new JButton("OK"); // TODO: const
        cancel = new JButton("Cancel"); // TODO: const
        cancel.addActionListener(e -> setVisible(false));
        ok.addActionListener(e -> addMoney(loginField.getText(), moneyField.getText()));
        buttonBox.add(ok);
        buttonBox.add(Box.createHorizontalStrut(12));
        buttonBox.add(cancel);
    }


    private static NumberFormat getMoneyFormat(){
        NumberFormat format = NumberFormat.getCurrencyInstance();
       // format.setMaximumFractionDigits(0);
        NumberFormatter formatter = new NumberFormatter(format);
        formatter.setMinimum(0.01);
        formatter.setMaximum(999999999.0);
        formatter.setAllowsInvalid(false);
        formatter.setOverwriteMode(true);
        return format;
    }



    private void addMoney(String username, String money) {
        UserService.getInstance().setMoney(username, money);
    }

}
