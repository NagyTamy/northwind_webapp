package com.codecool.web.dao;

import com.codecool.web.model.Task2;

import java.sql.SQLException;
import java.util.List;

public interface Task2Dao {

    List<Task2> getAll() throws SQLException;

    List<Task2> findCompanyByName(String companyName) throws SQLException;
    
}
