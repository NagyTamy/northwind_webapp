package com.codecool.web.model;


public final class Task1 {

    private final String product;
    private final String company;

    public Task1(String product, String company) {
        this.product=product;
        this.company=company;
    }

    public String getProduct() {
        return product;
    }

    public String getCompany() {
        return company;
    }
}
