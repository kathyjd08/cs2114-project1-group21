package rock_paper_surprise;

import java.io.*;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
/**
 * // -------------------------------------------------------------------------
/**
 *  test class for the Option class
 * 
 *  @author Anna Kinney (annak06)
 *  @version Sep 23, 2026
 */
public class OptionTest
{
    //~ Fields ................................................................


    
    //~ Constructors ..........................................................
    
    //~Public  Methods ........................................................
    /**
     * tests the getName method
     */
    @Test 
    public void testGetName() 
    { 
        Option rock = new Option("rock"); 
        assertEquals("rock", rock.getName()); 
    }
    
       
    /**
     * tests rock wins against scissors
     */
    @Test
    public void testFightRockWins()
    {
        Option rock = new Option("rock");
        Option scissors = new Option("scissors");
       
        assertEquals(1, rock.fight(scissors));
    }
    
    /**
     * tests rock loses against paper
     */
    @Test
    public void testFightRockLoses()
    {
        Option rock = new Option("rock");
        Option paper = new Option("paper");
        
        assertEquals(-1, rock.fight(paper));
    }
    
    /**
     * tests tie outcome
     */
    @Test
    public void testFightTie()
    {
        Option rock = new Option("rock");
        Option rocky = new Option("rock");
        
        assertEquals(0, rock.fight(rocky));
    }
    
    /**
     * tests against invalid option 
     */
    @Test
    public void testFightInvalidOption()
    {
        Option rock = new Option("rock");
        Option invalid = new Option("banana");
        
        assertEquals(-1, rock.fight(invalid));
    }
    
}
