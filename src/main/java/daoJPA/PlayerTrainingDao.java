package daoJPA;

import entity.Coach;
import entity.PlayerTraining;

import javax.persistence.EntityManager;
import java.util.List;

public class PlayerTrainingDao extends HibernateUtil<PlayerTraining> {
    public List<PlayerTraining> findAll(){
        return super.findAll("from PlayerTraining");
    }

    public PlayerTraining find(int id){
        return super.find(PlayerTraining.class, id);
    }

    public PlayerTraining getPlayerTrainingWithoutClosingEm(int id){
        EntityManager em = getEntityManager();
        PlayerTraining t = em.find(PlayerTraining.class, id);
        return t;
    }

    public PlayerTraining save(PlayerTraining pt){
        return super.save(pt);
    }

    public PlayerTraining update(PlayerTraining pt) {
        return super.update(pt);
    }

    public boolean delete(int id){
        return super.delete(PlayerTraining.class, id);
    }

}
