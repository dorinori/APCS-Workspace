/**
 * The abstract class <code>Triangle</code> requires methods for calculating the
 * area and the perimeter as specified the type of triangle. A method to
 * calculate the ratio of the area to the perimeter is provided. The class works
 * for equilateral triangles and for right isosceles triangles; which can be
 * specified with the length of a side.
 * 
 * @author Matt Zhou
 * @version 10/7/17
 * 
 * @author 5
 * @author Assignment - Java Methods Chapter 11, Exercise #8 - Triangle
 * 
 * @author Sources - none
 */
public abstract class AbstractTriangle
{
    private double side;

    /**
     * Calculates and returns the perimeter of this Triangle.
     * 
     * @return the perimeter of this Triangle
     */
    public abstract double getPerimeter();


    /**
     * Calculates and returns the area of this Triangle.
     * 
     * @return the area of this Triangle
     */
    public abstract double getArea();

    /**
     * Calculates and returns the ratio of this Triangle.
     * 
     * @return the ratio of this Triangle
     */
    public double getRatio()
    {
        return getArea() / getPerimeter();
    }


    /**
     * Triangle constructor.
     * 
     */
    public AbstractTriangle()
    {
        side = 0;
    }


    /**
     * Triangle constructor.
     * 
     * @param sideLength
     *            value of length of side
     */
    public AbstractTriangle( double sideLength )
    {
        side = sideLength;
    }


    /**
     * Calculates and returns the ratio of this Triangle.
     * 
     * @return the perimeter of this Triangle
     */
    public double getSide()
    {
        return side;
    }
}
