/**
 * Represents an unrecognized command word.
 * 
 * @author Anthony Barker
 * @version 11.26.2020
 */
public class UnknownCommand extends Command
{
    public void execute()
    {
        System.out.println("I don't know what you mean...");
    }
}