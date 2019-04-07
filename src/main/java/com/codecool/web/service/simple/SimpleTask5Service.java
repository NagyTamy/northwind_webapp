package com.codecool.web.service.simple;

import com.codecool.web.dao.Task5Dao;
import com.codecool.web.model.Task5;
import com.codecool.web.service.Task5Service;
import com.codecool.web.service.exception.ServiceException;

import java.sql.SQLException;
import java.util.List;

public final class SimpleTask5Service implements Task5Service {

    private final Task5Dao task5Dao;

    public SimpleTask5Service(Task5Dao task5Dao) {
        this.task5Dao=task5Dao;
    }

    @Override
    public List<Task5> getTask5List() throws SQLException {
        return task5Dao.getAll();
    }


    @Override
    public List<Task5> getFilteredTask5List(String string) throws SQLException, ServiceException {
        List<Task5> filteredList = task5Dao.findProductByName(string);
        if(filteredList.size()>0){
            return filteredList;
        } else {
            throw new ServiceException("No data found with these details.");
        }
    }
}
