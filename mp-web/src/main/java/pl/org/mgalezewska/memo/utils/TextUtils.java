package pl.org.mgalezewska.memo.utils;

import java.awt.*;
import java.awt.geom.Rectangle2D;

/**
 * User: mgalezewska
 * Date: 2015-01-25
 */
public class TextUtils {

    public static float getWidthInPixels(String text) {
        Font font = new Font("Helvetica", Font.BOLD, 16);
        FontMetrics metrics = new FontMetrics(font) {};
        Rectangle2D bounds = metrics.getStringBounds(text, null);
        return (float)bounds.getWidth();
    }

    public static float getHeightInPixels(String text) {
        Font font = new Font("Helvetica", Font.BOLD, 16);
        FontMetrics metrics = new FontMetrics(font) {};
        Rectangle2D bounds = metrics.getStringBounds(text, null);
        return (float)bounds.getHeight();
    }
}
