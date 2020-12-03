/**
 * A room that beams the player to a random location in the game
 * if he tries to leave it.
 * 
 * @author Anthony Barker
 * @version 11.27.2020
 */
public class TransporterRoom extends Room
{    
    private RoomRandomizer randomizer;
    
    public TransporterRoom(String description, RoomRandomizer randomizer)
    {
        super(description);
        this.randomizer = randomizer;
    }
    
    /**
     * @return a random room independent of the direction
     * parameter. If there are no rooms to choose from return
     * the exit found at this direction.
     * @param direction used when cannot find a random room to go to.
     */
    public Room getExit(String direction)
    {
        Room nextRoom = exits.get(direction);
        if (nextRoom == null) {
            // Make sure the player tries to exit the room
            // using an exit that actually exists.
            return null;
        }
        
        Room randomRoom = randomizer.findRandomRoom();
        if (randomRoom != null) {
            return randomRoom;  // Transport the player!
        }
        else {
            return nextRoom;    // Move to the direction as usual.
        }
    }
}
