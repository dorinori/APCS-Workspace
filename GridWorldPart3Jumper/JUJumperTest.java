import info.gridworld.actor.*;
import info.gridworld.grid.*;

import org.junit.*;
import static org.junit.Assert.*;


/**
 * Jumper tests:. test01 - jumper next to edge of grid - should turn test02 -
 * jumper 2 from edge of grid - should turn test03 - jumper 2 cells ahead is
 * empty - should jump test04 - jumper 2 cells ahead is empty - should jump
 * test05 - jumper 2 cells ahead is rock - should turn test06 - jumper 1 cell
 * ahead is rock - should jump test07 - jumper 1 cell adjacent to jumper 2 -
 * should jump over eachother
 *
 * @author Matt Zhou
 * @version 10-20-16
 *
 * @author Period: 3
 * @author Assignment - GridWorld Part 3 Jumper
 *
 * @author Sources: none
 */
public class JUJumperTest
{
    /*
     * Variables used by the test methods.
     */
    private Grid<Actor> grid;

    private ActorWorld world;

    private Jumper jumper1;

    private Jumper jumper2;

    private Rock rock;


    /**
     * Invoked before each test to instantiate the objects used for every test.
     */
    @Before
    public void initialize()
    {
        grid = new BoundedGrid<Actor>( 8, 8 );
        world = new ActorWorld( grid );
        jumper1 = new Jumper();
        jumper2 = new Jumper();
        rock = new Rock();
    }


    /**
     * test01 - jumper next to edge of grid - should turn
     */
    @Test
    public void jumperNextToEdgeOfGridShouldTurn()
    {		
        Location loc = new Location( 0, 3 );
        world.add( loc, jumper1 );
        jumper1.act();

        assertTrue( testOccupied( loc, jumper1, Location.NORTHEAST ) );
    }


    /**
     * test02 - jumper 2 from edge of grid - should turn.
     */
    @Test
    public void jumper2FromEdgeOfGridShouldTurn()
    {
        Location loc = new Location( 1, 3 );
        world.add( loc, jumper1 );
        jumper1.act();
			
        assertTrue( testOccupied( loc, jumper1, Location.NORTHEAST ) );
    }


    /**
     * test03 - jumper 2 cells ahead is empty - should jump
     */
    @Test
    public void test03()
    {
        Location loc = new Location( 2, 5 );
        world.add( loc, jumper1 );
        jumper1.act();

        assertTrue(
            testOccupied( new Location( 0, 5 ), jumper1, Location.NORTH ) );

    }


    /**
     * test04 - jumper 2 cells ahead is empty - should jump
     */
    @Test
    public void test04()
    {
        Location loc = new Location( 1, 5 );
        world.add( loc, jumper1 );

        Location loc2 = new Location( 3, 5 );
        world.add( loc2, jumper2 );
        jumper2.act();

        assertTrue( testOccupied( loc, jumper2, Location.NORTH ) );
    }


    /**
     * test05 - jumper 2 cells ahead is rock - should turn
     */
    @Test
    public void test05()
    {
        Location loc = new Location( 1, 5 );
        world.add( loc, rock );

        Location loc2 = new Location( 3, 5 );
        world.add( loc2, jumper1 );
        jumper1.act();

        assertTrue( testOccupied( loc2, jumper1, Location.NORTHEAST ) );
    }


    /**
     * test06 - jumper 1 cell ahead is rock - should jump
     */
    @Test
    public void test06()
    {
        Location loc = new Location( 2, 5 );
        world.add( loc, rock );

        Location loc2 = new Location( 3, 5 );
        world.add( loc2, jumper1 );
        jumper1.act();

        assertTrue(
            testOccupied( new Location( 1, 5 ), jumper1, Location.NORTH ) );

    }


    /**
     * test07 - jumper 1 cell adjacent to jumper 2 - should jump over eachother
     */
    @Test
    public void test07()
    {
        Location loc = new Location( 2, 5 );
        world.add( loc, jumper2 );
        jumper2.setDirection( 180 );
        jumper2.act();

        Location loc2 = new Location( 3, 5 );
        world.add( loc2, jumper1 );
        jumper1.act();

        assertTrue(
            testOccupied( new Location( 1, 5 ), jumper1, Location.NORTH ) );
        assertTrue(
            testOccupied( new Location( 4, 5 ), jumper2, Location.SOUTH ) );
        assertTrue( testEmpty( new Location( 3, 5 ) ) );
    }


    /**
     * Test helper method to test for empty location.
     *
     * @param loc
     *            null location if empty
     * @return true if all assertions pass
     */
    private boolean testEmpty( Location loc )
    {
        Actor empty = grid.get( loc );
        assertNull( "<<<<< " + loc + " should be empty. >>>>>", empty );

        return true;
    }


    /**
     * Test helper method to test that object is in a location, and has a
     * consistent loc, and direction dir.
     *
     * @param loc
     *            location that should be occupied
     * @param a
     *            actor that should be in location loc
     * @param dir
     *            direction this actor should be facing
     * @return true if all assertions pass
     */
    private boolean testOccupied( Location loc, Actor a, int dir )
    {
        Actor found = grid.get( loc );
        assertSame( "<<<<< " + loc + " should contain the actor. >>>>>",
            a,
            found );
        assertEquals( "<<<<< Loc should be " + loc + " >>>>>",
            loc,
            found.getLocation() );
        assertEquals( "<<<<< Dir should be " + dir + " >>>>>",
            dir,
            found.getDirection() );

        return true;
    }
}