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

    public void generatePdf(List<List<MemoBO>> memosList) throws IOException, COSVisitorException {

        PDDocument document = new PDDocument();

        for (List<MemoBO> memos : memosList) {
            PDPage page = new PDPage();
            document.addPage(page);

            PDPageContentStream contentStream = new PDPageContentStream(document, page);
            contentStream.setFont( PDType1Font.HELVETICA_BOLD, 12 );

            Table table = new FrontTable(page, contentStream, 10, 3);
            table.drawTable(memos);
            contentStream.close();

        }
        document.save("test.pdf");
    }

    public static void main(String... args) throws IOException, COSVisitorException {
        List<List<MemoBO>> memos = Lists.newArrayList();
        List<MemoBO> memoBOs = Lists.newArrayList();
        List<MemoBO> memoBOs2 = Lists.newArrayList();
        MemoBO memoBO = new MemoBO();
        memoBO.setWordPl("test");

        MemoBO memoBO2 = new MemoBO();
        memoBO2.setWordPl("dlugi test");

        MemoBO memoBO3 = new MemoBO();
        memoBO3.setWordPl("test");

        memoBOs.add(memoBO);
        memoBOs.add(memoBO2);
        memoBOs.add(memoBO3);
        memoBOs2.add(memoBO);
        memos.add(memoBOs);
        //memos.add(memoBOs2);

        PdfGenerator generator = new PdfGenerator();
        generator.generatePdf(memos);
    }
}
