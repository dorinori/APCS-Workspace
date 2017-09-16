import info.gridworld.actor.Actor;
import info.gridworld.actor.Critter;
import info.gridworld.grid.Location;
import info.gridworld.grid.Grid;

import java.util.ArrayList;

import java.awt.Color;

/**
 *  This is a bluster critter.
 *  It checks whether there are actors within two spaces of the critter, 
 *  and then sees if there are enough actors to justify darkening or not.
 *
 *  @author  Matt Zhou
 *  @version 11/8/16
 *  @author  Period: 5
 *  @author  Assignment: BlusterCritter - GridWorld Part4 Exercise 4
 *
 *  @author  Sources: none
 */
public class BlusterCritter extends Critter
{
    private static final double DARKENING_FACTOR = 0.05;
    int c;

    public BlusterCritter( int c )
    {
        this.c = c;
    }

    /**
     * This is a method that gets all the actors within 2 spaces.
     * <br />
     * Postcondition: The state of all actors is unchanged.
     * 
     * @return a list of actors that this critter wishes to process.
     */
    public ArrayList<Actor> getActors()
    {
        ArrayList<Actor> actors = new ArrayList<Actor>();

        Location loc = getLocation();
        for ( int r = loc.getRow() - 2; r <= loc.getRow() + 2; r++ )
        {
            for ( int c = loc.getCol() - 2; c <= loc.getCol() + 2; c++ )
            {
                Location tempLoc = new Location( r, c );
                if ( getGrid().isValid( tempLoc ) )
                {
                    Actor a = getGrid().get( tempLoc );
                    if ( a != null && a != this )
                    {
                        actors.add( a );
                    }
                }
            }
        }
        return actors;
    }

    /**
     * This processes all the actors.  It checks if the number of actors
     * are less than the courage value.  If it is, then it lightens up, else
     * it darkens.
     * <br />
     * Postcondition: (1) The state of all actors in the grid other than this
     * critter and the elements of <code>actors</code> is unchanged. (2) The
     * location of this critter is unchanged.
     * 
     * @param actors the actors to be processed
     */
    public void processActors( ArrayList<Actor> actors )
    {
        if ( actors.size() < c)
        {
            lighten();
        }
        else
        {
            darken();
        }
    }

    /**
     * This darkens the colors.
     */
    private void darken()
    {
        Color c = getColor();
        setColor( c.darker() );
    }


    /**
     * This lightens up the colors.
     */
    private void lighten()
    {
        Color c = getColor();
        setColor( c.brighter() );
    }
}
