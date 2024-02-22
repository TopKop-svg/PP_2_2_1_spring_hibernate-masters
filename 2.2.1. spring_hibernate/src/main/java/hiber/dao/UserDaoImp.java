package hiber.dao;

import hiber.model.Car;
import hiber.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class UserDaoImp implements UserDao {

   @Autowired
   private SessionFactory sessionFactory;

   @Override
   public void add(User user) {
      sessionFactory.getCurrentSession().save(user);
   }

    @Override
    public void addCar(Car car) {
        sessionFactory.getCurrentSession().save(car);
    }
    @Transactional(readOnly = true)
    public User getUserByHisCar(Car car) {
        String hql = "SELECT u FROM User u JOIN u.car c WHERE c.model = :model AND c.series = :series";
        Query query = sessionFactory.getCurrentSession().createQuery(hql);
        query.setParameter("model", car.getModel());
        query.setParameter("series", car.getSeries());
        List<User> userList = query.getResultList();
        if (userList.isEmpty()) {
            return null;
        } else {
            System.out.println(userList.get(0).getFirstName());
            return userList.get(0);
        }
    }



    @Override
   @SuppressWarnings("unchecked")
   public List<User> listUsers() {
      TypedQuery<User> query=sessionFactory.getCurrentSession().createQuery("from User");
      return query.getResultList();
   }

}
