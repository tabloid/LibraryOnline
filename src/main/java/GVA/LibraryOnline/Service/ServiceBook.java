package GVA.LibraryOnline.Service;

import GVA.LibraryOnline.Dao.DaoBook;
import GVA.LibraryOnline.Entity.BookInfo;
import GVA.LibraryOnline.Entity.EntityBook;
import GVA.LibraryOnline.Entity.EntityFeature;
import GVA.LibraryOnline.Exception.WrongNameFormatException;
import com.lowagie.text.DocumentException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.logging.Logger;

/**
 * Created by V.Herasymenko on 13.10.2015.
 */
@Service
public class ServiceBook {
    private static final Logger logger = Logger.getLogger(ServiceBook.class.getName());

    @Autowired
    private DaoBook daoBook;
    @Autowired
    private ServiceTitle serviceTitle;
    @Autowired
    private ServiceFeature serviceFeature;
    @Autowired
    private ServiceInfo serviceInfo;

    public List<EntityBook> getAllBooks() {
        return daoBook.getAllBooks();
    }

    public EntityBook getBookById(int id) {
        EntityBook entityBook = daoBook.getBookById(id);
        int downloads = entityBook.getDownloads();
        downloads++;
        daoBook.updateDownloads(id, downloads);
        logger.info("Updated number of downloads: " + downloads);
        return entityBook;
    }

    public List<EntityBook> getBooksByCriteria(String feature, String name, String author, String year) {
        String queryStr = "select new EntityBook(t.id, t.entityFeature, t.name, t.author, " +
                "t.year, t.extention, t.title, t.downloads) from EntityBook t where ";
        StringBuilder query = new StringBuilder(queryStr);
        if (feature != null) {
            query.append("LOWER(t.entityFeature.feature) like '%").append(feature.toLowerCase()).append("%' and ");
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
            throws WrongNameFormatException, IOException {
        BookInfo bookInfo = serviceInfo.getBookInfoFromFileName(file);
        EntityBook entityBook = new EntityBook();
        EntityFeature entityFeature = serviceFeature.getEntityFeature(feature);
        entityBook.setFeature(entityFeature);
        entityBook.setName(bookInfo.getName());
        entityBook.setAuthor(bookInfo.getAuthor());
        entityBook.setYear(bookInfo.getYear());
        entityBook.setExtention(bookInfo.getExtention());
        entityBook.setData(file.getBytes());
        entityBook.setDownloads(0);
        daoBook.save(entityBook);
        Thread newThread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    logger.info("Start title processing for bookId: " + entityBook.getId());
                    InputStream inputStream = file.getInputStream();
                    byte[] title = serviceTitle.getFirstPage(inputStream, entityBook.getExtention());
                    daoBook.updateTitle(entityBook.getId(), title);
                    logger.info("Finish title processing for bookId: " + entityBook.getId());
                } catch (IOException | DocumentException ex) {
                    logger.severe(ex.getMessage());
                }
            }
        });
        newThread.start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
            logger.severe(ex.getMessage());
        }
    }

    public void removeBook(int id) {
        daoBook.removeBookById(id);
    }
}
