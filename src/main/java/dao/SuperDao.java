/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author ppapakostas
 */
public class SuperDao {        //API:db://server name:port/db name?
    private final String URL = "jdbc:mysql://localhost:3306/basketballApp?serverTimezone=UTC";
    private final String USER = "root";
    private final String PASS = "1234";
    private Connection conn;

    protected Connection getConnection() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(URL, USER, PASS);
        } catch (SQLException ex) {
            Logger.getLogger(PlayerDao.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(SuperDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return conn;
    }//getConnection

    protected void closeConnections(ResultSet rs, Statement stmt) {
        try {
            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(PlayerDao.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
    }//closeConnections

    protected void closeConnections(Statement st) {
        try {
            st.close();
            conn.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
    }//closeConnections


}//class

