/**
 * This class discovers a lot of interesting numbers. It finds fibonacci
 * numbers, finds perfect numbers, mersenne primes, and even perfect numbers.
 *
 * @author Matt Zhou
 * @version 9/23/16
 * @author Period: 5
 * @author Assignment: JMCh08_PerfectNumbers
 *
 * @author Sources: none
 */
public class MyMath
{
    private static long[] powerOfTwoArray = new long[100];

    private static long[] mersennePrimeArray = new long[100];


    /**
     * Returns true if n is a prime; otherwise returns false.
     * 
     * @param n
     *            number to check if prime
     * @return true if n is a prime; otherwise returns false
     */
    public static boolean isPrime( int n )
    {
        if ( n <= 1 )
        {
            return false;
        }

        int m = 2;

        while ( m * m <= n )
        {
            if ( n % m == 0 )
            {
                return false;
            }
            m++;
        }

        return true;
    }


    /**
     * Question 8-15 Returns the n-th Fibonacci number
     * 
     * Find and read a few informative websites dedicated to Fibonacci numbers.
     * The following recursive method returns the n-th Fibonacci number:
     * 
     * // Returns the n-th Fibonacci number. // Precondition: n >= 1 public
     * static long fibonacci(int n) { if (n == 1 || n == 2) return 1; else
     * return fibonacci(n - 1) + fibonacci(n - 2); } Rewrite it without
     * recursion, using one loop.
     *
     * @param n
     *            Fibonacci number to find
     * @return n-th Fibonacci number
     */
    public static long fibonacci( int n )
    {
        int fibNum1 = 1;
        int fibNum2 = 0;
        int fibNum3 = 0;

        for ( int i = 0; i < n; i++ )
        {
            fibNum3 = fibNum1 + fibNum2;
            fibNum1 = fibNum2;
            fibNum2 = fibNum3;
        }
        return fibNum3;

    }


    /**
     * Returns true if n is a perfect number, false otherwise.
     * 
     * @param n
     *            number to test
     * @return true if n is a perfect number, false otherwise.
     */
    public static boolean isPerfect( int n )
    {

        int temp = 0;

        for ( int i = 1; i <= n / 2; i++ )
        {
            if ( n % i == 0 )
            {
                temp += i;
            }
        }
        return temp == n;

    }


    /**
     * Prints the first n perfect numbers
     * 
     * @param n
     *            number of perfect numbers to print
     */
    public static void printPerfectNums( int n )
    {
        System.out.println( "Perfect numbers: " );
        int count = 0;
        for ( int k = 1; count < n; k++ )
        {
            if ( isPerfect( k ) )
            {
                System.out.print( k + " " );
                count++;
            }
        }
        System.out.println();
    }


    /**
     * Prints the first n Mersenne primes
     * 
     * @param n
     *            number of Mersenne primes to print
     */
    public static void printMersennePrimes( int n )
    {
        System.out.println( "Mersenne primes: " );

        int count = 0;
        long p = 2;
        long num;

        while ( count < n )
        {
            num = powerOfTwo( p ) - 1;
            if ( isPrime( num ) )
            {
                System.out.println( num );
                mersennePrimeArray[count] = num;
                powerOfTwoArray[count] = p;
                count++;
            }
            p++;
        }

    }


    /**
     * Returns 2 to the power of n
     * 
     * @param n
     *            the degree of the power
     * @return num the result of the power of two
     */
    private static long powerOfTwo( long n )
    {
        long num = 1;
        for ( long i = 0; i < n; i++ )
        {
            num = num * 2;
        }

        return num;
    }


    /**
     * Returns true if n is a prime; otherwise returns false.
     * 
     * @param n
     *            number to check if prime
     * @return true if n is a prime; otherwise returns false
     */
    private static boolean isPrime( long n )
    {
        for ( long i = 2; i < n / 2; i++ )
        {
            if ( n % i == 0 )
            {
                return false;
            }
        }
        return true;
    }


    /**
     * Prints the first n even perfect numbers
     * 
     * @param n
     *            number to check if prime
     */
    public static void printEvenPerfectNums( int n )
    {
        System.out.println( "Even perfect numbers: " );

        int count = 0;

        while ( count < n )
        {
            long mersennePrime = mersennePrimeArray[count];
            long p = powerOfTwoArray[count];
            long num = powerOfTwo( p - 1 ) * mersennePrime;
            System.out.println( num );
            count++;
        }

        System.out.println();
    }


    /*********************************************************************/

    /**
     * The main method in this class calls the methods.
     * 
     * @param args
     *            is not used.
     */
    public static void main( String[] args )
    {
        int n = 19;
        System.out.println( n + "-th Fibonacci number = " + fibonacci( n ) );

        printPerfectNums( 4 );
        printMersennePrimes( 6 );
        printEvenPerfectNums( 6 );
    }
}
/*
 * 19-th Fibonacci number = 4181 Perfect numbers: 6 28 496 8128 Mersenne primes:
 * 3 7 31 127 8191 131071 524287 Even perfect numbers: 6 28 496 8128 33550336
 * 8589869056 137438691328
 */