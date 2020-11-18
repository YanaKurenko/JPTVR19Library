/*
 * ШАГИ ПОДКЛЮЧЕНИЯ БАЗЫ К ПРИЛОЖЕНИЮ:
* 1. Запустить базу данных ("jptvr19householdgoods")
* 2. Создать пользователя базы (user = "" ) и пароль (password = jptvr19householdgoods)
* 3. Подключить библиотеку(поставщика персистентности "постоянства")- persistence provider. EclipseLink(JPA 2.1)
* 4. Подключить драйвер базы данных (mysql-connector)
* 5. Cущностные классы пометить аннотациями ("@Entity, @Id, @GenerationValue и др. см. [Изучаем Java EE 7]")
* 6. Создать persistence unit в файле persistence.xml
* 7. Добавить сущности в файл persistence.xml (add.entity)
* 8. Создать класс, который отвечает за работу с базой данных(SaveToBase)
* 9. В бизнес-логике приложения использовать объект этого класса для сохранения данных в базу 
 */
package jptvr19library;

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
        app.run();
    }
    
}
