/**
 * The player picks and item from the room and puts it
 * in his bag. If the item is not in the room or it is 
 * too heavy for the player to carry print an error message.
 * 
 * @author Anthony Barker
 * @version 11.27.2020
 */
public class TakeCommand extends Command
{
    private Player player;

    /**
     * Constructor for objects of class TakeCommand
     */
    public TakeCommand(Player player)
    {
        this.player = player;
    }

    public void execute()
    {
        if (!hasSecondWord()) {
            System.out.println("Take what");
            return;
        }
        
        Room room = player.getRoom();
        Item item = room.getItem(getSecondWord());
        if (item != null) {
            if (player.pickUpItem(item)) {
                // the item is no longer in the room
                room.removeItem(item);
                Command command = new ItemsCommand(player);
                command.execute();
            }
            else {
                System.out.println("You cannot possibly pick this up!");
            }
        }
        else {
            System.out.println("Take what?");
        }        
    }
}
