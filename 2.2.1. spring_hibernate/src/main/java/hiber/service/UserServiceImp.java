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
         userDao.addCar(car); // Сохраняем машину
      }
      userDao.add(user);
   }

   @Transactional
   @Override
   public void add(Car car) {
      userDao.addCar(car); // Добавляем машину в базу данных
   }


   @Transactional(readOnly = true)
   @Override
   public List<User> listUsers() {
      return userDao.listUsers();
   }
}
