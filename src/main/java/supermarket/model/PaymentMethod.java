package supermarket.model;

public class PaymentMethod {
    private long paymentId;
    private String name;

    public PaymentMethod() {
    }

    public PaymentMethod(String name) {
        this.name = name;
    }

    public PaymentMethod(long paymentId, String name) {
        this.paymentId = paymentId;
        this.name = name;
    }

    public long getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(long paymentId) {
        this.paymentId = paymentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
