/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.time.LocalDate;

/**
 * @author ppapakostas
 */
public class Game {

    private int gameId;
    private int stadId;
    private LocalDate gDate;
    private String oppTeam;
    private int oppScore;
    private int myScore;

    public Game() {
    }

    public Game(int gameId, int stadId, LocalDate gDate, String oppTeam, int oppScore, int myScore) {
        this.gameId = gameId;
        this.stadId = stadId;
        this.gDate = gDate;
        this.oppTeam = oppTeam;
        this.oppScore = oppScore;
        this.myScore = myScore;
    }

    public Game(int stadId, LocalDate gDate, String oppTeam, int oppScore, int myScore) {
        this.stadId = stadId;
        this.gDate = gDate;
        this.oppTeam = oppTeam;
        this.oppScore = oppScore;
        this.myScore = myScore;
    }


    public int getMyScore() {
        return myScore;
    }

    public void setMyScore(int myScore) {
        this.myScore = myScore;
    }

    public int getGameId() {
        return gameId;
    }

    public void setGameId(int gameId) {
        this.gameId = gameId;
    }

    public int getStadId() {
        return stadId;
    }

    public void setStadId(int stadId) {
        this.stadId = stadId;
    }

    public LocalDate getgDate() {
        return gDate;
    }

    public void setgDate(LocalDate gDate) {
        this.gDate = gDate;
    }

    public String getOppTeam() {
        return oppTeam;
    }

    public void setOppTeam(String oppTeam) {
        this.oppTeam = oppTeam;
    }

    public int getOppScore() {
        return oppScore;
    }

    public void setOppScore(int oppScore) {
        this.oppScore = oppScore;
    }


}
