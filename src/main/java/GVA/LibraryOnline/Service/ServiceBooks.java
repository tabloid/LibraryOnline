package GVA.LibraryOnline.Service;

import GVA.LibraryOnline.Dao.DaoBook;
import GVA.LibraryOnline.Entity.EntityBook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
        List<EntityBook> list = new ArrayList<>();
        EntityBook book = new EntityBook();
        book.setName("all");
        list.add(book);
        return list;
    }


    public List<EntityBook> getBooksByFeatureAndName(String feature, String name){
        List<EntityBook> list = new ArrayList<>();
        EntityBook book = new EntityBook();
        book.setName(feature+name);
        list.add(book);
        return list;
    }

    public List<EntityBook> getBooksByFeatureAndNameAndAuthor(String feature, String name, String author){
        List<EntityBook> list = new ArrayList<>();
        EntityBook book = new EntityBook();
        book.setName(feature+name+author);
        list.add(book);
        return list;
    }

    public List<EntityBook> getBooksByFeatureAndNameAndAuthorAndYear(String feature, String name, String author, String year){
        List<EntityBook> list = new ArrayList<>();
        EntityBook book = new EntityBook();
        book.setName(feature+name+author+year);
        list.add(book);
        return list;
    }

    public List<EntityBook> getBooksByNameAndAuthorAndYear(String name, String author, String year){
        List<EntityBook> list = new ArrayList<>();
        EntityBook book = new EntityBook();
        book.setName(name+author+year);
        list.add(book);
        return list;
    }

    public List<EntityBook> getBooksByAuthorAndYear(String author, String year){
        List<EntityBook> list = new ArrayList<>();
        EntityBook book = new EntityBook();
        book.setName(author+year);
        list.add(book);
        return list;
    }

    public List<EntityBook> getBooksByFeature(String feature){
        return daoBook.getListByOneParam("feature", feature);
    }

    public List<EntityBook> getBooksByYear(String year){
        return daoBook.getListByOneParam("year", year);
    }

    public List<EntityBook> getBooksByName(String name){
        return daoBook.getListByOneParam("name", name);
    }

    public List<EntityBook> getBooksByAuthor(String author){
        return daoBook.getListByOneParam("author", author);
    }
}
