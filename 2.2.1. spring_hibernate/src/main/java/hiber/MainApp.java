package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.UserService;
import hiber.service.UserServiceImp;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;
import java.util.List;

public class MainApp {
   public static void main(String[] args) throws SQLException {
      AnnotationConfigApplicationContext context =
              new AnnotationConfigApplicationContext(AppConfig.class);
      UserService userService = context.getBean(UserService.class);
      User user1 = new User();
      user1.setFirstName("UserName");
      user1.setLastName("Lastname1");
      user1.setEmail("user1@mail.ru");
      Car car1 = new Car();
      car1.setModel("Toyota");
      car1.setSeries(2012);
      user1.setCar(car1);
      car1.setUser(user1);


      System.out.println(user1.getCar());

      userService.add(user1);
      //UserService userService = context.getBean(UserService.class);
      //
      //Car car1 = new Car();
      //car1.setModel("Toyota");
      //car1.setSeries(2012);
      //
      //Car car2 = new Car();
      //car2.setModel("BMW");
      //car2.setSeries(2010);
      //
      //User user1 = new User();
      //user1.setFirstName("User1");
      //user1.setLastName("Lastname1");
      //user1.setEmail("user1@mail.ru");
      //user1.setCar(car1);
      //userService.add(user1);
      //
      //User user2 = new User();
      //user2.setFirstName("User2");
      //user2.setLastName("Lastname2");
      //user2.setEmail("user2@mail.ru");
      //user2.setCar(car2);
      //userService.add(user2);

      // Получаем список пользователей из базы данных
      List<User> users = userService.listUsers();

      // Выводим информацию о каждом пользователе и его машине
      for (User user : users) {
         System.out.println("Id = " + user.getId());
         System.out.println("First Name = " + user.getFirstName());
         System.out.println("Last Name = " + user.getLastName());
         System.out.println("Email = " + user.getEmail());
         System.out.println("Car Model = " + user.getCar().getModel());
         System.out.println("Car Series = " + user.getCar().getSeries());
         System.out.println();
      }


      context.close();
   }
}


