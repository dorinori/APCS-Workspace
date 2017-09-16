
// This applet displays alternating messages

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class Banner extends JApplet implements ActionListener
{
    private int xPos, yPos; // hold the coordinates of the banner


    public void init()
    {
        Container c = getContentPane();
        c.setBackground( Color.WHITE );
        xPos = c.getWidth();
        yPos = c.getHeight() / 2;
        Timer clock = new Timer( 30, this ); // fires every 2 seconds
        clock.start();
    }


    // Called automatically after a repaint request
    public void paint( Graphics g )
    {
        super.paint( g );
        g.fillRect( xPos, yPos, 50, 100 );
    }


    // Called automatically when the timer fires
    public void actionPerformed( ActionEvent e )
    {
        Container c = getContentPane();

        xPos--;
        if ( xPos < -100 )
        {
            xPos = c.getWidth();
        }

        yPos = c.getHeight() / 2;
        repaint();
    }
}


