
// This applet displays alternating messages

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class BannerAd extends JApplet implements ActionListener
{
    private int xPos, yPos; // hold the coordinates of the banner

    private int msgID = 1;


    public void init()
    {
        Container c = getContentPane();
        c.setBackground( Color.WHITE );
        xPos = c.getWidth();
        yPos = c.getHeight() / 2;
        Timer clock = new Timer( 2000, this ); // fires every 2 seconds
        clock.start();
    }


    // Called automatically after a repaint request
    public void paint( Graphics g )
    {
        super.paint( g );
        if ( msgID == 1 )
        {
            g.setColor( Color.BLUE );
            g.drawString( "East or West", xPos, yPos );
        }
        else if ( msgID == -1 )
        {
            g.setColor( Color.BLUE );
            g.drawString( "Java is Best", xPos, yPos );
        }
    }


    // Called automatically when the timer fires
    public void actionPerformed( ActionEvent e )
    {
        msgID = -msgID;

        repaint();
    }
}


