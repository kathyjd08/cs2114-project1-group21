package rock_paper_surprise;

import java.util.*;
import java.io.*;

/**
 * // -------------------------------------------------------------------------
 * /** Player class
 * 
 * @author Anna Kinney (annak06)
 * @version Sep 18, 2026
 */
public class Player
{
    // ~ Fields ................................................................
    private String username;
    private int lives;
    private int score;
    private Player player;
    // ~ Constructors ..........................................................

    /**
     * Player class constructor for game method
     * 
     * @param username
     *            username of the player
     */
    public Player(String username)
    {
        this.username = username;
        this.lives = 3;
        this.score = 0;

        Score s = new Score();
        ArrayList<Player> players = s.players;

        for (int i = 0; i < players.size(); i++)
        {
            if (username.equals(players.get(i).getUsername())
                && players.get(i).getLives() != 0)
            {
                player = players.get(i);
                players.remove(i);
            }
        }

    }


    /**
     * Player class constructor for game method, unable to be called from main
     * class, only used in file read/write in Score class (By Kathryn Dedrick)
     * 
     * @param user
     *            username of the player
     * @param l
     *            lives of the player
     * @param s
     *            score of the player
     */
    public Player(String user, int l, int s)
    {
        this.lives = l;
        this.score = s;
        this.username = user;
    }

    // ~Public Methods ........................................................


    /**
     * gets the username of the player
     * 
     * @return username
     */
    public String getUsername()
    {
        return username;
    }


    /**
     * updates the lives for the player
     * 
     * @param lives
     */
    public void setLives(int lives)
    {
        this.lives = lives;
    }


    /**
     * gets the lives of the player
     * 
     * @return score
     */
    public int getLives()
    {
        return lives;
    }


    /**
     * updates the score of the player
     * 
     * @param score
     */
    public void setScore(int score)
    {
        this.score = score;
    }


    /**
     * gets the score of the player
     * 
     * @return score
     */
    public int getScore()
    {
        return score;
    }


    /**
     * highscore string
     * 
     * @returns string of username and score
     */
    public String toString()
    {
        return username + "'s " + "Highscore: " + score;
    }
}
