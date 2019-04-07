package com.codecool.web.service.simple;

import com.codecool.web.dao.Task2Dao;
import com.codecool.web.model.Task2;
import com.codecool.web.service.Task2Service;
import com.codecool.web.service.exception.ServiceException;

import java.sql.SQLException;
import java.util.List;

public final class SimpleTask2Service implements Task2Service {

    private final Task2Dao task2Dao;

    public SimpleTask2Service(Task2Dao task2Dao) {
        this.task2Dao=task2Dao;
    }

    @Override
    public List<Task2> getTask2List() throws SQLException {
        return task2Dao.getAll();
    }


    @Override
    public List<Task2> getFilteredTask2List(String string) throws SQLException, ServiceException {
        List<Task2> filteredList = task2Dao.findCompanyByName(string);
        if(filteredList.size()>0){
            return filteredList;
        } else {
            throw new ServiceException("No data found with these details.");
        }
    }
}
