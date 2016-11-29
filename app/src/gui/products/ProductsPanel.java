package gui.products;

import javax.swing.*;
import javax.swing.table.TableModel;
import java.awt.*;


public class ProductsPanel extends JPanel {
    JTable table;

    ProductsPanel() {
        super(new BorderLayout());
        TableModel model = new ProductsTableModel();
        table = new JTable(model);
        setVisible(true);
    }
}
