import info.gridworld.actor.Bug;


/**
 * This represents a spiral bug. It basically runs around in a spiral. You can
 * call act to make it move, put in a number in the constructor for the length.
 * 
 * @author Matt Zhou
 * @version 8/26/16
 * 
 * @author Period - 5
 * @author Assignment - GridWorld Part 2, Exercise 2 - SpiralBug
 * 
 * @author Sources - none
 */
public class SpiralBug extends Bug
{
    private int steps;

    private int sideLength;


    public SpiralBug( int length )
    {
        steps = 0;
        sideLength = length;
    }


    /**
     * Moves to the next location of the square.
     */
    public void act()
    {
        if ( steps < sideLength && canMove() )
        {
            move();
            steps++;
        }
        else
        {
            turn();
            turn();
            steps = 0;
            sideLength += 1;
        }
    }

}