package it.unibo.superpeach.graphics;


import java.io.File;
import java.awt.Graphics;
import javax.swing.JPanel;
import java.io.IOException;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;

/**
 * Implementation of a panel with an image on the background.
 * @author  Miriam Sonaglia
 */
public class ImagePanel extends JPanel {
    private BufferedImage backgroundImage;

    /**
     * reads the path of the image, if it doesn't exist it throws an exception.
     * @param imagePath
     */
    public ImagePanel(final String imagePath) {
        try {
            backgroundImage = ImageIO.read(new File(imagePath));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void paintComponent(final Graphics g) {
        super.paintComponent(g);
        if (backgroundImage != null) {
            g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
        }
    }
}
