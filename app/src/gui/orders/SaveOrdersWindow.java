package gui.orders;

import gui.components.ButtonBox;
import gui.components.StdComponents;
import gui.components.TextFieldBox;
import gui.utils.GuiUtilities;
import gui.utils.StringConstants;
import services.OrdersService;

import javax.swing.*;
import javax.swing.border.EmptyBorder;


public class SaveOrdersWindow extends JFrame {
    TextFieldBox filenameBox;
    Box mainBox;
    ButtonBox buttonBox;

    public SaveOrdersWindow() {
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

    private void setMainBox(){
        filenameBox = new TextFieldBox(StringConstants.FILENAME, 40);
        buttonBox = StdComponents.getButtonBox(StringConstants.SAVE, e -> save(filenameBox.jTextField.getText()), e->setVisible(false));

        mainBox = Box.createVerticalBox();
        mainBox.setBorder(new EmptyBorder(12, 12, 12, 12));
        mainBox.add(filenameBox.box);
        mainBox.add(Box.createVerticalStrut(13));
        mainBox.add(buttonBox.box);
    }

    private void save(String filename) {
        try {
            OrdersService.save(filename);
        } catch (Exception e) {
            GuiUtilities.printErrorMessage(e);
        }
    }
}
