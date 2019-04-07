package com.codecool.web.model;


public final class Task4 {

    private final String orderIDs;
    private final String company;

    public Task4(String company, String orderID) {
        this.orderIDs=orderID;
        this.company=company;
    }

    public String getOrderIDs() {
        return orderIDs;
    }

    public String getCompany() {
        return company;
    }
}
