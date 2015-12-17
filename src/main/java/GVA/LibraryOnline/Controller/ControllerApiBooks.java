package GVA.LibraryOnline.Controller;

import GVA.LibraryOnline.Entity.EntityBook;
import GVA.LibraryOnline.Entity.EntityFeature;
import GVA.LibraryOnline.Exception.WrongNameFormatException;
import GVA.LibraryOnline.Service.ServiceBook;
import GVA.LibraryOnline.Service.ServiceFeature;
import com.lowagie.text.DocumentException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

/**
 * Created by V.Herasymenko on 05.10.2015.
 */

@RestController
@RequestMapping(value = "/api")
public class ControllerApiBooks {

    @Autowired
    ServiceBook serviceBook;
    @Autowired
    ServiceFeature serviceFeature;

    @RequestMapping(value = "/books", method = RequestMethod.GET,
            produces = "application/json")
    public List<EntityBook> getBooks(@RequestParam(value = "feature", required = false) String feature,
                                     @RequestParam(value = "name", required = false) String name,
                                     @RequestParam(value = "author", required = false) String author,
                                     @RequestParam(value = "year", required = false) String year) {
        if (feature == null && name == null && author == null && year == null)
            return serviceBook.getAllBooks();
        else
            return serviceBook.getBooksByCriteria(feature, name, author, year);
    }

    @RequestMapping(value = "/books/{id}", method = RequestMethod.GET)
    public void getBook(@PathVariable int id, HttpServletResponse response) throws IOException {
        EntityBook entityBook = serviceBook.getBookById(id);
        if (entityBook != null) {
            response.setStatus(200);
            String filename = entityBook.getId() + "." + entityBook.getExtention();
            String len = String.valueOf(entityBook.getData().length);
            response.addHeader("Content-Length", len);
            response.addHeader("Content-Disposition", "attachment; filename=\"" + filename + "\"");
            OutputStream outputStream = response.getOutputStream();
            outputStream.write(entityBook.getData());
            outputStream.flush();
            outputStream.close();
        }
    }

    @RequestMapping(value = "/books/{feature}/new", method = RequestMethod.POST)
    public String addNewBook(@PathVariable String feature, @RequestParam("file") MultipartFile[] files)
            throws IOException, WrongNameFormatException, DocumentException {
        String log = "start\r\n";
        for (MultipartFile file : files) {
            if (!file.isEmpty()) {
                serviceBook.addNewBook(feature, file);
                log += file.getOriginalFilename() + " uploaded\r\n";
            }
        }
        return log;
    }

    @RequestMapping(value = "/books/features", method = RequestMethod.GET,
            produces = "application/json")
    public List<EntityFeature> getFeatures() {
        return serviceFeature.getAllEntityFeatures();
    }

    @RequestMapping(value = "/remove", method = RequestMethod.GET)
    public String removeAllBooks() {
        serviceBook.removeAllBooks();
        return "books removed";
    }

}
