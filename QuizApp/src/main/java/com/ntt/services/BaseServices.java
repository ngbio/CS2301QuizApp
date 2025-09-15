/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ntt.services;

import com.ntt.utils.JdbcConnector;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author THUAN
 */
public abstract class BaseServices<T> {
    public abstract PreparedStatement getStm(Connection conn)throws SQLException;
    public abstract List<T> getResults(ResultSet rs)throws SQLException;
    
    public List<T> list() throws SQLException { /// mẫu template method
               // Mo ket noi
        Connection conn = JdbcConnector.getInstance().connect();

        // Truy van
        PreparedStatement stm = this.getStm(conn);

        return this.getResults(stm.executeQuery());
    };
}
