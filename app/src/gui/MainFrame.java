package gui;

import gui.users.AddUserWindow;
import gui.users.UsersTableModel;

import javax.swing.*;
import javax.swing.table.TableModel;
import java.awt.*;

/**
 * Created by oTk on 27.11.2016.
 */
public class MainFrame extends JFrame {
    public MainFrame(String title) throws HeadlessException {
        super(title);
        addUsersTable();











    }

    private void addUsersTable(){
        TableModel model = new UsersTableModel();
        JTable table = new JTable(model);
        getContentPane().add(new JScrollPane(table));
        setPreferredSize(new Dimension(260, 220));
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void addMenu() {
        JFrame addUserWindow = new AddUserWindow();
        JMenuBar menuBar = new JMenuBar();
        JMenu userMenu = new JMenu("User"); // TODO: const
        JMenuItem jMenuItem = new JMenuItem("Add User"); // TODO: const
        jMenuItem.addActionListener(e -> addUserWindow.setVisible(true));
        userMenu.add(jMenuItem);
        menuBar.add(userMenu);
        menuBar.add(Box.createHorizontalGlue());
        setJMenuBar(menuBar);
    }
}
