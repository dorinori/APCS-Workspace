import java.util.*;

/**
 * RPN Calculator
 *
 * @author Matt Zhou
 * @version 1/13/17
 * @author Period: 5
 * @author Assignment: AB31RPN Calculator
 *
 * @author Sources: none
 */
public class RPN
{
    Scanner scan = new Scanner( System.in );
    
    private Stack<Integer> myStack;
    private Queue<String> myQ;

    /**
     * Constructs an RPN Calculator
     */
    public RPN()
    {
        myStack = new Stack<Integer>();
        myQ = new LinkedList<String>();
    }
    
    /**
     *  **** Used for testing - Do Not Remove ***
     *  
     *  Constructs an RPN Calculator and then redirects the Scanner input
     *  to the supplied string.
     *  
     *  @param console  replaces console input
     */
    public RPN(String console)
    {
        this();
        scan = new Scanner( console );
    }


    public void calculate()
    {
        while ( scan.hasNext() ){
            String str = scan.next();

            for (int i =0; i < str.length(); i++){  
                char c = str.charAt( i );
                switch (c) {
                    case 'Q':         
                    System.out.print( returnString() );
                    break;
                    
                    case 'q':         
                    System.out.print( returnString() );
                    break;

                    case '/':
                        divide();
                        break;
                        
                    case '+':
                        add();
                        break;
                        
                    case '-':
                        subtract();
                        break;
                        
                    case '*':
                        multiply();
                        break;
                        
                    default: myStack.push( Character.getNumericValue(c) );
                             break;
                }
                myQ.add( c + "" );
            }
        }
    }

    
    private void add()
    {
       myStack.push( myStack.pop() + myStack.pop() );
    }
    
    private void subtract()
    {
        myStack.push( -myStack.pop() + myStack.pop() );
    }
    
    private void multiply()
    {
        myStack.push( myStack.pop() * myStack.pop() );
    }
    
    private void divide()
    {
        int top = myStack.pop();
        int next = myStack.pop();   
        myStack.push( next / top );
    }
    
    private String returnString()
    {
        String print = "";
        while ( !myQ.isEmpty() )
        {
            print += myQ.remove() + " ";
        }
        
        print += "= " + myStack.pop();
        return print;
    }
    
    
    /**
     * Instantiates an RPN Calculator and invokes it calculate method
     * 
     * @param args  command-line arguments (not used)
     */
    public static void main( String[] args )
    {
        RPN rpn = new RPN();
        rpn.calculate();
    }
}