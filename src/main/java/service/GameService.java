/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import dao.GameDao;
import dao.StadiumDao;
import entity.Game;
import entity.Stadium;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;

/**
 * @author ppapakostas
 */
public class GameService {


    GameDao gdao = new GameDao();

    public List<Game> getGames() {
        return gdao.findAll();
    }

    public List<Stadium> getStadiums() {
        StadiumDao sdao = new StadiumDao();
        return sdao.findAll();
    }

    public Game create(Map<String, String[]> parameterMap) {
        int stadId = Integer.parseInt(parameterMap.get("stadId")[0]);
        LocalDate gDate = LocalDate.parse(parameterMap.get("gDate")[0]);
        String oppTeam = parameterMap.get("oppTeam")[0];
        int oppScore = Integer.parseInt(parameterMap.get("oppScore")[0]);
        int myScore = Integer.parseInt(parameterMap.get("myScore")[0]);
        StadiumDao sdao = new StadiumDao();
        Stadium stadium = sdao.find(stadId);
        Game game = new Game(gDate, oppTeam, oppScore, myScore, stadium);
        game = gdao.save(game);
        return game;
    }

    public Game getGameById(int gameId) {
        Game game = gdao.find(gameId);
        return game;
    }

    public boolean delete(int id) {
        boolean result = gdao.delete(id);
        return result;
    }

    public Game update(Map<String, String[]> parameterMap) {
        int gameId = Integer.parseInt(parameterMap.get("gameId")[0]);
        int stadId = Integer.parseInt(parameterMap.get("stadId")[0]);
        LocalDate gDate = LocalDate.parse(parameterMap.get("gDate")[0]);
        String oppTeam = parameterMap.get("oppTeam")[0];
        int oppScore = Integer.parseInt(parameterMap.get("oppScore")[0]);
        int myScore = Integer.parseInt(parameterMap.get("myScore")[0]);
        StadiumDao sdao = new StadiumDao();
        Stadium stadium = sdao.find(stadId);
        Game game = new Game(gDate, oppTeam, oppScore, myScore, stadium);
        game = gdao.update(game);
        return game;
    }
}
