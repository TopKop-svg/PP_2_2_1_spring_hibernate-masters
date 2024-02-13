package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;
import java.util.List;

public class MainApp {
   public static void main(String[] args) throws SQLException {
      AnnotationConfigApplicationContext context =
              new AnnotationConfigApplicationContext(AppConfig.class);

      UserService userService = context.getBean(UserService.class);

      // Добавляем пользователей
      User user1 = new User();
      user1.setFirstName("User1");
      user1.setLastName("Lastname1");
      user1.setEmail("user1@mail.ru");
      userService.add(user1);

      User user2 = new User();
      user2.setFirstName("User2");
      user2.setLastName("Lastname2");
      user2.setEmail("user2@mail.ru");
      userService.add(user2);

      User user3 = new User();
      user3.setFirstName("User3");
      user3.setLastName("Lastname3");
      user3.setEmail("user3@mail.ru");
      userService.add(user3);

      User user4 = new User();
      user4.setFirstName("User4");
      user4.setLastName("Lastname4");
      user4.setEmail("user4@mail.ru");
      userService.add(user4);

      // Добавляем машины
      Car car1 = new Car();
      car1.setModel("Toyota");
      car1.setSeries(12345);
      user1.setCar(car1);

      Car car2 = new Car();
      car2.setModel("BMW");
      car2.setSeries(54321);
      user2.setCar(car2);

      // Выводим информацию о пользователях
      List<User> users = userService.listUsers();
      for (User user : users) {
         System.out.println("Id = " + user.getId());
         System.out.println("First Name = " + user.getFirstName());
         System.out.println("Last Name = " + user.getLastName());
         System.out.println("Email = " + user.getEmail());

      }

      context.close();
   }
}


