package hibernate;

import hibernate.model.Competitors;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Created by jn on 2017-11-19.
 */
public class Manager {

    public static void main(String[] args) {

        System.out.println("Start");

        EntityManager entityManager = null;

        EntityManagerFactory entityManagerFactory = null;

        try {
            //taka nazwa jak w persistence.xml
            entityManagerFactory = Persistence.createEntityManagerFactory("hibernate-dynamic");
            //utworz entityManagera
            entityManager = entityManagerFactory.createEntityManager();

            //rozpocznij transakcje
            entityManager.getTransaction().begin();

            Competitors comp = new Competitors();
            comp.setFirst_Name("Andriej");
            comp.setLast_Name("Lukaszenko");
            comp.setHeight(190);
            comp.setType("freestyle");
            comp.setDate_Of_Birth("20-10-1996");

            entityManager.persist(comp);
            entityManager.remove(comp);
            entityManager.getTransaction().commit();
            System.out.println("Done");

            entityManager.close();

        } catch (Throwable ex) {
            System.err.println("Initial SessionFactory creation failed." + ex);
        } finally {
            entityManagerFactory.close();
        }
        }
    }