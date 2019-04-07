package com.codecool.web.servlet;

import com.codecool.web.dao.Task1Dao;
import com.codecool.web.dao.database.DatabaseTask1Dao;
import com.codecool.web.model.Task1;
import com.codecool.web.service.Task1Service;
import com.codecool.web.service.exception.ServiceException;
import com.codecool.web.service.simple.SimpleTask1Service;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@WebServlet("/task1")
public final class Task1Servlet extends AbstractServlet {

    // https://www.postgresql.org/docs/current/static/errcodes-appendix.html
    private static final String SQL_ERROR_CODE_UNIQUE_VIOLATION = "23505";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try (Connection connection = getConnection(req.getServletContext())) {
            Task1Dao task1Dao = new DatabaseTask1Dao(connection);
            Task1Service task1Service = new SimpleTask1Service(task1Dao);

            List<Task1> allItems = task1Service.getTask1List();

            req.setAttribute("list", allItems);
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
        req.getRequestDispatcher("task1.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try (Connection connection = getConnection(req.getServletContext())) {
            Task1Dao task1Dao = new DatabaseTask1Dao(connection);
            Task1Service task1Service = new SimpleTask1Service(task1Dao);

            String param = req.getParameter("product");
            List<Task1> filteredItems = task1Service.getFilteredTask1List(param);

            req.setAttribute("list", filteredItems);
        } catch (SQLException ex) {
            throw new ServletException(ex);
        } catch (ServiceException ex){
            req.setAttribute("error", "No result, please try a different name.");
            doGet(req, resp);
        }
        req.getRequestDispatcher("task1.jsp").forward(req, resp);
    }
}
