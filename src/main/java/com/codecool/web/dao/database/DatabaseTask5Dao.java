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
        String sql = "SELECT Company, product_name AS Product, unit_price AS Price FROM products p " +
                "INNER JOIN (SELECT company_name AS Company, MAX(list.unit_price) AS Price FROM products list " +
                "INNER JOIN suppliers ON list.supplier_id=suppliers.supplier_id " +
                "GROUP BY Company) t ON p.unit_price=t.Price ORDER BY Price DESC;";
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
