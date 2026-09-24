package rock_paper_surprise;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
/**
 * // -------------------------------------------------------------------------
/**
 *  test class for the Player class
 * 
 *  @author Anna Kinney (annak06)
 *  @version Sep 23, 2026
 */
public class PlayerTest
{

    
    //~ Fields ................................................................
    
    private Player player;

    //~ Constructors ..........................................................
    /**
     * set up method for test class
     */
    @Before
    public void setUp()
    {
        Player player = new Player("claire");
    }
    //~Public  Methods ........................................................
    /**
     * tests getUsername method
     */
    @Test
    public void testGetUsername()
    {
        assertEquals("claire", player.getUsername());
    }
    
    /**
     * tests getLives method
     */
    @Test
    public void testGetLives()
    {
        assertEquals(3, player.getLives());
    }
    
    /**
     * tests setLives method
     */
    @Test
    public void testSetLives()
    {
        player.setLives(5);
        assertEquals(5, player.getLives());
    }
    
    /**
     * tests getScore method
     */
    @Test 
    public void testGetScore()
    {
        assertEquals(0, player.getScore());
    }
    
    /**
     * tests set score method
     */
    @Test
    public void testSetScore()
    {
        player.setScore(100);
        assertEquals(100, player.getScore());
    }
    
    /**
     * tests to toString method
     */
    @Test
    public void testToString()
    {
        assertEquals("claire's Highscore: 0", player.toString());
    }
}
