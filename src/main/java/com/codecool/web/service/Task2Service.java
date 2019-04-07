package com.codecool.web.service;

import com.codecool.web.model.Task2;
import com.codecool.web.service.exception.ServiceException;

import java.sql.SQLException;
import java.util.List;

public interface Task2Service {

    List<Task2> getTask2List() throws SQLException;

    List<Task2> getFilteredTask2List(String string) throws SQLException, ServiceException;

}
