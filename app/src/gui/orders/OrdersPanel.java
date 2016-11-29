package gui.orders;

import gui.products.ProductsTableModel;

import javax.swing.*;
import javax.swing.table.TableModel;
import java.awt.*;

/**
 * Created by oTk on 27.11.2016.
 */
public class OrdersPanel extends JPanel {
    JTable table;

    OrdersPanel() {
        super(new BorderLayout());
        TableModel model = new OrdersTableModel();
        table = new JTable(model);
        setVisible(true);
    }
}
