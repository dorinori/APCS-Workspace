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

public class NotChecker implements Checker
{
    private Checker check;


    /**
     * @param a
     *            a Checker
     */
    public NotChecker( Checker a )
    {
        check = a;
    }


    /**
     * @param text
     *            a string to consider for acceptance
     * @return true if this Checker accepts text; false otherwise
     */
    public boolean accept( String text )
    {
        return !check.accept( text );
    }
}
