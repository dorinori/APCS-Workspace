import java.awt.*;
import javax.swing.*;


/**
 * This writes an optical illusion. Just call drawIllusion to draw the illusion.
 * It's a bunch of boxes that make the lines that are parallel look not
 * parallel.
 * 
 * @author Matt Zhou
 * @version 9/22/16
 * 
 *          Period - 5 - A12.6 - ParallelLines
 * 
 *          Sources - none
 */
public class ParallelLines extends JPanel
{
    private final static int OFFSET_LENGTH = 10;

    private final static int SIDE_LENGTH = 40;

    private final static int X_START = 15;

    private final static int Y_START = 10;


    /**
     * This just paints the screen, gets the width and height.
     * 
     * @param g Passes in a graphics object.
     */
    public void paintComponent( Graphics g )
    {
        super.paintComponent( g ); // Call JPanel's paintComponent method
                                   // to paint the background

        int width = getWidth();
        int height = getHeight();

        drawIllusion( g, width, height );
    }


    /**
     * This draws the illusion. It creates row by row squares with side length
     * SIDE_LENGTH, and offsets them in a pattern that repeats every four
     * blocks. At the end, it draws a line underneath the boxes.
     * 
     * @param g Passes in a graphics object.
     * @param width This is the width of the screen.
     * @param height This is the height of the screen.
     */
    public void drawIllusion( Graphics g, int width, int height )
    {
        for ( int row = 0; row < 8; row++ )
        {
            int x = X_START;

            if ( row % 4 == 2 )
            {
                x = X_START + 2 * OFFSET_LENGTH;
            }
            else if ( row % 4 == 1 || row % 4 == 3 )
            {
                x = X_START + OFFSET_LENGTH;
            }
            else
            {
                x = X_START;
            }

            for ( int col = 0; col < 7; col++ )
            {
                g.fillRect( x + 2 * col * SIDE_LENGTH, Y_START + 
                    row * SIDE_LENGTH, SIDE_LENGTH, SIDE_LENGTH );
            }

            g.drawLine( X_START, row * SIDE_LENGTH + 50, width - 65, 
                row * SIDE_LENGTH + 50 );
        }

    }


    /**
     * Draw the parallel lines.
     * 
     * @param args
     *            command-line arguments (not used)
     */
    public static void main( String[] args )
    {
        JFrame w = new JFrame( "ParallelLines" );
        w.setBounds( 100, 100, 640, 480 );
        w.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        ParallelLines panel = new ParallelLines();
        panel.setBackground( Color.WHITE );
        Container c = w.getContentPane();
        c.add( panel );
        w.setResizable( true );
        w.setVisible( true );
    }
}
