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
      List<User> users = userService.listUsers();


      for (User user : users) {
         System.out.println("Id = " + user.getId());
         System.out.println("First Name = " + user.getFirstName());
         System.out.println("Last Name = " + user.getLastName());
         System.out.println("Email = " + user.getEmail());
         System.out.println("Car Model = " + user.getCar().getModel());
         System.out.println("Car Series = " + user.getCar().getSeries());
      }
      System.out.println(userService.getUserByHisCar(car1));
      context.close();
   }
}


