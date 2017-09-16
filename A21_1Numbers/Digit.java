/**
 * Represents a single digit with a given base. The purpose of this class is to
 * assist the Number object. It represents the abstraction of a digit within a
 * number. To use this class, create an instance of it in the Number class.
 * 
 * @author Matt Zhou
 * @version 4/3/17
 * 
 * @author Period - 5
 * @author Assignment - A21_1Numbers
 * 
 * @author Sources - None
 */
public class Digit
{
    int base;
    int value;

    public Digit( int myValue, int myBase )
    {
        value = myValue;
        base = myBase;
    }
    
    public Digit()
    {
        new Digit( 0, 10 );
    }


    public boolean increment()
    {
        if ( value == base - 1 )
        {
            value = 0;
            return true;
        }
        else
        {
            value++;
            return false;
        }
    }


    public String toString()
    {
        if ( value < 10 )
            return "" + value;
        char temp = (char)( value - 10 + 'A' );
        return "" + temp;
    }
}
