/**
 * Print all items currently carried by the player and 
 * their total weight.
 * 
 * @author Anthony Barker
 * @version 11.25.2020
 */
public class ItemsCommand extends Command
{
    private Player player;
    
    /**
     * Constructor for objects of class ItemsCommand
     */
    public ItemsCommand(Player player)
    {
        this.player = player;
    }

    public void execute()
    {
        System.out.println(player.getItemString());
        System.out.println();        
    }
}
