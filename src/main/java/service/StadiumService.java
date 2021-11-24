/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import dao.StadiumDao;
import entity.Stadium;

import java.util.List;

/**
 * @author ppapakostas
 */
public class StadiumService {

    StadiumDao sdao = new StadiumDao();

    public List<Stadium> getStadiums() {
        return sdao.findAll();
    }

    public Stadium getStadiumById(int stadId) {
        Stadium stadium = sdao.find(stadId);
        return stadium;
    }

    public Stadium create(String sName, String location, Integer capacity) {
        Stadium stadium = new Stadium(sName, location, capacity);
        stadium = sdao.save(stadium);
        return stadium;
    }

    public boolean delete(int id) {
        boolean result = sdao.delete(id);
        return result;
    }

    public Stadium update(int stadId, String sName, String location, int capacity) {
        Stadium stadium = new Stadium(stadId, sName, location, capacity);
        stadium = sdao.update(stadium);
        return stadium;
    }


}
