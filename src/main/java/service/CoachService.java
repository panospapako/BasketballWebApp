/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import dao.CoachDao;
import entity.Coach;

import java.util.List;

/**
 * @author ppapakostas
 */
public class CoachService {
    CoachDao cdao = new CoachDao();

    public List<Coach> getCoaches() {
        return cdao.findAll();
    }

    public Coach getCoachById(int idNumber) {
        Coach coach = cdao.find(idNumber);
        return coach;
    }

    public Coach create(String lName, String fName) {
        Coach coach = new Coach(lName, fName);
        coach = cdao.save(coach);
        return coach;
    }

    public boolean delete(int id) {
        boolean result = cdao.delete(id);
        return result;
    }

        public Coach update(int id, String lName, String fName) {
        Coach coach = new Coach(id, lName, fName);
        coach = cdao.update(coach);
        return coach;
    }
}
