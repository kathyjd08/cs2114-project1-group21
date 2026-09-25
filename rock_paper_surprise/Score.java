package rock_paper_surprise;

import java.util.*;
import java.io.*;

/**
 * This class reads and writes the save file of scores and keeps track of player
 * progress.
 * 
 * @author Kathryn Dedrick
 * @version Sept. 2026
 */
public class Score
{
    // ~ Fields ................................................................
    public ArrayList<Player> players = new ArrayList<>();
    private String user;
    private int score;
    private int lives;
    private File playerRecords = new File("playerRecords.txt");
    /**
     * This method is run first to gather the player data from the text file.
     */
    public void initialize()
    {
        try
        {
            BufferedReader reader =
                new BufferedReader(new FileReader(playerRecords));
            String line = reader.readLine();
            while (line != null)
            {
                String[] records = line.split(",");
                int lives = Integer.parseInt(records[1]);
                int score = Integer.parseInt(records[2]);
                Player temp = new Player(records[0], lives, score);
                players.add(temp);
                line = reader.readLine();
            }
            reader.close();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
    /**
     * This method is returns the top three players from the ArrayList
     */

    public ArrayList<Player> getTopThree()
    {
        ArrayList<Player> sorted = new ArrayList<Player>(players);

        sorted.sort((p1, p2) -> Integer.compare(p2.getScore(), p1.getScore()));
        ArrayList<Player> temp = new ArrayList<>();
        temp.add(sorted.get(0));
        temp.add(sorted.get(1));
        temp.add(sorted.get(2));
        return temp;
    }
    /**
     * This method saves the current player's data to the file.
     */

    public void save()
    {
        playerRecords = new File("playerRecords.txt");
        try
        {
            BufferedWriter writer =
                new BufferedWriter(new FileWriter(playerRecords));
            for (int i = 0; i < players.size(); i++)
            {
                String user = (players.get(i)).getUsername();
                int l = (players.get(i)).getLives();
                int s = (players.get(i)).getScore();
                writer.write(user + "," + l + "," + s + "\n");
            }
            writer.close();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
