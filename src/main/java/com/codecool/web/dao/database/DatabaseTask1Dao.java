package com.codecool.web.dao.database;

import com.codecool.web.dao.Task1Dao;
import com.codecool.web.model.Task1;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public final class DatabaseTask1Dao extends AbstractDao implements Task1Dao {

    public DatabaseTask1Dao(Connection connection) {
        super(connection);
    }


    @Override
    public List<Task1> getAll() throws SQLException {
        List<Task1> items = new ArrayList<>();
        String sql = "SELECT product_name AS Product, company_name AS Supplier FROM products FULL OUTER JOIN suppliers " +
                "ON products.supplier_id=suppliers.supplier_id ORDER BY product_name, company_name";
        try(Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql)){
                while (resultSet.next()){
                    items.add(new Task1(resultSet.getString("product_name"), resultSet.getString("company_name")));

                }
            }return items;
        }



    @Override
    public List<Task1> findProductsByName(String productName) throws SQLException {
        List<Task1> filteredItems = new ArrayList<>();
        List<Task1> allItems = getAll();
        for (Task1 item : allItems){
            if (item.getProduct().contains(productName)){
                filteredItems.add(item);
            }
        }
        return filteredItems;
    }
}
