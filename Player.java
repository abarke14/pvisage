import java.util.HashMap;
import java.util.Set;
import java.util.Map;
import java.util.Iterator;
import java.util.Stack;

/**
 * Represents a player who is moving through the game rooms and
 * carries a number of items up to a certain weight. As the player
 * moves from room to room his path is stored so he can go back to
 * where he came from.
 * 
 * @author Anthony Barker
 * @version 11.27.2020
 */
public class Player
{
    private String name;
    private Room currentRoom;
    private Stack<Room> rooms;
    private HashMap<String, Item> items;
    private Room chargedRoom;
    
    // the player can carry items up to 9999kg max.
    private int maxWeight = 9999;
    
    // player stats
    //int hitPoints;
    
    // player sanity
    
    
    //public Player(String name) {
    //this.hitPoints = 10;
    //}
    
    
    /**
     * Constructor for objects of class Player
     */
    public Player(String name, Room room)
    {
        this.name = name;
        currentRoom = room;
        rooms = new Stack<Room>();
        items = new HashMap<String, Item>();
    }

    /**
     * @return the name of this player.
     */
    public String getName()
    {
        return name;
    }
    
    /**
     * @return the room that the player is currently in.
     */
    public Room getRoom()
    {
        return currentRoom;
    }
    
    /** 
     * @return the item in the player's bag with the given name. If
     * no item with this name exists return null.
     * @param name The name of the item to return.
     */
    public Item getItem(String name)
    {
        return items.get(name);
    }
    
    /**
     * Move the player to a room. The room that the player was
     * currently in is stored in his path.
     * @param room The room to move the player in to.
     */
    public void goRoom(Room room)
    {
        rooms.push(currentRoom);
        currentRoom = room;
    }
    
    /**
     * Move this player to the room he was previously in. 
     * @return True if the player can move back or false if the 
     * player is at the room where he started the game.
     */
    public boolean goBack()
    {
        if (rooms.empty()) {
            return false;
        }
    
        currentRoom = rooms.pop();
        return true;
    }
    
    /**
     * Pick up an item and put it the player's bag. If the item's
     * weight makes the bag too heavy for the player to carry it
     * is not put into the bag.
     * @param name The the item to put into the bag.
     * @return True if the item is put into the bag or false if not.
     */
    public boolean pickUpItem(Item item)
    {
        if (!canTake(item)) {
            return false;
        }
        
        items.put(item.getName(), item);
        return true;
    }

    /**
     * Drop an item from the bag in to the current room.
     * @param name The name of the item to drop.
     * @return the item that was dropped from the bag.
     */
    public Item dropItem(String name)
    {
        Item item = getItem(name);
        if (item != null) {
            items.remove(name);
        }
        
        return item;
    }
   
    /**
     * @return true if the item can be picked up and there  
     * is enough space in the bag for it or false if not.
     */
    private boolean canTake(Item item)
    {
        int newWeight = getCurrentWeight() + item.getWeight();
        return ((newWeight <= maxWeight) && (item.canBePickedUp()));
    }
    
    /**
     * @return the total weight of all items currently in the bag.
     */
    private int getCurrentWeight()
    {
        int total = 0;
        Iterator it = items.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry)it.next();
            total += ((Item)entry.getValue()).getWeight();
        }
        return total;
    }
    
    public void setChargedRoom()
    {
        if (getItem("Beamer") == null)
            return;
        
        if (!(chargedRoom == null))
        {
            System.out.println("The beamer is storing the memory of the room!");
            return;
        }
        
        chargedRoom = currentRoom;
    }
    
    public void activate()
    {
        if (chargedRoom == null)
        {
            System.out.println("The beamer needs to mirror a room first.");
            return;
        }
        
        currentRoom = chargedRoom;
    }
    
    /**
     * @return a list of all items that this player carries in 
     * his bag, their total weight and how much more the bag can
     * carry in kg.
     */
    public String getItemString()
    {
        String returnString = "Items in your bag: ";
        Set<String> keys = items.keySet();
        for(String name : keys) {
            returnString += " " + name;
        }
                
        int currentWeight = getCurrentWeight();
        int freeWeight = maxWeight-currentWeight;
        returnString += ".\nYour bag weighs " + (currentWeight/1000.0) + "kg. " +
                        "There is room for " + (freeWeight/1000.0) + " more kg.";
        
        return returnString;
    }
}
