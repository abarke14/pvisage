
/**
 * Try to go back to the room you came from.
 * 
 * @author Anthony Barker
 * @version 11.27.2020
 */
public class BackCommand extends Command
{
    private Player player;
    
    /**
     * Constructor for objects of class BackCommand
     */
    public BackCommand(Player player)
    {
        this.player = player;
    }

    public void execute()
    {
        if (player.goBack()) {
            Command command = new LookCommand(player);
            command.execute();
        }
        else {
            System.out.println("Go back to where?");
        }        
    }
}