package gui.orders;

import javax.swing.*;
import javax.swing.table.TableModel;
import java.awt.*;

public class OrdersPanel extends JPanel {
    JTable table;

    OrdersPanel() {
        super(new BorderLayout());
        TableModel model = new OrdersTableModel();
        table = new JTable(model);
        setVisible(true);
    }
}
