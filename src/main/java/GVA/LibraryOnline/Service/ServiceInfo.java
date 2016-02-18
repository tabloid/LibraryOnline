package GVA.LibraryOnline.Service;

import GVA.LibraryOnline.Entity.BookInfo;
import GVA.LibraryOnline.Exception.WrongNameFormatException;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

/**
 * Created by v.herasymenko on 2/18/2016.
 */
@Service
public class ServiceInfo {

    public BookInfo getBookInfoFromFileName(MultipartFile file) throws WrongNameFormatException{
        BookInfo bookInfo = null;
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

            bookInfo = new BookInfo();
            bookInfo.setAuthor(author);
            bookInfo.setName(name);
            bookInfo.setYear(year);
            bookInfo.setExtention(extention);
        }
        else throw new WrongNameFormatException();
            return bookInfo;
    }

}
