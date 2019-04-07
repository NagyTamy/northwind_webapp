package com.codecool.web.dao.database;

import com.codecool.web.dao.Task4Dao;
import com.codecool.web.model.Task4;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public final class DatabaseTask4Dao extends AbstractDao implements Task4Dao {

    public DatabaseTask4Dao(Connection connection) {
        super(connection);
    }
    

    @Override
    public List<Task4> getAll() throws SQLException{
        List<Task4> items = new ArrayList<>();
        String sql = "SELECT company_name AS CompanyName, STRING_AGG(CAST(order_id AS varchar(10)), ', ') AS OrderID FROM customers " +
                "FULL OUTER JOIN orders ON customers.customer_id=orders.customer_id GROUP BY CompanyName ORDER BY CompanyName;";
        try(Statement statement=connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql)){
            while (resultSet.next()){
                items.add(new Task4(resultSet.getString("CompanyName"), resultSet.getString("OrderID")));
            }
        } return items;
    }

    @Override
    public List<Task4> findOrdersByCompanyName(String companyName) throws SQLException {
        List<Task4> filteredItems = new ArrayList<>();
        List<Task4> allItems = getAll();
        for (Task4 item : allItems){
            if (item.getCompany().toLowerCase().contains(companyName.toLowerCase())){
                filteredItems.add(item);
            }
        }
        return filteredItems;
    }


}
