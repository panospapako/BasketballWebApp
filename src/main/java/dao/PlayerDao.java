/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entities.Player;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author ppapakostas
 */
public class PlayerDao extends SuperDao implements InterfaceDao<Player> {

    private static final String FINDALL = "SELECT idNumber, lName, fName, dateOfBirth, weight, height FROM Player";
    private static final String FINDPLAYERBYID = "SELECT * FROM Player WHERE idNumber = ?";
    private static final String INSERTPLAYER = "INSERT INTO Player (lName, fName, dateOfBirth, weight, height) VALUES (?, ?, ?, ?, ?)";
    private static final String DELETEPLAYER = "DELETE FROM Player WHERE idNumber = ?";
    private static final String UPDATEPLAYER = "UPDATE Player SET lName = ? , fName = ?, dateOfBirth = ?, weight = ?, height = ? WHERE idNumber = ?";
    private static final String FINDPLAYERWHONOTTPARTICIPATE = "SELECT * FROM Player WHERE idNumber not in (SELECT playerId FROM Player_Training WHERE trainId = ?)";

    @Override
    public List<Player> findAll() {
        Statement stmt = null;
        ResultSet rs = null;
        List<Player> list = new ArrayList<>();
        try {
            stmt = getConnection().createStatement();
            rs = stmt.executeQuery(FINDALL);
            while (rs.next()) {
                int idNumber = rs.getInt(1);
                String lName = rs.getString(2);
                String fName = rs.getString(3);
                LocalDate dateOfBirth = LocalDate.parse(rs.getString(4));
                double weight = rs.getDouble(5);
                double height = rs.getDouble(6);
                Player p = new Player(idNumber, lName, fName, dateOfBirth, weight, height);
                list.add(p);
            }
        } catch (SQLException ex) {
            Logger myLogger = Logger.getLogger(PlayerDao.class.getName());
            myLogger.log(Level.SEVERE, null, ex);

        } finally {
            closeConnections(rs, stmt);
        }
        return list;
    }

    @Override
    public Player findById(int id) {
        PreparedStatement pstm = null;
        ResultSet rs = null;
        Player p = null;
        try {
            pstm = getConnection().prepareStatement(FINDPLAYERBYID);
            pstm.setInt(1, id);
            rs = pstm.executeQuery();
            rs.next();
            int idNumber = rs.getInt(1);
            String lName = rs.getString(2);
            String fName = rs.getString(3);
            LocalDate dateOfBirth = LocalDate.parse(rs.getString(4));
            double weight = rs.getDouble(5);
            double height = rs.getDouble(6);
            p = new Player(idNumber, lName, fName, dateOfBirth, weight, height);
        } catch (SQLException ex) {
            Logger.getLogger(PlayerDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            closeConnections(rs, pstm);
        }
        return p;
    }

    @Override
    public boolean create(Player p) {
        PreparedStatement pst = null;
        boolean created = false;
        try {
            pst = getConnection().prepareStatement(INSERTPLAYER);
            pst.setString(1, p.getlName());
            pst.setString(2, p.getfName());
            pst.setString(3, String.valueOf(p.getDateOfBirth()));
            pst.setDouble(4, p.getWeight());
            pst.setDouble(5, p.getHeight());
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
    public boolean delete(int id) {
        PreparedStatement pst = null;
        boolean deleted = false;
        try {
            pst = getConnection().prepareStatement(DELETEPLAYER);
            pst.setInt(1, id);
            int result = pst.executeUpdate();
            if (result > 0) {
                deleted = true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(PlayerDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            closeConnections(pst);
        }
        return deleted;
    }

    @Override
    public boolean update(Player p) {
        PreparedStatement pst = null;
        boolean updated = false;
        try {
            pst = getConnection().prepareStatement(UPDATEPLAYER);
            pst.setString(1, p.getlName());
            pst.setString(2, p.getfName());
            pst.setString(3, String.valueOf(p.getDateOfBirth()));
            pst.setDouble(4, p.getWeight());
            pst.setDouble(5, p.getHeight());
            pst.setInt(6, p.getIdNumber());
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

    public List<Player> findPlayerWhoNotParticipate(int id) {
        PreparedStatement pstm = null;
        ResultSet rs = null;
        List<Player> list = new ArrayList<>();
        try {
            pstm = getConnection().prepareStatement(FINDPLAYERWHONOTTPARTICIPATE);
            pstm.setInt(1, id);
            rs = pstm.executeQuery();
            while (rs.next()) {
                int idNumber = rs.getInt(1);
                String lName = rs.getString(2);
                String fName = rs.getString(3);
                LocalDate dateOfBirth = LocalDate.parse(rs.getString(4));
                double weight = rs.getDouble(5);
                double height = rs.getDouble(6);
                Player p = new Player(idNumber, lName, fName, dateOfBirth, weight, height);
                list.add(p);
            }
        } catch (SQLException ex) {
            Logger.getLogger(PlayerDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            closeConnections(rs, pstm);
        }
        return list;
    }

}//
