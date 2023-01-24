package DBI;

import java.sql.Date;
import java.util.List;


public class Order {
    private Integer id;
    private Date creationDate;
    private String fullName;
    private String telephone;
    private String email;
    private String deliveryAddress;
    private String orderStatus;
    private Date shippingDate;
    private static Order orderList = new Order();
    private final List<Order> orders;


    public Order(Integer id, Date creationDate, String fullName, String telephone, String email, String deliveryAddress,String orderStatus, Date shippingDate) {
        setId(id);
        setCreationDate(creationDate);
        setFullName(fullName);
        setTelephone(telephone);
        setEmail(email);
        setDeliveryAddress(deliveryAddress);
        setOrderStatus(orderStatus);
        setShippingDate(shippingDate);
        orders = null;
    }

    public Order() { orders = new Repository().findAllOrders();}
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public Date getCreationDate() {
        return creationDate;
    }
    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }
    public String getFullName() {
        return fullName;
    }
    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
    public String getTelephone() {
        return telephone;
    }
    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getDeliveryAddress() {
        return deliveryAddress;
    }
    public void setDeliveryAddress(String deliveryAddress) {
        this.deliveryAddress = deliveryAddress;
    }
    public String getOrderStatus() {
        return orderStatus;
    }
    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }
    public Date getShippingDate() {
        return shippingDate;
    }
    public void setShippingDate(Date shippingDate) {
        this.shippingDate = shippingDate;
    }
    public int getOrderCount() {
        return orders.size();
    }
    public Order getOrder(int index) {
        return orders.get(index);
    }
    public static Order getOrderInstance() {
        return orderList;
    }
}
