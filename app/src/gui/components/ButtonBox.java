package gui.components;

import javax.swing.*;
import java.awt.event.ActionListener;

/**
 * Created by omsk29 on 11/29/2016.
 */
public class ButtonBox {
    public Box buttonBox;
    public JButton leftButton;
    public JButton rightButton;

    public ButtonBox(String leftButtonText, ActionListener leftButtonActionListener,
                     String rightButtonText, ActionListener rightButtonActionListener) {
        buttonBox = Box.createHorizontalBox();

        leftButton = new JButton(leftButtonText);
        rightButton = new JButton(rightButtonText);

        leftButton.addActionListener(leftButtonActionListener);
        rightButton.addActionListener(rightButtonActionListener);

        buttonBox.add(leftButton);
        buttonBox.add(Box.createHorizontalStrut(12));
        buttonBox.add(rightButton);
    }
}
