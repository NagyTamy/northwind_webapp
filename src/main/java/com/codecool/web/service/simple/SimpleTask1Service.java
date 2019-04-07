package com.codecool.web.service.simple;

import com.codecool.web.dao.Task1Dao;
import com.codecool.web.model.Task1;
import com.codecool.web.service.Task1Service;
import com.codecool.web.service.exception.ServiceException;

import java.sql.SQLException;
import java.util.List;

public final class SimpleTask1Service implements Task1Service {

    private final Task1Dao task1Dao;

    public SimpleTask1Service(Task1Dao task1Dao) {
        this.task1Dao=task1Dao;
    }

    @Override
    public List<Task1> getTask1List() throws SQLException {
        return task1Dao.getAll();
    }


    @Override
    public List<Task1> getFilteredTask1List(String string) throws SQLException, ServiceException {
        List<Task1> filteredList = task1Dao.findProductsByName(string);
        if(filteredList.size()>0){
            return filteredList;
        } else {
            throw new ServiceException("No data found with these details.");
        }
    }
}
