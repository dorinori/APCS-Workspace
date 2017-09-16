/**
 * A checker is an object that examines strings and accepts those strings that
 * meet a particular criterion.
 *
 * @author Matt Zhou
 * @version Oct 13, 2014
 * @author Period: 1-7
 * @author Assignment: A11_3Checker
 *
 * @author Sources: none
 */

public class AndChecker implements Checker
{
    private Checker checker1;

    private Checker checker2;


    /**
     * @param a
     *            a Checker
     * @param b
     *            another Checker
     */
    public AndChecker( Checker a, Checker b )
    {
        checker1 = a;
        checker2 = b;
    }

    /**
     * @param text
     *            a string to consider for acceptance
     * @return true if this Checker accepts text; false otherwise
     */
    public boolean accept( String text )
    {
        if ( checker1.accept( text ) == checker2.accept( text ) )
        {
            if ( checker1.accept( text ) )
            {
                return true;
            }
        }
        return false;
    }
}
