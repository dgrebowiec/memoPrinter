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

import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.edit.PDPageContentStream;
import pl.org.mgalezewska.memo.bo.MemoBO;
import pl.org.mgalezewska.memo.utils.TextUtils;

import java.io.IOException;
import java.util.List;

/**
 * @author Małgorzata Gałężewska <mgalezewska@opi.org.pl>
 */
public class BackTable extends Table {

    public BackTable(PDPage page, PDPageContentStream contentStream, int rows, int cols) {
        super(page, contentStream, rows, cols);
    }

    @Override
    void drawContent(List<MemoBO> content) throws IOException {

        float translationX = colWidth * 3;
        float translationY = y - (rowHeight/2) - 10;
        float kanjiX = colWidth * 3;
        float kanjiY = y - 35;

        int cell = cols;
        for (MemoBO memo : content) {
            drawTranslation(memo, translationX, translationY);
            drawKanji(memo, kanjiX, kanjiY);

            --cell;
            if (cell != 0) {
                translationX -= colWidth;
                kanjiX -= colWidth;
            } else {
                translationY -= rowHeight;
                translationX = colWidth * 3;
                kanjiY -= rowHeight;
                kanjiX = colWidth * 3;
                cell = 3;
            }
        }
    }

    private void drawTranslation(MemoBO memo, float x, float y) throws IOException {
        float stringWidth = TextUtils.getWidthInPixels(memo.getWordPl());
        x -= (colWidth /2) + (stringWidth / 2);
        contentStream.beginText();
        contentStream.moveTextPositionByAmount(x, y);
        contentStream.drawString(memo.getWordPl());
        contentStream.endText();
    }

    private void drawKanji(MemoBO memo, float x, float y) throws IOException {
        float stringWidth = TextUtils.getWidthInPixels(memo.getWordPl());
        x -= stringWidth + 15;
        contentStream.beginText();
        contentStream.moveTextPositionByAmount(x, y);
        contentStream.drawString(memo.getWordPl());
        contentStream.endText();
    }
}
