package com.example.helloworld;

public class Fruit {
    private String name;//水果的名称
    private int imageld;

    public Fruit(String name, int imageld) {
        this.name = name;
        this.imageld = imageld;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getImageld() {
        return imageld;
    }

    public void setImageld(int imageld) {
        this.imageld = imageld;
    }
}
