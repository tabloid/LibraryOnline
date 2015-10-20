package GVA.LibraryOnline.Controller;

import GVA.LibraryOnline.Entity.EntityBook;
import GVA.LibraryOnline.Service.ServiceBooks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

/**
 * Created by V.Herasymenko on 05.10.2015.
 */

@RestController
@RequestMapping(value = "/api")
public class ControllerBooks {

    @Autowired
    ServiceBooks serviceBooks;

    @RequestMapping(value = "/books",
            method = RequestMethod.GET,
            produces = "application/json")
    public List<EntityBook> getBooks(@RequestParam(value = "feature", required = false) String feature,
                                     @RequestParam(value = "name", required = false) String name,
                                     @RequestParam(value = "author", required = false) String author,
                                     @RequestParam(value = "year", required = false) String year) {
        if (feature == null && name == null && author == null && year == null)
            return serviceBooks.getAllBooks();
        else
            return serviceBooks.getBooksByCriteria(feature, name, author, year);
    }

    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    public String handleFileUpload(@RequestParam("file") MultipartFile file) {
        if (!file.isEmpty()) {
            try {
                byte[] bytes = file.getBytes();
                String name = file.getName();
                return "You successfully uploaded " + name + "!";
            } catch (IOException ex) {
                System.out.println(ex);
            }
        }
        return "You failed to upload file because it was empty.";
    }

}
