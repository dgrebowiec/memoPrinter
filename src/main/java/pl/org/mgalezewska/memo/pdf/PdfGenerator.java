package pl.org.mgalezewska.memo.pdf;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import org.apache.pdfbox.exceptions.COSVisitorException;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.edit.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import pl.org.mgalezewska.memo.bo.MemoBO;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

/**
 * User: mgalezewska
 * Date: 2015-01-24
 */
public class PdfGenerator {

    public void generateFrontPdf(List<MemoBO> memos) throws IOException, DocumentException {
        Document document = new Document();
        PdfWriter.getInstance(document, new FileOutputStream("front.pdf"));
        document.open();

        MemoFrontTable frontTable = new MemoFrontTable();
        PdfPTable table = frontTable.generateTable(memos);
        document.add(table);

        document.close();
    }

    public void generateBackPdf(List<MemoBO> memos) throws IOException, DocumentException {
        Document document = new Document();
        PdfWriter.getInstance(document, new FileOutputStream("back.pdf"));
        document.open();

        MemoBackTable backTable = new MemoBackTable();
        PdfPTable table = backTable.generateTable(memos);
        document.add(table);

        document.close();
    }
}
