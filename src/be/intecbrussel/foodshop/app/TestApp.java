package be.intecbrussel.foodshop.app;

import be.intecbrussel.foodshop.exception.FoodAlreadyInStockException;
import be.intecbrussel.foodshop.exception.FoodNotInStockException;
import be.intecbrussel.foodshop.exception.NotEnoughFoodInStockException;
import be.intecbrussel.foodshop.exception.NotEnoughMoneyException;
import be.intecbrussel.foodshop.model.*;

import java.util.Map;

public class  TestApp {
    public static void main(String[] args) {
        Stock stock = new Stock();
        FoodShop foodShop = new FoodShop(stock);
        Customer hungryPerson = new Customer("Mustafa", 101, "medeniz@gmail.com", 1520);

        Food apple = new Food("Apple", 1, 25, "Adam");
        Food pollo = new Food("Chicken", 3, 35, "CP");
        Food pizza = new Food("Pizza Hut", 7.5, 350, "Mediterranean");
        Food hamburger = new Food("MvDonalds", 6.5, 400, "Bic Mac");
        Food patat = new Food("Patato", 5, 125, "Patates");

        addFood(stock, pizza);
        addFood(stock, patat);
        addFood(stock, apple);

        addToStock(stock, pizza, 21);
        addToStock(stock, patat, 6);
        addToStock(stock, apple, 2);

        Order myFirstOrder = new Order();
        myFirstOrder.addFoodToOrder(pizza, 2);
        myFirstOrder.addFoodToOrder(patat, 5);
        myFirstOrder.addFoodToOrder(apple, 9);
        myFirstOrder.addFoodToOrder(pollo, 6);
        myFirstOrder.addFoodToOrder(hamburger, 3);

        System.out.println("════ Order ════");
        myFirstOrder.getFoodItems().forEach((food, amount) -> System.out.println(amount + " " + food));
        System.out.println();
        System.out.println("════ Stock ════");
        stock.getFoodStock().forEach((food, amount) -> System.out.println(amount + " " + food));
        System.out.println();

        myFirstOrder.applyDiscount(-30);

        try {
            foodShop.sellFood(myFirstOrder, hungryPerson);
        } catch (NotEnoughMoneyException e) {
            System.out.println(e.getMessage());
            System.out.println("This is not enough money for this order!");
        } catch (NotEnoughFoodInStockException notEnoughFoodInStockException) {
            System.out.println(notEnoughFoodInStockException.getMessage());
            System.out.println("We don't have enough of this to make the order, try our other products");
        } catch (FoodNotInStockException foodNotInStockException) {
            System.out.println(foodNotInStockException.getMessage());
            System.out.println("We don't have this item!");
        }

        stock.getFoodStock().forEach((food, amount) -> System.out.println(amount + " " + food));
        System.out.println();

        System.out.println(hungryPerson.getMoney());
        System.out.println(foodShop.getRegisters().get(0).getMoney());
    }

    private static void addFood(Stock stock, Food food) {
        try {
            stock.addFood(food);
        } catch (FoodAlreadyInStockException faise) {
            System.out.println(faise.getMessage());
        }
    }

    private static void addToStock(Stock stock, Food food, int amount){
        try {
            stock.addToStock(food, amount);
        } catch (FoodNotInStockException fnise) {
            System.out.println(fnise.getMessage());
        }
    }

    private static void removeFromStock(Stock stock, Food food, int amount) {
        try {
            stock.removeFromStock(food, amount);
        } catch (NotEnoughFoodInStockException nefise) {
            System.out.println(nefise.getMessage());
            System.out.println("You need to order more !");
        } catch (FoodNotInStockException fnise) {
            System.out.println(fnise.getMessage());
            System.out.println("You need to create a stock !");
        }
    }

    private static void print(Stock stock) {
        Map<Food, Integer> foodStock = stock.getFoodStock();
        System.out.println("------FOOD STOCK-----");
        for (Food food : foodStock.keySet()) {
            System.out.println(food.getName() + " - " + foodStock.get(food));
        }
        System.out.println("---------------------");
    }
}
