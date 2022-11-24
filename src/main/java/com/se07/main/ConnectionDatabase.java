package com.se07.main;

import com.microsoft.sqlserver.jdbc.SQLServerDataSource;
import com.microsoft.sqlserver.jdbc.SQLServerException;

import java.sql.*;

public class ConnectionDatabase {
    public Connection databaseLink;
    //
    public Connection getConnection() {
        SQLServerDataSource sqlServerDataSource = new SQLServerDataSource();
        sqlServerDataSource.setUser("sa");
        sqlServerDataSource.setPassword("123456");
        sqlServerDataSource.setServerName("DESKTOP-0P2LCL1");
        sqlServerDataSource.setDatabaseName("se07");
        sqlServerDataSource.setPortNumber(1433);
        sqlServerDataSource.setEncrypt(false);
        try {
            databaseLink = sqlServerDataSource.getConnection();
        } catch (SQLServerException e) {
            throw new RuntimeException(e);
        }
        return  databaseLink;
    }
}

