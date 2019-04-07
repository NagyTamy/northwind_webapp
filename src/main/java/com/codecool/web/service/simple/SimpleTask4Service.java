package com.codecool.web.service.simple;

import com.codecool.web.dao.Task4Dao;
import com.codecool.web.model.Task4;
import com.codecool.web.service.Task4Service;
import com.codecool.web.service.exception.ServiceException;

import java.sql.SQLException;
import java.util.List;

public final class SimpleTask4Service implements Task4Service {

    private final Task4Dao task4Dao;

    public SimpleTask4Service(Task4Dao task4Dao) {
        this.task4Dao=task4Dao;
    }

    @Override
    public List<Task4> getTask4List() throws SQLException {
        return task4Dao.getAll();
    }


    @Override
    public List<Task4> getFilteredTask4List(String string) throws SQLException, ServiceException {
        List<Task4> filteredList = task4Dao.findOrdersByCompanyName(string);
        if(filteredList.size()>0){
            return filteredList;
        } else {
            throw new ServiceException("No data found with these details.");
        }
    }
}
