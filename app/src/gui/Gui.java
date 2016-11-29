package gui;

import model.abstractstore.Storage;
import model.abstractstore.User;
import model.birdsimpl.BirdsStorage;
import services.BirdsStorageService;
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
        frame.setSize(1000, 1000);
        frame.setUndecorated(true);
        frame.setVisible(true);
        frame.setMinimumSize(new Dimension(400, 400));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Add the ubiquitous "Hello World" label.
        JLabel label = new JLabel("Hello World");
        frame.getContentPane().add(label);

        //frame.setSize(1000, 1000);
        //Display the window.
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        UserService.getInstance().addUser("nameTest1", "testPWD1");
        UserService.getInstance().addUser("nameTest2", "testPWD2");
        UserService.getInstance().addUser("nameTest3", "testPWD3");
        UserService.getInstance().getUser("nameTest1").setMoney("100");

        BirdsStorageService.getInstance().addBirdsItem("testBird1", "10.0");
        BirdsStorageService.getInstance().addBirdsItem("testBird2", "999.999");
        BirdsStorageService.getInstance().addBirdsItem("testBird3", "01999.999");
        BirdsStorageService.getInstance().receipt("testBird1", 5);

        //Schedule a job for the event-dispatching thread:
        //creating and showing this application's GUI.
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }
}
