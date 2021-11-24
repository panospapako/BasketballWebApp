package dao;

import entity.Game;

import javax.persistence.EntityManager;
import java.util.List;

public class GameDao extends HibernateUtil<Game> {
    public List<Game> findAll(){
        return super.findAll("from Game");
    }

    public Game find(int id){
        return super.find(Game.class, id);
    }

    public Game getGameWithoutClosingEm(int id){
        EntityManager em = getEntityManager();
        Game t = em.find(Game.class, id);
        return t;
    }

    public Game save(Game g){
        return super.save(g);
    }

    public Game update(Game g) {
        return super.update(g);
    }

    public boolean delete(int id){
        return super.delete(Game.class, id);
    }
}
