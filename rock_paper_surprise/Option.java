package rock_paper_surprise;

import java.io.*;

/**
 * // -------------------------------------------------------------------------
 * /** Option class
 * 
 * @author Anna Kinney (annak06)
 * @version Sep 23, 2026
 */
public class Option
{
    // ~ Fields ................................................................
    private String name;
    // ~ Constructors ..........................................................

    /**
     * option class constructor types ex. normal or surprise
     * 
     * @param name
     *            of option
     */
    public Option(String name)
    {

        this.name = name;
    }

    // ~Public Methods ........................................................


    /**
     * getter for option name
     * 
     * @return name of option
     */
    public String getName()
    {
        return name;
    }


  


    // ----------------------------------------------------------
    /**
     * fight method, determines if player wins or loses
     * 
     * @param pc
     * @return integer for the score
     */
    public int fight(Option pc)
    {
        Score score = new Score();
        if (this.name.equals("rock") && pc.getName().equals("scissors"))
        {
            return 1;
        }
        else if (this.name.equals("paper") && pc.getName().equals("rock"))
        {
            return 1;
        }
        else if (this.name.equals("scissors") && pc.getName().equals("paper"))
        {
            return 1;
        }
        else if (this.name.equals(pc.getName()))
        {
            return 0;
        }
        else if(this.name.equals("surprise"))
        {
            return 1;
        }
        else if (this.name.equals("save")) {
            return 2;
        }
        else
        {
            return -1;
        }
    }

}
