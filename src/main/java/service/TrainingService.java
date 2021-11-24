/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import dao.TrainingDao;
import entity.Training;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @author ppapakostas
 */
public class TrainingService {

    TrainingDao tdao = new TrainingDao();

    public Training create(LocalDateTime tDateTime) {
        Training training = new Training(tDateTime);
        training = tdao.save(training);
        return training;
    }

    public List<Training> getTrainings() {
        return tdao.findAll();
    }

    public Training getTrainingById(int trainId) {
        Training training = tdao.find(trainId);
        return training;
    }

    public boolean delete(int id) {
        boolean result = tdao.delete(id);
        return result;
    }

    public Training update(int trainId, LocalDateTime tDateTime) {
        Training training = new Training(trainId, tDateTime);
        training = tdao.update(training);
        return training;
    }


}
