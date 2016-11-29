package gui.products;

import exceptions.ProductException;
import gui.components.ButtonBox;
import gui.components.TextFieldBox;
import gui.utils.GuiUtilities;
import gui.utils.Settings;
import gui.utils.StringConstants;
import model.abstractstore.Storage;
import services.StorageService;
import services.StoreService;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class AddProductWindow extends JFrame {


    public ButtonBox buttonBox;
    public TextFieldBox productCountBox;
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
        productCountBox = new TextFieldBox(StringConstants.COUNT, Settings.COUNT_MAX_CHAR_LENGTH);
        buttonBox = new ButtonBox(
                StringConstants.OK,
                e -> addProduct(productNameBox.jTextField.getText(),
                        productPriceBox.jTextField.getText(),
                        productCountBox.jTextField.getText()),
                StringConstants.CANCEL,
                e -> setVisible(false));


        productPriceBox.jLabel.setPreferredSize(productNameBox.jLabel.getPreferredSize());

        mainBox = Box.createVerticalBox();
        mainBox.setBorder(new EmptyBorder(12, 12, 12, 12));
        mainBox.add(productNameBox.box);
        mainBox.add(Box.createVerticalStrut(12));
        mainBox.add(productPriceBox.box);
        mainBox.add(Box.createVerticalStrut(17));
        mainBox.add(productCountBox.box);
        mainBox.add(Box.createVerticalStrut(17));
        mainBox.add(buttonBox.box);
    }


    public void addProduct(String name, String price, String count ) {
        try {
            StorageService.getInstance().addBirdsItem(name,price );
            StorageService.getInstance().receipt(name, Integer.parseInt(count));
        } catch (Exception ex) {
            GuiUtilities.printErrorMessage(ex);
        }
    }
}
