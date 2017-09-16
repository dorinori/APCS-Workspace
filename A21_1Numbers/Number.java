import java.util.*;


/**
 * Represents a number with a given base. The purpose of this class is to allow
 * flexibility in the base value. It represents the abstraction of any number.
 * To use this class, create an instance of it in another class.
 * 
 * @author Matt Zhou
 * @version 4/3/17
 * 
 * @author Period - 5
 * @author Assignment - A21_1Numbers
 * 
 * @author Sources - None
 */
public class Number
{
    LinkedList<Digit> list;
    int base;

    public Number()
    {
        list = new LinkedList<Digit>();
        list.add( new Digit( 0, 10 ) );
        this.base = 10;
    }
 
 
    public Number( int myValue, int myBase )
    {
        list = new LinkedList<Digit>();
        base = myBase;
        int r = 1000000000;
        while ( myValue > 0 )
        {
            r = myValue % base;
            myValue /= base;
            list.add( 0, new Digit( r, base ) );
        }
    }
 
 
    public String toString()
    {
        String temp = "";
        for ( Digit d : list )
            temp += d.toString();
        return temp;
    }
 
 
    public void increment()
    {
        for ( int i = list.size() - 1; i >= 0; i-- )
            if ( list.get( i ).increment() == false )
                return;
        list.add( 0, new Digit( 1, base ) );
    }
}
