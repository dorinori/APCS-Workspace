import info.gridworld.actor.Bug;


/**
 * This represents a circle bug.
 * Make a circle bug by putting in the length of the circle's sides.
 * 
 * @author Matt Zhou
 * @version 8/26/16
 * 
 * @author Period - 5
 * @author Assignment - GridWorld Part 2, Random bugs - CircleBug
 * 
 * @author Sources - none
 */
public class CircleBug extends Bug
{
    private int steps;

    private int sideLength;


    /**
     * Constructs a box bug that traces a square of a given side length
     * 
     * @param length
     *            the side length
     */
    public CircleBug( int length )
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
            steps = 0;
        }
    }
}