import exceptions.AuthorisationException;
import exceptions.MoneyException;
import exceptions.ProductException;
import exceptions.UserException;
import gui.MainFrame;
import gui.utils.GuiUtilities;
import services.StorageService;
import services.StoreService;
import services.UserService;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class BirdsStoreApplication {
    private static void createAndShowGUI() {
        // JFrame frame = new JFrame("HelloWorldSwing");
        JFrame frame = new MainFrame("HelloWorldSwing");
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
//        frame.setUndecorated(true);
        frame.setPreferredSize(new Dimension(1400, 800));
        //frame.setSize( 1600,1600 );
        //frame.setUndecorated( true );
        frame.setVisible(true);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // frame.getContentPane().add(label);

        //frame.setSize(1000, 1000);
        //Display the window.
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {
//        String filename = "D:\\prj\\test.txt";
//        try {
//            UserService.read(filename);
//        } catch (Exception e) {
//            GuiUtilities.printErrorMessage(e);
//        }
        try {
            UserService.addUser("nameTest1", "testPWD1");
            UserService.addUser("q11", "123");
            UserService.addUser("nameTest3", "testPWD3");
            UserService.getUser("nameTest1").setMoney("100");
            UserService.getUser("q11").setMoney("100");
            StorageService.getInstance().addBirdsItem("testBird1", "10.0");
            StorageService.getInstance().addBirdsItem("b11", "19.9");
            StorageService.getInstance().addBirdsItem("testBird3", "01999.999");
            StorageService.getInstance().receipt("testBird1", 15);
            StorageService.getInstance().receipt("b11", 4);
        } catch (Exception e) {
            GuiUtilities.printErrorMessage(e);
        }

        try {
            StoreService.getInstance().buy("nameTest1", "testPWD1", "testBird1", 3);
            StoreService.getInstance().buy("nameTest1", "testPWD1", "testBird1", 1);
        } catch (AuthorisationException |
                ProductException |
                UserException |
                MoneyException e) {
            e.printStackTrace();
        }
        javax.swing.SwingUtilities.invokeLater(() -> createAndShowGUI());
    }
}
