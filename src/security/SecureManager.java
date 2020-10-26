package security;

import entity.Reader;
import entity.User;
import java.util.List;
import java.util.Scanner;
import tools.creators.ReaderManager;
import tools.creators.UserManager;
import tools.savers.SaverToFile;


public class SecureManager {
private Scanner scanner = new Scanner(System.in);
public static enum role {READER,MANAGER};
    public User checkTask(List<User> listUsers, List<Reader> ListReaders) {
        // предоставить выбор пользователю: 
            //0. Выход из программы 
            //1. Регистрация 
            //2. Вход в систему
        // спросить у пользователя Логин и Пароль.
        // пройти по массиву пользователей(Ридерс)
        // найти обьект Юзер 
        // у которого совпадают логины (аутентификация)authentication
        // - если Юзер не найден -> дать возможность зарегистрироваться
        // сравнить пароли у user.Password() и password 
        // -- если совпадают -> возвращаем обьект пользователя (авторизация)authorization
        // -- иначе дать еще 2 попытки ввести пароль, после чего 
        // -- выход из программы System.exit(0);
        do {
            String task = this.printCheckTasks();
            switch(task) {
                case "0":
                    System.out.println("Выход из программы. Пока");
                    System.exit(0);
                    break;
                case "1":
                    this.registration(listUsers,ListReaders);
                    break;
                case "2":
                    return this.checkInUser(listUsers);
                default:
                     System.out.println("Выберите указанные задачи");
            }
        }while(true);
    }
    private String printCheckTasks(){
        System.out.println("--- Вход в систему ---"); 
        System.out.println("0. Выход из программы");
        System.out.println("1. Регистрация ");
        System.out.println("2. Вход в систему");
        System.out.print("Выберите номер задачи: ");
        String numTask = scanner.nextLine() ;
        return numTask;
    }
    private void registration(List<User> listUsers, List <Reader> listReaders) {
        UserManager userManager = new UserManager();
        User user = userManager.createUser();
        userManager.addUserToArray(user, listUsers);
        ReaderManager readerManager = new ReaderManager();
        readerManager.addReaderToArray(user.getReader(), listReaders);
        SaverToFile saverToFile = new SaverToFile();
        saverToFile.save(listReaders, "readers");
        saverToFile.save(listUsers, "users");
    }

    private User checkInUser(List<User> listUsers) {
        System.out.println("--- Вход в систему ---");
        System.out.println("Введите логин: ");
        String login = scanner.nextLine();
        System.out.println("Введите пароль: ");
        String password = scanner.nextLine();
        for (int i = 0; i < listUsers.size(); i++){
            User user = listUsers.get(i);
            if(user == null )continue ; 
            if(login.equals(user.getLogin())) { //authentication 
                for (int j = 0; j < 3; j++) {
                    if(password.equals(user.getPassword())){ //authorization
                        return user;
                    }else{
                        System.out.print("Попробуй еще раз: ");
                        password = scanner.nextLine();
                    }
                    
                }
                System.out.println("Пароль введен неверно (у вас нет доступа)");
                System.exit(0);
                
            }
        }
        System.out.println("Такого пользователя не существует. Зарегистрируйтесь!");
        System.exit(0);
        return null;
        
    }
    
   
}
