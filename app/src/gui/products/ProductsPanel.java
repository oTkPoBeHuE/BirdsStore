package gui.products;

import javax.swing.*;
import javax.swing.table.TableModel;
import java.awt.*;

/**
 * Created by oTk on 27.11.2016.
 */
public class ProductsPanel extends JPanel {
    JTable table;

    ProductsPanel() {
        super(new BorderLayout());
        TableModel model = new ProductsTableModel();
        table = new JTable(model);
        setVisible(true);
    }
}
