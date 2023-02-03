package DBI;

import javax.swing.*;
import java.awt.*;

public class TableFrame extends JFrame {
    ProductsTable productsTable = new ProductsTable();
    OrderTable orderTable = new OrderTable();
    OrderItemTable orderItemTable = new OrderItemTable();
    JTable table = new JTable();
    private String tableName = DataBaseViewer.getTableName();
    public TableFrame(){
        setTitle(tableName);
        setSize(1000,300);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        switch (tableName) {
            case ("продукты"):
                table.setModel(productsTable);
                table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
                table.setIntercellSpacing(new Dimension(10, 5));
                add(table.getTableHeader(), BorderLayout.NORTH);
                JScrollPane spp = new JScrollPane(table);
                spp.setPreferredSize(new Dimension(1000, 300));
                add(spp, BorderLayout.CENTER);
                break;

            case("заказы"):
                table.setModel(orderTable);
                table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
                table.setIntercellSpacing(new Dimension(5, 5));
                add(table.getTableHeader(), BorderLayout.NORTH);
                JScrollPane spo = new JScrollPane(table);
                spo.setPreferredSize(new Dimension(1000, 300));
                add(spo, BorderLayout.CENTER);
                break;

            case ("позиции_заказа"):
                table.setModel(orderItemTable);
                table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
                table.setIntercellSpacing(new Dimension(10, 5));
                add(table.getTableHeader(), BorderLayout.NORTH);
                JScrollPane spi = new JScrollPane(table);
                spi.setPreferredSize(new Dimension(1000, 300));
                add(spi, BorderLayout.CENTER);
                break;
        }
    }
}
