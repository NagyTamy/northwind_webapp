package com.codecool.web.servlet;

import com.codecool.web.dao.Task1Dao;
import com.codecool.web.dao.database.DatabaseTask1Dao;
import com.codecool.web.model.Task1;
import com.codecool.web.service.Task1Service;
import com.codecool.web.service.simple.SimpleTask1Service;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

@WebServlet("")
public final class IndexServlet extends AbstractServlet {

    // https://www.postgresql.org/docs/current/static/errcodes-appendix.html
    private static final String SQL_ERROR_CODE_UNIQUE_VIOLATION = "23505";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("index.jsp").forward(req, resp);
    }

}
