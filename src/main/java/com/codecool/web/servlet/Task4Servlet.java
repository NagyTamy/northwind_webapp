package com.codecool.web.servlet;

import com.codecool.web.dao.Task4Dao;
import com.codecool.web.dao.database.DatabaseTask4Dao;
import com.codecool.web.model.Task4;
import com.codecool.web.service.Task4Service;
import com.codecool.web.service.exception.ServiceException;
import com.codecool.web.service.simple.SimpleTask4Service;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/task4")
public final class Task4Servlet extends AbstractServlet {

    // https://www.postgresql.org/docs/current/static/errcodes-appendix.html
    private static final String SQL_ERROR_CODE_UNIQUE_VIOLATION = "44505";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try (Connection connection = getConnection(req.getServletContext())) {
            Task4Dao task4Dao = new DatabaseTask4Dao(connection);
            Task4Service task4Service = new SimpleTask4Service(task4Dao);

            List<Task4> allItems = task4Service.getTask4List();

            req.setAttribute("list", allItems);
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
        req.getRequestDispatcher("task4.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try (Connection connection = getConnection(req.getServletContext())) {
            Task4Dao task4Dao = new DatabaseTask4Dao(connection);
            Task4Service task4Service = new SimpleTask4Service(task4Dao);

            String param = req.getParameter("company");

            List<Task4> filteredItems = task4Service.getFilteredTask4List(param);

            req.setAttribute("list", filteredItems);
        } catch (SQLException ex) {
            throw new ServletException(ex);
        } catch (ServiceException ex){
            req.setAttribute("error", "No result, please try a different name.");
            doGet(req, resp);
        }
        req.getRequestDispatcher("task4.jsp").forward(req, resp);
    }
}
