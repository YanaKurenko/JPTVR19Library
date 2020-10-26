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
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import security.SecureManager;
import tools.creators.BookManager;
import tools.savers.SaverToFile;
import ui.ManagerUI;
import ui.ReaderUI;

public class App {
    private List<Book> listBooks = new ArrayList<>();
    private List<Reader> listReader = new ArrayList<>();
    private List<History> listHistories = new ArrayList<>();
    private List<User> listUsers = new ArrayList<>();
    
    private BookManager bookManager = new BookManager();
    private ReaderManager readerManager = new ReaderManager();
    private LibraryManager libraryManager = new LibraryManager();
    private SaverToFile saverToFile = new SaverToFile();
    private SecureManager secureManager = new SecureManager();

    public static User loginedUser;
    
    public App() {
        listBooks = saverToFile.load("books");
        listReader = saverToFile.load("readers");
        listHistories = saverToFile.load("histories");
        listUsers = saverToFile.load("users");
    }
    
    public void run(){
        boolean repeat = true;
        System.out.println("--- Библиотека ---");
        this.loginedUser = secureManager.checkTask(listUsers,listReader);
        if("MANAGER".equals(this.loginedUser.getRole())){
            ManagerUI managerUI = new ManagerUI();
            managerUI.getManagerUI(listReader, listUsers, listBooks, listHistories);
        }else if("READER".equals(this.loginedUser.getRole())){
            ReaderUI readerUI = new ReaderUI();
            readerUI.getReaderUI(listReader, listUsers, listBooks, listHistories);
        }
    }
}