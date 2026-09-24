package rock_paper_surprise;


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
        Option rock = new Option("rock", "normal"); 
        assertEquals("rock", rock.getName()); 
    }
    
    /**
     * tests the getType method
     */
    @Test
    public void testGetType()
    {
        Option rock = new Option("rock", "normal"); 
        assertEquals("nomral", rock.getType());
    }
    
    /**
     * tests rock wins against scissors
     */
    @Test
    public void testFightRockWins()
    {
        Option rock = new Option("rock", "normal");
        Option scissors = new Option("scissors", "normal");
       
        assertEquals(1, rock.fight(scissors));
    }
    
    /**
     * tests rock loses against paper
     */
    @Test
    public void testFightRockLoses()
    {
        Option rock = new Option("rock", "normal");
        Option paper = new Option("paper", "norma");
        
        assertEquals(-1, rock.fight(paper));
    }
    
    /**
     * tests tie outcome
     */
    @Test
    public void testFightTie()
    {
        Option rock = new Option("rock", "normal");
        Option rocky = new Option("rock", "normal");
        
        assertEquals(0, rock.fight(rocky));
    }
    
    /**
     * tests against invalid option 
     */
    @Test
    public void testFightInvalidOption()
    {
        Option rock = new Option("rock", "normal");
        Option invalid = new Option("banana", "normal");
        
        assertEquals(-1, rock.fight(invalid));
    }
    
}
