import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.applet.AudioClip;

/**
   This is a fortune teller abstraction.
   Every time you press the button, it randomly generates a fortune.

   @author  Matt Zhou
   @version 10/24/16

   @author  Period - 5
   @author  Assignment - Lab 12.3: Fortune Teller

   @author  Sources - none
 */
public class FortuneTeller extends JApplet implements ActionListener
{

    private String[] fortuneArray = { 
        "Today it's up to you to create the peacefulness you long for.",
        "A friend asks only for your time not your money.",
        "If you refuse to accept anything but the best,you very often get it.",
        "A smile is your passport into the hearts of others.",
        "A good way to keep healthy is to eat more Chinese food.", 
        "Your high-minded principles spell success.",
        "Hard work pays off in the future, laziness pays off now.",
        "Change can hurt, but it leads a path to something better.", 
        "Enjoy the good luck a companion brings you.",
        "People are naturally attracted to you." };

    private JTextField display;
    private AudioClip ding;

    public void init()
    {
        ding = getAudioClip(getDocumentBase(), "ding.wav");

        display = new JTextField("  Press \"Next\" to see your fortune...", 30);
        display.setBackground(Color.WHITE);
        display.setEditable(false);

        JButton go = new JButton("Next");
        go.addActionListener(this);

        Container c = getContentPane();
        c.setLayout(new FlowLayout());
        c.add(display);
        c.add(go);
    }

    public void actionPerformed(ActionEvent e)
    {
        ding.play();
        
        int randomFortune = (int)(Math.random()*fortuneArray.length);
        
        display.setText("  " + fortuneArray[randomFortune] );
    }
}

