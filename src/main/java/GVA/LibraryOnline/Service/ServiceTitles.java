package GVA.LibraryOnline.Service;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.pdf.PdfImportedPage;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfWriter;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.rendering.PDFRenderer;
import org.springframework.stereotype.Service;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

/**
 * Created by V.Herasymenko on 04.11.2015.
 */

//only for pdf available
@Service
public class ServiceTitles {

    private byte[] getFirstPdfPage(byte[] input) throws IOException, DocumentException {
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(input);
        Document document = new Document(PageSize.A4, 0, 0, 0, 0);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PdfWriter writer = PdfWriter.getInstance(document, byteArrayOutputStream);
        PdfReader reader = null;
        try {
            reader = new PdfReader(byteArrayInputStream);
        } catch (OutOfMemoryError ex) {
            System.out.println(ex);
            return null;
        }
        document.open();
        PdfImportedPage page = writer.getImportedPage(reader, 1);
        Image image = Image.getInstance(page);
        image.scaleToFit(document.getPageSize());
        document.add(image);
        document.close();
        byte[] output = byteArrayOutputStream.toByteArray();
        byteArrayInputStream.close();
        byteArrayOutputStream.close();
        return output;
    }

    private byte[] getFirstJPGPage(byte[] input) throws IOException {
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(input);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PDDocument document = PDDocument.load(byteArrayInputStream);
        PDFRenderer pdfRenderer = new PDFRenderer(document);
        BufferedImage bufferedImage = pdfRenderer.renderImage(0, 0.7F);
        ImageIO.write(bufferedImage, "jpg", byteArrayOutputStream);
        document.close();
        byte[] output = byteArrayOutputStream.toByteArray();
        byteArrayInputStream.close();
        byteArrayOutputStream.close();
        return output;
    }

    public byte[] getFirstPage(byte[] input)throws IOException, DocumentException{
        return getFirstJPGPage(getFirstPdfPage(input));
    }


}
