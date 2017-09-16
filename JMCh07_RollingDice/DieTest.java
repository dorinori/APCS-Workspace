/**
 * Tests the die.
 *
 * @author Matt Zhou
 * @version 9/13/16
 * @author Period: 5
 * @author Assignment: JMCh07_RollingDice
 *
 * @author Sources: none
 */
public class DieTest
{
    /**
     * Tests the die.
     * 
     * @param args
     *            command-line arguments (not used)
     */
    public static void main( String[] args )
    {
        // int[] counterArray = {0,0,0,0,0,0};
        // int numDots;
        // String text = "";
        //
        // Die die = new Die();
        //
        // for (int i = 0; i < 999999999; i ++){
        // text = "";
        // die.roll();
        // counterArray[(die.getNumDots()-1)]++;
        //
        // for (int c = 0; c < counterArray.length; c ++){
        // text += counterArray[c] + "\t";
        // }
        //
        // System.out.println( text );
        // }

        Die die = new Die();
        die.roll();
        System.out.println( die.getNumDots() );
        die.roll();
        System.out.println( die.getNumDots() );
    }
}
