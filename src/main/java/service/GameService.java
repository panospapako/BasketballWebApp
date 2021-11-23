/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import dao.GameDao;
import dao.StadiumDao;
import entities.Game;
import entities.Stadium;

import java.time.LocalDate;
import java.util.List;

/**
 * @author ppapakostas
 */
public class GameService {


    GameDao gdao = new GameDao();

    public boolean create(int stadId, LocalDate gDate, String oppTeam, int oppScore, int myScore) {
        Game g = new Game(stadId, gDate, oppTeam, oppScore, myScore);
        boolean result = gdao.create(g);
        return result;
    }

    public List<Game> getGames() {
        return gdao.findAll();
    }

    public List<Stadium> getStadiums() {
        StadiumDao sdao = new StadiumDao();
        return sdao.findAll();
    }

    public Game getGameById(int gameId) {
        Game g = gdao.findById(gameId);
        return g;
    }

    public boolean delete(int id) {
        boolean result = gdao.delete(id);
        return result;
    }

    public boolean update(int gameId, int stadId, LocalDate gDate, String oppTeam, int oppScore, int myScore) {
        Game g = new Game(gameId, stadId, gDate, oppTeam, oppScore, myScore);
        boolean result = gdao.update(g);
        return result;
    }
}
