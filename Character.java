/**
 * Represents a character who can be found in a room. A character
 * speaks some text when the player first meets him, and may give
 * the player some help if given the right item.
 * 
 * @author Anthony Barker
 * @version 11.25.2020
 */
public class Character
{
    private String name;
    private String text;
    private Item token;
    private String help;
    private boolean canHelp;
    
    /**
     * Constructor for objects of class Character
     */
    public Character(String name, String text)
    {
        this.name = name;
        this.text = text;
        this.token = null;
    }

    /**
     * Help can be offered when the right item is given to this character.
     * @param token The item this character needs.
     * @param help The help to be offered.
     */
    public void setToken(Item token, String help)
    {
        this.token = token;
        this.help = help;
    }
    
    /**
     * @return the name of this character.
     */
    public String getName()
    {
        return name;
    }
    
    /**
     * @return the text this character speaks.
     */
    public String getText()
    {
        return text;
    }
    
    /**
     * @return the item this character needs.
     */
    public Item getToken()
    {
        return token;
    }
    
    /**
     * @return the name and the text of this character.
     */
    public String getLongDescription()
    {
        return name + " says '" + text + "'.";        
    }    
    
    /**
     * Offer some help to the player if the right item is
     * given.
     * @param item The item to give to the character.
     * @return the help text offered by this character.
     */
    public boolean help(Item item)
    {
        if ((token != null) && (token==item)) {
            text = help;
            token = null;
            return true;
        }
        return false;
    }
}