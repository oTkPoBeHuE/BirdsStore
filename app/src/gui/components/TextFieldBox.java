package gui.components;

import javax.swing.*;

public class TextFieldBox {
    public JTextField jTextField ;
    public  JLabel jLabel;
    public    Box box;

    public TextFieldBox(String labelText, int maxTextLength){
        box =  Box.createHorizontalBox();
        jTextField = new JTextField(maxTextLength);
        jLabel = new JLabel(labelText);
        box.add(jLabel);
        box.add(Box.createHorizontalStrut(6));
        box.add(jTextField);
    }

}
