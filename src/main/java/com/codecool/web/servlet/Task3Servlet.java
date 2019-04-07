package com.codecool.web.servlet;

import com.codecool.web.dao.Task3Dao;
import com.codecool.web.dao.database.DatabaseTask3Dao;
import com.codecool.web.model.Task3;
import com.codecool.web.service.Task3Service;
import com.codecool.web.service.exception.ServiceException;
import com.codecool.web.service.simple.SimpleTask3Service;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/task3")
public final class Task3Servlet extends AbstractServlet {

    // https://www.postgresql.org/docs/current/static/errcodes-appendix.html
    private static final String SQL_ERROR_CODE_UNIQUE_VIOLATION = "33505";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try (Connection connection = getConnection(req.getServletContext())) {
            Task3Dao task3Dao = new DatabaseTask3Dao(connection);
            Task3Service task3Service = new SimpleTask3Service(task3Dao);

            List<Task3> allItems = task3Service.getTask3List();

            req.setAttribute("list", allItems);
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
        req.getRequestDispatcher("task3.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try (Connection connection = getConnection(req.getServletContext())) {
            Task3Dao task3Dao = new DatabaseTask3Dao(connection);
            Task3Service task3Service = new SimpleTask3Service(task3Dao);

            String param = req.getParameter("company");

            List<Task3> filteredItems = task3Service.getFilteredTask3List(param);

            req.setAttribute("list", filteredItems);
        } catch (SQLException ex) {
            throw new ServletException(ex);
        } catch (ServiceException ex){
            req.setAttribute("error", "No result, please try a different name.");
            doGet(req, resp);
        }
        req.getRequestDispatcher("task3.jsp").forward(req, resp);
    }
}
