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

import com.itextpdf.text.Element;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import pl.org.mgalezewska.memo.bo.MemoBO;

import java.util.List;

/**
 * @author Małgorzata Gałężewska <mgalezewska@opi.org.pl>
 */
public class MemoFrontTable implements Table {

    @Override
    public PdfPTable generateTable(List<MemoBO> memos) {
        PdfPTable table = new PdfPTable(3);
        table.setWidthPercentage(100f);

        for (MemoBO memo : memos) {
            PdfPTable nested = generateNestedTable(memo);
            table.addCell(nested);
        }
        table.completeRow();
        return table;
    }

    private PdfPTable generateNestedTable(MemoBO memo) {
        PdfPTable table = new PdfPTable(1);
        table.setWidthPercentage(100f);

        PdfPCell cell = new PdfPCell(new Phrase(memo.getWordPl()));
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
        cell.setBorder(PdfPCell.NO_BORDER);
        cell.setFixedHeight(100f);

        table.addCell(cell);
        return table;
    }

}
