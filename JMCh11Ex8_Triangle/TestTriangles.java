/**
 * Triangle test class
 * 
 * @author Matt Zhou
 * @version 10/7/17
 * 
 * @author 5
 * @author Assignment - Java Methods Chapter 11, Exercise #8 - Triangle
 * 
 * @author Sources - none
 */
public class TestTriangles
{
    /**
     * Test method for the Triangle class
     * 
     * @param args
     *            command line arguments - not used
     */
    public static void main( String[] args )
    {
        double side = 10.0;
        AbstractTriangle equilateral = new EquilateralTriangle( side );
        AbstractTriangle right = new RightTriangle( side );

        double equilateralRatio = equilateral.getRatio();
        double rightRatio = right.getRatio();

        System.out.println( "EquilateralTriangle( " + equilateral.getSide() 
            + " ): " + "getRatio() = " + equilateralRatio );

        System.out.println( "RightTriangle( " + right.getSide() 
            + " ): " + "getRatio() = " + rightRatio );

        String bigger = "right isosceles";
        String smaller = "equilateral";

        double radRight;
        double radEquilateral;

        radRight = right.getArea() / ( 0.5 * right.getPerimeter() );
        radEquilateral = equilateral.getArea() 
                        / ( 0.5 * equilateral.getPerimeter() );

        if ( radRight < radEquilateral )
        {
            bigger = "equilateral";
            smaller = "right isosceles";
        }

        System.out.println();
        System.out.print( "The " + bigger + " triangle " );
        System.out.println( "holds a larger inscribed circle " );
        System.out.println( "than the " + smaller + " triangle." );
    }
}
/*
 * EquilateralTriangle( 10.0 ): getRatio() = 1.443375672974064 RightTriangle(
 * 10.0 ): getRatio() = 1.4644660940672622
 * 
 * The right isosceles triangle holds a larger inscribed circle than the
 * equilateral triangle.
 */
