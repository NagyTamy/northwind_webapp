package com.codecool.web.service;

import com.codecool.web.model.Task3;
import com.codecool.web.service.exception.ServiceException;

import java.sql.SQLException;
import java.util.List;

public interface Task3Service {

    List<Task3> getTask3List() throws SQLException;

    List<Task3> getFilteredTask3List(String string) throws SQLException, ServiceException;

}
