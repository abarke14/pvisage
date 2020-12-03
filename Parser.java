import java.util.Scanner;

/**
 * Reads user input and tries to interpret it as a game command.
 * It returns the command as an object of class Command.
 * 
 * @author Anthony Barker
 * @version 11.20.2020
 */
public class Parser
{
    // instance variables - replace the example below with your own
    private Scanner reader;
    private CommandWords commands;
    
    /**
     * Constructor for objects of class Parser
     */
    public Parser()
    {
        commands = new CommandWords();
        reader = new Scanner(System.in);
    }

    /**
     * @return the next command from the user.
     */
    public Command getCommand()
    {
        String word1 = null;
        String word2 = null;
        
        System.out.print("> ");
        String inputLine = reader.nextLine();
        
        // find up to two words on the line.
        Scanner tokenizer = new Scanner(inputLine);
        if (tokenizer.hasNext()) {
            word1 = tokenizer.next();
            if (tokenizer.hasNext()) {
                word2 = tokenizer.next();
                // we ignore the rest of the input line.
            }
        }
        Command command = commands.getCommand(word1);
        command.setSecondWord(word2);
        return command;
    }
    
    /**
     * @return the list of known game commands.
     */
    public CommandWords getCommands()
    {
        return commands;
    }
}
