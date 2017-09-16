/**
 * This is an abstraction of a Pig. Call the constructors and pass in the sounds
 * and type.
 * 
 * @author Matt Zhou
 * @version 10/24/16
 * 
 *          Period - 5 Assignment - A29.1 Old MacDonald
 * 
 *          Sources - none
 */
class Pig implements Animal
{
    private String myType;

    private String mySound;


    /**
     * Initializes a newly created Pig object so that it represents an Animal 
     * of the specified type that makes the specified sound.
     * 
     * @param type
     *            the type of Cow
     * @param sound
     *            the sound the Cow makes
     */
    public Pig( String type, String sound )
    {
        myType = type;
        mySound = sound;
    }


    /**
     * Gets the sound.
     * 
     * @return sound The sound
     */
    public String getSound()
    {
        return mySound;
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