package gui;

import exceptions.AuthorisationException;
import exceptions.MoneyException;
import exceptions.ProductException;
import exceptions.UserException;
import services.StorageService;
import services.OrdersService;
import services.StoreService;
import services.UserService;

import javax.swing.*;
import java.awt.*;

/**
 * Created by oTk on 27.11.2016.
 */
public class Gui {
    private static void createAndShowGUI() {
        //Create and set up the window.
       // JFrame frame = new JFrame("HelloWorldSwing");
        JFrame frame = new MainFrame("HelloWorldSwing");
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
//        frame.setUndecorated(true);
        frame.setPreferredSize(new Dimension(1400, 800));
       //frame.setSize( 1600,1600 );
        //frame.setUndecorated( true );
        frame.setVisible(true);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Add the ubiquitous "Hello World" label.
       // frame.getContentPane().add(label);

        //frame.setSize(1000, 1000);
        //Display the window.
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        UserService.addUser("nameTest1", "testPWD1");
        UserService.addUser("nameTest2", "testPWD2");
        UserService.addUser("nameTest3", "testPWD3");
        UserService.getUser("nameTest1").setMoney("100");

        StorageService.getInstance().addBirdsItem("testBird1", "10.0");
        StorageService.getInstance().addBirdsItem("testBird2", "999.999");
        StorageService.getInstance().addBirdsItem("testBird3", "01999.999");
        StorageService.getInstance().receipt("testBird1", 15);
        try {
            StoreService.getInstance().buy("nameTest1", "testPWD1", "testBird1", 3 );
            StoreService.getInstance().buy("nameTest1", "testPWD1", "testBird1", 1 );
        } catch (AuthorisationException |
                ProductException |
                UserException |
                MoneyException e) {
            e.printStackTrace();
        }

        //Schedule a job for the event-dispatching thread:
        //creating and showing this application's GUI.
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }
}
