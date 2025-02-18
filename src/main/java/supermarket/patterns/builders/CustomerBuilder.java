package supermarket.patterns.builders;

import supermarket.model.Customer;

public class CustomerBuilder {
    private long id;
    private String name;
    private String lastName;
    private String email;

    public CustomerBuilder setId(long id) {
        this.id = id;
        return this;
    }

    public CustomerBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public CustomerBuilder setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public CustomerBuilder setEmail(String email) {
        this.email = email;
        return this;
    }

    public Customer build() {
        Customer customer = new Customer();
        customer.setCustomerId(id);
        customer.setFirstName(name);
        customer.setLastName(lastName);
        customer.setEmail(email);
        return customer;
    }
}