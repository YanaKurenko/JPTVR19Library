/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity.DBControllers;

import entity.User;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author user
 */
public class UserFacade extends AbstractFacade<User>{
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPTVR19LibraryDev25PU");
    private EntityManager em = emf.createEntityManager();

    public UserFacade(Class<User> entityClass) {
        super(entityClass);
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
   
}
