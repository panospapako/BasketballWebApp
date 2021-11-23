/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;


import entities.User;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author ppapakostas
 */
public class UserDao extends SuperDao {
    private static final String FINDUSERBYUSERNAME = "SELECT * FROM User WHERE username = ?";

    public User findByUserName(String uN) {
        PreparedStatement pstm = null;
        ResultSet rs = null;
        User u = null;
        try {
            pstm = getConnection().prepareStatement(FINDUSERBYUSERNAME);
            pstm.setString(1, uN);
            rs = pstm.executeQuery();
            rs.next();
            String userName = rs.getString(1);
            String password = rs.getString(2);
            int role = rs.getInt(3);
            u = new User(userName, password, role);
        } catch (SQLException ex) {
            Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NullPointerException e) {

        } finally {
            closeConnections(rs, pstm);
        }
        return u;
    }
}
