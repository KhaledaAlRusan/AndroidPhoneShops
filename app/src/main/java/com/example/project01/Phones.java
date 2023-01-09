package com.example.project01;

public class Phones {
    String name,brand;
    String[] colors;
    double price;
    int image,storage[];

    public Phones() {
    }

    public Phones(String name, String brand, String[] colors, double price, int image, int[] storage) {
        this.name = name;
        this.brand = brand;
        this.colors = colors;
        this.price = price;
        this.image = image;
        this.storage = storage;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String[] getColors() {
        return colors;
    }

    public void setColors(String[] colors) {
        this.colors = colors;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public int[] getStorage() {
        return storage;
    }

    public void setStorage(int[] storage) {
        this.storage = storage;
    }
}
