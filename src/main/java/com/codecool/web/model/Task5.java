package com.codecool.web.model;

public final class Task5 {

    private final String product;
    private final String company;
    private final int price;

    public Task5(String product, String company, int price) {
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

    public int getPrice() {
        return price;
    }
}
