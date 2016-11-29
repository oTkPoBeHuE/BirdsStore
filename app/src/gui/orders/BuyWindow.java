package gui.orders;

import exceptions.AuthorisationException;
import exceptions.MoneyException;
import exceptions.ProductException;
import exceptions.UserException;
import gui.components.ButtonBox;
import gui.components.PasswordFieldBox;
import gui.components.StdComponents;
import gui.components.TextFieldBox;
import gui.utils.GuiUtilities;
import gui.utils.StringConstants;
import services.StoreService;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

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

        buttonBox = StdComponents.getButtonBox(
                "Buy",
                e -> buy(loginBox.jTextField.getText(),
                        passwordFieldBox.jPasswordField.getPassword(),
                        productNameBox.jTextField.getText(),
                        countBox.jTextField.getText())
                ,
                e -> setVisible(false));


        mainBox = Box.createVerticalBox();
        mainBox.setBorder(new EmptyBorder(12, 12, 12, 12));
        mainBox.add(loginBox.box);
        mainBox.add(Box.createVerticalStrut(7));
        mainBox.add(passwordFieldBox.box);
        mainBox.add(Box.createVerticalStrut(7));
        mainBox.add(productNameBox.box);
        mainBox.add(Box.createVerticalStrut(7));
        mainBox.add(countBox.box);
        mainBox.add(Box.createVerticalStrut(17));
        mainBox.add(buttonBox.box);
    }

    private void buy(String username, char[] password, String productName, String count) {
        try {
            int parse_count = Integer.parseInt(count);
            String pwd = String.copyValueOf(password);

            StoreService.getInstance().buy(username, pwd, productName, parse_count);
        } catch (AuthorisationException | UserException | ProductException | MoneyException e) {
            GuiUtilities.printErrorMessage(e);
        } catch (Exception e) {
            GuiUtilities.printErrorMessage(e);
        }
    }
}
