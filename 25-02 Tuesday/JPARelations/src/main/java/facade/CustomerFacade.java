package facade;

import entity.Customer;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

public class CustomerFacade {
    
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu");
    private static EntityManager em;
    
    public Customer getCustomerByID(int id) {
        em = emf.createEntityManager();
        try {
            return em.find(Customer.class, id);
        } finally {
            em.close();
        }
    }
    
    public List<Customer> getCustomers() {
        em = emf.createEntityManager();
        try {
           TypedQuery<Customer> tq = em.createQuery("SELECT c from Customer c", Customer.class);
           return tq.getResultList();
        } finally {
            em.close();
        }
    }
    public Customer addCustomer(Customer cust) {
        em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(cust);
            em.getTransaction().commit();
            return cust;
        } finally {
            em.close();
        }
    }
    public Customer deleteCustomer(int id) {
        em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            Customer cust = em.find(Customer.class, id);
            em.remove(cust);
            em.getTransaction().commit();
            return cust;
        } finally {
            em.close();
        }
    }
    
    public Customer editCustomer(Customer cust) {
        em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            Customer customer = em.find(Customer.class, cust.getId());
            customer.setFirstName(cust.getFirstName());
            customer.setLastName(cust.getLastName());
            em.getTransaction().commit();
            return customer;
        } finally {
            em.close();
        }
    }
}