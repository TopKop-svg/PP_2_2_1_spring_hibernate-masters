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

      Car car1 = new Car();
      car1.setModel("Toyota");
      car1.setSeries(2012);

      Car car2 = new Car();
      car2.setModel("BMW");
      car2.setSeries(2010);

      User user1 = new User();
      user1.setFirstName("User1");
      user1.setLastName("Lastname1");
      user1.setEmail("user1@mail.ru");
      user1.setCar(car1);
      userService.add(user1);

      User user2 = new User();
      user2.setFirstName("User2");
      user2.setLastName("Lastname2");
      user2.setEmail("user2@mail.ru");
      user2.setCar(car2);
      userService.add(user2);



      context.close();
   }
}


