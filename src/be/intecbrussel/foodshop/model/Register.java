package be.intecbrussel.foodshop.model;

import be.intecbrussel.foodshop.exception.NotEnoughMoneyInRegisterException;

public class Register {
    private double money;

    public double getMoney() {
        return money;
    }

    public void addMoney(double amount) {
        this.money += amount;
    }

    public void deductMoney(double moneyToDeduct) throws NotEnoughMoneyInRegisterException {
        if (moneyToDeduct > money) {
            throw new NotEnoughMoneyInRegisterException("There is not enough money in the register to proceed this transaction. Register: " + money + "€ | Trying to deduct: " + moneyToDeduct + "€");
        } else {
            this.money -= moneyToDeduct;
        }
    }

}
