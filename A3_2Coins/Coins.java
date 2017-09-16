import java.lang.reflect.Field;
import java.util.Scanner;


/**
 * Coins: This class accepts a certain amount of monetary change (in cents). The
 * output is a list of the number of quarters, dimes, nickels, and pennies that
 * will make that amount of change with the least number of coins possible.
 *
 * @author Matt Zhou
 * @version 9/1/16
 * @author Period: 5
 * 
 * @author Assignment: Lab Activity 3.2 - Coins
 * 
 * @author Sources: none
 */
public class Coins
{
    private int myChange;

    private int[][] values = new int[][] { 
        { 0, 0, 0, 0 }, 
        { 25, 10, 5, 1 } };

    private String[] coinNames = new String[] { 
        "Quarter(s) \t", 
        "Dime(s) \t", 
        "Nickel(s) \t", 
        "Penny(s) \t", };


    /**
     * Creates a new <code>Coins</code> instance.
     *
     * @param change
     *            an <code>integer</code> value representing the change
     */
    public Coins( int change )
    {
        myChange = change;
    }


    /**
     * This calculates the change.
     */
    public void calculate()
    {
        for ( int i = 0; i < values[1].length && i < values[0].length; i++ )
        {
            values[0][i] = myChange / values[1][i];
            System.out.println( coinNames[i] + values[0][i] );
            myChange %= values[1][i];
        }
    }


    /**
     * Intended only for debugging.
     * 
     * <p>
     * A generic toString implementation that uses reflection to print names and
     * values of all fields <em>declared in this class</em>. Note that
     * superclass fields are left out of this implementation.
     * </p>
     * 
     * @return a string representation of this Easter.
     */
    public String toString()
    {
        String str = this.getClass().getName() + "[";
        String separator = "";

        Field[] fields = this.getClass().getDeclaredFields();

        for ( Field field : fields )
        {
            try
            {
                str += separator + field.getType().getName() + " " 
                                + field.getName() + ":" + field.get( this );
            }
            catch ( IllegalAccessException ex )
            {
                System.out.println( ex );
            }
            separator = ", ";
        }
        return str + "]";
    }


    /**
     * Tester for the Coins class.
     * 
     * @param args
     *            command line arguments - not used
     */
    public static void main( String[] args )
    {
        Scanner console = new Scanner( System.in );

        System.out.print( "Please enter the number of cents --> " );
        int cents = console.nextInt();

        Coins change = new Coins( cents );
        change.calculate();
    }
}
