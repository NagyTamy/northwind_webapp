package com.codecool.web.servlet;

import com.codecool.web.dao.Task5Dao;
import com.codecool.web.dao.database.DatabaseTask5Dao;
import com.codecool.web.model.Task5;
import com.codecool.web.service.Task5Service;
import com.codecool.web.service.exception.ServiceException;
import com.codecool.web.service.simple.SimpleTask5Service;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/task5")
public final class Task5Servlet extends AbstractServlet {


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try (Connection connection = getConnection(req.getServletContext())) {
            Task5Dao task5Dao = new DatabaseTask5Dao(connection);
            Task5Service task5Service = new SimpleTask5Service(task5Dao);

            List<Task5> allItems = task5Service.getTask5List();

            req.setAttribute("list", allItems);
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
        req.getRequestDispatcher("task5.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try (Connection connection = getConnection(req.getServletContext())) {
            Task5Dao task5Dao = new DatabaseTask5Dao(connection);
            Task5Service task5Service = new SimpleTask5Service(task5Dao);

            String param = req.getParameter("product");

            List<Task5> filteredItems = task5Service.getFilteredTask5List(param);

            req.setAttribute("list", filteredItems);
        } catch (SQLException ex) {
            throw new ServletException(ex);
        } catch (ServiceException ex){
            req.setAttribute("error", "No result, please try a different name.");
            doGet(req, resp);
        }
        req.getRequestDispatcher("task5.jsp").forward(req, resp);
    }
}
