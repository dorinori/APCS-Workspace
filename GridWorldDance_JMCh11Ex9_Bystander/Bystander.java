/**
 * This is a bystander class.
 * It extends RightShoe so it's a subclass.  It makes a bystander 
 * dancer that just stands in the corner and turns 45 degrees every so often.
 * 
 * @author Matt Zhou
 * @version 10/14/16
 * 
 * @author Period - 5
 * @author Assignment - Ch 11, Ex9 - GridWorld Dance - Bystander
 * 
 * @author Sources - none
 */
public class Bystander extends RightShoe
{
    /**
     * Moves bystander
     * @param dance - The dance
     */
    public void learn( Dance dance )
    {
        setSteps( "-1 -7 " );
    }
}
