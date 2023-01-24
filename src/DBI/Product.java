package DBI;


import java.util.List;

public class Product {
    private String vendorCode;
    private String productName;
    private String productColor;
    private Integer productPrice;
    private Integer productInStock;
    private static Product productList = new Product();
    private final List<Product> products;

    public Product(String vendorCode, String productName, String productColor, Integer productPrice, Integer productInStock) {
        setVendorCode(vendorCode);
        setProductName(productName);
        setProductColor(productColor);
        setProductPrice(productPrice);
        setProductInStock(productInStock);
        products = null;
    }

    public Product() {
        products = new Repository().findAllProducts();
    }

    public String getVendorCode() {
        return vendorCode;
    }
    public void setVendorCode(String vendorCode) {
        this.vendorCode = vendorCode;
    }
    public String getProductName() {
        return productName;
    }
    public void setProductName(String productName) {
        this.productName = productName;
    }
    public String getProductColor() {
        return productColor;
    }
    public void setProductColor(String productColor) {
        this.productColor = productColor;
    }
    public Integer getProductPrice() {
        return productPrice;
    }
    public void setProductPrice(Integer productPrice) {
        this.productPrice = productPrice;
    }
    public Integer getProductInStock() {
        return productInStock;
    }
    public void setProductInStock(Integer productInStock) {
        this.productInStock = productInStock;
    }
    public int getProductsCount() {
        return products.size();
    }
    public Product getProduct(int index) {
        return products.get(index);
    }
    public static Product getProductInstance() {
        return productList;
    }
}
