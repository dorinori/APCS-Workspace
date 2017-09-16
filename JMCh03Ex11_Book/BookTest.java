/**
 * This is a class that tests the Book class.
 *
 * @author Matt Zhou
 * @version 8/24/16
 * @author Period: 5
 * @author Assignment: JMCh03Ex11_Book
 *
 * @author Sources: none
 */
public class BookTest
{
    /**
     * The main method in this class checks the Book operations for consistency.
     * 
     * @param args
     *            is not used.
     */
    public static void main( String[] args )
    {
        Book book = new Book( 3 );
        System.out.println( book.getNumPages() );
        System.out.println( book.getCurrentPage() );

        for ( int i = 0; i < 3; i++ )
        {
            book.nextPage();
            System.out.println( book.getCurrentPage() );
        }
    }
}
