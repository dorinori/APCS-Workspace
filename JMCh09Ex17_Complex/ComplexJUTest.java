import org.junit.*;

import static org.junit.Assert.*;
import junit.framework.JUnit4TestAdapter;

/**
 *  Test for the complex number class.
 *  
 *  testConstructor1Param - test the 1 parameter constructor
 *  testConstructor2Param - test the 2 parameter constructor
 *  testAddRealAndComplexNum - addition of a complex number 
 *     with a real number
 *  testAdd2ComplexNums - addition of two complex numbers
 *  testMultiply2ComplexNums - multiplication of two complex numbers
 *  testMultiplyRealAndComplexNum - multiplication of a complex number
 *     with a real number
 *  testAbsoluteValue - absolute value of a complex number
 *
 *  @author  Matt Zhou
 *  @version 10/3/16
 *  @author  Period: 5
 *  @author  Assignment: JMCh09Ex17_Complex 
 *
 *  @author  Sources: none
 */
public class ComplexJUTest extends junit.framework.TestCase
{
    /* public void ----
     * Complext c1 = newComplex
     * asserteqa=uals (3 + 00 i, c1 to string
     */
    
    @Test
    public void testConstructor1Param()
    {
        Complex c = new Complex( 10 );
        assertEquals( "10.0 + 0.0i", c.toString());
    }

    @Test
    public void testConstructor2Param()
    {
        Complex c1 = new Complex(1, 2);
        assertEquals( "1.0 + 2.0i", c1.toString());
        
    }

    @Test
    public void testAddRealAndComplexNum()
    {
        Complex c2 = new Complex(2, 3);
        Complex c = c2.add( 5.5 );
        assertEquals( "7.5 + 3.0i", c.toString());
               
    }
    
    @Test
    public void testAdd2ComplexNums()
    {
        Complex c2 = new Complex(2, 3);
        Complex c = c2.add( new Complex(4, 5) );
        assertEquals( "6.0 + 8.0i", c.toString());
    }

    @Test
    public void testMultiply2ComplexNums()
    {
       Complex c1 = new Complex(1, 2);
       Complex c2 = new Complex(3, 4);
       Complex c3 = c2.multiply(c1);
       assertEquals( "-5.0 + 10.0i", c3.toString());
    }

    @Test
    public void testMultiplyRealAndComplexNum()
    {
        Complex c = new Complex(1, 2);
        Complex ans = c.multiply( 4.0 );
        assertEquals("4.0 + 8.0i", ans.toString());
    }

    @Test
    public void testAbsoluteValue()
    {
        Complex c2 = new Complex(3, 4);
        assertEquals( 5.0, c2.abs(), 0.01);
    }
    
    public static junit.framework.Test suite()
    {
        return new JUnit4TestAdapter( ComplexJUTest.class );
    }

    public static void main( String args[] )
    {
        org.junit.runner.JUnitCore.main( "ComplexJUTest" );
    }
}
