/**
 * This is a class that represents a book, with number of pages and the current
 * page. It represents a physical book, and includes a couple of get methods
 * that allow access to the fields. It also allows the user to increment the
 * current page by 1, provided current page is less than the number of pages.
 *
 * @author Matt Zhou
 * @version 8/24/16
 * @author Period: 5
 * @author Assignment: JMCh03Ex11_Book
 *
 * @author Sources: none
 */
public class Book
{
    private int numPages;

    private int currentPage;


    public Book( int pages )
    {
        numPages = pages;
        currentPage = 1;
    }


    public int getNumPages()
    {
        return numPages;
    }


    public int getCurrentPage()
    {
        return currentPage;
    }


    public void nextPage()
    {
        if ( currentPage < numPages )
        {
            currentPage++;
        }
    }

}
