package DBI;

import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;
import java.util.Date;

public class OrderTable implements TableModel {

    public static final String[] COLUMNS = new String[] {
            "Идентификатор",
            "Дата создания",
            "ФИО заказчика",
            "контактный телефон",
            "адрес эл.почты",
            "адрес доставки",
            "статус заказа",
            "дата отгрузки заказа"
    };

    @Override
    public int getRowCount() {
        return Order.getOrderInstance().getOrderCount();
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
                    return Date.class;
                case 2:
                case 3:
                case 4:
                case 5:
                case 6:
                    return String.class;
                case 7:
                    return Date.class;
            }
        throw new IllegalArgumentException("Неизвестный столбец");
    }
    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {

            Order order = Order.getOrderInstance().getOrder(rowIndex);
            switch (columnIndex) {
                case 0: return order.getId();
                case 1: return order.getCreationDate();
                case 2: return order.getFullName();
                case 3: return order.getTelephone();
                case 4: return order.getEmail();
                case 5: return order.getDeliveryAddress();
                case 6: return order.getOrderStatus();
                case 7: return order.getShippingDate();
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




