package com.codecool.web.servlet;

import com.codecool.web.dao.Task2Dao;
import com.codecool.web.dao.database.DatabaseTask2Dao;
import com.codecool.web.model.Task2;
import com.codecool.web.service.Task2Service;
import com.codecool.web.service.exception.ServiceException;
import com.codecool.web.service.simple.SimpleTask2Service;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/task2")
public final class Task2Servlet extends AbstractServlet {

    // https://www.postgresql.org/docs/current/static/errcodes-appendix.html
    private static final String SQL_ERROR_CODE_UNIQUE_VIOLATION = "23505";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try (Connection connection = getConnection(req.getServletContext())) {
            Task2Dao task2Dao = new DatabaseTask2Dao(connection);
            Task2Service task2Service = new SimpleTask2Service(task2Dao);

            List<Task2> allItems = task2Service.getTask2List();

            req.setAttribute("list", allItems);
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
        req.getRequestDispatcher("task2.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try (Connection connection = getConnection(req.getServletContext())) {
            Task2Dao task2Dao = new DatabaseTask2Dao(connection);
            Task2Service task2Service = new SimpleTask2Service(task2Dao);

            String param = req.getParameter("company");

            List<Task2> filteredItems = task2Service.getFilteredTask2List(param);

            req.setAttribute("list", filteredItems);
        } catch (SQLException ex) {
            throw new ServletException(ex);
        } catch (ServiceException ex){
            req.setAttribute("error", "No result, please try a different name.");
            doGet(req, resp);
        }
        req.getRequestDispatcher("task2.jsp").forward(req, resp);
    }
}
