/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jptvr19library;

import tools.creators.LibraryManager;
import tools.creators.ReaderManager;
import entity.Book;
import entity.History;
import entity.Reader;
import entity.User;
import entity.dbcontrollers.ReaderFacade;
import entity.dbcontrollers.UserFacade;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import security.SecureManager;
import tools.creators.BookManager;
import tools.savers.SaveInterface;
import tools.savers.SaverToBase;
import tools.savers.SaverToFile;
import ui.ManagerUI;
import ui.ReaderUI;

public class App {
   
    private SecureManager secureManager = new SecureManager();
  //  private SaveInterface saver = new SaverToFile();
    private SaveInterface saver = new SaverToBase();
    
    public static User loginedUser;
    
    public App() {
               
    }
    
    public void run(){
        boolean repeat = true;
        System.out.println("--- Библиотека ---");
        this.loginedUser = secureManager.checkTask();
        if(SecureManager.role.MANAGER.toString().equals(this.loginedUser.getRole())){
            ManagerUI managerUI = new ManagerUI();
            managerUI.getManagerUI();
        }else if(SecureManager.role.READER.toString().equals(this.loginedUser.getRole())){
            ReaderUI readerUI = new ReaderUI();
            readerUI.getReaderUI();
        }
    }
}