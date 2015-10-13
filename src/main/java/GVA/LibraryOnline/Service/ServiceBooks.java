package GVA.LibraryOnline.Service;

import GVA.LibraryOnline.Entity.EntityBook;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by V.Herasymenko on 13.10.2015.
 */
@Service
public class ServiceBooks {

    private void initList(){
        List<EntityBook> list = new ArrayList<>();
        EntityBook book1 = new EntityBook();
        book1.setAuthor("Уоллс Крейг");
        book1.setName("Spring в действии");
        book1.setFeature("it");
        book1.setYear("2013");
        book1.setData(new byte[]{1, 2, 3, 4});
        EntityBook book2 = new EntityBook();
        list.add(book1);
        list.add(book2);
    }

    public List<EntityBook> getAllBooks(){
        List<EntityBook> list = new ArrayList<>();
        EntityBook book = new EntityBook();
        book.setName("all");
        list.add(book);
        return list;
    }

    public List<EntityBook> getBooksByFeature(String feature){
        List<EntityBook> list = new ArrayList<>();
        EntityBook book = new EntityBook();
        book.setName(feature);
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

    public List<EntityBook> getBooksByYear(String year){
        List<EntityBook> list = new ArrayList<>();
        EntityBook book = new EntityBook();
        book.setName(year);
        list.add(book);
        return list;
    }
}
