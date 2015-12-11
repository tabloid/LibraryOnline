package GVA.LibraryOnline.Service;


import com.lowagie.text.*;
import com.lowagie.text.pdf.PdfImportedPage;
import com.lowagie.text.pdf.PdfReader;
import com.lowagie.text.pdf.PdfWriter;
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

    private byte[] getPdfPageFromBook(byte[] input) throws IOException, DocumentException {
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
        Rectangle rectangle = document.getPageSize();
        image.scaleToFit(rectangle.getWidth(), rectangle.getHeight());
        document.add(image);
        document.close();
        byte[] output = byteArrayOutputStream.toByteArray();
        byteArrayInputStream.close();
        byteArrayOutputStream.close();
        return output;
    }

    private byte[] getJPGPageFromPdfPage(byte[] input) throws IOException {
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(input);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PDDocument document = PDDocument.load(byteArrayInputStream);
        PDFRenderer pdfRenderer = new PDFRenderer(document);
        BufferedImage bufferedImage = pdfRenderer.renderImage(0, 0.3F);
        ImageIO.write(bufferedImage, "jpg", byteArrayOutputStream);
        document.close();
        byte[] output = byteArrayOutputStream.toByteArray();
        byteArrayInputStream.close();
        byteArrayOutputStream.close();
        return output;
    }

    public byte[] getFirstPage(byte[] input, String extention) throws IOException, DocumentException {
        if (extention.equals("pdf"))
        return getJPGPageFromPdfPage(getPdfPageFromBook(input));
        else return null;
    }


}
