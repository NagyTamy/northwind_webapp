package com.codecool.web.service;

import com.codecool.web.model.Task5;
import com.codecool.web.service.exception.ServiceException;

import java.sql.SQLException;
import java.util.List;

public interface Task5Service {

    List<Task5> getTask5List() throws SQLException;

    List<Task5> getFilteredTask5List(String string) throws SQLException, ServiceException;

}
