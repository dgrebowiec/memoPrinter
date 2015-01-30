/*
 * To oprogramowanie jest własnością
 *
 * OPI - Ośrodek Przetwarzania Informacji,
 * Al. Niepodległości 188B, 00-608 Warszawa
 * Numer KRS: 0000127372
 * Sąd Rejonowy dla m. st. Warszawy w Warszawie XII Wydział
 * Gospodarczy KRS
 * REGON: 006746090
 * NIP: 525-000-91-40
 * Wszystkie prawa zastrzeżone. To oprogramowanie może być używane tylko
 * zgodnie z przeznaczeniem. OPI nie odpowiada za ewentualne wadliwe
 * działanie kodu.
 */
package pl.org.mgalezewska.memo.pdf;

import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import pl.org.mgalezewska.memo.bo.MemoBO;

import java.io.IOException;
import java.util.List;

/**
 * @author Małgorzata Gałężewska <mgalezewska@opi.org.pl>
 */
public class MemoBackTable implements Table {

    @Override
    public PdfPTable generateTable(List<MemoBO> memos) throws IOException, DocumentException {
        PdfPTable table = new PdfPTable(3);
        table.setWidthPercentage(100f);

        for (MemoBO memo : memos) {
            PdfPTable nested = generateNestedTable(memo);
            table.addCell(nested);
        }
        table.completeRow();
        return table;
    }

    private PdfPTable generateNestedTable(MemoBO memo) throws IOException, DocumentException {
        PdfPTable table = new PdfPTable(1);
        table.setWidthPercentage(100f);

        BaseFont baseFont = BaseFont.createFont("HeiseiKakuGo-W5", "UniJIS-UCS2-H", BaseFont.EMBEDDED);
        Font font = new Font(baseFont, 14);
        PdfPCell cell = new PdfPCell(new Phrase(memo.getKanji(), font));
        cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
        cell.setVerticalAlignment(Element.ALIGN_RIGHT);
        cell.setBorder(PdfPCell.NO_BORDER);
        cell.setFixedHeight(40f);

        PdfPCell cell2 = new PdfPCell(new Phrase(memo.getWordJap()));
        cell2.setHorizontalAlignment(Element.ALIGN_CENTER);
        cell2.setVerticalAlignment(Element.ALIGN_TOP);
        cell2.setBorder(PdfPCell.NO_BORDER);
        cell2.setFixedHeight(60f);

        table.addCell(cell);
        table.addCell(cell2);
        return table;
    }
}
