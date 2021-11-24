///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
package service;

import dao.PlayerDao;
import dao.PlayerTrainingDao;
import dao.StadiumDao;
import dao.TrainingDao;
import entity.*;

import java.time.LocalDate;
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

    public List<Training> listOfTraining() {
        TrainingDao tdao = new TrainingDao();
        return tdao.findAll();
    }

    public Training getTrainingById(int trainId) {
        TrainingDao tdao = new TrainingDao();
        Training t = tdao.find(trainId);
        return t;
    }

    public PlayerTraining create(Map<String, String[]> parameterMap) {
        int idNumber = Integer.parseInt(parameterMap.get("idNumber")[0]);
        PlayerDao playerDao = new PlayerDao();
        Player player = playerDao.find(idNumber);
        int trainId = Integer.parseInt(parameterMap.get("trainId")[0]);
        TrainingDao trainingDao = new TrainingDao();
        Training training = trainingDao.find(trainId);
        int performance = Integer.parseInt(parameterMap.get("performance")[0]);
        PlayerTraining playerTraining = new PlayerTraining(player, training, performance);
        playerTraining = ptdao.save(playerTraining);
        return playerTraining;
    }


}
