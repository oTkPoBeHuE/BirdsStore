package gui.components;

import javax.swing.*;

public class TextFieldBox {
    public JTextField jTextField ;
    public  JLabel jLabel;
    public    Box box;

    public TextFieldBox(String labelText, int maxTextLenght){
        box =  Box.createHorizontalBox();
        jTextField = new JTextField(maxTextLenght);
        jLabel = new JLabel(labelText);
        box.add(jLabel);
        box.add(Box.createHorizontalStrut(6));
        box.add(jTextField);
    }

}
