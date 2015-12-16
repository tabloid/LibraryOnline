package GVA.LibraryOnline.Service;

import GVA.LibraryOnline.Dao.DaoBook;
import GVA.LibraryOnline.Entity.EntityBook;
import GVA.LibraryOnline.Exception.WrongNameFormatException;
import com.lowagie.text.DocumentException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * Created by V.Herasymenko on 13.10.2015.
 */
@Service
public class ServiceBooks {
    @Autowired
    DaoBook daoBook;
    @Autowired
    ServiceTitles serviceTitles;

    public List<EntityBook> getAllBooks() {
        String queryStr = "select new EntityBook(t.id, t.feature, t.name, t.author, t.year, t.extention, t.title) " +
                "from EntityBook t";
        return daoBook.getListByCriteria(queryStr);
    }

    public EntityBook getBookById(int id) {
        return daoBook.getBookById(id);
    }

    public List<EntityBook> getBooksByCriteria(String feature, String name, String author, String year) {
        StringBuilder query = new StringBuilder("select table from EntityBook table where ");
        if (feature != null) {
            query.append("LOWER(feature) like '%").append(feature.toLowerCase()).append("%' and ");
        }
        if (name != null) {
            query.append("LOWER(name) like '%").append(name.toLowerCase()).append("%' and ");
        }
        if (author != null) {
            query.append("LOWER(author) like '%").append(author.toLowerCase()).append("%' and ");
        }
        if (year != null) {
            query.append("year like '%").append(year).append("%' and ");
        }
        query.delete(query.length() - 4, query.length());
        return daoBook.getListByCriteria(query.toString());
    }

    public void addNewBook(String feature, MultipartFile file)
            throws WrongNameFormatException, DocumentException, IOException {
        String fileName = file.getOriginalFilename();
        String extention = fileName.substring(fileName.lastIndexOf(".") + 1);
        String fileNameWithoutExtention = fileName.substring(0, fileName.lastIndexOf("."));
        //split by dot symbol
        String[] array = fileNameWithoutExtention.split("\\.");
        int len = array.length;
        if (len >= 3) {
            //first element is author name
            String author = array[0].trim();
            //last element is year
            String year = array[len - 1].trim();
            //everything between first and last element is name value
            //this is for book names that consist of several sentences divided by dot
            String name = "";
            if (len > 3) {
                for (int i = 1; i <= len - 2; i++)
                    name += array[i] + ". ";
                name = name.substring(0, name.lastIndexOf("."));
            } else
                name = array[1].trim();

            EntityBook entityBook = new EntityBook();
            entityBook.setFeature(feature);
            entityBook.setName(name);
            entityBook.setAuthor(author);
            entityBook.setYear(year);
            entityBook.setExtention(extention);
            InputStream inputStream = file.getInputStream();
            byte[] title = serviceTitles.getFirstPage(inputStream, extention);
            entityBook.setTitle(title);
            entityBook.setData(file.getBytes());
            daoBook.save(entityBook);
        } else throw new WrongNameFormatException();
    }

    public void removeAllBooks(){
        daoBook.remove();
    }
}
