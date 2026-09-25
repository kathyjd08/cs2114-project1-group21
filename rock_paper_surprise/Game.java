package rock_paper_surprise;

import java.lang.Math;
import java.util.ArrayList;
import java.util.Scanner;

public class Game
{
    private double rockProb;
    private double paperProb;
    private double scissorsProb;
    private double surpriseProb;

    public Game(Player player)
    {
        rockProb = 0.3;
        paperProb = 0.3;
        scissorsProb = 0.3;
        surpriseProb = 0.1;
    }


    public Option getResponse()
    {
        double rand = Math.random(); // Random double from [0, 1)
        if (rand < rockProb)
        {
            // return new Option(/* TODO: Option constructor */); // Rock
        }
        else if (rand < (rockProb + paperProb))
        {
            // return new Option(); // Paper
        }
        else if (rand < (rockProb + paperProb + scissorsProb))
        {
            // return new Option(); // Scissors
        }
        else if (rand < (rockProb + paperProb + scissorsProb + surpriseProb))
        {
            // return new Option(); // Surprise
        }
    }


    public void getScoreboard()
    {
        Score score = new Score();
        ArrayList<Player> topThree = score.getTopThree();
        for (int i = 0; i < topThree.size(); i++)
        {
            Player player = topThree.get(i);
            System.out.println(player);
        }
    }


    public static void main(String[] args)
    {
        Score score = new Score();
        score.initialize();
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter username: ");
        String username = sc.nextLine();
        Player player = new Player(username);
        Game game = new Game(player);
        System.out.println("Your score is " + player.getScore());

        System.out.print(
            "Enter option (choose from rock, paper, scissors, //surprises, or save): ");
        String playerInput = sc.next();
        Option playerOp = new Option(playerInput);
        Option compOp = game.getResponse();
        int result = playerOp.fight(compOp);
        if (result == 1)
        {
            System.out.println("You win!");

        }
        else if (result == -1)
        {
            System.out.println("You tied.");
        }
        else if (result == 2)
        {
            System.out.println("You may now close the game!");
            score.players.add(player);
            score.save();
        }
        else
        {
            System.out.println("You lost :(");
            player.setLives(player.getLives() - 1);
        }
    }
}
