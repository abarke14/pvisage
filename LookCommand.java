/**
 * Have a look around the current room or at an item that is 
 * either in the room or in the player's bag.
 * 
 * @author Anthony Barker
 * @version 11.26.2020
 */
public class LookCommand extends Command
{
    private Player player;
    
    /**
     * Constructor for objects of class LookCommand
     */
    public LookCommand(Player player)
    {
        this.player = player;
    }

    public void execute()
    {
        if (!hasSecondWord()) {
            // look around the room
            System.out.println(player.getRoom().getLongDescription());
            System.out.println();                    
            return;
        }
        
        String name = getSecondWord();
        
        boolean found = lookItemInRoom(name);       // look at the room
        if (!found) {
            found = lookItemInBag(name);            // look in the bag
            if (!found) {
                found = lookCharacterInRoom(name);  // look character
            }
        }
        
        if (!found) {
            System.out.println("Look what?");
        }
    }
    
    /**
     * Look at the room for an item with the given name and
     * show its description.
     * @return true if the item is found or false if it's not.
     */
    private boolean lookItemInRoom(String name)
    {
        Item item = player.getRoom().getItem(name);
        if (item != null) {
            System.out.println(item.getLongDescription());
            return true;
        }
        else {
            return false;
        }
    }
    
    /**
     * Look at the player's bag for an item with the given
     * name and show its description.
     * @return true if the item is found or false if it's not.
     */
    private boolean lookItemInBag(String name)
    {
        Item item = player.getItem(name);
        if (item != null) {
            System.out.println(item.getLongDescription());
            return true;
        }
        else {
            return false;
        }
    }
    
    /**
     * Look at a character with the given name and show
     * its description.
     * @return true if the character is found or false if it's not.
     */
    public boolean lookCharacterInRoom(String name)
    {
        Character c = player.getRoom().getCharacter(name);
        if (c != null) {
            System.out.println(c.getLongDescription());
            return true;
        }
        else {
            return false;
        }        
    }
}
