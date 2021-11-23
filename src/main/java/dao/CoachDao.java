/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entities.Coach;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author ppapakostas
 */
public class CoachDao extends SuperDao implements InterfaceDao<Coach> {
    private static final String FINDALL = "SELECT idNumber, lName, fName FROM Coach";
    private static final String FINDCOACHBYID = "SELECT * FROM Coach WHERE idNumber = ?";
    private static final String INSERTCOACH = "INSERT INTO Coach (lName, fName) VALUES (?, ?)";
    private static final String DELETECOACH = "DELETE FROM Coach WHERE idNumber = ?";
    private static final String UPDATECOACH = "UPDATE Coach SET lName = ? , fName = ? WHERE idNumber = ?";

    @Override
    public List<Coach> findAll() {
        Statement stmt = null;
        ResultSet rs = null;
        List<Coach> list = new ArrayList<>();
        try {
            stmt = getConnection().createStatement();
            rs = stmt.executeQuery(FINDALL);
            while (rs.next()) {
                int idNumber = rs.getInt(1);
                String lName = rs.getString(2);
                String fName = rs.getString(3);
                Coach c = new Coach(idNumber, lName, fName);
                list.add(c);
            }
        } catch (SQLException ex) {
            Logger.getLogger(CoachDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            closeConnections(rs, stmt);
        }
        return list;
    }

    @Override
    public Coach findById(int id) {
        PreparedStatement pstm = null;
        ResultSet rs = null;
        Coach c = null;
        try {
            pstm = getConnection().prepareStatement(FINDCOACHBYID);
            pstm.setInt(1, id);
            rs = pstm.executeQuery();
            rs.next();
            int idNumber = rs.getInt(1);
            String lName = rs.getString(2);
            String fName = rs.getString(3);
            c = new Coach(idNumber, fName, lName);
        } catch (SQLException ex) {
            Logger.getLogger(CoachDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            closeConnections(rs, pstm);
        }
        return c;
    }

    @Override
    public boolean create(Coach c) {
        PreparedStatement pst = null;
        boolean created = false;
        try {
            pst = getConnection().prepareStatement(INSERTCOACH);
            pst.setString(1, c.getlName());
            pst.setString(2, c.getfName());
            int result = pst.executeUpdate();
            if (result > 0) {
                created = true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(CoachDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            closeConnections(pst);
        }
        return created;
    }

    @Override
    public boolean delete(int id) {
        PreparedStatement pst = null;
        boolean deleted = false;
        try {
            pst = getConnection().prepareStatement(DELETECOACH);
            pst.setInt(1, id);
            int result = pst.executeUpdate();
            if (result > 0) {
                deleted = true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(CoachDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            closeConnections(pst);
        }
        return deleted;
    }

    @Override
    public boolean update(Coach c) {
        PreparedStatement pst = null;
        boolean updated = false;
        try {
            pst = getConnection().prepareStatement(UPDATECOACH);
            pst.setString(1, c.getlName());
            pst.setString(2, c.getfName());
            pst.setInt(3, c.getIdNumber());
            int result = pst.executeUpdate();
            if (result > 0) {
                updated = true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(PlayerDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            closeConnections(pst);
        }
        return updated;
    }
}
