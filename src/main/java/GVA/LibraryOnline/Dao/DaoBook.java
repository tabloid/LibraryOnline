package GVA.LibraryOnline.Dao;

import GVA.LibraryOnline.Entity.EntityBook;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

/**
 * Created by V.Herasymenko on 19.10.2015.
 */
@Repository
public class DaoBook {

    @PersistenceContext
    protected EntityManager entityManager;

    public List<EntityBook> getList(){
        String queryStr = "select table from EntityBook table";
        Query query = entityManager.createQuery(queryStr);
        List<EntityBook> list = query.getResultList();
        return list;
    }

    public List<EntityBook> getListByOneParam(String param1, String value1){
        String queryStr = "select table from EntityBook table where table.:param1 = :value1";
        Query query = entityManager.createQuery(queryStr).
                setParameter("param1", param1).
                setParameter("value1", value1);
        List<EntityBook> list = query.getResultList();
        return list;
    }

    public List<EntityBook> getListByTwoParam(String param1, String value1, String param2, String value2){
        String queryStr = "select table from EntityBook table where " +
                "table.:param1 = :value1 and " +
                "table.:param2 = :value2";
        Query query = entityManager.createQuery(queryStr).
                setParameter("param1", param1).
                setParameter("value1", value1).
                setParameter("param2", param2).
                setParameter("value2", value2);
        List<EntityBook> list = query.getResultList();
        return list;
    }

    public List<EntityBook> getListByThreeParam(String param1, String value1,
                                                String param2, String value2,
                                                String param3, String value3){
        String queryStr = "select table from EntityBook table where " +
                "table.:param1 = :value1 and " +
                "table.:param2 = :value2 and " +
                "table.:param3 = :value3";
        Query query = entityManager.createQuery(queryStr).
                setParameter("param1", param1).
                setParameter("value1", value1).
                setParameter("param2", param2).
                setParameter("value2", value2).
                setParameter("param3", param3).
                setParameter("value3", value3);
        List<EntityBook> list = query.getResultList();
        return list;
    }

    public List<EntityBook> getListByFourParam(String param1, String value1,
                                                String param2, String value2,
                                                String param3, String value3,
                                               String param4, String value4){
        String queryStr = "select table from EntityBook table where " +
                "table.:param1 = :value1 and " +
                "table.:param2 = :value2 and " +
                "table.:param3 = :value3 and " +
                "table.:param4 = :value4";
        Query query = entityManager.createQuery(queryStr).
                setParameter("param1", param1).
                setParameter("value1", value1).
                setParameter("param2", param2).
                setParameter("value2", value2).
                setParameter("param3", param3).
                setParameter("value3", value3).
                setParameter("param4", param4).
                setParameter("value4", value4);
        List<EntityBook> list = query.getResultList();
        return list;
    }

}
