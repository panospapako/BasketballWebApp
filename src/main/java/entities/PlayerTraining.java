/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

/**
 * @author ppapakostas
 */
public class PlayerTraining {

    private int PTCode;
    private Player player;
    private Training training;
    private int performance;

    public PlayerTraining() {
    }

    public PlayerTraining(int PTCode, Player player, Training training, int performance) {
        this.PTCode = PTCode;
        this.player = player;
        this.training = training;
        this.performance = performance;
    }

    public int getPerformance() {
        return performance;
    }

    public void setPerformance(int performance) {
        this.performance = performance;
    }

    public int getPTCode() {
        return PTCode;
    }

    public void setPTCode(int PTCode) {
        this.PTCode = PTCode;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public Training getTraining() {
        return training;
    }

    public void setTraining(Training training) {
        this.training = training;
    }


}
