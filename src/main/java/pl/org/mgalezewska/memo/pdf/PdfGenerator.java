package pl.org.mgalezewska.memo.pdf;

import com.itextpdf.text.DocumentException;

import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * User: mgalezewska
 * Date: 2015-02-03
 */
public interface PdfGenerator {

    public void generateFrontPdf() throws IOException, DocumentException;

    public void generateBackPdf() throws IOException, DocumentException;

}
