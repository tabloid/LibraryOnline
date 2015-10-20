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
        return daoBook.getList();
    }

    public List<EntityBook> getBooksByFeatureAndNameAndAuthorAndYear(String feature, String name, String author, String year){
        return daoBook.getListByFourParam("feature", feature, "name", name,
                "author", author, "year", year);
    }

    public List<EntityBook> getBooksByFeatureAndNameAndAuthor(String feature, String name, String author){
        return daoBook.getListByThreeParam("feature", feature, "name", name, "author", author);
    }

    public List<EntityBook> getBooksByFeatureAndNameAndYear(String feature, String name, String year){
        return daoBook.getListByThreeParam("feature", feature, "name", name, "year", year);
    }

    public List<EntityBook> getBooksByFeatureAndAuthorAndYear(String feature, String author, String year){
        return daoBook.getListByThreeParam("feature", feature, "author", author, "year", year);
    }

    public List<EntityBook> getBooksByNameAndAuthorAndYear(String name, String author, String year){
        return daoBook.getListByThreeParam("name", name, "author", author, "year", year);
    }

    public List<EntityBook> getBooksByFeatureAndName(String feature, String name){
        return daoBook.getListByTwoParam("feature", feature, "name", name);
    }

    public List<EntityBook> getBooksByFeatureAndAuthor(String feature, String author){
        return daoBook.getListByTwoParam("feature", feature, "author", author);
    }

    public List<EntityBook> getBooksByFeatureAndYear(String feature, String year){
        return daoBook.getListByTwoParam("feature", feature, "year", year);
    }

    public List<EntityBook> getBooksByNameAndAuthor(String name, String author){
        return daoBook.getListByTwoParam("name", name, "author", author);
    }

    public List<EntityBook> getBooksByNameAndYear(String name, String year){
        return daoBook.getListByTwoParam("name", name, "year", year);
    }

    public List<EntityBook> getBooksByAuthorAndYear(String author, String year){
        return daoBook.getListByTwoParam("author", author, "year", year);
    }

    public List<EntityBook> getBooksByFeature(String feature){
        return daoBook.getListByOneParam("feature", feature);
    }

    public List<EntityBook> getBooksByName(String name){
        return daoBook.getListByOneParam("name", name);
    }

    public List<EntityBook> getBooksByAuthor(String author){
        return daoBook.getListByOneParam("author", author);
    }

    public List<EntityBook> getBooksByYear(String year){
        return daoBook.getListByOneParam("year", year);
    }


}
