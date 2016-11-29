package gui.orders;

import gui.utils.StringConstants;
import model.abstractstore.Money;
import model.abstractstore.Order;
import services.OrdersService;

import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

/**
 * Created by oTk on 29.11.2016.
 */
public class OrdersTableModel extends DefaultTableModel {
    private Set<TableModelListener> listeners = new HashSet<TableModelListener>();;

    @Override
    public int getRowCount() {
        return OrdersService.size();
    }

    @Override
    public int getColumnCount() {
        return 5;
    }

    @Override
    public String getColumnName(int columnIndex) {

        switch (columnIndex) {
            case 0:
                return StringConstants.PRODUCT_NAME;
            case 1:
                return StringConstants.USERNAME;
            case 2:
                return StringConstants.COUNT;
            case 3:
                return StringConstants.BILL;
            case 4:
                return StringConstants.DATE;
        }
        return "";
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        switch (columnIndex) {
            case 0:
                return String.class;
            case 1:
                return String.class;
            case 2:
                return Money.class;
            case 3:
                return Integer.class;
            case 4:
                return LocalDateTime.class;
            default:
                return String.class; // TODO: ?????
        }
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }

    public Object getValueAt(int rowIndex, int columnIndex) {
        List<Order> orders = OrdersService.getAllOrders();
        Collections.sort(orders);
        DateTimeFormatter formater = DateTimeFormatter.ofPattern("HH:mm:ss", Locale.US);

        switch (columnIndex) {
            case 0:
                return orders.get(rowIndex).getProductName();
            case 1:
                return orders.get(rowIndex).getUserName();
            case 2:
                return orders.get(rowIndex).getCount();
            case 3:
                return orders.get(rowIndex).getTotalAmount();
            case 4:
                return formater.format(orders.get(rowIndex).getLocalTime());
        }

        return "";
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {

    }
}
