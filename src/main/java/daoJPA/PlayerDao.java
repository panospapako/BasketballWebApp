package daoJPA;

import entity.Player;

import javax.persistence.EntityManager;
import java.util.List;

/**
 *
 * @author ppapakostas
 */
public class PlayerDao extends HibernateUtil<Player>{

    public List<Player> findAll(){
        return super.findAll("from Player");
    }

    public Player find(int id){
        return super.find(Player.class, id);
    }

    public Player getPlayerWithoutClosingEm(int id){
        EntityManager em = getEntityManager();
        Player t = em.find(Player.class, id);
        return t;
    }

    public Player save(Player p){
        return super.save(p);
    }

    public Player update(Player p) {
        return super.update(p);
    }

    public boolean delete(int id){
        return super.delete(Player.class, id);
    }

//    TO DO: last 3 methods
}
