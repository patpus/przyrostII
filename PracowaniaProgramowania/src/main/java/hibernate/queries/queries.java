package hibernate.queries;

import hibernate.model.Author;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

public class queries {

    EntityManager entityManager;

    public queries(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public List<Author> getAuthorByLastName(String name) {
        TypedQuery<Author> query = entityManager.createQuery(
                "SELECT c FROM Author c WHERE c.last_name LIKE :name", Author.class);
        return query.setParameter("name", name).getResultList();
    }
}
