package com.codecool.web.dao.database;

import com.codecool.web.dao.Task3Dao;
import com.codecool.web.model.Task3;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public final class DatabaseTask3Dao extends AbstractDao implements Task3Dao {

    public DatabaseTask3Dao(Connection connection) {
        super(connection);
    }


    @Override
    public List<Task3> getAll() throws SQLException{
        List<Task3> items = new ArrayList<>();
        String sql = "SELECT company_name AS Company FROM suppliers " +
                "FULL OUTER JOIN products ON products.supplier_id=suppliers.supplier_id GROUP BY company_name " +
                "ORDER BY Company;";
        try(Statement statement=connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql)){
            while (resultSet.next()){
                items.add(new Task3(resultSet.getString("company_name")));
            }
        } return items;
    }


    @Override
    public List<Task3> findCompanyByName(String companyName) throws SQLException {
        List<Task3> filteredItems = new ArrayList<>();
        List<Task3> allItems = getAll();
        for(Task3 item : allItems){
            if(item.getCompany().contains(companyName)){
                filteredItems.add(item);
            }
        }
        return filteredItems;
    }


}
