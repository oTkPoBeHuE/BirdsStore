package gui.components;

import javax.swing.*;

public class TextFieldBox {
    public JTextField jTextField ;
    public  JLabel jLabel;
    public    Box box;

    public TextFieldBox(String labelText, int minTextLength){
        box =  Box.createHorizontalBox();
        jTextField = new JTextField(minTextLength);
        jLabel = new JLabel(labelText);
        box.add(jLabel);
        box.add(Box.createHorizontalStrut(6));
        box.add(jTextField);
    }

}
