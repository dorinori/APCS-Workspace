import java.util.*;


/**
 * This is a mail server.
 * 
 * Represents mail coming in and out to from the actors. Has a couple methods,
 * use them to send mail.
 * 
 * @author Matt Zhou
 * @version 1/19/17
 * 
 * @author Period - 5
 * @author Assignment - ActorsWorld
 * 
 * @author Sources - none
 */
public class MailServer extends LinkedList<Message>
{
    private Set<Actor> actors;
    
    
    public MailServer()
    {
        actors = new TreeSet<Actor>();
    }
 
    public void signUp( Actor actor )
    {
        actors.add( actor );
    }
 
 
    public void dispatch( Message msg )
    {
        if ( msg.getRecipient() == null )
        {
            for ( Actor actor : actors )
            {
                actor.receive( msg );
            }
        }
        else
        {
            msg.getRecipient().receive( msg );
        }
    }
    
    
    // for testing purposes only
    protected Set<Actor> getActors()
    {
        return actors;
    }
}
