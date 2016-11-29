package gui.components;

import javax.swing.*;
import java.awt.event.ActionListener;

/**
 * Created by omsk29 on 11/29/2016.
 */
public class ButtonBox {
    public Box box;
    public JButton leftButton;
    public JButton rightButton;

    public ButtonBox(String leftButtonText, ActionListener leftButtonActionListener,
                     String rightButtonText, ActionListener rightButtonActionListener) {
        box = Box.createHorizontalBox();

        leftButton = new JButton(leftButtonText);
        rightButton = new JButton(rightButtonText);

        leftButton.addActionListener(leftButtonActionListener);
        rightButton.addActionListener(rightButtonActionListener);

        box.add(leftButton);
        box.add(Box.createHorizontalStrut(12));
        box.add(rightButton);
    }
}
