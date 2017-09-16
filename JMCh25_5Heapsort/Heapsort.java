/**
   TODO Write a one-sentence summary of your class here.
   TODO Follow it with additional details about its purpose, what abstraction
   it represents, and how to use it.

   @author  TODO Your Name
   @version TODO Date

   @author  Period - TODO Your Period
   @author  Assignment - TODO Assignment Name

   @author  Sources - TODO list collaborators
 */
public class Heapsort
{
    // Sorts a[0], ..., a[size-1] in ascending order
    //   using the Mergesort algorithm
    public static void sort(double[] a)
    {
        int l = a.length;
        for ( int i = l / 2; i >= 1; i-- )
            reheapDown( a, i, l );
        while ( l > 1 )
        {
            // swap a[0] with a[n-1]:
            double temp = a[0];
            a[0] = a[l - 1];
            a[l - 1] = temp;
            l--;
            reheapDown( a, 1, l );
        }
    }
    
    // Should be private - made public for testing
    public static void reheapDown(double[] a, int i, int n)
    {
        int x = i - 1;
        while ( 2 * x + 1 < n )
        {
            if ( 2 * x + 2 == n )
                if ( a[x] > a[2 * x + 1] )
                    return;
                else
                {
                    double y = a[x];
                    a[x] = a[2 * x + 1];
                    a[2 * x + 1] = y;
                    return;
                }
            if ( a[x] >= a[2 * x + 1] && a[x] >= a[2 * x + 2] )
                return;
            if ( a[2 * x + 1] > a[2 * x + 2] )
            {
                double y = a[x];
                a[x] = a[2 * x + 1];
                a[2 * x + 1] = y;
                x = 2 * x + 1;
            }
            else
            {
                double y = a[x];
                a[x] = a[2 * x + 2];
                a[2 * x + 2] = y;
                x = 2 * ( x + 2 );
            }
        }
    }
}
