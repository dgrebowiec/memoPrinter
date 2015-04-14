package pl.org.mgalezewska.memo.csv;

import com.google.common.collect.Lists;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import pl.org.mgalezewska.memo.bo.MemoBO;

import java.io.*;
import java.util.List;

/**
 * User: mgalezewska
 * Date: 2015-01-17
 */
public class CSVReader {

    private static final String[] HEADERS = {"word_pl", "word_jap", "kanji"};

    private static final String word_pl = "word_pl";
    private static final String word_jap = "word_jap";
    private static final String kanji = "kanji";

    public List<MemoBO> read(String filePath) {

        InputStreamReader reader = null;
        CSVParser csvParser = null;
        CSVFormat csvFormat = CSVFormat.DEFAULT.withHeader(HEADERS);

        try {
            reader = new InputStreamReader(new FileInputStream(filePath), "UTF-8");
            csvParser = new CSVParser(reader, csvFormat);

            return transferMemo(csvParser.getRecords());

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                reader.close();
                csvParser.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return null;
    }

    private List<MemoBO> transferMemo(List<CSVRecord> records) {
        List<MemoBO> memos = Lists.newArrayList();
        for (CSVRecord record : records) {
            MemoBO memoBO = new MemoBO();
            memoBO.setWordPl(record.get(word_pl));
            memoBO.setWordJap(record.get(word_jap));
            memoBO.setKanji(record.get(kanji));
            memos.add(memoBO);
        }

        return memos;
    }
}
