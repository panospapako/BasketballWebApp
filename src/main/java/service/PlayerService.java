/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import dao.PlayerDao;
import entity.Player;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

/**
 * @author ppapakostas
 */
public class PlayerService {

    PlayerDao pdao = new PlayerDao();

    public List<Player> getPlayers() {
        return pdao.findAll();
    }

    public Player getPlayerById(int idNumber) {
        Player p = pdao.find(idNumber);
        return p;
    }

    public Player create(String lName, String fName, LocalDate dateOfBirth, Integer weight, Integer height) {
        Player p = new Player(lName, fName, dateOfBirth, weight, height);
        p = pdao.save(p);
        return p;
    }

    public boolean delete(int id) {
        boolean result = pdao.delete(id);
        return result;
    }

    public Player update(int idNumber, String lName, String fName, LocalDate dateOfBirth, Integer weight, Integer height) {
        Player p = new Player(idNumber, lName, fName, dateOfBirth, weight, height);
        p = pdao.update(p);
        return p;
    }

}
