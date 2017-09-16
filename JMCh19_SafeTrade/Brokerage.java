import java.lang.reflect.*;
import java.util.*;


/**
 * Represents a brokerage. This represents a brokerage in the stock market. Call
 * its methods to use it. Documentation is provided, it is very useful when
 * trying to use this class. In order to use this class, instantiate it first.
 * Have at it.
 *
 * @author Matt Zhou
 * @version Mar 23, 2017
 * @author Period: 5
 * @author Assignment: JMCh19_SafeTrade
 *
 * @author Sources: Preethi, Surya
 */
public class Brokerage implements Login
{
    private Map<String, Trader> traders;

    private Set<Trader> loggedTraders;

    private StockExchange exchange;


    /**
     * Constructs new brokerage affiliated with a given stock exchange.
     * Initializes the map of traders to an empty map (a TreeMap), keyed by
     * trader's name; initializes the set of active (logged-in) traders to an
     * empty set (a TreeSet).
     * 
     * @param exchange
     *            the exchange
     */
    public Brokerage( StockExchange exchange )
    {
        traders = new TreeMap<String, Trader>();
        loggedTraders = new TreeSet<Trader>();
        this.exchange = exchange;
    }


    /**
     * Constructs new brokerage affiliated with a given stock exchange.
     * Initializes the map of traders to an empty map (a TreeMap), keyed by
     * trader's name; initializes the set of active (logged-in) traders to an
     * empty set (a TreeSet).
     * 
     * @param name
     *            the name
     * @param password
     *            the password
     * @return0 if successful, or an error code (a negative integer) if failed:
     *          -1 -- invalid screen name (must be 4-10 chars) -2 -- invalid
     *          password (must be 2-10 chars) -3 -- the screen name is already
     *          taken.
     */
    public int addUser( String name, String password )
    {
        if ( name.length() < 4 || name.length() > 10 )
            return -1;
        if ( password.length() < 2 || password.length() > 10 )
            return -2;
        if ( traders.containsKey( name ) )
            return -3;

        Trader t = new Trader( this, name, password );
        traders.put( name, t );
        return 0;
    }


    /**
     * Tries to login a trader with a given screen name and password. If no
     * messages are waiting for the trader, sends a "Welcome to SafeTrade!"
     * message to the trader. Opens a dialog window for the trader by calling
     * trader's openWindow() method. Adds the trader to the set of all logged-in
     * traders.
     * 
     * @param name
     *            - the name
     * @param password
     *            - the password
     * @return 0 if successful, or an error code (a negative integer) if failed:
     *         -1 -- screen name not found -2 -- invalid password -3 -- user is
     *         already logged in.
     * 
     */
    public int login( String name, String password )
    {
        Trader t = traders.get( name );

        if ( !traders.containsKey( name ) )
            return -1;
        if ( !t.getPassword().equals( password ) )
            return -2;
        if ( loggedTraders.contains( t ) )
            return -3;

        t.receiveMessage( "Welcome to SafeTrade!" );
        t.openWindow();
        loggedTraders.add( t );

        return 0;
    }


    /**
     * Removes a specified trader from the set of logged-in traders.
     * 
     * @param trader
     *            the trader
     */
    public void logout( Trader trader )
    {
        loggedTraders.remove( trader );
    }


    /**
     * Requests a quote for a given stock from the stock exachange and passes it
     * along to the trader by calling trader's receiveMessage method.
     * 
     * @param symbol
     *            the stock symbol
     * @param trader
     *            the trader that requested the quote
     */
    public void getQuote( String symbol, Trader trader )
    {
        trader.receiveMessage( exchange.getQuote( symbol ) );
    }


    /**
     * Places an order at the stock exchange.
     * 
     * @param order
     *            - the TradeOrder order
     */
    public void placeOrder( TradeOrder order )
    {
        if ( order == null )
            return;

        exchange.placeOrder( order );
    }


    //
    // The following are for test purposes only
    //
    protected Map<String, Trader> getTraders()
    {
        return traders;
    }


    protected Set<Trader> getLoggedTraders()
    {
        return loggedTraders;
    }


    protected StockExchange getExchange()
    {
        return exchange;
    }


    /**
     * <p>
     * A generic toString implementation that uses reflection to print names and
     * values of all fields <em>declared in this class</em>. Note that
     * superclass fields are left out of this implementation.
     * </p>
     * 
     * @return a string representation of this Brokerage.
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
