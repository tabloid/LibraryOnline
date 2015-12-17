package GVA.LibraryOnline.Service;

import GVA.LibraryOnline.Dao.DaoFeature;
import GVA.LibraryOnline.Entity.EntityFeature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by V.Herasymenko on 17.12.2015.
 */
@Service
public class ServiceFeature {
    @Autowired
    DaoFeature daoFeature;

    public EntityFeature getEntityFeature(String feature) {
        EntityFeature entityFeature = daoFeature.getEntityFeature(feature);
        if (entityFeature == null) {
            entityFeature = new EntityFeature(feature);
            daoFeature.save(entityFeature);
        }
        return entityFeature;
    }

    public List<EntityFeature> getAllEntityFeatures(){
        return daoFeature.getAllEntityFeatures();
    }
}
