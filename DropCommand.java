/**
 * The player gets an item out of his bag and drops it in to the room.
 * 
 * @author Anthony Barker
 * @version 11.26.2020
 */
public class DropCommand extends Command
{
    private Player player;

    /**
     * Constructor for objects of class DropCommand
     */
    public DropCommand(Player player)
    {
        this.player = player;
    }

    public void execute()
    {
        if (!hasSecondWord()) {
            System.out.println("Drop what");
            return;
        }     
        
        Item item = player.dropItem(getSecondWord());
        if (item != null) {
            Room room = player.getRoom();
            room.addItem(item);
            Command command = new LookCommand(player);
            command.execute();
        }
        else {
            System.out.println("Drop what?");
        }        
    }
}