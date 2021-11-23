/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;

/**
 * @author ppapakostas
 */
public interface InterfaceDao<E> {
    boolean create(E e);

    List<E> findAll();

    E findById(int id);

    boolean update(E e);

    boolean delete(int id);
}
