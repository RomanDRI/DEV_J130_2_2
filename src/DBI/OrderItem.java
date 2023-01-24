package DBI;


import java.util.List;

public class OrderItem {

    private Integer orderCode;
    private String vendorCodeOfProduct;
    private Integer price;
    private Integer numberOfProducts;
    private static OrderItem orderItemList = new OrderItem();
    private final List<OrderItem> orderItems;

    public OrderItem(Integer orderCode,String vendorCodeOfProduct,Integer price, Integer numberOfProducts) {
        setOrderCode(orderCode);
        setVendorCodeOfProduct(vendorCodeOfProduct);
        setPrice(price);
        setNumberOfProducts(numberOfProducts);
        orderItems = null;
    }
    public OrderItem() {
        orderItems = new Repository().findAllOrdersItem();
    }
    public Integer getOrderCode() {
        return orderCode;
    }
    public void setOrderCode(Integer orderCode) {
        this.orderCode = orderCode;
    }
    public String getVendorCodeOfProduct() {
        return vendorCodeOfProduct;
    }
    public void setVendorCodeOfProduct(String vendorCodeOfProduct) {
        this.vendorCodeOfProduct = vendorCodeOfProduct;
    }
    public Integer getPrice() {
        return price;
    }
    public void setPrice(Integer price) {
        this.price = price;
    }
    public Integer getNumberOfProducts() {
        return numberOfProducts;
    }
    public void setNumberOfProducts(Integer numberOfProducts) {
        this.numberOfProducts = numberOfProducts;
    }
    public int getOrderItemsCount() {
        return orderItems.size();
    }
    public OrderItem getOrderItem(int index) {
        return orderItems.get(index);
    }
    public static OrderItem getOrderItemInstance() {
        return orderItemList;
    }
}
