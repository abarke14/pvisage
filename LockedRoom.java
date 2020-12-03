/**
 * A room that is locked and can be unlocked with a key.
 * 
 * @author Anthony Barker 
 * @version 11.24.2020
 */
public class LockedRoom extends Room
{
    private boolean locked;
    private Item key;
    
    /**
     * Constructor for objects of class LockedRoom
     */
    public LockedRoom(String description, Item key)
    {
        super(description);
        locked = true;
        this.key = key;
    }
   
    /**
     * @return the key required to open the room's door.
     */
    public Item getKey()
    {
        return key;
    }
    
    /**
     * Try to open the room with the given key.
     * @param key The key to open the door with.
     * @return true if the room is opened or false if it isn't.
     */
    public boolean open(Item key)
    {
        if (!locked) {
            return true;    // this door is already open
        }
        else {
            if (this.key==key) {            
                locked = false;
            }                
            return !locked;
        }
    }    
}