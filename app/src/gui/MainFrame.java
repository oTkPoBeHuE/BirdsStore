package gui;

import gui.orders.BuyWindow;
import gui.orders.OrdersTableModel;
import gui.products.AddProductWindow;
import gui.products.ProductsTableModel;
import gui.users.*;
import gui.utils.StringConstants;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import java.awt.*;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;



public class MainFrame extends JFrame {


    private final ScheduledExecutorService scheduler;

    public MainFrame(String title) throws HeadlessException {
        super(title);
        scheduler = Executors.newSingleThreadScheduledExecutor();

        addTable(new UsersTableModel());
        addTable(new ProductsTableModel());
        addTable(new OrdersTableModel());

        addMenu();
        setLayout(new FlowLayout());
    }

    private void update(Runnable command) {
        scheduler.scheduleAtFixedRate(command, 0, 300, TimeUnit.MILLISECONDS);
    }

    private void addTable(AbstractTableModel tableModel) {
        AbstractTableModel model = tableModel;
        JTable table = new JTable(model);
        getContentPane().add(new JScrollPane(table));
        setPreferredSize(new Dimension(260, 220));
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
        update(() -> model.fireTableDataChanged());
    }

    private void addMenu() {
        JMenuBar menuBar = new JMenuBar();

        menuBar.add(createJMenuItem(StringConstants.CREATE_USER, new AddUserWindow()));
        menuBar.add(createJMenuItem(StringConstants.SET_MONEY, new SetMoneyWindow()));
        menuBar.add(createJMenuItem(StringConstants.ADD_PRODUCT, new AddProductWindow()));
        menuBar.add(createJMenuItem(StringConstants.BUY, new BuyWindow()));
        menuBar.add(createJMenuItem(StringConstants.USERS_SAVE, new SaveUsersWindow()));
        menuBar.add(createJMenuItem(StringConstants.USERS_READ, new ReadUsersWindow()));

        menuBar.add(Box.createHorizontalGlue());
        setJMenuBar(menuBar);
    }

    private JMenuItem createJMenuItem(String name, JFrame jFrame) {
        JMenuItem jMenuItem = new JMenuItem(name);
        jMenuItem.addActionListener(e -> jFrame.setVisible(true));
        return jMenuItem;
    }

}
