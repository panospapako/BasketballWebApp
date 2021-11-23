package daoJPA;

import entity.Coach;
import entity.Training;

import javax.persistence.EntityManager;
import java.util.List;

public class TrainingDao extends HibernateUtil<Training> {
    public List<Training> findAll(){
        return super.findAll("from Training");
    }

    public Training find(int id){
        return super.find(Training.class, id);
    }

    public Training getTrainingWithoutClosingEm(int id){
        EntityManager em = getEntityManager();
        Training t = em.find(Training.class, id);
        return t;
    }

    public Training save(Training t){
        return super.save(t);
    }

    public Training update(Training t) {
        return super.update(t);
    }

    public boolean delete(int id){
        return super.delete(Training.class, id);
    }
}
