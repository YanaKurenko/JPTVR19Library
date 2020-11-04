/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tools.savers;

import entity.Reader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

/**
 *
 * @author pupil
 */
public class SaverToFile {
    public void save(List arrayList,String fileName) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPTVR19LibraryDev25PU");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        for (int i = 0; i < arrayList.size(); i++) {
            if("Reader".equals(arrayList.get(i).getClass().toString())){
                List<Reader> listReader = (List<Reader>) arrayList;
                if(listReader.get(i).getId()==null){
                 em.persist(listReader.get(i));
                }
            }
        }
        tx.commit();
//                FileOutputStream fos = null;
//        ObjectOutputStream oos = null;
//        try {
//            fos = new FileOutputStream("readers");
//            oos = new ObjectOutputStream(fos);
//            oos.writeObject(arrayList);
//            oos.flush();
//        } catch (FileNotFoundException ex) {
//            System.out.println("Не найден файл");
//        } catch (IOException ex) {
//            System.out.println("Ошибка ввода/вывода");
//        }
    }
    public List load(String fileName) {
//        List arrayList = new ArrayList();
//        List<Reader> listReaders = new ArrayList<>();
//        FileInputStream fis = null;
//        ObjectInputStream ois = null;
//        try {
//            fis = new FileInputStream(fileName);
//            ois = new ObjectInputStream(fis);
//            arrayList = (List) ois.readObject();
//        } catch (FileNotFoundException ex) {
//            System.out.println("Не найден файл");
//        } catch (IOException ex) {
//            System.out.println("Ошибка ввода/вывода");
//        } catch (ClassNotFoundException ex) {
//            System.out.println("Не найден класс");
//        }
//        return arrayList;
    }
}
