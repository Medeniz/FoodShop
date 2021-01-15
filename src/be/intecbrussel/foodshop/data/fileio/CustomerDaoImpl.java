package be.intecbrussel.foodshop.data.fileio;

import be.intecbrussel.foodshop.config.FilePaths;
import be.intecbrussel.foodshop.data.CustomerDao;
import be.intecbrussel.foodshop.model.Customer;

import java.io.FileWriter;
import java.io.IOException;

public class CustomerDaoImpl implements CustomerDao {
    @Override
    public Customer readCustomer() {
        return null;
    }

    @Override
    public void writeCustomer(Customer customer) {
        try {
            FileWriter fileWriter = new FileWriter(FilePaths.CUSTOMER_FILEPATH.getFile(), false);
            fileWriter.write(customer.toString() + "\n");
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
