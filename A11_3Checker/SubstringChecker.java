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

public class SubstringChecker implements Checker
{
    private String text;


    /**
     * @param text
     *            a text to check
     */
    public SubstringChecker( String text )
    {
        this.text = text;
    }


    /**
     * @param str
     *            a string to consider for acceptance
     * @return true if this Checker accepts text; false otherwise
     */
    public boolean accept( String str )
    {
        return str.indexOf( text ) != -1;

    }

}
