package org.procode.app;

public class Product {

    private long id;
    private String name;
    private double price;


    public Product() {
    }

    public Product(long id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void increasePrice(double value) {
        price += value;

    }

    public void decreasePrice(double value) {
        price -= value;

    }

    public String getProductCatalogue(Long pId){
        //DB is not ready
        return "";
    }
}
