package DBI;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Repository {
    private String url = DataBaseViewer.getUrl(); // jdbc:mysql://localhost:3306/database_lab_2
    private String user = "root";
    private String password = "root";

    public void checkUrl() {
        try(Connection connection = DriverManager.getConnection(url,user,password);
            Statement statement = connection.createStatement()) {
            statement.executeQuery("SELECT * FROM Продукты");
            statement.executeQuery("SELECT * FROM Заказы");
            statement.executeQuery("SELECT * FROM Позиции_заказа");
            DataBaseViewer.setUlrError(true);
        } catch (SQLException ex) {
            DataBaseViewer.setUlrError(false);
            System.out.println("Неверный адрес базы данных");
        }
    }
    public List<Product> findAllProducts() {
        List<Product> products = new ArrayList<>();
        try(Connection connection = DriverManager.getConnection(url,user,password);
            Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery("SELECT * FROM Продукты");
                while (resultSet.next()) {
                    String vendorCode = resultSet.getString(1);
                    String productName = resultSet.getString(2);
                    String productColor = resultSet.getString(3);
                    Integer productPrice = resultSet.getInt(4);
                    Integer productInStock = resultSet.getInt(5);
                    Product product = new Product(vendorCode, productName, productColor, productPrice, productInStock);
                    products.add(product);
                    DataBaseViewer.setUlrError(true);
                }
        } catch (SQLException ex) {
            DataBaseViewer.setUlrError(false);
            System.out.println("Неверный адрес базы данных");
        }
        return products;
    }
    public List<Order> findAllOrders() {
        List<Order> orders = new ArrayList<>();
        try(Connection connection = DriverManager.getConnection(url,user,password);
            Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery("SELECT * FROM Заказы");
            while (resultSet.next()) {
                Integer id = resultSet.getInt(1);
                Date creationDate = resultSet.getDate(2);
                String fullName = resultSet.getString(3);
                String telephone = resultSet.getString(4);
                String email = resultSet.getString(5);
                String deliveryAddress = resultSet.getString(6);
                String orderStatus = resultSet.getString(7);
                Date shippingDate = resultSet.getDate(8);
                Order order = new Order(id, creationDate,fullName,telephone,email,deliveryAddress,orderStatus, shippingDate);
                orders.add(order);
                DataBaseViewer.setUlrError(true);
            }
    } catch (SQLException ex) {
            DataBaseViewer.setUlrError(false);
            System.out.println("Неверный адрес базы данных");
        }
        return orders;
    }
    public List<OrderItem> findAllOrdersItem() {
        List<OrderItem> orderItems = new ArrayList<>();
        try(Connection connection = DriverManager.getConnection(url,user,password);
            Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery("SELECT * FROM Позиции_заказа");;
            while (resultSet.next()) {
                Integer orderCode = resultSet.getInt(1);
                String vendorCodeOfProduct = resultSet.getString(2);
                Integer price = resultSet.getInt(3);
                Integer numberOfProducts = resultSet.getInt(4);
                OrderItem orderItem = new OrderItem(orderCode,vendorCodeOfProduct,price,numberOfProducts);
                orderItems.add(orderItem);
                DataBaseViewer.setUlrError(true);
            }
        } catch (SQLException ex) {
            DataBaseViewer.setUlrError(false);
            System.out.println("Неверный адрес базы данных");
        }
        return orderItems;
    }
}
