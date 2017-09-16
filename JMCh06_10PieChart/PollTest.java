/**
 * PollTest tests the Poll.
 *
 * @author Matt Zhou
 * @version 9/8/16
 * @author Period: 5
 * @author Assignment: JMCh06_10PieChart
 *
 * @author Sources: none
 */
public class PollTest
{
    /**
     * Tests the Poll.
     * 
     * @param args
     *            command-line arguments (not used)
     */
    public static void main( String[] args )
    {
        PollDisplayPanel votingMachine = 
                        new PollDisplayPanel( "Tami", "Brian", "Liz" );
        votingMachine.vote1();
        votingMachine.vote2();
        votingMachine.vote2();
        System.out.println( votingMachine );
    }
}
