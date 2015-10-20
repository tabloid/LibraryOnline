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
        return daoBook.getList();
    }

    public List<EntityBook> getBooksByCriteria(String feature, String name, String author, String year){
        StringBuilder query = new StringBuilder("select table from EntityBook table where ");
        if (feature != null) {
            query.append("feature = ").append(feature).append(" and ");
        }
        if (name != null) {
            query.append("name = ").append(name).append(" and ");
        }
        if (author != null) {
            query.append("author = ").append(author).append(" and ");
        }
        if (year != null) {
            query.append("year = ").append(year).append(" and ");
        }
        query.delete(query.length()-4, query.length());
        String str = null;
        try{
            str = new String(query.toString().getBytes("UTF-8"));
        } catch (UnsupportedEncodingException ex){
            System.out.println(ex);
        }

        return daoBook.getListByCriteria(str);
    }

}
