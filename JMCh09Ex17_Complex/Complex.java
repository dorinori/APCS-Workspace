/**
 * Represents a complex number of the form a + bi. Provides methods for adding,
 * multiplying and calculating the absolute value.
 *
 * @author Matt Zhou
 * @version 10/3/16
 * @author Period: 5
 * @author Assignment: JMCh09Ex17_Complex
 *
 * @author Sources: none
 */
public class Complex
{
    private double a;

    private double b;


    public Complex( double aNum )
    {
        a = aNum;
        b = 0;
    }


    public Complex( double aNum, double bNum )
    {
        a = aNum;
        b = bNum;
    }


    public double abs()
    {
        double aVal = a * a;
        double bVal = b * b;
        return Math.sqrt( aVal + bVal );
    }


    public Complex add( Complex other )
    {
        double aVal = a + other.getA();
        double bVal = b + other.getB();

        return new Complex( aVal, bVal );
    }
    
    public Complex add( double d )
    {
        double aVal = a + d;
        
        return new Complex( aVal, b );
    }


    public Complex multiply( Complex other )
    {
        double aVal = a * other.a - b * other.b;
        double bVal = a * other.b + b * other.a;

        return new Complex( aVal, bVal );
    }


    public Complex multiply( double d )
    {
        double aVal = a * d;
        double bVal = b * d;

        return new Complex( aVal, bVal );
    }
    
    public double getA()
    {
        return a;
    }


    public double getB()
    {
        return b;
    }


    public String toString()
    {
        return a + " + " + b + "i";
    }
}
