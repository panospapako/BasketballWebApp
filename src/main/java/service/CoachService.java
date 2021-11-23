/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import daoJPA.CoachDao;
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
        Coach c = cdao.find(idNumber);
        return c;
    }

    public Coach create(String lName, String fName) {
        Coach c = new Coach(lName, fName);
        c = cdao.save(c);
        return c;
    }

    public boolean delete(int id) {
        boolean result = cdao.delete(id);
        return result;
    }

        public Coach update(int id, String lName, String fName) {
        Coach c = new Coach(id, lName, fName);
        c = cdao.update(c);
        return c;
    }
}
