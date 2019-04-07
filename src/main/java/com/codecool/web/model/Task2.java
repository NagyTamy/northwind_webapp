package com.codecool.web.model;

public final class Task2 {

    private final int numbersOfProduct;
    private final String company;

    public Task2(int numbersOfProduct, String company) {
        this.numbersOfProduct=numbersOfProduct;
        this.company=company;
    }

    public int getNumbersOfProduct() {
        return numbersOfProduct;
    }

    public String getCompany() {
        return company;
    }
}
