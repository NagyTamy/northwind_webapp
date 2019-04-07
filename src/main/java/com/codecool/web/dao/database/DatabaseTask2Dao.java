package com.codecool.web.dao.database;

import com.codecool.web.dao.Task2Dao;
import com.codecool.web.model.Task2;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public final class DatabaseTask2Dao extends AbstractDao implements Task2Dao {

    public DatabaseTask2Dao(Connection connection) {
        super(connection);
    }




    @Override
    public List<Task2> getAll() throws SQLException{
        List<Task2> items = new ArrayList<>();
        String sql = "SELECT company_name AS Company, count(company_name) AS NumbersOfProduct FROM suppliers " +
                "FULL OUTER JOIN products ON products.supplier_id=suppliers.supplier_id GROUP BY company_name " +
                "ORDER BY NumbersOfProduct DESC, Company";
        try(Statement statement=connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql)){
            while (resultSet.next()){
                items.add(new Task2(resultSet.getInt("NumbersOfProduct"), resultSet.getString("company_name")));
            }
        } return items;
    }


    @Override
    public List<Task2> findCompanyByName(String companyName) throws SQLException {
        List<Task2> filteredItems = new ArrayList<>();
        List<Task2> allItems = getAll();
        for(Task2 item : allItems){
            if(item.getCompany().contains(companyName)){
                filteredItems.add(item);
            }
        }
        return filteredItems;
    }


}
