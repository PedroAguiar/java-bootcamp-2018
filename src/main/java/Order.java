import javax.persistence.*;
public class Order {
   private int orderId;
   private String orderItems;


   public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId=orderId;
    }

    public String getOrderItems() {
        return orderItems;
   }
    public void setOrderId(String orderItems){
        this.orderItems=orderItems;
    }
}


