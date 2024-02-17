package it.unibo.superpeach.graphics;

import java.awt.Font;
import java.awt.Color;
import java.awt.Component;
import javax.swing.JButton;
import javax.swing.BorderFactory;
import javax.swing.border.Border;

/**
 * Implementation of a customed button.
 * @author  Miriam Sonaglia
 */
public class CustomButton extends JButton {
    /**
     * This method create a button with a text, abackground color and a border.
     * @param text
     * @param customColor
     * @param customColor1
     * @param scale
     */
    public CustomButton(final String text, final Color customColor, final Color customColor1, final int scale) {
        super(text);
        setAlignmentX(Component.CENTER_ALIGNMENT);
        setFont(new Font("Monospaced", Font.BOLD, 10 * scale));
        setForeground(customColor1);
        setBackground(customColor);
        setFocusable(false);
        Border border = BorderFactory.createLineBorder(customColor1, 2, true);
        setBorder(border);
        setBorder(BorderFactory.createCompoundBorder(
                border,
                BorderFactory.createEmptyBorder(10, 10*2, 10, 10*2)
        ));
    }
}
