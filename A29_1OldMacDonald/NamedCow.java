/**
 * This is an abstraction of a Cow. Call the constructors and pass in the sounds
 * and type.
 * 
 * @author Matt Zhou
 * @version 10/24/16
 * 
 *          Period - 5 Assignment - A29.1 Old MacDonald
 * 
 *          Sources - none
 */
class NamedCow extends Cow
{
    private String name;

    /**
     * Initializes a newly created Cow object so that it represents an Animal
     * of the specified type that makes the specified sound.
     * 
     * @param type
     *            the type of Cow
     * @param sound
     *            the sound the Cow makes
     */
    public NamedCow( String type, String sound )
    {
        super( type, sound );
        this.name = "";
    }
    /**
     * Initializes a newly created Cow object so that it represents an Animal
     * of the specified type that makes the specified sound.
     * 
     * @param type
     *            the type of Cow
     * @param name
     *            the name of Cow
     * @param sound
     *            the sound the Cow makes
     */
    public NamedCow( String type, String name, String sound )
    {
        super( type, sound );
        this.name = name;
    }

    /**
     * Gets the name.
     * 
     * @return name The name
     */
    public String getName()
    {
        return name;
    }

}
