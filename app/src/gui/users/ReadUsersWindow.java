package gui.users;

import gui.components.ButtonBox;
import gui.components.StdComponents;
import gui.components.TextFieldBox;
import gui.utils.GuiUtilities;
import gui.utils.StringConstants;
import services.UserService;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class ReadUsersWindow extends JFrame {

    TextFieldBox filenameBox;
    Box mainBox;
    ButtonBox buttonBox;

    public ReadUsersWindow() {
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
        buttonBox = StdComponents.getButtonBox(StringConstants.READ, e -> read(filenameBox.jTextField.getText()), e->setVisible(false));

        mainBox = Box.createVerticalBox();
        mainBox.setBorder(new EmptyBorder(12, 12, 12, 12));
        mainBox.add(filenameBox.box);
        mainBox.add(Box.createVerticalStrut(17));
        mainBox.add(buttonBox.box);
    }

    private void read(String filename) {
        try {
            UserService.read(filename);
        } catch (Exception e) {
            GuiUtilities.printErrorMessage(e);
        }
    }
}
