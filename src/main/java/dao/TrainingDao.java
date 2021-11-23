/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entities.Training;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author ppapakostas
 */
public class TrainingDao extends SuperDao implements InterfaceDao<Training> {

    private static final String INSERTTRAINING = "INSERT INTO Training (tDateTime) VALUES (?)";
    private static final String FINDALL = "SELECT trainId, tDateTime FROM Training";
    private static final String FINDTRAININGBYID = "SELECT * FROM Training WHERE trainId = ?";
    private static final String DELETETRAINING = "DELETE FROM Training WHERE trainId = ?";
    private static final String UPDATETRAINING = "UPDATE Training SET tDateTime = ? WHERE trainId = ?";

    @Override
    public boolean create(Training t) {
        PreparedStatement pst = null;
        boolean created = false;
        try {
            pst = getConnection().prepareStatement(INSERTTRAINING);
            pst.setString(1, String.valueOf(t.gettDateTime()));
            int result = pst.executeUpdate();
            if (result > 0) {
                created = true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(PlayerDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            closeConnections(pst);
        }
        return created;
    }

    @Override
    public List<Training> findAll() {
        Statement stmt = null;
        ResultSet rs = null;
        List<Training> list = new ArrayList<>();
        try {
            stmt = getConnection().createStatement();
            rs = stmt.executeQuery(FINDALL);
            while (rs.next()) {
                int trainId = rs.getInt(1);
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
                LocalDateTime tDateTime = LocalDateTime.parse(rs.getString(2), formatter);
                Training t = new Training(trainId, tDateTime);
                list.add(t);
            }
        } catch (SQLException ex) {
            Logger.getLogger(StadiumDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            closeConnections(rs, stmt);
        }
        return list;
    }

    @Override
    public Training findById(int id) {
        PreparedStatement pstm = null;
        ResultSet rs = null;
        Training t = null;
        try {
            pstm = getConnection().prepareStatement(FINDTRAININGBYID);
            pstm.setInt(1, id);
            rs = pstm.executeQuery();
            rs.next();
            int trainId = rs.getInt(1);
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            LocalDateTime tDateTime = LocalDateTime.parse(rs.getString(2), formatter);
            t = new Training(trainId, tDateTime);
        } catch (SQLException ex) {
            Logger.getLogger(StadiumDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            closeConnections(rs, pstm);
        }
        return t;
    }

    @Override
    public boolean update(Training t) {
        PreparedStatement pst = null;
        boolean updated = false;
        try {
            pst = getConnection().prepareStatement(UPDATETRAINING);
            pst.setString(1, String.valueOf(t.gettDateTime()));
            pst.setInt(2, t.getTrainId());
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

    @Override
    public boolean delete(int id) {
        PreparedStatement pst = null;
        boolean deleted = false;
        try {
            pst = getConnection().prepareStatement(DELETETRAINING);
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

}
