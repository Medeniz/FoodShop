package be.intecbrussel.foodshop.app;

import be.intecbrussel.foodshop.model.Customer;
import be.intecbrussel.foodshop.service.CustomerRepository;

public class TestApp2 {
    public static void main(String[] args) {
        CustomerRepository cr = new CustomerRepository();
        Customer jeanJaque = new Customer("Jean Jacques",54, "JeanJacqueMetEenC@msn.be", 250);
        Customer mustafa = new Customer("Mustafa", 25, "JeanJacqueMetEenC@msn.be", 1500);

        cr.writeCustomer(jeanJaque);
        cr.writeCustomer(mustafa);
    }
}
