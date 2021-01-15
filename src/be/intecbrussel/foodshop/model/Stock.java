package be.intecbrussel.foodshop.model;

import be.intecbrussel.foodshop.exception.FoodAlreadyInStockException;
import be.intecbrussel.foodshop.exception.FoodNotInStockException;
import be.intecbrussel.foodshop.exception.NotEnoughFoodInStockException;

import java.util.HashMap;
import java.util.Map;

public class Stock {
    private Map<Food, Integer> foodStock;

    {
        foodStock = new HashMap<>();
    }

    public Map<Food, Integer> getFoodStock() { 
        return foodStock;
    } 

    public void setFoodStock(Map<Food, Integer> foodStock) { 
        this.foodStock = foodStock;
    }

    public void addFood(Food food) throws FoodAlreadyInStockException{
        if(food != null){
            Integer value = this.foodStock.putIfAbsent(food, 0);
            if (value != null) {
                throw new FoodAlreadyInStockException("Food " + food.getName() + " is already in the stock.");
            }
        } 
    } 

    public void removeFood(Food food) { 
        this.foodStock.remove(food);
    }

    public void addToStock(Food food, int amountToAdd) throws FoodNotInStockException{
        if (foodStock.containsKey(food)) {
            int newAmount = foodStock.get(food) + amountToAdd;
            foodStock.replace(food, newAmount);
        } else {
            throw new FoodNotInStockException("Food " + food.getName() + " does not have stock!");
        }
    }

    public void removeFromStock(Food food, int amount) throws NotEnoughFoodInStockException, FoodNotInStockException {
        if (!foodStock.containsKey(food)) {
            throw new FoodNotInStockException("Food " + food.getName() + " does not have a stock!");
        }

        if (this.foodStock.get(food) < amount) {
            throw new NotEnoughFoodInStockException("There is not enough of this food " + food.getName() + " in stock. Stock: " + this.foodStock.get(food) + " | Trying to remove: " + amount);
        }  else { 
            this.foodStock.replace(food, foodStock.get(food) - amount);
        } 
    }

}
