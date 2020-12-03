/**
 * Try to go to one direction. If there is an exit, enter
 * the new room, otherwise print an error message;
 * 
 * @author Anthony Barker
 * @version 11.26.2020
 */
public class GoCommand extends Command
{
    private Player player;

    /**
     * Constructor for objects of class GoCommand
     */
    public GoCommand(Player player)
    {
        this.player = player;
    }

    public void execute()
    {
        if (!hasSecondWord()) {
            // if there is no second word, we don't know where to go...
            System.out.println("Go where?");
            return;            
        }      
        
        String direction = getSecondWord();

        // Try to leave current room.
        Room nextRoom = player.getRoom().getExit(direction);

        if (nextRoom == null) {
            System.out.println("There is no door!");
        }
        else {
            if (nextRoom.open(null)) {
                player.goRoom(nextRoom);
                System.out.println(player.getRoom().getLongDescription());
                System.out.println();
            }
            else {
                System.out.println("This door is locked!");
            }
        }        
    }
}