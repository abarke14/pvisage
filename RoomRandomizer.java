import java.util.ArrayList;
import java.util.Random;

/**
 * Find a random Room from a given collection of rooms.
 * 
 * @author Anthony Barker
 * @version 11.23.2020
 */
public class RoomRandomizer
{
    private ArrayList<Room> rooms;
    private Random randomGenerator;
    
    /**
     * Constructor for objects of class RoomRandomizer
     */
    public RoomRandomizer()
    {
        rooms = new ArrayList<Room>();
        randomGenerator = new Random();
    }

    /**
     * Add a Room to the collection of rooms.
     * @param room The room to add.
     */
    public void addRoom(Room room)
    {
        rooms.add(room);
    }
    
    /**
     * @return a random room from a given collection of
     * rooms in the game or null if there are no rooms to 
     * choose from.
     */
    public Room findRandomRoom()
    {
        if (rooms.size() == 0) {
            return null;
        }
        
        int index = randomGenerator.nextInt(rooms.size());
        return rooms.get(index);
    }
}