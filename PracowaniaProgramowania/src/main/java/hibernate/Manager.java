package hibernate;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import hibernate.model.Author;
import hibernate.model.Book;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.io.File;
import java.io.IOException;
import java.util.List;

import static org.hibernate.validator.internal.util.Contracts.assertNotNull;

public class Manager {

    public static void main(String[] args) throws IOException{

        System.out.println("Start");

        EntityManager entityManager;

        EntityManagerFactory entityManagerFactory = null;

        try {
            //create Factory
            entityManagerFactory = Persistence.createEntityManagerFactory("hibernate-dynamic");
            //create entityManager
            entityManager = entityManagerFactory.createEntityManager();

            //begin transaction
            entityManager.getTransaction().begin();

            //create entities
            Author auth = new Author();
            auth.setLast_name("Nowoj");
            auth.setCountry("Russia");
            auth.setBirth("1996");

            Author auth2 = new Author();
            auth2.setLast_name("Rybak");
            auth2.setCountry("Poland");
            auth2.setBirth("1997");

            Book b1 = new Book();
            b1.setAuthor("Szto");
            b1.setPrice(204);
            b1.setCreated("1996");
            b1.setTitle("Lord of the Rings");

            //add to table
            entityManager.persist(auth2);

            auth.setBook(b1);
            auth.getSubcategories().add(auth2);

            entityManager.persist(b1);
            entityManager.persist(auth);

            Author author = entityManager.find(Author.class, auth.getId());
            Query query = entityManager.createQuery("Select k from Author k");
            List<Author> authors = query.getResultList();

            System.out.println("Author: " +auth.getId() + " " + auth.getLast_name());

            entityManager.getTransaction().commit();

            //JSON FORMAT
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.writeValue(new File("result.json"), auth);
           // Author resAuth = objectMapper.readValue(new File("result.json", Author.class));

            // XML FORMAT
            XmlMapper xmlMapper = new XmlMapper();
            xmlMapper.writeValue(new File("result.xml"), auth);
            System.out.println("Done");

            entityManager.close();


        } catch (Throwable ex) {
            System.err.println("Initial SessionFactory creation failed." + ex);
        } finally {
            entityManagerFactory.close();
        }
        }
    }