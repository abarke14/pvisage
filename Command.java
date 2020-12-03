/**
 * Represents a two-words game command. A command currently consists
 * of two parts: a CommandWord and a string. If the command has only 
 * one word then the second string is null.
 * 
 * @author Anthony Barker
 * @version 11.24.2020
 */
public abstract class Command
{
    private String secondWord;

    /**
     * Set the second string of the command.
     */
    public void setSecondWord(String word)
    {
        secondWord = word;
    }
    
    /**
     * @return The second word of this command. Returns null if 
     * there is no second word.
     */
    public String getSecondWord()
    {
        return secondWord;
    }
      
    /**
     * @return true if the command has a second word.
     */
    public boolean hasSecondWord()
    {
        return (secondWord != null);
    }
    
    abstract public void execute();
}