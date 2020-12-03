import java.util.HashMap;

/**
 * Holds a list of command words known to the game.
 * 
 * @author Anthony Barker
 * @version 11.28.2020
 */
public class CommandWords
{
    // A mapping between a command word and the Command
    // associated with it.
    private HashMap<String, Command> commands;

    /**
     * Constructor for objects of class CommandWords
     */
    public CommandWords()
    {
        commands = new HashMap<String, Command>();
    }

    /**
     * Associate a command word with a Command object.
     */
    public void addCommand(String word, Command command)    
    {
        commands.put(word, command);
    }
    
    /**
     * Check whether a given string is a valid command word.
     * @return true if it is, false if it isn't.
     */
    public boolean isCommand(String aString)
    {
        return commands.containsKey(aString);
    }
    
    /**
     * Find the Command associated with a command word.
     * @return The Command corresponding to the command word
     * or UnknownCommand if it is not a valid command word.
     */
    public Command getCommand(String commandWord)
    {
        Command command = commands.get(commandWord);
        if (command != null) {
            return command;
        }
        else {
            return new UnknownCommand();
        }
    }
    
    /**
     * @returns the list of known commands as a string.
     */
    public String getCommandsString()
    {
        String returnString = "";
        for(String command : commands.keySet()) {
            returnString += command + " ";
        }
        return returnString;
    }    
}