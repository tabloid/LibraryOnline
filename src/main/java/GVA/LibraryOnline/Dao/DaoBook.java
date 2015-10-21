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

    public List<EntityBook> getListByCriteria(String queryStr){
        System.out.println(queryStr);
        Query query = entityManager.createQuery(queryStr);
        List<EntityBook> list = query.getResultList();
        return list;
    }

    public EntityBook getBookById(int id){
        return entityManager.find(EntityBook.class, id);
    }

    public void save(EntityBook entityBook){
        entityManager.persist(entityBook);
    }

}
