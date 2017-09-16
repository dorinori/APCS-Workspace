import java.util.*;

/**
   This a search engine.
   Call its methods to implement it as a search engine.

   @author  Matt Zhou
   @version 2/13/17

   @author Period - 5
   @author Assignment - JM24.6 - Search Engine

   @author Sources - none
 */
public class SearchEngine
{
    // Instance variable(s)
    private String myURL; // holds the name for the "url" (file name)
    private Map<String, List<String>> myIndex; // holds the word index

    public SearchEngine(String url){
        myURL = url;
        myIndex = new HashMap<String, List<String>>(20000);
    }


    // Methods
    public String getURL() {
        return myURL;
    }
    
    public void add(String line) {
        Set<String> list = parseWords( line ); 
        for ( String string : list ) 
        { 
            LinkedList<String> temp = new LinkedList<String>(); 
            if ( !myIndex.containsKey( string ) ) 
            { 
                myIndex.put( string, temp ); 
            } 
            myIndex.get( string ).add( line ); 
        } 
    } 
   
    public List<String> getHits( String word ) 
    { 
        return myIndex.get( word ); 
    } 

    private Set<String> parseWords(String line) {
        String lineArray[] = line.split("\\W+");
        TreeSet<String> wordTree = new TreeSet<String>();
        
        for ( String string : lineArray ) 
        { 
            if ( !string.isEmpty() ) 
            { 
                wordTree.add( string.toLowerCase() );
            } 
        } 
        
        return wordTree;
    }
    
    //*************************************************************
    // For test purposes only
    // not to be used in solution implementation
    public Map<String, List<String>> getIndex()
    {
        return myIndex;
    }
}
