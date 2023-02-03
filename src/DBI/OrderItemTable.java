package DBI;

import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

public class OrderItemTable implements TableModel {

    public static final String[] COLUMNS = new String[] {
            "Код записи заказа",
            "Артикул товара",
            "Цена",
            "Количество"
    };
    @Override
    public int getRowCount() {
        return OrderItem.getOrderItemInstance().getOrderItemsCount();
    }

    @Override
    public int getColumnCount() {
        return COLUMNS.length;
    }

    @Override
    public String getColumnName(int columnIndex) {
        return COLUMNS[columnIndex];
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
            switch (columnIndex) {
                case 0:
                    return Integer.class;
                case 1:
                    return String.class;
                case 2:
                case 3:
                    return Integer.class;
            }
        throw new IllegalArgumentException("Неизвестный столбец");
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
            OrderItem orderItem = OrderItem.getOrderItemInstance().getOrderItem(rowIndex);
            switch (columnIndex) {
                case 0: return orderItem.getOrderCode();
                case 1: return orderItem.getVendorCodeOfProduct();
                case 2: return orderItem.getPrice();
                case 3: return orderItem.getNumberOfProducts();
            }
        throw new IllegalArgumentException("Неизвестный столбец");
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
    }
    @Override
    public void addTableModelListener(TableModelListener l) {
    }
    @Override
    public void removeTableModelListener(TableModelListener l) {

    }
}





