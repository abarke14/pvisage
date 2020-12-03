/**
 * Represents an item that can be found in a room. An item
 * has a name, a description and weight in grams. The player 
 * can only pick up an item whose weight does not exceed his
 * maximum weight capability.
 * 
 * @author Anthony Barker
 * @version 11.22.2020
 */
public class Item
{
    protected String name;
    protected String description;
    private int weight;
    
    /**
     * Constructor for objects of class Item
     */
    public Item(String name, String description, int weight)
    {
        this.name = name;
        this.description = description;
        this.weight = weight;
    }
    
    /**
     * @return the name of this artifact.
     */
    public String getName()
    {
        return name;
    }
    
    /**
     * @return the description of this artifact.
     */
    public String getDescription()
    {
        return description;
    }
    
    /**
     * @return the weight of this artifact in grams.
     */
    public int getWeight()
    {
        return weight;
    }

    public boolean canBePickedUp()
    {
        return true;
    }
    
    /**
     * @return the name of this item along with its description
     * and its weight in kg.
     */
    public String getLongDescription()
    {
        return "This is " + description + " and it weighs " + (weight/1000.0) + " kg.";
    }
}
