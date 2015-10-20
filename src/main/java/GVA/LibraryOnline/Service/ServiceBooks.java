package GVA.LibraryOnline.Service;

import GVA.LibraryOnline.Dao.DaoBook;
import GVA.LibraryOnline.Entity.EntityBook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by V.Herasymenko on 13.10.2015.
 */
@Service
public class ServiceBooks {
    @Autowired
    DaoBook daoBook;

    public List<EntityBook> getAllBooks(){
        String queryStr = "select table from EntityBook table";
        return daoBook.getListByCriteria(queryStr);
    }

    public List<EntityBook> getBooksByCriteria(String feature, String name, String author, String year){
        StringBuilder query = new StringBuilder("select table from EntityBook table where ");
        if (feature != null) {
            query.append("LOWER(feature) like '").append(feature.toLowerCase()).append("%' and ");
        }
        if (name != null) {
            query.append("LOWER(name) like '").append(name.toLowerCase()).append("%' and ");
        }
        if (author != null) {
            query.append("LOWER(author) like '").append(author.toLowerCase()).append("%' and ");
        }
        if (year != null) {
            query.append("year like '").append(year).append("%' and ");
        }
        query.delete(query.length()-4, query.length());
        return daoBook.getListByCriteria(query.toString());
    }

}
