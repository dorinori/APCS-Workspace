/**
 * Calculates the area and the perimeter of an equilateral triangle as specified
 * by the abstract Triangle superclass.
 * 
 * @author Matt Zhou
 * @version 10/7/17
 * 
 * @author 5
 * @author Assignment - Java Methods Chapter 11, Exercise #8 - Triangle
 * 
 * @author Sources - none
 */
public class EquilateralTriangle extends AbstractTriangle
{

    /**
     * Triangle constructor.
     * 
     */
    public EquilateralTriangle()
    {
        super();
    }
    
    /**
     * Triangle constructor.
     * 
     * @param side
     *            value of length of side
     */
    public EquilateralTriangle( double side )
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
        return this.getSide() * 3;
    }

    /**
     * Calculates and returns the area of this Triangle.
     * 
     * @return the area of this Triangle
     */
    public double getArea()
    {
        return Math.sqrt( 3 ) / 4 * this.getSide() * this.getSide();
    }

}
