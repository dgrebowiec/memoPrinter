package pl.org.mgalezewska.memo.bean;

import com.google.common.collect.Lists;
import org.apache.commons.csv.CSVRecord;
import org.apache.pdfbox.exceptions.COSVisitorException;
import org.primefaces.model.StreamedContent;
import org.primefaces.model.UploadedFile;
import pl.org.mgalezewska.memo.bo.MemoBO;
import pl.org.mgalezewska.memo.commons.FileManager;
import pl.org.mgalezewska.memo.csv.CSVReader;
import pl.org.mgalezewska.memo.pdf.PdfGenerator;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import java.io.IOException;
import java.util.Collections;
import java.util.List;

/**
 * User: mgalezewska
 * Date: 2015-01-15
 */
@ManagedBean
@SessionScoped
public class MemoBean {

    private UploadedFile file;

    private FileManager fileManager = new FileManager();

    private List<MemoBO> memos = Lists.newArrayList();

    public void upload() throws IOException, COSVisitorException {
        if(file != null) {
            FacesMessage message = new FacesMessage("Succesful", file.getFileName() + " is uploaded.");
            FacesContext.getCurrentInstance().addMessage(null, message);

            fileManager.saveFile(file);
            readRecords();
            generateFrontPdf();
            generateBackPdf();
        }
    }

    public void generateFrontPdf() throws IOException, COSVisitorException {
        PdfGenerator generator = new PdfGenerator();
        List<List<MemoBO>> pages = getPages(15);
        generator.generateFrontPdf(pages);
    }

    public void generateBackPdf() throws IOException, COSVisitorException {
        PdfGenerator generator = new PdfGenerator();
        List<List<MemoBO>> pages = getPages(15);
        generator.generateBackPdf(pages);
    }

    public List<MemoBO> getTransations() {
        List<MemoBO> reverses = Lists.newArrayList();
        reverses.addAll(memos);
        Collections.reverse(reverses);
        return reverses;
    }

    private void readRecords() {
        CSVReader reader = new CSVReader();
        memos = reader.read(fileManager.getPath());
    }

    private List<List<MemoBO>> getPages(int size) {
        List pages = Lists.newArrayList();
        final int count = memos.size();
        for (int i = 0; i < count; i += size) {
            pages.add(memos.subList(i, Math.min(count, i + size)));
        }
        return pages;
    }

    public UploadedFile getFile() {
        return file;
    }

    public void setFile(UploadedFile file) {
        this.file = file;
    }

    public List<MemoBO> getMemos() {
        return memos;
    }

    public void setMemos(List<MemoBO> memos) {
        this.memos = memos;
    }

}
