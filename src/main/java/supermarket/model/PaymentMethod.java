package supermarket.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "payment_method")
@XmlAccessorType(XmlAccessType.FIELD)
@JsonPropertyOrder({"payment_id", "name"})
public class PaymentMethod {
    @XmlElement(name = "payment_id")
    @JsonProperty("payment_id")
    private long paymentId;
    @XmlElement(name = "name")
    @JsonProperty("name")
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
