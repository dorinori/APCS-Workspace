/**
 * A class to solve various loop problems
 * 
 * @author Matt Zhou
 * @version 9/22/16
 * 
 *          Period - 5 - A12.1 - FunLoops
 * 
 *          Sources - none
 */
public class FunLoops
{
    /**
     * Finds the magic square.
     * 
     * @param n The number of magic squares to find.
     */
    public void magicsquare( long n )
    {
        System.out.println( "Magic Squares" );

        long foundNum = 0;
        long count = 1;
        while ( foundNum < n )
        {
            long magicSquare = count * count;
            if ( sumOfLong( magicSquare ) == 0 )
            {
                foundNum++;
                System.out.println( foundNum + ": " + magicSquare );
            }
            count++;
        }

    }

    /**
     * Keeps on subtracting consecutive numbers from another number.
     * 
     * @param n The number.
     */
    private long sumOfLong( long n )
    {
        for ( long i = 0; n > 0; i++ )
        {

            n = n - i;
        }
        return n;

    }



    /**
     * Finds the lcm. The least common multiple is (the product of the elements
     * in) the union of the sets of prime factors for both numbers. The union of
     * two sets is obtained by writing down the element from both sets and
     * removing those from the intersection of the sets, since those elements
     * have been counted twice.
     * 
     * @param a
     *            A number.
     * @param b
     *            A number.
     * 
     * @return a * b / gcd( a, b ) Returns the lcm.
     */
    public int lcm( int a, int b )
    {
        return a * b / gcd( a, b );

    }



    /**
     * Finds the gcd. Start by dividing the larger number m with the smaller n.
     * This gives a remainder r1. Then divide the smaller number n with the
     * obtained remainder r1. This gives anew remainder r2. Now divide the
     * remainder r1 with the remainder r2. This gives yet another remainder r3.
     * Repeat the procedure until the remainder becomes zero.
     * 
     * @param a
     *            A number.
     * @param b
     *            A number.
     */
    private int gcd( int a, int b )
    {
        while ( a != 0 && b != 0 )
        {
            int c = b;
            b = a % b;
            a = c;
        }
        return a + b;
    }

    /**
     * Does the loops.
     * 
     * @param args
     *            command-line arguments (not used)
     */
    public static void main( String[] args )
    {
        FunLoops fun = new FunLoops();

        fun.magicsquare( 4 );
        System.out.println();

        System.out.println( "LCM (15, 18) = " + fun.lcm( 15, 18 ) );
        System.out.println( "LCM (40, 12) = " + fun.lcm( 40, 12 ) );
        System.out.println( "LCM (2, 7) = " + fun.lcm( 2, 7 ) );
        System.out.println( "LCM (100, 5) = " + fun.lcm( 100, 5 ) );
        System.out.println();

        fun.magicsquare( 10 );
    }
}
