/**
 * This is an abstraction of a Chick. It can randomly choose a sound. Call the
 * constructors and pass in the sounds and type.
 * 
 * @author Matt Zhou
 * @version 10/24/16
 * 
 *          Period - 5 Assignment - A29.1 Old MacDonald
 * 
 *          Sources - none
 */
class Chick implements Animal
{

    private String myType;

    private String mySound;

    private String myOtherSound;


    /**
     * Initializes a newly created Chick object so that it represents an Animal
     * of the specified type that makes the specified sound.
     * 
     * @param type
     *            the type of Chick
     * @param sound
     *            the sound the Chick makes
     */
    public Chick( String type, String sound )
    {
        myType = type;
        mySound = sound;
    }


    /**
     * Initializes a newly created Chick object so that it represents an Animal
     * of the specified type that makes the specified sound.
     * 
     * @param type
     *            the type of Chick
     * @param sound1
     *            the sound the Chick makes
     * 
     * @param sound2
     *            the sound the Chick can make
     */
    public Chick( String type, String sound1, String sound2 )
    {
        myType = type;
        mySound = sound1;
        myOtherSound = sound2;
    }


    /**
     * Gets the sound.
     * 
     * @return sound The sound
     */
    public String getSound()
    {
        String sound;
        double randomChoice = Math.random();
        if ( randomChoice < 0.5 )
        {
            sound = mySound;
        }
        else
        {
            sound = myOtherSound;
        }
        return sound;

    }

    /**
     * Gets the type.
     * 
     * @return myType The type
     */
    public String getType()
    {
        return myType;
    }
}