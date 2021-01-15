package be.intecbrussel.foodshop.model;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Order {
    private Map<Food, Integer> foodItems;
    private double percentDiscount;

    public Order() { 
        this.foodItems = new HashMap<>();
    } 

    public Map<Food, Integer> getFoodItems() { 
        return foodItems;
    } 

    public void setFoodItems(Map<Food, Integer> foodItems) { 
        this.foodItems = foodItems;
    } 

    public double getDiscount() { 
        return percentDiscount;
    } 

    public void applyDiscount(double percent) {
        if (percent > 0 && percent <= 100) {
            percentDiscount = percent;
        } else {
            // TODO handle Incorrect Percentage.
        }
    } 

    public double getTotalPrice(){ 
        // obtain a set of key-value pairs:
        Set<Map.Entry<Food, Integer>> foodSet = foodItems.entrySet();
        double totalPrice = foodSet.stream()
                .mapToDouble(entry -> entry.getKey().getPrice() * entry.getValue())
                .sum();

        double priceAfterDiscount = totalPrice - (totalPrice/100*percentDiscount);

        return priceAfterDiscount;
    }

    public void addFoodToOrder(Food food, Integer amount) {
        Integer amountAlreadyInOrder = foodItems.putIfAbsent(food, amount);

        if (amountAlreadyInOrder == null) {
            return;
        }

        foodItems.replace(food, amountAlreadyInOrder + amount);
    }
}
