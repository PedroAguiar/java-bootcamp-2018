import javax.persistence.*;
public abstract class Client {
    private int clientId;
    private String clientName;
    private String clientLastName;
    private String clientDescription;
    private int clientPayments;

    public int getClientId() {
        return clientId;
    }

    public void setClientId(int productId) {
        this.clientId=clientId;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String productName) {
        this.clientName = productName;
    }

    public String getClientLastName(){
        return clientLastName;
    }
    public void setClientLastName(String clientLastName){
        this.clientLastName = clientLastName;
    }

    public String getClientDescription(){
        return clientDescription;
    }

    public void setClientDescription(String clientDescription){
        this.clientDescription = clientDescription;
    }
    public int getClientPayments(int clientPayments){
        return clientPayments;
    }
    public void setClientPayments(){
        this.clientPayments=clientPayments;

    }
}

