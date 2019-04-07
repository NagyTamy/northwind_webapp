package com.codecool.web.model;

public final class Task5 {

    private final String product;
    private final String company;
    private final float price;

    public Task5(String product, String company, float price) {
        this.product=product;
        this.company=company;
        this.price=price;
    }

    public String getProduct() {
        return product;
    }

    public String getCompany() {
        return company;
    }

    public float getPrice() {
        return price;
    }
}
