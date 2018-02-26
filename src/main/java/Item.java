import javax.persistence.*;
public class Item {

    private int productId;

    private String productName;

    private Double productPrice;

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
       this.productId=productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(double productPrice) {
        this.productPrice = productPrice;
    }

}
