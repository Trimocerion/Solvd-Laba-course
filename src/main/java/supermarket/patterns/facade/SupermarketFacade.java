package supermarket.patterns.facade;

import supermarket.model.Checkout;
import supermarket.model.Customer;
import supermarket.service.ICheckoutService;
import supermarket.service.ICustomersService;

public class SupermarketFacade {

    private final ICheckoutService checkoutService;
    private final ICustomersService customersService;

    public SupermarketFacade(ICheckoutService checkoutService, ICustomersService customersService) {
        this.checkoutService = checkoutService;
        this.customersService = customersService;
    }

    public Checkout getCheckout(long id) {
        return checkoutService.get(id);
    }

    public Customer getCustomer(long id) {
        return customersService.get(id);
    }


}
