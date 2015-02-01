package pl.org.mgalezewska.memo.pdf;

import com.google.common.collect.Lists;
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
import java.util.Collections;
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
        List<MemoBO> transformed = transformOrder(memos);
        PdfPTable table = backTable.generateTable(transformed);
        document.add(table);

        document.close();
    }

    private List<MemoBO> transformOrder(List<MemoBO> memos) {

        addEmptyMemo(memos);
        List<MemoBO> reversed = Lists.newArrayList();
        for (int i = 0; i < memos.size(); i += 3) {
            List<MemoBO> sublist = Lists.newArrayList();
            if (i + 3 > memos.size())
                sublist = memos.subList(i, memos.size());
            else
                sublist = memos.subList(i, i + 3);
            Collections.reverse(sublist);
            reversed.addAll(sublist);
        }
        return reversed;
    }

    private void addEmptyMemo(List<MemoBO> memos) {
        if (memos.size() % 3 == 0) return;

        for (int i = 0; i < memos.size() % 3; ++i) {
            memos.add(new MemoBO());
        }
    }
}
