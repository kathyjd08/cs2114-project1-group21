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
    public ArrayList<Player> players;
    private String user;
    private int score;
    private int lives;
    private File playerRecords = new File("playerRecords.txt");

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
    /*
     * To Do: - save file method to make and update the file - methods to create
     * the arraylist of players - method to grab game results - get scoreboard
     * method to give game class data for top 3 players - the game class just
     * needs generics to be able to give info to score and player takes info
     * from score. - See persistent achievement tracker for file referencing,
     * watching videos on similar projects to learn how they implemented a
     * persistent achievement tracker (Possibly fix my tracker so I can better
     * answer questions)
     */

}
