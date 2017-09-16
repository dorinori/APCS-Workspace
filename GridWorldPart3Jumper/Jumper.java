import info.gridworld.actor.Bug;
import info.gridworld.actor.Flower;
import info.gridworld.actor.Rock;
import info.gridworld.grid.Grid;

import java.awt.Color;

import info.gridworld.actor.Actor;
import info.gridworld.grid.Location;


/**
 * A <code>Jumper</code> is an actor that will jump over Rocks and Flowers and
 * turn. A jumper can remove another jumper by jumping on them.
 * 
 * @author TODO Your Name(s)
 * @version TODO Date
 * @author Period: TODO
 * @author Assignment: GridWorld_Part3_Jumper
 * 
 * @author Sources: TODO
 */
public class Jumper extends Bug implements Edible
{
    public Jumper()
    {
        setColor( Color.WHITE );
    }
    
    public Jumper( Color JumperColor )
    {
        setColor( JumperColor );
    }


    public void act()
    {
        jump();
    }
    
    public void jump()
    {
        Grid<Actor> gr = getGrid();
        if (gr == null){
            return;
        }
        
        Location loc = getLocation();
        Location next = loc.getAdjacentLocation( getDirection() );
        Location twoAway = next.getAdjacentLocation( getDirection() );
        
        
        if ( !gr.isValid( twoAway ) ){
            setDirection( getDirection() + Location.HALF_RIGHT );
        }
        else{
            Actor neighborTwoAway = gr.get( twoAway );
            if ( (neighborTwoAway instanceof Flower) || (neighborTwoAway instanceof Rock)){
                setDirection( getDirection() + Location.HALF_RIGHT );
            }
            else{
                moveTo( twoAway );
            }
        }
    }
}