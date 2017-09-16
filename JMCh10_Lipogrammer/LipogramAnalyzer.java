/**
   This class is a lipogrammer.
   Use the methods to replace a certain letter with a hashtag.

   @author  Matt Zhou
   @version 10/6/16

   @author Period - 5
   @author Assignment - JMCh10 Lipogrammer

   @author Sources - none
 */
public class LipogramAnalyzer
{
    private String text;

    /**
       Constructor: Saves the text string
       @param text String to analyze
     */
    public LipogramAnalyzer(String t)
    {
        text = t;
    }

    /**
       Returns the text string with all characters equal to letter 
       replaced with '#'.

       @param letter character to replace
       @return text string with all characters equal to letter 
                    replaced with '#'
     */
    public String mark(char letter)
    {
        return text.replace( letter + "", "#" );
    }


    /**
     * Returns a String that concatenates all "offending" words from text that
     * contain letter; the words are separated by '\n' characters; the returned
     * string does not contain duplicate words: each word occurs only once;
     * there are no punctuation or whitespace characters in the returned string.
     * 
     * @param letter
     *            character to find in text
     * @return String containing all words with letter
     */
    public String allWordsWith( char letter )
    {
        String word = "";
        int x = 0;
        while ( x < text.length() )
        {
            if ( text.charAt( x ) == letter )
            {
                if ( word.indexOf( "\n" + extractWord( x ) + "\n" ) == -1 )
                {
                    word += "\n" + extractWord( x ) + "\n";

                }

            }
            x++;
        }
        word = word.replace( "\n\n", "\n" );
        if ( word.length() > 0 )
        {
            return word.substring( 1 );
        }
        else
        {
            return word;
        }

    }


    /**
     * Returns the word that contains character at pos excluding any punctuation
     * or whitespace.
     * 
     * @param pos
     *            location of character
     * 
     * @return word that contains character at pos
     */
    public String extractWord( int pos )
    {

        int start = pos;
        int finish = pos;
        if ( Character.isLetter( text.charAt( pos ) ) )
        {

            while ( start >= 0 && Character.isLetter( text.charAt( start ) ) )
            {
                start--;
            }
            while ( finish < text.length() && Character.isLetter( text.charAt( finish ) ) )
            {
                finish++;
            }
            return text.substring( start + 1, finish );
        }
        else
        {
            return text.substring( start + 1, finish );
        }
    }
}
