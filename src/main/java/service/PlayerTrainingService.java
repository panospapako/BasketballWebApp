/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import dao.PlayerDao;
import dao.PlayerTrainingDao;
import dao.TrainingDao;
import entities.Player;
import entities.PlayerTraining;
import entities.Training;

import java.util.List;
import java.util.Map;

/**
 * @author ppapakostas
 */
public class PlayerTrainingService {

    private PlayerTrainingDao ptdao;

    public PlayerTrainingService() {
        ptdao = new PlayerTrainingDao();
    }

    public List<PlayerTraining> getPlayerTrainings() {
        List<PlayerTraining> list = ptdao.findAll();
        return list;
    }

    public List<PlayerTraining> getParticipants(int trainId) {
        List<PlayerTraining> list = ptdao.findByTraining(trainId);
        return list;
    }

    public List<Player> listOfPlayer() {
        PlayerDao pdao = new PlayerDao();
        return pdao.findAll();
    }

    public List<Player> listOfPlayerWhoNotParticipate(int trainId) {
        PlayerDao pdao = new PlayerDao();
        return pdao.findPlayerWhoNotParticipate(trainId);
    }

    public List<Training> listOfTraining() {
        TrainingDao tdao = new TrainingDao();
        return tdao.findAll();
    }

    public Training getTrainingById(int trainId) {
        TrainingDao tdao = new TrainingDao();
        Training t = tdao.findById(trainId);
        return t;
    }

    public boolean createPlayerTraining(Map<String, String[]> parameterMap) {
        int player = Integer.parseInt(parameterMap.get("player")[0]);
        int training = Integer.parseInt(parameterMap.get("training")[0]);
        int performance = Integer.parseInt(parameterMap.get("performance")[0]);
        System.out.println(player);
        System.out.println(training);
        System.out.println(performance);
        boolean result = ptdao.create(player, training, performance);
        return result;
    }
}
