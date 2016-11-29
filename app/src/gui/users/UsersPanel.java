package gui.users;

import javax.swing.*;
import javax.swing.table.TableModel;
import java.awt.*;

public class UsersPanel extends JPanel {
    JTable table;

    UsersPanel() {
        super(new BorderLayout());
        TableModel model = new UsersTableModel();
        table = new JTable(model);
        setVisible(true);
    }
}
