package pl.org.mgalezewska.memo.pdf;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;

/**
 * User: mgalezewska
 * Date: 2015-02-03
 */
public class Pdf {

    private Document document;

    public Pdf(String fileName) throws FileNotFoundException, DocumentException {
        this.document = new Document();
        PdfWriter.getInstance(document, new FileOutputStream(fileName));
    }

    public void open() {
        this.document.open();
    }

    public void add(Element element) throws DocumentException {
        this.document.add(element);
    }

    public void close() {
        this.document.close();
    }
}
