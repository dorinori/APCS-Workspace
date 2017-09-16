/**
 * Implements a rolling die object.
 *
 * @author Matt Zhou
 * @version 9/13/16
 * @author Period: 5
 * @author Assignment: JMCh07_RollingDice
 *
 * @author Sources: none
 */
public class CrapsGame
{
    private int point = 0;


    /**
     * Calculates the result of the next dice roll in the Craps game. The
     * parameter total is the sum of dots on two dice. point is set to the saved
     * total, if the game continues, or 0, if the game has ended. Returns 1 if
     * player won, -1 if player lost, 0 if player continues rolling.
     * 
     * @param total
     *            the sum of the two die
     * @return result, whether the player won or lost
     */
    public int processRoll( int total )
    {
        int result = 0;

        if ( point == 0 )
        {
            if ( total == 7 || total == 11 )
            {
                result = 1;
                point = 0;
            }
            else if ( total == 2 || total == 3 || total == 12 )
            {
                result = -1;
                point = 0;
            }
            else
            {
                point = total;

            }
        }
        else
        {
            if ( total == point )
            {
                result = 1;
                point = 0;
            }
            else if ( total == 7 )
            {
                result = -1;
                point = 0;
            }
        }

        return result;

    }


    /**
     * Returns the saved point
     * 
     * @return point --> the point calculated for the game.
     */
    public int getPoint()
    {
        return point;
    }
}