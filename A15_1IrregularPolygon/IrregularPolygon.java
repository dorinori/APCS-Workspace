import java.awt.Color;
import java.awt.geom.*;
import java.util.*;
import gpdraw.*;

/**
 * This draws and gets information about polygons.
 * Call the methods to calculate perimeter and area.
 *
 * @author  Matt Zhou
 * @version 11/3/16
 *
 * @author  Period - 5
 * @author  Assignment - IrregularPolygon
 * 
 * @author  Sources - none
 */
public class IrregularPolygon
{
    private DrawingTool pen; // = new DrawingTool( new SketchPad( 300, 300, 0 ) );
    private ArrayList<Point2D.Double> myPolygon;

    //constuctors
    
    public IrregularPolygon()
    {
        myPolygon = new ArrayList<Point2D.Double>();
    }

    // public methods

    public void add( Point2D.Double aPoint )
    {
        myPolygon.add( aPoint );
    }

    private double distance( Point2D.Double p1, Point2D.Double p2 )
    {
        return Math.sqrt( Math.pow( ( p2.x - p1.x ), 2 )
            + Math.pow( ( p2.y - p1.y ), 2 ) );
    }


    public double perimeter()
    {
        if ( myPolygon.size() < 3 )
        {
            return 0;
        }
        
        double perimeter = 0;
        
        for ( int i = 0; i < myPolygon.size() - 1; i++ )
        {
            perimeter += distance( myPolygon.get( i ), myPolygon.get( i + 1 ) );
        }
        
        perimeter += distance( myPolygon.get( myPolygon.size() - 1 ), myPolygon.get( 0 ) );
        
        return perimeter;
    }


    public double area()
    {
        if ( myPolygon.size() < 3 )
        {
            return 0;
        }
        
        double area = 0;
        
        for ( int i = 0; i < myPolygon.size() - 1; i++ )
        {
            area += myPolygon.get( i ).x * myPolygon.get( i + 1 ).y;
        }
        
        area += myPolygon.get( myPolygon.size() - 1 ).x * myPolygon.get( 0 ).y;
        
        for ( int i = 0; i < myPolygon.size() - 1; i++ )
        {
            area -= myPolygon.get( i ).y * myPolygon.get( i + 1 ).x;
        }
        
        area -= myPolygon.get( myPolygon.size() - 1 ).y * myPolygon.get( 0 ).x;
        
        area = Math.abs( area / 2 );
        
        return area;
    }


    public void draw()
    {
        if ( myPolygon.size() < 3 )
        {
            return;
        }
        
        pen.up();
        pen.move( myPolygon.get( 0 ).getX(), myPolygon.get( 0 ).getY() );
        pen.down();
        
        for ( int i = 1; i < myPolygon.size(); i++ )
        {
            pen.move( myPolygon.get( i ).getX(), myPolygon.get( i ).getY() );
        }
        
        pen.move( myPolygon.get( 0 ).getX(), myPolygon.get( 0 ).getY() );
    }
}
