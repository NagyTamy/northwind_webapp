package com.codecool.web.dao.database;

import com.codecool.web.dao.Task5Dao;
import com.codecool.web.model.Task5;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public final class DatabaseTask5Dao extends AbstractDao implements Task5Dao {

    public DatabaseTask5Dao(Connection connection) {
        super(connection);
    }
    

    @Override
    public List<Task5> getAll() throws SQLException{
        List<Task5> items = new ArrayList<>();
        String sql = "SELECT s.company_name AS Company, p.product_name as Product, p.unit_price AS Price FROM products AS p " +
                "JOIN suppliers AS s ON p.supplier_id = s.supplier_id " +
                "LEFT JOIN products AS prod ON p.supplier_id = prod.supplier_id AND p.unit_price < prod.unit_price " +
                "WHERE prod.product_id IS NULL " +
                "ORDER BY p.unit_price DESC, p.product_name, s.company_name;";
        try(Statement statement=connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql)){
            while (resultSet.next()){
                items.add(new Task5(resultSet.getString("Company"), resultSet.getString("Product"), resultSet.getFloat("Price")));
            }
        } return items;
    }

    @Override
    public List<Task5> findProductByName(String productName) throws SQLException {
        List<Task5> filteredItems = new ArrayList<>();
        List<Task5> allItems = getAll();
        for (Task5 item : allItems){
            if (item.getProduct().toLowerCase().contains(productName.toLowerCase())){
                filteredItems.add(item);
            }
        }
        return filteredItems;
    }



}
