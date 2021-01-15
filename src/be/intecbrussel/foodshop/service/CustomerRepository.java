package be.intecbrussel.foodshop.service;

import be.intecbrussel.foodshop.data.CustomerDao;
import be.intecbrussel.foodshop.data.fileio.CustomerDaoImpl;
import be.intecbrussel.foodshop.model.Customer;

public class CustomerRepository {
    CustomerDao customerDao = new CustomerDaoImpl();

    public void writeCustomer(Customer customer){
        customerDao.writeCustomer(customer);
    }
}
