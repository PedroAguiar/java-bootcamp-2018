import javax.persistence.*;
public class Payment {

    private int paymentId;
    private int paymentOrder;
    private int paymentAmount;

    public int getPaymentId(){
        return paymentId;
    }

    public void setPaymentId(int paymentId) {
        this.paymentId = paymentId;
    }

    public int getPaymentOrder(){
        return paymentOrder;

    }

    public void setPaymentOrder(int paymentOrder) {
        this.paymentOrder = paymentOrder;
    }

    public int getPaymentAmount(){
        return paymentAmount;

    }
    public void setPaymentAmount(int paymentAmount) {
        this.paymentAmount = paymentAmount;
    }


}
