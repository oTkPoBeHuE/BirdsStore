package gui.users;

import gui.utils.StringConstants;
import model.abstractstore.Money;
import model.abstractstore.User;
import services.UserService;

import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class UsersTableModel extends DefaultTableModel {

    private Set<TableModelListener> listeners = new HashSet<>();

    @Override
    public int getRowCount() {
        return UserService.size();
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
                return String.class;
        }
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        List<User> users = UserService.getAllUsers();
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


}
