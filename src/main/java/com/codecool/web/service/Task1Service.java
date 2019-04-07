package com.codecool.web.service;

import com.codecool.web.model.Task1;
import com.codecool.web.service.exception.ServiceException;

import java.sql.SQLException;
import java.util.List;
import java.util.ServiceConfigurationError;

public interface Task1Service {

    List<Task1> getTask1List() throws SQLException;

    List<Task1> getFilteredTask1List(String string) throws SQLException, ServiceException;

}
