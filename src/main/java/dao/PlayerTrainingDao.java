/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entities.Player;
import entities.PlayerTraining;
import entities.Training;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author ppapakostas
 */
public class PlayerTrainingDao extends SuperDao implements InterfaceDao<PlayerTraining> {

    private static final String FINDALL = "SELECT * FROM Player_Training";
    private static final String INSERTPLAYERTRAINING = "INSERT INTO Player_Training (playerId, trainId, performance) VALUES (?, ?, ?)";

    private static final String FINDBYTRAINING = "SELECT * FROM Player_Training WHERE trainId = ?";

    public boolean create(int player, int training, int performance) {
        PreparedStatement pst = null;
        boolean created = false;
        try {
            pst = getConnection().prepareStatement(INSERTPLAYERTRAINING);
            pst.setInt(1, player);
            pst.setInt(2, training);
            pst.setInt(3, performance);
            int result = pst.executeUpdate();
            if (result > 0) {
                created = true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(PlayerTrainingDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            closeConnections(pst);
        }
        return created;
    }

    @Override
    public List<PlayerTraining> findAll() {
        PreparedStatement st = null;
        ResultSet rs = null;
        List<PlayerTraining> list = new ArrayList();
        try {
            st = getConnection().prepareStatement(FINDALL);
            rs = st.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("PTCode");
                Player player = getPlayerById(rs.getInt("playerId"));
                Training training = getTrainingById(rs.getInt("trainId"));
                int performance = rs.getInt("performance");
                PlayerTraining pt = new PlayerTraining(id, player, training, performance);
                list.add(pt);
            }
        } catch (SQLException ex) {
            Logger.getLogger(PlayerTrainingDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            closeConnections(rs, st);
        }
        return list;
    }

    public List<PlayerTraining> findByTraining(int trainId) {
        PreparedStatement pstm = null;
        ResultSet rs = null;
        List<PlayerTraining> list = new ArrayList();
        try {
            pstm = getConnection().prepareStatement(FINDBYTRAINING);
            pstm.setInt(1, trainId);
            rs = pstm.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("PTCode");
                Player player = getPlayerById(rs.getInt("playerId"));
                Training training = getTrainingById(rs.getInt("trainId"));
                int performance = rs.getInt("performance");
                PlayerTraining pt = new PlayerTraining(id, player, training, performance);
                list.add(pt);
            }
        } catch (SQLException ex) {
            Logger.getLogger(PlayerTrainingDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            closeConnections(rs, pstm);
        }
        return list;
    }


    private Player getPlayerById(int id) {
        PlayerDao pdao = new PlayerDao();
        Player p = pdao.findById(id);
        return p;
    }

    private Training getTrainingById(int id) {
        TrainingDao tdao = new TrainingDao();
        Training t = tdao.findById(id);
        return t;
    }

    @Override
    public boolean create(PlayerTraining e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public PlayerTraining findById(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean update(PlayerTraining e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
