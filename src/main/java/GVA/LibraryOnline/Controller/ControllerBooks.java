package GVA.LibraryOnline.Controller;

import GVA.LibraryOnline.Entity.EntityBook;
import GVA.LibraryOnline.Service.ServiceBooks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
        else if (feature != null && name == null && author == null && year == null)
            return serviceBooks.getBooksByFeature(feature);
        else if (feature != null && name != null && author == null && year == null)
            return serviceBooks.getBooksByFeatureAndName(feature, name);
        else if (feature != null && name != null && author != null && year == null)
            return serviceBooks.getBooksByFeatureAndNameAndAuthor(feature, name, author);
        else if (feature != null && name != null && author != null && year != null)
            return serviceBooks.getBooksByFeatureAndNameAndAuthorAndYear(feature, name, author, year);
        else if (feature == null && name != null && author != null && year != null)
            return serviceBooks.getBooksByNameAndAuthorAndYear(name, author, year);
        else if (feature == null && name == null && author != null && year != null)
            return serviceBooks.getBooksByAuthorAndYear(author, year);
        else if (feature == null && name == null && author == null && year != null)
            return serviceBooks.getBooksByYear(year);
        else if (feature == null && name != null && author == null && year == null)
            return serviceBooks.getBooksByName(name);
        else if (feature == null && name == null && author != null && year == null)
            return serviceBooks.getBooksByAuthor(author);
        return null;
    }

}
