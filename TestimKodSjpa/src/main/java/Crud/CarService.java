package Crud;


import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import Car.Car;

import java.util.List;
/**
 * Created by Галка on 22.03.2016.
 */
public class CarService { public EntityManager em = Persistence.createEntityManagerFactory("COLIBRI").createEntityManager();

    public Car add(Car car) {
        em.getTransaction().begin();
        Car carFromDB = em.merge(car);
        em.getTransaction().commit();
        return carFromDB;
    }

    public void delete(long id) {
        em.getTransaction().begin();
        em.remove(get(id));
        em.getTransaction().commit();
    }

    public Car get(long id) {
        return em.find(Car.class, id);
    }

    public void update(Car car) {
        em.getTransaction().begin();
        em.merge(car);
        em.getTransaction().commit();
    }

    public List<Car> getAll() {
        TypedQuery<Car> namedQuery = em.createNamedQuery("Car.getAll", Car.class);
        return namedQuery.getResultList();
    }

}
