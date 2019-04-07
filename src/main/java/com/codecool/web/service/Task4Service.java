package com.codecool.web.service;

import com.codecool.web.model.Task3;
import com.codecool.web.model.Task4;
import com.codecool.web.service.exception.ServiceException;

import java.sql.SQLException;
import java.util.List;

public interface Task4Service {

    List<Task4> getTask4List() throws SQLException;

    List<Task4> getFilteredTask4List(String string) throws SQLException, ServiceException;

}
