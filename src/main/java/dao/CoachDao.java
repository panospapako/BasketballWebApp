package dao;

import entity.Coach;

import javax.persistence.EntityManager;
import java.util.List;

public class CoachDao extends HibernateUtil<Coach>{
    public List<Coach> findAll(){
        return super.findAll("from Coach");
    }

    public Coach find(int id){
        return super.find(Coach.class, id);
    }

//    public Coach getCoachWithoutClosingEm(int id){
//        EntityManager em = getEntityManager();
//        Coach t = em.find(Coach.class, id);
//        return t;
//    }

    public Coach save(Coach c){
        return super.save(c);
    }

    public Coach update(Coach c) {
        return super.update(c);
    }

    public boolean delete(int id){
        return super.delete(Coach.class, id);
    }

//    TO DO: last 3 methods

}
