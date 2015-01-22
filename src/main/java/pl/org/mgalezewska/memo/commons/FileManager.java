package pl.org.mgalezewska.memo.commons;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.io.IOUtils;
import org.primefaces.model.UploadedFile;

import java.io.*;
import java.nio.file.Files;

/**
 * User: mgalezewska
 * Date: 2015-01-17
 */
public class FileManager {

    private String path;

    public void saveFile(UploadedFile file) {

        String prefix = FilenameUtils.getBaseName(file.getFileName());
        String suffix = FilenameUtils.getExtension(file.getFileName());

        try {
            File save = File.createTempFile(prefix + "-", "." + suffix);
            path = save.getAbsolutePath();
            InputStream input = file.getInputstream();
            FileUtils.copyInputStreamToFile(input, save);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
}
