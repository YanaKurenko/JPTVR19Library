/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity.dbcontrollers;

import entity.Book;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

/**
 *
 * @author pupil
 */
public class BookFacade extends AbstractFacade<Book>{
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPTVR19LibraryDev25PU");
    private EntityManager em = emf.createEntityManager();

    public BookFacade(Class<Book> entityClass) {
        super(entityClass);
    }


    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    

}
