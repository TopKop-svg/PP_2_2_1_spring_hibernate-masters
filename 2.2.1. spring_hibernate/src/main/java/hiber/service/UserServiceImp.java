package hiber.service;

import hiber.dao.UserDao;
import hiber.model.Car;
import hiber.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserServiceImp implements UserService {

   @Autowired
   private UserDao userDao;

   @Transactional
   @Override
   public void add(User user) {
      // Если у пользователя есть машина, сохраняем ее перед сохранением пользователя
      Car car = user.getCar();
      if (car != null) {
         // Помещаем машину пользователя в базу данных
         user.setCar(null); // Чтобы избежать рекурсии
         userDao.add(user);
         car.setUser(user); // Устанавливаем связь с пользователем
         user.setCar(car); // Обратно устанавливаем машину у пользователя
      }
      userDao.add(user);
   }

   @Transactional(readOnly = true)
   @Override
   public List<User> listUsers() {
      return userDao.listUsers();
   }
}
