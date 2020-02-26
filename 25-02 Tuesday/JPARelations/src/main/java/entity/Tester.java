package entity;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Tester {
 
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu");
    
    public static void main(String[] args) {
        EntityManager em = emf.createEntityManager();
        Persistence.generateSchema("pu", null);
        em.getTransaction().begin();
        Customer c1 = new Customer("John", "Doe");
        Customer c2 = new Customer("Jane", "Doe");
        Address a1 = new Address("Jensensgade", "København");
        Address a2 = new Address("Jørgensensgade", "København");
        Address a3 = new Address("Johnsensgade", "København");
        Address a4 = new Address("Johansensgade", "København");
        em.persist(a1);
        em.persist(a2);
        em.persist(a3);
        em.persist(a4);
        c1.addAddresses(a1);
        c1.addAddresses(a3);
        c2.addAddresses(a3);
        c1.addHobby("football"); c1.addHobby("basketball");
        c2.addHobby("hockey"); c2.addHobby("ice skating");
        em.persist(c1);
        em.persist(c2);
        em.getTransaction().commit();
    }
}