package pl.org.mgalezewska.memo.bean;

import com.google.common.collect.Lists;
import org.apache.commons.csv.CSVRecord;
import org.primefaces.model.UploadedFile;
import pl.org.mgalezewska.memo.bo.MemoBO;
import pl.org.mgalezewska.memo.commons.FileManager;
import pl.org.mgalezewska.memo.csv.CSVReader;

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

    public void upload() throws IOException {
        if(file != null) {
            FacesMessage message = new FacesMessage("Succesful", file.getFileName() + " is uploaded.");
            FacesContext.getCurrentInstance().addMessage(null, message);

            fileManager.saveFile(file);
            readRecords();
        }
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
