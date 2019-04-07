package com.codecool.web.dao.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

abstract class AbstractDao {

    final Connection connection;

    AbstractDao(Connection connection) {
        this.connection = connection;
    }

}
