import java.util.*;

/**
 * Represents various States and their respective cities.
 *
 * @author Matt Zhou
 * @version 3/31/17
 * @author Period - 5
 *
 * @author Assignment - TestSem2CollectionsStates
 *
 * @author Sources - GPECK
 */
public class States
{
    private Map<String, Set<String>> theMap;

    public States()
    {
        theMap = new TreeMap<String, Set<String>>();
    }

    // postcondition: Information from theCity
    // has been added to theMap
    public void addCityToMap(CityInfo theCity)
    {
        Set<String> temp = theMap.get( theCity.state() );
        
        if (temp == null)
            temp = new HashSet<String>();
        
        temp.add( theCity.city() );
        theMap.put( theCity.state(), temp);
    }

    public void printOneState(String theState)
    {
        System.out.print( theState + " " );
        for (Object s: theMap.get( theState ).toArray()){
            System.out.print(s + " ");
        }
        System.out.println();
    }
    
    public void printAllStates()
    {
        for (String k: theMap.keySet()){
            printOneState(k);
        }
    }

    //*************************************************************
    // For test purposes only
    // not to be used in solution implementation
    public Map<String, Set<String>> getTheMap()
    {
        return theMap;
    }
}
