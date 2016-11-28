package gui.users;

import model.abstractstore.Money;
import model.abstractstore.User;
import services.UserService;

import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by oTk on 27.11.2016.
 */
public class UsersTableModel implements TableModel {
    private Set<TableModelListener> listeners = new HashSet<TableModelListener>();;

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
                return "Name";
            case 1:
                return "Money";
            case 2:
                return "Password";
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

    @Override
    public void addTableModelListener(TableModelListener listener) {
        listeners.add(listener);
    }

    @Override
    public void removeTableModelListener(TableModelListener listener) {
        listeners.remove(listener);
    }
}
