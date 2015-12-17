package GVA.LibraryOnline.Dao;

import GVA.LibraryOnline.Entity.EntityFeature;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by V.Herasymenko on 17.12.2015.
 */
@Repository
@Transactional
public class DaoFeature {
    @PersistenceContext
    protected EntityManager entityManager;

    public List<EntityFeature> getAllEntityFeatures() {
        String queryStr = "select EF from EntityFeature EF";
        Query query = entityManager.createQuery(queryStr);
        List<EntityFeature> list = query.getResultList();
        return list;
    }

    public EntityFeature getEntityFeature(String feature) {
        Integer id = getId(feature);
        if (id != null)
            return entityManager.find(EntityFeature.class, id);
        return null;
    }

    private Integer getId(String feature) {
        String queryStr = "select EF.id from EntityFeature EF where EF.feature = :feature";
        Query query = entityManager.createQuery(queryStr);
        query.setParameter("feature", feature);
        List<Integer> list = query.getResultList();
        if (list.isEmpty())
            return null;
        else
            return list.get(0);
    }

    public void save(EntityFeature entityFeature) {
        entityManager.persist(entityFeature);
    }
}
