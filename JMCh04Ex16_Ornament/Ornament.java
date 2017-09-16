import java.awt.*;
import javax.swing.*;


/**
 * This program draws an ornament of nested triangles
 * 
 * @author Matt Zhou
 * @version 915.16
 * 
 * @author Period - 5
 * @author Assignment - Ch04 Ex4-16 Ornament
 * 
 * @author Sources - none
 */
public class Ornament extends JPanel
{
    /**
     * Paints the component.
     * 
     * @param g
     *            Graphics are passed in.
     */
    public void paintComponent( Graphics g )
    {
        super.paintComponent( g ); // Call JPanel's paintComponent method
                                   // to paint the background
        drawTriangles( g, 200, 150, 64 );
    }


    /**
     * Draws an ornament made of triangles in Graphics g with the base midpoint
     * at (x, y) and base half-length r
     * 
     * @param g
     *            Graphics are passed in.
     * @param x
     *            Base midpoint x value.
     * @param y
     *            Base midpoint y value.
     * @param r
     *            Base half-length value.
     */
    public void drawTriangles( Graphics g, int x, int y, int r )
    {
        if ( r < 4 )
        {
            return;
        }

        g.drawLine( x - r, y, x + r, y );
        g.drawLine( x - r, y, x, y - r );
        g.drawLine( x + r, y, x, y - r );

        drawTriangles( g, x - r / 2, y, r / 2 );
        drawTriangles( g, x + r / 2, y, r / 2 );

    }

    /**
     * The main method in this class checks the Book operations for consistency.
     * 
     * @param args
     *            is not used.
     */
    public static void main( String[] args )
    {
        JFrame w = new JFrame( "Triangles" );
        w.setBounds( 600, 600, 400, 240 );
        w.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        Ornament panel = new Ornament();
        panel.setBackground( Color.WHITE );
        Container c = w.getContentPane();
        c.add( panel );
        w.setResizable( false );
        w.setVisible( true );
    }
}
