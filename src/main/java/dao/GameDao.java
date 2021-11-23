/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entities.Game;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author ppapakostas
 */
public class GameDao extends SuperDao implements InterfaceDao<Game> {

    private static final String INSERTGAME = "INSERT INTO Game (stadId, gDate, oppTeam, oppScore, myScore) VALUES (?, ?, ?, ?, ?)";
    private static final String FINDALL = "SELECT * FROM Game";
    private static final String FINDGAMEBYID = "SELECT * FROM Game WHERE gameId = ?";
    private static final String DELETEGAME = "DELETE FROM Game WHERE gameId = ?";
    private static final String UPDATEGAME = "UPDATE Game SET stadId = ?, gDate = ?, oppTeam = ?, oppScore = ?, myScore = ? WHERE gameId = ?";

    @Override
    public boolean create(Game g) {
        PreparedStatement pst = null;
        boolean created = false;
        try {
            pst = getConnection().prepareStatement(INSERTGAME);
            pst.setInt(1, g.getStadId());
            pst.setString(2, String.valueOf(g.getgDate()));
            pst.setString(3, g.getOppTeam());
            pst.setInt(4, g.getOppScore());
            pst.setInt(5, g.getMyScore());
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
    public List<Game> findAll() {
        Statement stmt = null;
        ResultSet rs = null;
        List<Game> list = new ArrayList<>();
        try {
            stmt = getConnection().createStatement();
            rs = stmt.executeQuery(FINDALL);
            while (rs.next()) {
                int gameId = rs.getInt(1);
                int stadId = rs.getInt(2);
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                LocalDate gDate = LocalDate.parse(rs.getString(3), formatter);
                String oppTeam = rs.getString(4);
                int oppScore = rs.getInt(5);
                int myScore = rs.getInt(6);
                Game g = new Game(gameId, stadId, gDate, oppTeam, oppScore, myScore);
                list.add(g);
            }
        } catch (SQLException ex) {
            Logger.getLogger(StadiumDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            closeConnections(rs, stmt);
        }
        return list;
    }

    @Override
    public Game findById(int id) {
        PreparedStatement pstm = null;
        ResultSet rs = null;
        Game g = null;
        try {
            pstm = getConnection().prepareStatement(FINDGAMEBYID);
            pstm.setInt(1, id);
            rs = pstm.executeQuery();
            rs.next();
            int gameId = rs.getInt(1);
            int stadId = rs.getInt(2);
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            LocalDate gDate = LocalDate.parse(rs.getString(3), formatter);
            String oppTeam = rs.getString(4);
            int oppScore = rs.getInt(5);
            int myScore = rs.getInt(6);
            g = new Game(gameId, stadId, gDate, oppTeam, oppScore, myScore);
        } catch (SQLException ex) {
            Logger.getLogger(StadiumDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            closeConnections(rs, pstm);
        }
        return g;
    }

    @Override
    public boolean update(Game g) {
        PreparedStatement pst = null;
        boolean updated = false;
        try {
            pst = getConnection().prepareStatement(UPDATEGAME);
            pst.setInt(1, g.getStadId());
            pst.setString(2, String.valueOf(g.getgDate()));
            pst.setString(3, g.getOppTeam());
            pst.setInt(4, g.getOppScore());
            pst.setInt(5, g.getMyScore());
            pst.setInt(6, g.getGameId());
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
            pst = getConnection().prepareStatement(DELETEGAME);
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
