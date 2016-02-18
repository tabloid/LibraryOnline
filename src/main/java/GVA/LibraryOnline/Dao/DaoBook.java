package GVA.LibraryOnline.Dao;

import GVA.LibraryOnline.Entity.EntityBook;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by V.Herasymenko on 19.10.2015.
 */
@Repository
@Transactional
public class DaoBook {

    @PersistenceContext
    protected EntityManager entityManager;

    public List<EntityBook> getAllBooks(){
        String queryStr = "select new EntityBook(t.id, t.entityFeature, t.name, t.author, " +
                "t.year, t.extention, t.title) from EntityBook t";
        Query query = entityManager.createQuery(queryStr);
        List<EntityBook> list = query.getResultList();
        return list;
    }

    public List<EntityBook> getListByCriteria(String queryStr) {
        Query query = entityManager.createQuery(queryStr);
        List<EntityBook> list = query.getResultList();
        return list;
    }

    public EntityBook getBookById(int id) {
        return entityManager.find(EntityBook.class, id);
    }

    public void save(EntityBook entityBook) {
        entityManager.persist(entityBook);
    }

    public void update(EntityBook entityBook){
        entityManager.merge(entityBook);
    }

    public void remove() {
        String query = "delete from EntityBook books";
        entityManager.createQuery(query).executeUpdate();
        query = "delete from EntityFeature features";
        entityManager.createQuery(query).executeUpdate();
    }

}
