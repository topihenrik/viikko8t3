package com.example.viikko8t3;

import java.util.ArrayList;

public class BottleDispenser{
    private static float money;
    private static ArrayList<Bottle> bottleList = new ArrayList<Bottle>();
    private static BottleDispenser bd = null;

    private BottleDispenser(){}

    public static BottleDispenser getInstance() {
        if (bd == null) {
            bd = new BottleDispenser();
            money = 0;
            bottleList.add(new Bottle("Pepsi Max", "Pepsi", 0.3, 0.5, 1.8));
            bottleList.add(new Bottle("Pepsi Max", "Pepsi", 0.3, 1.5, 2.2));
            bottleList.add(new Bottle("Coca-Cola Zero", "Coca-Cola", 0.3, 0.5, 2.0));
            bottleList.add(new Bottle("Coca-Cola Zero", "Coca-Cola", 0.3, 1.5, 2.5));
            bottleList.add(new Bottle("Fanta Zero", "Coca-Cola", 0.3, 0.5, 1.95));
            return bd;
        }
        return bd;
    }

    public static float getMoney() {
        return money;
    }

    public static String getArrayElementName(int index) {
        return (bottleList.get(index-1)).getName();
    }

    public static String getArrayElementSize(int index) {
        return String.valueOf((bottleList.get(index-1)).getSize());
    }




    public void addMoney(int money) {
        this.money += money;
        return;
    }

    public int buyBottle(int choice) {
        int errCode;
        if (money >= bottleList.get(choice-1).getPrice()) {
            if (bottleList.size() >= 1) {
                money -= (bottleList.get(choice-1)).getPrice();
                errCode = 0;
            } else {
                errCode = 1;
            }
        } else {
            errCode = 2;
        }
        return errCode;
    }

    public void removeArray(int index) {
        bottleList.get(index-1).setName("Nothing");
        bottleList.get(index-1).setManufacturer("Nothing");
        bottleList.get(index-1).setEnergy(0);
        bottleList.get(index-1).setSize(0);
        bottleList.get(index-1).setPrice(0);
        return;
    }

    public void returnMoney() {
        money = 0;
        return;
    }

}
