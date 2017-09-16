/**
 * Calculates the area and the perimeter of a right triangle as specified by the
 * abstract Triangle superclass.
 * 
 * @author Matt Zhou
 * @version 10/7/17
 * 
 * @author 5
 * @author Assignment - Java Methods Chapter 11, Exercise #8 - Triangle
 * 
 * @author Sources - none
 */
public class RightTriangle extends AbstractTriangle
{
    /**
     * Triangle constructor.
     * 
     */
    public RightTriangle()
    {
        super();
    }


    /**
     * Triangle constructor.
     * 
     * @param side
     *            value of length of side
     */
    public RightTriangle( double side )
    {
        super( side );
    }


    /**
     * Calculates and returns the perimeter of this Triangle.
     * 
     * @return the perimeter of this Triangle
     */
    public double getPerimeter()
    {
        return ( 2 + Math.sqrt( 2.0 ) ) * this.getSide();
    }


    /**
     * Calculates and returns the area of this Triangle.
     * 
     * @return the area of this Triangle
     */
    public double getArea()
    {
        return this.getSide() * this.getSide() / 2;
    }

}
