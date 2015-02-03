package pl.org.mgalezewska.memo.pdf;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.PdfPTable;

import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * User: mgalezewska
 * Date: 2015-02-03
 */
public interface PdfGenerator {

    public PdfPTable generateFrontPdf() throws IOException, DocumentException;

    public PdfPTable generateBackPdf() throws IOException, DocumentException;

}
