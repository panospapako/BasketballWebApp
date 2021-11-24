package dao;

import entity.User;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.TypedQuery;


public class UserDao extends HibernateUtil<User>{

    public User findByUserName(String username) {
        EntityManager entityManager = getEntityManager();
        TypedQuery<User> typedQuery = entityManager.createNamedQuery("User.findByUsername", User.class);
        typedQuery.setParameter("epitheto", username);
        User user;
        try{
            user = typedQuery.getSingleResult();
        }catch(NoResultException nre){
            System.out.println(">>>>> User does not exist!!!");
            user = null;
        }catch(NonUniqueResultException nure){
            System.out.println(">>>>> There are too many user with username:"+username);
            user = null;
        }
        return user;
    }
}
