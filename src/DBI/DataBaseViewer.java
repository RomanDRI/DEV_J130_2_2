package DBI;

import javax.swing.*;
import java.awt.*;

public class DataBaseViewer extends JFrame {

    private JTextField addressField;
    private static String url;
    private static boolean ulrError;
    private JTextField tableNameField;
    private static String tableName;
    private JLabel massageLabel;
    public static String getUrl() {
        return url;
    }
    public static String getTableName() { return tableName; }
    public static void setUlrError(boolean ulrError) {
        DataBaseViewer.ulrError = ulrError;
    }
    public DataBaseViewer () {
        setTitle("Просмотрщик баз данных");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        Container root = getContentPane();
        root.setLayout(new BorderLayout(10,10));
        setVisible(true);

        root.add(createDataArea(), BorderLayout.CENTER);
        root.add(createButton(), BorderLayout.SOUTH);

        setSize(600,150);

    }

    private JPanel createButton(){
        JPanel panel = new JPanel(new FlowLayout());
        JButton loadTableButton = new JButton("Загрузка");

        panel.add(loadTableButton);

        loadTableButton.addActionListener(e -> loadTable());

        return panel;
    }

    private void loadTable(){
        massageLabel.setText("");
        url = addressField.getText();
        Repository repository = new Repository();
        repository.checkUrl();
        tableName = tableNameField.getText().toLowerCase();
        if (ulrError == true) {
            TableFrame tableFrame = new TableFrame();
            switch (tableNameField.getText().toLowerCase()) {
                case "продукты":
                case "заказы":
                case "позиции_заказа":
                    tableFrame.setVisible(true);
                    break;
                default:
                    tableFrame.setVisible(false);
                    massageLabel.setText("Неверное название таблицы (Продукты, Заказы, Позиции_заказа)");
            }
        } else massageLabel.setText("Неверный адрес базы данных");
    }
    private JPanel createDataArea() {
        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();

        JLabel dataBaseAddress = new JLabel("Введите адрес базы данных ");
        addressField = new JTextField(40);

        constraints.gridx = 0;
        constraints.gridy = 0;
        panel.add(dataBaseAddress,constraints);

        constraints.gridx = 1;
        constraints.gridy = 0;
        panel.add(addressField,constraints);

        JLabel tableName = new JLabel("Введите название таблицы ");
        tableNameField = new JTextField(40);

        constraints.gridx = 0;
        constraints.gridy = 1;
        panel.add(tableName,constraints);

        constraints.gridx = 1;
        constraints.gridy = 1;
        panel.add(tableNameField, constraints);

        massageLabel = new JLabel();

        constraints.gridx = 1;
        constraints.gridy = 2;
        panel.add(massageLabel, constraints);

        return panel;
    }
}
