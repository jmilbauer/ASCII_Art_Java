import java.awt.Color;
import java.awt.FileDialog;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;

/**Created as an exension of Picture.java to allow for 2D arrays of integers.
 * @author Jeremiah Milbauer
 */
public class PPicture extends Picture
{
    int[][] pixels;

    public PPicture(String filename)
    {
        super(filename);
        pixels = new int[this.height()][this.width()];
        for (int r = 0; r < this.height(); r++)
        {
            for (int c = 0; c < this.width(); c++)
            {
                int avgcolor = (this.get(c,r).getRed() + this.get(c,r).getGreen() + this.get(c,r).getBlue())  / 3;
                pixels[r][c] = avgcolor;
            }
        }
    }

    //note that the first [] is for x coord, next [] is for y coord
    public int[][] getPixels() 
    {
        return pixels;
    }
}
