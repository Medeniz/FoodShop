package be.intecbrussel.foodshop.data;

import be.intecbrussel.foodshop.model.Customer;

public interface CustomerDao {

    Customer readCustomer();
    void writeCustomer(Customer customer);

}
