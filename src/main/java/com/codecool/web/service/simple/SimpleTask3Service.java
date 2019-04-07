package com.codecool.web.service.simple;

import com.codecool.web.dao.Task3Dao;
import com.codecool.web.model.Task3;
import com.codecool.web.service.Task3Service;
import com.codecool.web.service.exception.ServiceException;

import java.sql.SQLException;
import java.util.List;

public final class SimpleTask3Service implements Task3Service {

    private final Task3Dao task3Dao;

    public SimpleTask3Service(Task3Dao task3Dao) {
        this.task3Dao=task3Dao;
    }

    @Override
    public List<Task3> getTask3List() throws SQLException {
        return task3Dao.getAll();
    }


    @Override
    public List<Task3> getFilteredTask3List(String string) throws SQLException, ServiceException {
        List<Task3> filteredList = task3Dao.findCompanyByName(string);
        if(filteredList.size()>0){
            return filteredList;
        } else {
            throw new ServiceException("No data found with these details.");
        }
    }
}
