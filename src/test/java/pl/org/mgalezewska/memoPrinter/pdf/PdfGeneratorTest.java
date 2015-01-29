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
package pl.org.mgalezewska.memoPrinter.pdf;

import com.google.common.collect.Lists;
import org.apache.pdfbox.exceptions.COSVisitorException;
import org.junit.Test;
import pl.org.mgalezewska.memo.bo.MemoBO;
import pl.org.mgalezewska.memo.pdf.PdfGenerator;

import java.io.IOException;
import java.util.List;

/**
 * @author Małgorzata Gałężewska <mgalezewska@opi.org.pl>
 */
public class PdfGeneratorTest {

    @Test
    public void generatePdfTest() throws IOException, COSVisitorException {
        List<List<MemoBO>> memos = Lists.newArrayList();
        List<MemoBO> memoBOs = Lists.newArrayList();
        List<MemoBO> memoBOs2 = Lists.newArrayList();
        MemoBO memoBO = new MemoBO();
        memoBO.setWordPl("test1");
        memoBO.setWordJap("neko1");

        MemoBO memoBO2 = new MemoBO();
        memoBO2.setWordPl("dlugi test2");
        memoBO2.setWordJap("neko2");

        MemoBO memoBO3 = new MemoBO();
        memoBO3.setWordPl("test3");
        memoBO3.setWordJap("neko3");
        memoBO3.setKanji("無言");

        MemoBO memoBO4 = new MemoBO();
        memoBO4.setWordPl("test4");
        memoBO4.setWordJap("neko4");

        memoBOs.add(memoBO);
        memoBOs.add(memoBO2);
        memoBOs.add(memoBO3);
        memoBOs.add(memoBO4);
        memoBOs2.add(memoBO);
        memos.add(memoBOs);
        //memos.add(memoBOs2);

        PdfGenerator generator = new PdfGenerator();
        generator.generateFrontPdf(memos);
        generator.generateBackPdf(memos);
    }
}
