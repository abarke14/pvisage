/**
 * Try to unlock a room. If the key to the room's door is
 * not in the player's bag print an error message.
 * 
 * @author Anthony Barker
 * @version 11.26.2020
 */
public class UnlockCommand extends Command
{
    private Player player;

    /**
     * Constructor for objects of class UnlockCommand
     */
    public UnlockCommand(Player player)
    {
        this.player = player;
    }

    public void execute()
    {   
        Room nextRoom = player.getRoom().getExit(getSecondWord());
        if (nextRoom == null) {
            System.out.println("Which door are you unlocking?");
        }
        else {
            if (nextRoom.open(null)) {
                System.out.println("The door seems to be already open.");
                return;
            }
            
            Item roomKey = nextRoom.getKey();
            boolean unlocked = nextRoom.open(player.getItem(roomKey.getName()));
            if (unlocked) {
                System.out.println("You unlock the door.");
            }
            else {
                System.out.println("That key doesn't fit.");
            }
        }        
    }    
}
