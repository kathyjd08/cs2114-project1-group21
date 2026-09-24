package rock_paper_surprise;
/**
 * // -------------------------------------------------------------------------
/**
 *  Option class
 * 
 *  @author Anna Kinney (annak06)
 *  @version Sep 23, 2026
 */
public class Option
{
    //~ Fields ................................................................
    private String name;
    private String type;
    //~ Constructors ..........................................................
    
    /**
     * option class constructor 
     * types ex. normal or surprise
     * @param name of option
     * @param type of option
     */
    public Option(String name, String type)
    {
        this.name = name;
        this.type = type;
    }
    
    //~Public  Methods ........................................................
 
    /**
     * getter for option name
     * @return name of option
     */
    public String getName()
    {
        return name;
    }
    /**
     * getter for option type
     * @return type of option
     */
    public String getType()
    {
        return type;
    }
    
    // ----------------------------------------------------------
    /**
     * fight method, determines if player wins or loses
     * @param pc
     * @return integer for the score 
     */
    public int fight(Option pc)
    {
        if (this.name.equals("rock") && pc.getName().equals("scissors"))
        {
            return 1;
        }
        else if (name.equals("paper") && pc.getName().equals("rock"))
        {
            return 1;
        }
        else if (name.equals("scissors") && pc.getName().equals("paper"))
        {
            return 1;
        }
        else if (name.equals(pc.getName()))
        {
            return 0;
        }
        else
        {
            return -1;
        }
    }
    
    
}
