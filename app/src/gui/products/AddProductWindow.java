package gui.products;

import gui.components.ButtonBox;
import gui.components.TextFieldBox;
import gui.utils.Settings;
import gui.utils.StringConstants;
import services.StorageService;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

/**
 * Created by omsk29 on 11/29/2016.
 */
public class AddProductWindow extends JFrame {


    public ButtonBox buttonBox;
    public TextFieldBox productNameBox;
    public TextFieldBox productPriceBox;
    public Box mainBox;

    public AddProductWindow() {
        super(StringConstants.ADD_PRODUCT);
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
        productNameBox = new TextFieldBox(StringConstants.PRODUCT_NAME, Settings.PRODUCT_NAME_MAX_LENGTH);
        productPriceBox = new TextFieldBox(StringConstants.PRODUCT_PRICE, Settings.MONEY_MAX_CHAR_LENGTH);
        buttonBox = new ButtonBox(
                StringConstants.OK,
                e -> StorageService.getInstance().addBirdsItem(
                        productNameBox.jTextField.getText(),
                        productPriceBox.jTextField.getText()),
                StringConstants.CANCEL,
                e -> setVisible(false));


        productPriceBox.jLabel.setPreferredSize(productNameBox.jLabel.getPreferredSize());

        mainBox = Box.createVerticalBox();
        mainBox.setBorder(new EmptyBorder(12, 12, 12, 12));
        mainBox.add(productNameBox.box);
        mainBox.add(Box.createVerticalStrut(12));
        mainBox.add(productPriceBox.box);
        mainBox.add(Box.createVerticalStrut(17));
        mainBox.add(buttonBox.box);
    }



}
