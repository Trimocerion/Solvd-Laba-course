package supermarket.model;

import jakarta.xml.bind.annotation.*;

import java.util.List;

@XmlRootElement(name = "supermarket")
@XmlAccessorType(XmlAccessType.FIELD)
public class Supermarket {

    @XmlElementWrapper(name = "stores")
    @XmlElement(name = "store")
    private List<Store> stores;

    @XmlElementWrapper(name = "products")
    @XmlElement(name = "product")
    private List<Product> products;

    @XmlElementWrapper(name = "customers")
    @XmlElement(name = "customer")
    private List<Customer> customers;

    @XmlElementWrapper(name = "users")
    @XmlElement(name = "user")
    private List<User> users;

    public Supermarket() {}

    public Supermarket(List<Store> stores, List<Product> products, List<Customer> customers, List<User> users) {
        this.stores = stores;
        this.products = products;
        this.customers = customers;
        this.users = users;
    }

    public List<Store> getStores() {
        return stores;
    }

    public void setStores(List<Store> stores) {
        this.stores = stores;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public List<Customer> getCustomers() {
        return customers;
    }

    public void setCustomers(List<Customer> customers) {
        this.customers = customers;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    @Override
    public String toString() {
        return "Supermarket{" +
                "stores=" + stores +
                ", products=" + products +
                ", customers=" + customers +
                ", users=" + users +
                '}';
    }
}
