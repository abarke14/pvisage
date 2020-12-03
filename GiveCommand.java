/**
 * Give an item to a character. Some characters can provide the
 * player with some help if given the right item.
 * 
 * @author Anthony Barker
 * @version 11.27.2020
 */
public class GiveCommand extends Command
{
    private Player player;

    /**
     * Constructor for objects of class GiveCommand
     */
    public GiveCommand(Player player)
    {
        this.player = player;
    }

    public void execute()
    {
        if (!hasSecondWord()) {
            System.out.println("Give what?");
            return;
        }
        
        Character character = player.getRoom().getCharacter(getSecondWord());
        if (character != null) {
            Item token = character.getToken();
            if (token != null) {
                Item item = player.getItem(token.getName());
                if (item != null) {
                    boolean helped = character.help(item);
                    if (helped) {
                        player.dropItem(item.getName());
                    } 
                    System.out.println(character.getLongDescription());
                }
                else {
                    System.out.println("You don't have " + token.getName());
                }
            }
        }
        else {
            System.out.println("Give to whom?");            
        }        
    }
}
