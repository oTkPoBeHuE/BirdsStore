package gui;

import gui.users.AddUserWindow;
import gui.users.UsersTableModel;

import javax.swing.*;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;
import java.awt.*;
import java.awt.event.WindowListener;
import java.util.concurrent.Executors;
import java.util.concurrent.RunnableFuture;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * Created by oTk on 27.11.2016.
 */
public  class MainFrame extends JFrame{

    private final ScheduledExecutorService scheduler;

    private void update(Runnable command){
        scheduler.scheduleAtFixedRate(command, 0, 300, TimeUnit.MILLISECONDS);
    }

    public MainFrame(String title) throws HeadlessException {
        super(title);
        scheduler = Executors.newSingleThreadScheduledExecutor();
        addUsersTable();
        addMenu();

    }

    private void addUsersTable(){
        AbstractTableModel  model = new UsersTableModel();
        JTable table = new JTable(model);
        getContentPane().add(new JScrollPane(table));
        setPreferredSize(new Dimension(260, 220));
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
        update(()->model.fireTableDataChanged());
    }



    private void addMenu() {
        JFrame addUserWindow = new AddUserWindow();

        JMenuBar menuBar = new JMenuBar();
       // JMenu userMenu = new JMenu("User"); // TODO: const

        JMenuItem jMenuItem = new JMenuItem("Add User"); // TODO: const
        jMenuItem.addActionListener(e -> addUserWindow.setVisible(true));
        //userMenu.add(jMenuItem);
        menuBar.add(jMenuItem);
        menuBar.add(Box.createHorizontalGlue());
        setJMenuBar(menuBar);
    }
    private void ref(){
        validate();
        repaint(11);
    }
}
