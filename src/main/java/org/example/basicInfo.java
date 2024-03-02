package org.example;

public class basicInfo { //create variables

    private String id;
    private String name;
    private double price;
    private String category;

    public basicInfo(String id, String name, double price, String category) { //make variable into a constructor
        this.id = id;
        this.name = name;
        this.price = price;
        this.category = category;
    }

    public String getName() {
        return name;
    } // make a method that prints name

    public double getPrice() {
        return price;
    } // make a method that prints price

    public String getCategory() {
        return category;
    } // make a method that prints category

    @Override
    public String toString() { // made a method that prints all
        return "ID: " + id + ", Category: " + category + ", Name: " + name + ", Price: $" + price;
    }
}
