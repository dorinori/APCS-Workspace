import info.gridworld.actor.ActorWorld;
import info.gridworld.grid.Location;

/**
 * This is a bystander class.
 * It extends RightShoe so it's a subclass.  It makes a bystander 
 * dancer that just stands in the corner and turns 45 degrees every so often.
 * 
 * @author Matt Zhou
 * @version 10/14/16
 * 
 * @author Period - 5
 * @author Assignment - Ch 11, Ex9 - GridWorld Dance - Bystander
 * 
 * @author Sources - none
 */

public class BystanderNumber extends CongaNumber
{
    /**
     * @param world - GridWorld world
     */
    public void setUpDancers( ActorWorld world )
    {
        super.setUpDancers( world );

        world.add( new Location( 0, world.getGrid().getNumCols() - 1 ),
            new Bystander() );
    }

    /**
     * @param args - command line arguments not used
     */
    public static void main( String[] args )
    {
        DanceNumber number = new BystanderNumber();
        number.run( new ActorWorld(), new Conga() );
    }
}
