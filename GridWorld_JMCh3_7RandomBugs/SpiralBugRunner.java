import java.awt.Color;

import info.gridworld.actor.Actor;
import info.gridworld.grid.UnboundedGrid;
import info.gridworld.actor.ActorWorld;
import info.gridworld.grid.Location;

/**
   This is a spiral bug runner.
   The main is here so I can run the spiral bug program

   @author  Matt Zhou
   @version 8/26/16

   @author  Period - 5
   @author  Assignment - GridWorld Part 2, Exercise 2 - SpiralBugRunner

   @author  Sources - none
 */
public class SpiralBugRunner
{
    public static void main( String[] args )
    {
        UnboundedGrid grid = new UnboundedGrid<Actor>();
        ActorWorld world = new ActorWorld( grid );

        SpiralBug alice = new SpiralBug( 4 );

        world.add( new Location( 0, 6 ), alice );
        world.show();
    }
}