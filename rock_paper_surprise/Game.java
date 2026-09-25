package rock_paper_surprise;

import java.lang.Math;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * // -------------------------------------------------------------------------
 * /** Game class
 * 
 * @author Chris Tricarico (christ07)
 * @version Sept., 2026
 */
public class Game {
    private double rockProb;
    private double paperProb;
    private double scissorsProb;
    private double surpriseProb;

    /**
     * Game class constructor
     * 
     * @param player
     *            Player playing the game.
     */
    public Game(Player player) {
        rockProb = 0.3;
        paperProb = 0.3;
        scissorsProb = 0.3;
        surpriseProb = 0.1;
    }


    /**
     * Gets the response of the computer based on probability.
     * 
     * @return Option with String name
     */
    public Option getResponse() {
        double rand = Math.random(); // Random double from [0, 1)
        if (rand < rockProb) {
            return new Option("Rock");
        }
        else if (rand < (rockProb + paperProb)) {
            return new Option("Paper");
        }
        else if (rand < (rockProb + paperProb + scissorsProb)) {
            return new Option("Scissors");
        }
        else {
            return new Option("Surprise");
        }
    }


    /**
     * Runs the prompts and the game.
     */
    public static void main(String[] args) {
        Score score = new Score();
        score.initialize();
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter username: ");
        String username = sc.nextLine();
        Player player = null;
        while (player == null) {
            try {
                player = new Player(username);
            }
            catch (IllegalArgumentException e) {
                System.out.println("Please enter a valid username: ");
                username = sc.nextLine();
            }
        }
        Game game = new Game(player);
        ArrayList<String> possOptions = new ArrayList<String>();
        possOptions.add("rock");
        possOptions.add("paper");
        possOptions.add("scissors");
        possOptions.add("surprise");
        possOptions.add("save");
        while (player.getLives() > 0) {
            System.out.println("Your score is " + player.getScore());
            System.out.println("You have " + player.getLives() + " lives");
            System.out.print(
                "Enter option (choose from rock, paper, scissors, surprise, or save): ");
            String playerInput = sc.next().toLowerCase();
            while (possOptions.contains(playerInput) == false) {
                System.out.print(
                    "Enter option (choose from rock, paper, scissors, surprise, or save): ");
                playerInput = sc.next().toLowerCase();
            }
            Option playerOp = new Option(playerInput);
            Option compOp = game.getResponse();
            int result = playerOp.fight(compOp);
            if (result == 1) {
                System.out.println("You win!");
                player.setScore(player.getScore() + 1);
            }
            else if (result == 0) {

                System.out.println("You tied.");
            }
            else if (result == 2) {
                System.out.println("You may now close the game!");
                score.players.add(player);
                score.save();
                break;
            }
            else {
                System.out.println("You lost :(");
                player.setLives(player.getLives() - 1);
            }
        }
        if (player.getLives() == 0) {
            System.out.println("You are out of lives!");
        }
    }
}
