import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;


/**
 * This is the pig latin analyzer. This analyzes phrases and turns them into 
 * pig latin. Basically, we turn individual words into pig latin first, 
 * then we turn phrases into pig latin.
 * 
 * @author Matt Zhou
 * @version 10/14/16
 * 
 * @author Period - 5
 * @author Assignment - Piglatinator
 * 
 * @author Sources - none
 */
public class PiglatinAnalyzer
{
    private String text;


    // Constructor: saves the text string
    public PiglatinAnalyzer( String text )
    {
        this.text = text;
    }


    /**
     * Converts a string to it piglatin form according to the following rules:
     * a. If there are no vowels in englishWord, then pigLatinWord is just
     * englishWord + "ay". (There are ten vowels: 'a', 'e', 'i', 'o', and 'u',
     * and their uppercase counterparts.) b. Else, if englishWord begins with a
     * vowel, then pigLatinWord is just englishWord + "yay". c. Otherwise (if
     * englishWord has a vowel in it and yet doesn't start with a vowel), then
     * pigLatinWord is end + start + "ay", where end and start are defined as
     * follows: 1. Let start be all of englishWord up to (but not including) its
     * first vowel. 2. Let end be all of englishWord from its first vowel on. 3.
     * But, if englishWord is capitalized, then capitalize end and
     * "uncapitalize" start.
     *
     * @return piglatin version of text as a String
     */
    public String phraseToPigLatin()
    {
        String phraseToTranslate = text;

        String arr[] = phraseToTranslate.split( "\\W+" );

        for ( int i = 0; i < arr.length; i++ )
        {
            if ( arr[i].matches( "[a-zA-Z]+" ) )
            {
                arr[i] = wordToPigLatin( arr[i] );
            }
        }
        return Arrays.toString( arr ).replace( "[", "" ).replace( "]", "" );
    }


    /**
     * Converts an "english" word to its piglatin form
     *
     * @param englishWord
     *            a string representing an english word
     * @return piglatin form of the english word
     */
    public String wordToPigLatin( String englishWord )
    {
        String pigLatinWord = "";
        int pos = indexOfVowel( englishWord );

        if ( pos == -1 )
        {
            pigLatinWord += englishWord + "ay";
        }
        else if ( pos == 0 )
        {
            pigLatinWord += englishWord + "yay";
        }
        else
        {
            String end = englishWord.substring( pos );
            String start = englishWord.substring( 0, pos );
            if ( checkForCaps( englishWord ) )
            {
                end = Character.toUpperCase( end.charAt( 0 ) ) + end.substring( 1 );
                start = Character.toLowerCase( start.charAt( 0 ) ) + start.substring( 1 );
            }
            pigLatinWord += end + start + "ay";

        }

        return pigLatinWord;
    }


    private int indexOfVowel( String word )
    {
        for ( char c : word.toCharArray() )
        {
            if ( "AEIOUaeiou".indexOf( c ) != -1 )
            {
                return word.indexOf( c );
            }
        }
        return -1;
    }


    private boolean checkForCaps( String word )
    {
        return Character.isUpperCase( word.charAt( 0 ) );
    }

}
