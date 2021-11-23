/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import dao.UserDao;
import entities.User;

/**
 * @author ppapakostas
 */
public class UserService {

    UserDao udao = new UserDao();

    public User getUserByUserName(String uN) {
        User u = udao.findByUserName(uN);
        return u;
    }

}
