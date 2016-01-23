import java.awt.*;
import java.awt.font.*;
import java.awt.geom.*;
import java.awt.image.BufferedImage;
import java.text.*;
import java.util.*;
import java.util.List;

/**
 * Generates ASCII art!
 * 
 * @author Jeremiah Milbauer
 * @version 1.9.2015
 */
public class Generator
{
    private PPicture pic;
    private int[][] pixels;
    private int picHeight;
    private int picWidth;
    private int patchHeight;
    private int patchWidth;
    private int[][] compressedPic;
    private int bits;
    private int gridHeight;
    private int gridWidth;
    private final int RESOLUTION_FACTOR = 32;


    /**
     * Constructor for objects of class Generator
     */
    public Generator(PPicture p)
    {
        pic = p;
        pixels = pic.getPixels();
        picWidth = pixels.length;
        picHeight = pixels[0].length;
        double ratio = (double)picWidth / (double)picHeight;
        gridHeight = RESOLUTION_FACTOR;
        gridWidth = (int)((RESOLUTION_FACTOR * 2.25) / ratio);
    }

    /* This generates an ASCII String output with 16 different ascii characters.
     * 
     */
    public String toASCIIString(String contrastChars)
    {
        int rows = gridHeight;
        int cols = gridWidth;
        patchHeight = picHeight / cols;
        patchWidth = picWidth / rows;
        compressedPic = new int[rows][cols];
        bits = contrastChars.length();
        String result = "";

        /**Goes through each division decided by the grid of ascii pixels.
         * Works left to right then top down
         * 
         */
        for (int r = 0; r < rows; r++) //each column
        {
            for (int c = 0; c < cols; c++) //each row
            {
                int baseX = r * patchWidth;
                int baseY = c * patchHeight;
                
                int sumColor = 0;
                int scannedSquares = 0;
                
                for (int i = baseX; i < baseX + patchWidth; i++)
                {
                    for (int j = baseY; j < baseY + patchHeight; j++)
                    {
                        sumColor += pixels[i][j];
                        scannedSquares++;
                    }
                }
                int avgColor = sumColor / scannedSquares;
                compressedPic[r][c] = avgColor;
            }
        }
        
        for (int c = 0; c < compressedPic.length; c ++) // this is width
        {
            for (int r = 0; r < compressedPic[c].length; r++)
            {
                result += contrastChars.charAt((int)Math.floor((bits*compressedPic[c][r])/256));
            }
            result += "\n";
        }
     
        return result;
    }
}
