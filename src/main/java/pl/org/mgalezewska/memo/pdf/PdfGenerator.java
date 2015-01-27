package pl.org.mgalezewska.memo.pdf;

import com.google.common.collect.Lists;
import org.apache.pdfbox.exceptions.COSVisitorException;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.edit.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import pl.org.mgalezewska.memo.bo.MemoBO;

import java.io.IOException;
import java.util.List;

/**
 * User: mgalezewska
 * Date: 2015-01-24
 */
public class PdfGenerator {

    public void generateFrontPdf(List<List<MemoBO>> memosList) throws IOException, COSVisitorException {

        PDDocument document = new PDDocument();
        for (List<MemoBO> memos : memosList) {
            PDPage page = new PDPage();
            document.addPage(page);

            PDPageContentStream contentStream = new PDPageContentStream(document, page);
            contentStream.setFont(PDType1Font.HELVETICA_BOLD, 16);
            Table frontTable = new FrontTable(page, contentStream, 5, 3);
            frontTable.drawTable(memos);
            contentStream.close();
        }
        document.save("front.pdf");
    }

    public void generateBackPdf(List<List<MemoBO>> memosList) throws IOException, COSVisitorException {

        PDDocument document = new PDDocument();
        for (List<MemoBO> memos : memosList) {
            PDPage page2 = new PDPage();
            document.addPage(page2);

            PDPageContentStream contentStream2 = new PDPageContentStream(document, page2);
            contentStream2.setFont(PDType1Font.HELVETICA_BOLD, 16);
            Table backTable = new BackTable(page2, contentStream2, 5, 3);
            backTable.drawTable(memos);
            contentStream2.close();
        }
        document.save("back.pdf");
    }
}
