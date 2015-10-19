package GVA.LibraryOnline.Dao;

import GVA.LibraryOnline.Entity.EntityBook;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created by V.Herasymenko on 19.10.2015.
 */
@Repository
public class DaoBook {

    @PersistenceContext
    protected EntityManager entityManager;

    public List<EntityBook> getListByOneParam(String param, String value){
        String query = "select table from EntityBook table where table." + param + " = '" + value + "'";
        List<EntityBook> list = entityManager.createQuery(query).getResultList();
        return list;
    }
}
