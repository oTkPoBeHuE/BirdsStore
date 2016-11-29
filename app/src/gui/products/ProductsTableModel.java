package gui.products;

import gui.utils.StringConstants;
import model.abstractstore.Money;
import model.abstractstore.Storage;
import services.StorageService;

import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by oTk on 29.11.2016.
 */
public class ProductsTableModel extends DefaultTableModel {
    private Set<TableModelListener> listeners = new HashSet<TableModelListener>();;

    @Override
    public int getRowCount() {
        return StorageService.getInstance().size();
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
                return StringConstants.PRICE;
            case 2:
                return StringConstants.COUNT;
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
                return Integer.class;
            default:
                return String.class;
        }
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }

    public Object getValueAt(int rowIndex, int columnIndex) {
        List<Storage.Products> products = StorageService.getInstance().getAllProducts();
        Collections.sort(products);

        switch (columnIndex) {
            case 0:
                return products.get(rowIndex).getProduct().getName();
            case 1:
                return products.get(rowIndex).getProduct().getPrice();
            case 2:
                return products.get(rowIndex).getCount();
        }
        return "";
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {

    }
}
