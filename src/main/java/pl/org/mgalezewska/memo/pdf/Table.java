package pl.org.mgalezewska.memo.pdf;

import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.edit.PDPageContentStream;
import pl.org.mgalezewska.memo.bo.MemoBO;

import java.io.IOException;
import java.util.List;

/**
 * User: mgalezewska
 * Date: 2015-01-24
 */
public abstract class Table {

    protected int rows;

    protected int cols;

    protected float margin = 0f;

    protected float y = 800f;

    protected float cellMargin = 15f;

    protected float height;

    protected float width;

    protected float rowHeight = 150f;

    protected float colWidth;

    protected PDPageContentStream contentStream;

    public Table(PDPage page, PDPageContentStream contentStream, int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
        this.contentStream = contentStream;

        width = page.findMediaBox().getWidth() - margin - margin;
        height = rowHeight * rows;
        colWidth = width/(float)cols;
    }

    public void drawTable(List<MemoBO> content) throws IOException {
        drawLines();
        drawContent(content);
    }

    private void drawLines() throws IOException {
        drawRows();
        drawCols();
    }

    private void drawRows() throws IOException {
        float nexty = y ;
        for (int i = 0; i <= rows; i++) {
            contentStream.drawLine(margin, nexty, margin+width, nexty);
            nexty-= rowHeight;
        }
    }

    private void drawCols() throws IOException {
        float nextx = margin;
        for (int i = 0; i <= cols; i++) {
            contentStream.drawLine(nextx, y, nextx, y-height);
            nextx += colWidth;
        }
    }

    abstract void drawContent(List<MemoBO> content) throws IOException;
}
