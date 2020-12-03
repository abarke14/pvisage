import java.util.HashMap;
import java.util.Set;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * Represents one location in the scenery of the game. A Room can
 * have exits. For each exit a reference to the neighboring room is
 * stored. Also, an arbitrary number of items and characters can be 
 * found in a Room.
 * 
 * @author Anthony Barker
 * @version 11.20.2020
 */
public class Room
{
    private String description;
    protected HashMap<String, Room> exits;
    private ArrayList<Item> items;
    private ArrayList<Character> characters;
    
    /**
     * Constructor for objects of class Room
     */
    public Room(String description)
    {
        this.description = description;
        exits = new HashMap<String, Room>();
        items = new ArrayList<Item>();
        characters = new ArrayList<Character>();
    }

    /**
     * Define the exits of this room. Every direction leads to
     * another room or is null.
     */
    public void setExits(Room north, Room east, Room south, Room west)
    {
        if (north != null)
            exits.put("north", north);
        if (east != null)
            exits.put("east", east);
        if (south != null)
            exits.put("south", south);
        if (west != null)
            exits.put("west", west);
    }
    
    /**
     * Define an exit from this room. 
     * @param direction The direction of the exit.
     * @param neighbor The room in the given direction.
     */
    public void setExit(String direction, Room neighbor)
    {
        exits.put(direction, neighbor);
    }
  
    /**
     * Place an item into this room.
     */
    public void addItem(Item item)
    {
        items.add(item);
    }
    
    /**
     * Remove an item from the room.
     */
    public void removeItem(Item item)
    {       
        items.remove(item);
    }
    
    /**
     * @return the item with the given name. If no item with 
     * this name exists return null.
     * @param name The name of the item to return.
     */
    public Item getItem(String name)
    {
        for(Item item : items) {
            if(item.getName().equals(name)) {
                return item;
            }
        }
        
        // if we get to this point no item with this name exists.
        return null;
    }
    
    /**
     * Place a character in the room.
     */
    public void addCharacter(Character character)
    {
        characters.add(character);
    }
       
    /**
     * @return the character with the given name. If no character 
     * with this name exists return null.
     * @param name The name of the character to return.
     */
    public Character getCharacter(String name)
    {
        for(Character character : characters) {
            if(character.getName().equals(name)) {
                return character;
            }
        }
        
        // if we get to this point no character with this name exists.
        return null;
    }
       
    /**
     * Try to open the room's door.
     * @param key The key to open the door with. Ignored.
     * @return true. 
     */
    public boolean open(Item key)
    {
        return true;
    }
    
    /**
     * @return the key required to open the room's door or
     * null if no key is needed.
     */
    public Item getKey()
    {
        return null;
    }
    
    /**
     * @return the description of the room.
     */
    public String getDescription()
    {
        return description;
    }
    
    /**
     * @return the descriptions of the room along with its exits,
     * items and characters that are inside the room.
     */
    public String getLongDescription()
    {
        return "You are " + description + ".\n" + getCharacterString() +
               ".\n" + getExitString() + "\n" + getItemString();
    }
    
    /**
     * Get the room that an exit leads to.
     * @param direction The direction we want to move to.
     * @return The room found at this direction or null if the
     * direction is invalid.
     */
    public Room getExit(String direction)
    {
        return exits.get(direction);
    }
    
    /**
     * Return a description of the room's exits, 
     * for example "Exits: north west".
     * @return A description of the room's available exits.
     */
    public String getExitString()
    {
        String returnString = "Exits: ";
        Set<String> keys = exits.keySet();
        for(String exit : keys) {
            returnString += " " + exit;
        }
        return returnString;
    }
    
    /**
     * @return a list of all items found in the room as a String.
     */
    public String getItemString()
    {
        String returnString = "Items: ";
        for(Item item : items) {
            returnString += " " + item.getName();
        }
        return returnString;
    }
    
    /**
     * @return a list of all characters found in the room as a String.
     * If nobody is in the room return an appropriate message.
     */
    public String getCharacterString()
    {
        if (characters.size() == 0) {
            return "There's noone else in here, you breathe a sigh of relief.";
        }
        
        String returnString = "Someone, or something, is in here: ";                
        for(Character character : characters) {
            returnString += " " + character.getName();
        }
        return returnString;        
    }
}