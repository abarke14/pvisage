/**
 * Print out some help information and a list of the command words.
 * 
 * @author Anthony Barker
 * @version 11.20.2020
 */
public class HelpCommand extends Command
{
    private CommandWords commands;
    
    /**
     * Constructor for objects of class HelpCommand
     */
    public HelpCommand(CommandWords commands)
    {
        this.commands = commands;
    }

    public void execute()
    {
        System.out.println("You are lost. You are alone. You wander");
        System.out.println("around at the university.");
        System.out.println();
        System.out.println("Your command words are:");
        System.out.println(commands.getCommandsString());        
    }
}
