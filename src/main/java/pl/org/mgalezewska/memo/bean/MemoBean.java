package pl.org.mgalezewska.memo.bean;

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

    public void upload() throws IOException {
        if(file != null) {
            FacesMessage message = new FacesMessage("Succesful", file.getFileName() + " is uploaded.");
            FacesContext.getCurrentInstance().addMessage(null, message);

            fileManager.saveFile(file);

        }
    }

    public List<MemoBO> readRecords() {
        CSVReader reader = new CSVReader();
        return reader.read(fileManager.getPath());
    }


    public UploadedFile getFile() {
        return file;
    }

    public void setFile(UploadedFile file) {
        this.file = file;
    }
}
