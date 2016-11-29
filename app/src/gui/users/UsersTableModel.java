package gui.users;

import gui.utils.StringConstants;
import model.abstractstore.Money;
import model.abstractstore.User;
import services.UserService;

import javax.swing.event.TableModelListener;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by oTk on 27.11.2016.
 */
public class UsersTableModel extends DefaultTableModel {

    private Set<TableModelListener> listeners = new HashSet<TableModelListener>();
    ;

    @Override
    public int getRowCount() {
        return UserService.getInstance().size();
    }

    @Override
    public int getColumnCount() {
        return 3;
    }

    @Override
    public String getColumnName(int columnIndex) {

        switch (columnIndex) {
            case 0:
                return StringConstants.NAME;
            case 1:
                return StringConstants.MONEY;
            case 2:
                return StringConstants.PASSWORD;
        }
        return "";
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        switch (columnIndex) {
            case 0:
                return String.class;
            case 1:
                return Money.class;
            case 2:
                return String.class;
            default:
                return String.class; // TODO: ?????
        }
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }

    // TODO: siglton statig bugfix
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        List<User> users = UserService.getInstance().getAllUsers();
        Collections.sort(users);

        switch (columnIndex) {
            case 0:
                return users.get(rowIndex).getName();
            case 1:
                return users.get(rowIndex).getMoney();
            case 2:
                return users.get(rowIndex).getPassword();
        }

        return "";
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {

    }

//    @Override
//    public void addTableModelListener(TableModelListener listener) {
//        listeners.add(listener);
//    }
//
//    @Override
//    public void removeTableModelListener(TableModelListener listener) {
//        listeners.remove(listener);
//    }


}
