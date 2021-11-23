package daoJPA;

import entity.Stadium;

import javax.persistence.EntityManager;
import java.util.List;

public class StadiumDao extends HibernateUtil<Stadium> {
    public List<Stadium> findAll(){
        return super.findAll("from Stadium");
    }

    public Stadium find(int id){
        return super.find(Stadium.class, id);
    }

    public Stadium getStadiumWithoutClosingEm(int id){
        EntityManager em = getEntityManager();
        Stadium t = em.find(Stadium.class, id);
        return t;
    }

    public Stadium save(Stadium s){
        return super.save(s);
    }

    public Stadium update(Stadium s) {
        return super.update(s);
    }

    public boolean delete(int id){
        return super.delete(Stadium.class, id);
    }
}
