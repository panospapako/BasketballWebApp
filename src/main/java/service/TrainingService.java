/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import dao.TrainingDao;
import entities.Training;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @author ppapakostas
 */
public class TrainingService {

    TrainingDao tdao = new TrainingDao();

    public boolean create(LocalDateTime tDateTime) {
        Training t = new Training(tDateTime);
        boolean result = tdao.create(t);
        return result;
    }

    public List<Training> getTrainings() {
        return tdao.findAll();
    }

    public Training getTrainingById(int trainId) {
        Training t = tdao.findById(trainId);
        return t;
    }

    public boolean delete(int id) {
        boolean result = tdao.delete(id);
        return result;
    }

    public boolean update(int trainId, LocalDateTime tDateTime) {
        Training t = new Training(trainId, tDateTime);
        boolean result = tdao.update(t);
        return result;
    }


}
