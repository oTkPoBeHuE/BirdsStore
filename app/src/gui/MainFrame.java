package gui;

import gui.orders.OrdersTableModel;
import gui.products.ProductsTableModel;
import gui.users.AddUserWindow;
import gui.users.SetMoneyWindow;
import gui.users.UsersTableModel;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import java.awt.*;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import static gui.utils.StringConstants.CREATE_USER;
import static gui.utils.StringConstants.SET_MONEY;

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
        addProductsTable();
        addOrdersTable();
        addMenu();
        setLayout(new FlowLayout());
    }

    private void addOrdersTable(){
        AbstractTableModel  model = new OrdersTableModel();
        JTable table = new JTable(model);
        getContentPane().add(new JScrollPane(table));
        setPreferredSize(new Dimension(260, 220));
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
        update(()->model.fireTableDataChanged());
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

    private void addProductsTable() {
        AbstractTableModel  model = new ProductsTableModel();
        JTable table = new JTable(model);
        getContentPane().add(new JScrollPane(table));
        setPreferredSize(new Dimension(260, 220));
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
        update(()->model.fireTableDataChanged());
    }

    private void addMenu() {
        JMenuBar menuBar = new JMenuBar();

        menuBar.add(createJMenuItem(CREATE_USER, new AddUserWindow()));
        menuBar.add(createJMenuItem(SET_MONEY, new SetMoneyWindow()));

        menuBar.add(Box.createHorizontalGlue());
        setJMenuBar(menuBar);
    }

    private JMenuItem createJMenuItem(String name,  JFrame jFrame ){
        JMenuItem jMenuItem = new JMenuItem(name);
        jMenuItem.addActionListener(e -> jFrame.setVisible(true));
        return jMenuItem;
    }

}
