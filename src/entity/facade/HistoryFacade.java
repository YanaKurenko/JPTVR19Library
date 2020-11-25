/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity.facade;

import entity.History;
import entity.Reader;
import factory.ConnectSingleton;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author user
 */
public class HistoryFacade extends AbstractFacade<History>{

    private EntityManager em;

    public HistoryFacade() {
        super(History.class);
        ConnectSingleton connect = ConnectSingleton.getInstance();
        em = connect.getEntityManager();
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public List<History> findReadAll(Reader reader, Boolean read) {
        if(read == true){
            try {
                return em.createQuery("SELECT h FROM History h WHERE h.reader = :reader AND h.returnDate = NULL")
                        .setParameter("reader", reader)
                        .getResultList();
            } catch (Exception e) {
                return null;
            }
        }else{
            try {
                return em.createQuery("SELECT h FROM History h WHERE h.reader = :reader")
                        .setParameter("reader", reader)
                        .getResultList();
            } catch (Exception e) {
                return null;
            }
        }
    }

    

}
