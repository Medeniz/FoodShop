package be.intecbrussel.foodshop.model;

import java.util.Objects;

public class Food {
    private String name;
    private double price;
    private double calori;
    private String brand;

    public Food(String name, double price, double calori, String brand) {
        this.name = name;
        this.price = price;
        this.calori = calori;
        this.brand = brand;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getCalori() {
        return calori;
    }

    public void setCalori(double calori) {
        this.calori = calori;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Food food = (Food) o;
        return Double.compare(food.price, price) == 0 &&
                Double.compare(food.calori, calori) == 0 &&
                Objects.equals(name, food.name) &&
                Objects.equals(brand, food.brand);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, price, calori, brand);
    }

    @Override
    public String toString() {
        return "Food{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", calori=" + calori +
                ", brand='" + brand + '\'' +
                '}';
    }
}
