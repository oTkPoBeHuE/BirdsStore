import gui.MainFrame;
import services.UserService;

import javax.swing.*;
import java.awt.*;

public class BirdsStoreApplication {
    private static void createAndShowGUI() {
        JFrame frame = new MainFrame("HelloWorldSwing");
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setPreferredSize(new Dimension(1400, 800));
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        String filename = "test.txt";
        try {
            UserService.read(filename);
        } catch (Exception e) {
        }
        javax.swing.SwingUtilities.invokeLater(() -> createAndShowGUI());
    }
}
