import info.gridworld.actor.ActorWorld;
import info.gridworld.grid.BoundedGrid;
import info.gridworld.grid.Location;

import java.awt.Color;


/**
 * A bug that runs in a circular pattern. This is the runner page for the circle
 * bug program.
 * 
 * @author Matt Zhou
 * @version 8/26/16
 * 
 * @author Period - 5
 * @author Assignment - GridWorld Part 2, Random Bugs - CircleBugRunner
 * 
 * @author Sources - none
 */
public class CircleBugRunner
{
    public static void main( String[] args )
    {
        ActorWorld world = new ActorWorld();
        CircleBug alice = new CircleBug( 2 );

        world.add( new Location( 7, 8 ), alice );

        world.show();
    }
}