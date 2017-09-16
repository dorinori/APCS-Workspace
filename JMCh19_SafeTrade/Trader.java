import java.lang.reflect.*;
import java.util.*;


/**
 * Represents a stock trader. This represents a stock trader in the stock
 * market. Call its methods to use it. Documentation is provided, it is very
 * useful when trying to use this class. In order to use this class, instantiate
 * it first. Have at it.
 *
 * @author Matt Zhou
 * @version Mar 23, 2017
 * @author Period: 5
 * @author Assignment: JMCh19_SafeTrade
 *
 * @author Sources: Preethi, Surya
 */
public class Trader implements Comparable<Trader>
{
    private Brokerage brokerage;

    private String screenName, password;

    private TraderWindow myWindow;

    private Queue<String> mailbox;


    /**
     * Constructs a new trader, affiliated with a given brockerage, with a given
     * screen name and password.
     * 
     * @param brokerage
     *            the brokerage for this trader.
     * @param name
     *            user name
     * @param pswrd
     *            password
     */
    public Trader( Brokerage brokerage, String name, String pswrd )
    {
        this.brokerage = brokerage;
        screenName = name;
        password = pswrd;
        mailbox = new LinkedList<String>();
    }


    /**
     * Returns name.
     * 
     * @return screenName the screen name
     */
    public String getName()
    {
        return screenName;
    }


    /**
     * Returns password
     * 
     * @return password the password
     */
    public String getPassword()
    {
        return password;
    }


    /**
     * Compares this trader to another by comparing their screen names case
     * blind.
     * 
     * @param other
     *            the other trader
     * @return the result of the comparison of this trader and other.
     */
    public int compareTo( Trader other )
    {
        return screenName.compareToIgnoreCase( other.getName() );
    }


    /**
     * Checks for equality.
     * 
     * @param other
     * @return screenName.equalsIgnoreCase( other.getName() )
     */
    public boolean equals( Trader other )
    {
        return screenName.equalsIgnoreCase( other.getName() );
    }


    /**
     * Opens a window.
     */
    public void openWindow()
    {
        myWindow = new TraderWindow( this );

        while ( mailbox.peek() != null )
            myWindow.showMessage( mailbox.remove() );
    }


    /**
     * Checks to see if there's messages.
     * 
     * @return mailbox.peek() != null
     */
    public boolean hasMessages()
    {
        return mailbox.peek() != null;
    }


    /**
     * Receives messages.
     * 
     * @param msg
     */
    public void receiveMessage( String msg )
    {
        mailbox.add( msg );
        if ( myWindow != null )
            while ( mailbox.peek() != null )
                myWindow.showMessage( mailbox.remove() );
    }


    /**
     * Receives a quote.
     * 
     * @param symbol
     */
    public void getQuote( String symbol )
    {
        brokerage.getQuote( symbol, this );
    }


    /**
     * Places an order.
     * 
     * @param order
     */
    public void placeOrder( TradeOrder order )
    {
        brokerage.placeOrder( order );
    }


    /**
     * Quits this trader.
     */
    public void quit()
    {
        brokerage.logout( this );
        myWindow = null;
    }


    //
    // The following are for test purposes only
    //
    protected Queue<String> mailbox()
    {
        return mailbox;
    }


    /**
     * <p>
     * A generic toString implementation that uses reflection to print names and
     * values of all fields <em>declared in this class</em>. Note that
     * superclass fields are left out of this implementation.
     * </p>
     * 
     * @return a string representation of this Trader.
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
                if ( field.getType().getName().equals( "Brokerage" ) )
                    str += separator + field.getType().getName() + " " + field.getName();
                else
                    str += separator + field.getType().getName() + " " + field.getName() + ":" + field.get( this );
            }
            catch ( IllegalAccessException ex )
            {
                System.out.println( ex );
            }

            separator = ", ";
        }

        return str + "]";
    }
}
