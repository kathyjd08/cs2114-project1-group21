package rock_paper_surprise;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import java.io.*;

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
        player = new Player("claire");
    }
    //~Public  Methods ........................................................
    /**
     * tests invalid username
     */
    @Test
    public void testUsernameWithComma()
    {
        assertThrows(IllegalArgumentException.class,
        () -> new Player("claire,smith"));
    }
    /**
     * tests null usernames
     */
    @Test
    public void testNullUsername()
    {
        assertThrows(IllegalArgumentException.class,
        () -> new Player(null));
    }
    /**
     * tests empty usernames
     */
    @Test
    public void testEmptyUsername()
    {
        assertThrows(IllegalArgumentException.class,
        () -> new Player(""));
    }
    /**
     * tests white space usernames
     */
    @Test
    public void testWhitespaceUsername()
    {
        assertThrows(IllegalArgumentException.class,
        () -> new Player(" "));
    }
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
