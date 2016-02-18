package GVA.LibraryOnline.Dao;

import GVA.LibraryOnline.Entity.EntityBook;
import GVA.LibraryOnline.Entity.EntityFeature;
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

    public void updateTitle(int bookId, byte[] bookTittle){
        String queryStr = "update EntityBook set title = :title where id = :id";
        Query query = entityManager.createQuery(queryStr);
        query.setParameter("title", bookTittle);
        query.setParameter("id", bookId);
        query.executeUpdate();

    }

    public void removeBookById(int bookId) {

        String queryStr = "delete from EntityBook book where book.id = :id";
        Query query = entityManager.createQuery(queryStr);
        query.setParameter("id", bookId);
        query.executeUpdate();

    }
}
