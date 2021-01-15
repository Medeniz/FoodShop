package be.intecbrussel.foodshop.model;

import be.intecbrussel.foodshop.exception.FoodNotInStockException;
import be.intecbrussel.foodshop.exception.NotEnoughFoodInStockException;
import be.intecbrussel.foodshop.exception.NotEnoughMoneyException;
import be.intecbrussel.foodshop.service.CustomerRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class FoodShop {
    private List<Register> registers;
    private Stock stock;
    private CustomerRepository customerRepository;

    //Constructor
    public FoodShop(Stock stock) {
        this.stock = stock;
        this.registers = new ArrayList<>();
        registers.add(new Register());
    }
    //Getters
    public List<Register> getRegisters() {
        return registers;
    }

    public void setRegisters(List<Register> registers) {
        this.registers = registers;
    }

    public Stock getStock() {
        return stock;
    }

    public void setStock(Stock stock) {
        this.stock = stock;
    }

    public CustomerRepository getCustomerRepository() {
        return customerRepository;
    }
    //Setter
    public void setCustomerRepository(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }
    //Sell Food Method
    public Map<Food, Integer> sellFood(Order order, Customer customer) throws NotEnoughMoneyException, NotEnoughFoodInStockException, FoodNotInStockException {
        checkStock(order);
        checkCustomerMoney(customer, order);
        removeFoodFromStock(order);
        updateCustomersMoney(customer, order);
        addMoneyToRegister(order);

        return order.getFoodItems();
    }

    // Private Methods !!!
    private void checkStock(Order order) throws NotEnoughFoodInStockException, FoodNotInStockException{
        for (Map.Entry<Food, Integer> entry : order.getFoodItems().entrySet()) {
            Food food = entry.getKey();
            Integer amount = entry.getValue();
            checkFoodInStock(food, amount);
        }
    }

    private void checkFoodInStock(Food food, Integer amount) throws NotEnoughFoodInStockException, FoodNotInStockException{
        Map<Food, Integer> foodStock = stock.getFoodStock();

        if(!foodStock.containsKey(food)) {
            throw new FoodNotInStockException(food.getName() + " is not in stock!");
        }

        if (foodStock.get(food) < amount) {
            throw new NotEnoughFoodInStockException("There is not enough " + food.getName() + " left!");
        }
    }

    private void checkCustomerMoney(Customer customer, Order order) throws NotEnoughMoneyException {
        boolean notEnough = order.getTotalPrice() > customer.getMoney();
        if (notEnough) {
            throw new NotEnoughMoneyException("Order costs " + order.getTotalPrice() + "€ en je hebt " + customer.getMoney() + "€");
        }
    }

    private void removeFoodFromStock(Order order) throws NotEnoughFoodInStockException, FoodNotInStockException{
        for (Map.Entry<Food, Integer> entry : order.getFoodItems().entrySet()) {
            Food food = entry.getKey();
            Integer amount = entry.getValue();
            stock.removeFromStock(food, amount);
        }
    }

    private void updateCustomersMoney(Customer customer, Order order) {
        customer.setMoney(customer.getMoney() - order.getTotalPrice());
    }

    private void addMoneyToRegister(Order order) {
        registers.get(0).addMoney(order.getTotalPrice());
        // TODO register -> multithreading
    }


}

