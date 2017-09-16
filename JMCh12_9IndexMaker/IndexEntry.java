import java.awt.geom.Point2D;
import java.util.ArrayList;

public class IndexEntry
{
    private String word;
    private ArrayList<Integer> numsList;

    // Constructs an IndexEntry for a given word
    // (converted to upper case); sets numsList
    // to an empty ArrayList.
    public IndexEntry(String word)
    {
        this.word = word.toUpperCase();
        numsList = new ArrayList<Integer>();
    }

    // Returns the word of this IndexEntry object.
    public String getWord()
    {
        return word;
    }

    // If num is not already in the list, adds num
    // at the end of this IndexEntry's list
    // of numbers.
    public void add(int num)
    {
        Integer integer = num;
        if (!numsList.contains( integer ) )
        {
            numsList.add( integer );
        }
    }

    // Converts this IndexEntry into a string in the
    // following format: the word followed by a space, followed by
    // numbers separated by a comma and a space.
    public String toString()
    {
        String string = word;
        
        for (Integer number : numsList) {
            string = string +  " " + number.toString() + ",";
        }
        
        string = string.substring( 0 , string.length() - 1 );
        
        return string;
    }
}
