/**
 * Decoration is an item that can be found in a room. A player
 * can look at decoration but cannot pick it up regardless of its
 * weight, which is ignored.
 * 
 * @author Anthony Barker
 * @version 11.23.2020
 */
public class Decoration extends Item
{
    /**
     * Constructor for objects of class Decoration
     */
    public Decoration(String name, String description)
    {
        super(name, description, 0);
    }

    public boolean canBePickedUp()
    {
        return false;
    }
    
    /**
     * @return the name of this item long with its description.
     */
    public String getLongDescription()
    {
        return "This " + name + " is " + description + ".";
    }
}