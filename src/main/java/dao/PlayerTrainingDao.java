package dao;

import entity.PlayerTraining;
import entity.User;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.TypedQuery;
import java.util.List;

public class PlayerTrainingDao extends HibernateUtil<PlayerTraining> {
    public List<PlayerTraining> findAll(){
        return super.findAll("from PlayerTraining");
    }

    public List<PlayerTraining> findByTraining(int trainId) {
        EntityManager entityManager = getEntityManager();
        TypedQuery<PlayerTraining> typedQuery = entityManager.createNamedQuery("PlayerTraining.findByTraining", PlayerTraining.class);
        typedQuery.setParameter("trainId", trainId);
        List<PlayerTraining> playerTraining;
        playerTraining = typedQuery.getResultList();
        return playerTraining;
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
