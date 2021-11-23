/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entities.Stadium;

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
public class StadiumDao extends SuperDao implements InterfaceDao<Stadium> {
    private static final String FINDALL = "SELECT stadId, sName, location, capacity FROM Stadium";
    private static final String FINDSTADIUMBYID = "SELECT * FROM Stadium WHERE stadId = ?";
    private static final String INSERTSTADIUM = "INSERT INTO Stadium (sName, location, capacity) VALUES (?, ?, ?)";
    private static final String DELETESTADIUM = "DELETE FROM Stadium WHERE stadId = ?";
    private static final String UPDATESTADIUM = "UPDATE Stadium SET sName = ?, location = ?, capacity = ? WHERE stadId = ?";

    @Override
    public List<Stadium> findAll() {
        Statement stmt = null;
        ResultSet rs = null;
        List<Stadium> list = new ArrayList<>();
        try {
            stmt = getConnection().createStatement();
            rs = stmt.executeQuery(FINDALL);
            while (rs.next()) {
                int stadId = rs.getInt(1);
                String sName = rs.getString(2);
                String location = rs.getString(3);
                int capacity = rs.getInt(4);
                Stadium s = new Stadium(stadId, sName, location, capacity);
                list.add(s);
            }
        } catch (SQLException ex) {
            Logger.getLogger(StadiumDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            closeConnections(rs, stmt);
        }
        return list;
    }

    @Override
    public Stadium findById(int id) {
        PreparedStatement pstm = null;
        ResultSet rs = null;
        Stadium s = null;
        try {
            pstm = getConnection().prepareStatement(FINDSTADIUMBYID);
            pstm.setInt(1, id);
            rs = pstm.executeQuery();
            rs.next();
            int stadId = rs.getInt(1);
            String sName = rs.getString(2);
            String location = rs.getString(3);
            int capacity = rs.getInt(4);
            s = new Stadium(stadId, sName, location, capacity);
        } catch (SQLException ex) {
            Logger.getLogger(StadiumDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            closeConnections(rs, pstm);
        }
        return s;
    }

    @Override
    public boolean create(Stadium s) {
        PreparedStatement pst = null;
        boolean created = false;
        try {
            pst = getConnection().prepareStatement(INSERTSTADIUM);
            pst.setString(1, s.getsName());
            pst.setString(2, s.getLocation());
            pst.setInt(3, s.getCapacity());

            int result = pst.executeUpdate();
            if (result > 0) {
                created = true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(StadiumDao.class.getName()).log(Level.SEVERE, null, ex);
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
            pst = getConnection().prepareStatement(DELETESTADIUM);
            pst.setInt(1, id);
            int result = pst.executeUpdate();
            if (result > 0) {
                deleted = true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(StadiumDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            closeConnections(pst);
        }
        return deleted;
    }

    @Override
    public boolean update(Stadium s) {
        PreparedStatement pst = null;
        boolean updated = false;
        try {
            pst = getConnection().prepareStatement(UPDATESTADIUM);
            pst.setString(1, s.getsName());
            pst.setString(2, s.getLocation());
            pst.setInt(3, s.getCapacity());
            pst.setInt(4, s.getStadId());
            int result = pst.executeUpdate();
            if (result > 0) {
                updated = true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(StadiumDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            closeConnections(pst);
        }
        return updated;
    }

}
