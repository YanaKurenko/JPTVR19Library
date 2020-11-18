/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity.dbcontrollers;

import entity.History;
import entity.Book;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

/**
 *
 * @author pupil
 */
public abstract class AbstractFacade<T> {

    private Class<T> entityClass;

    public AbstractFacade(Class<T> entityClass) {
        this.entityClass = entityClass;
    }
    
    protected abstract EntityManager getEntityManager();
    
    public void create(T entity){
        getEntityManager().getTransaction().begin();
        getEntityManager().persist(entity);
        getEntityManager().getTransaction().commit();
    }

    public List<T> findAll() {
        try {
            return getEntityManager().createQuery("SELECT en FROM "+entityClass.getName()+" en")
                    .getResultList();
        } catch (Exception e) {
            return null;
        }
    }
    public T find(Long Id) {
        try {
            return (T) getEntityManager().createQuery("SELECT en FROM "+entityClass.getName()+" en WHERE en.id = :id")
                    .setParameter("id", Id)
                    .getSingleResult();
        } catch (Exception e) {
            return null;
        }
    }
        public void edit(History history) {
        getEntityManager().getTransaction().begin();
        getEntityManager().merge(history);
        getEntityManager().getTransaction().commit();
    }
}
