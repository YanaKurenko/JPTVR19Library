/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jptvr19library;

import factory.ConnectSingleton;

/**
 *
 * @author Melnikov
 */
public class JPTVR19Library {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        App app = new App();
        try {
            app.run();
        } finally {
            ConnectSingleton connect = ConnectSingleton.getInstance();
            if (connect.getEntityManager() != null) {
                connect.getEntityManager().close();
            }
            if (connect.getEntityManagerFactory() != null) {
                connect.getEntityManagerFactory().close();
            }
        }
    }
    
}
