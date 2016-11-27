package gui;

import javax.swing.*;
import javax.swing.table.TableModel;
import java.awt.*;

/**
 * Created by oTk on 27.11.2016.
 */
public class MainFrame extends JFrame {
    public MainFrame(String title) throws HeadlessException {
        super(title);
        TableModel model = new UsersTableModel();
        JTable table = new JTable(model);
        getContentPane().add(new JScrollPane(table));
        setPreferredSize(new Dimension(260, 220));
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }
}
