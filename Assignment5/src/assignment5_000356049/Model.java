package assignment5_000356049;

import java.util.Random;

/**
 * This is the Model class focus on the logic to support View class
 *
 * @author TRUNG KIEN, BUI
 */
public class Model {
    /**
     * Initialize playerScore counter;
     */
    private int playerScore;
    /**
     * Initialize ComputerScore counter;
     */
    private int computerScore;
    /**
     * Declare String variable and save computerPlays's result to it;
     */
    private String computerChoice;

    /**
     * Method to randomly generate rock, paper, and scissor for computer and save it in computerChoice variable
     *
     * @return computerChoice
     */
    public String computerPlays() {
        Random random = new Random();
        int randomNumbers = random.nextInt(3);
        if (randomNumbers == 0) {
            computerChoice = "rock";
        } else if (randomNumbers == 1) {
            computerChoice = "paper";
        } else {
            computerChoice = "scissors";
        }
        return computerChoice;
    }

    /**
     * Method/ Logic to compare user choice and randomly generated choice from computerPlays method and return the winner
     *
     * @param playerMove
     * @return result as a message to show the winner each round
     */
    public String play(String playerMove) {
        String computerMove = computerPlays();
        String result;
        if ((playerMove.equals("rock") && computerMove.equals("scissors"))
                || (playerMove.equals("paper") && computerMove.equals("rock"))
                || (playerMove.equals("scissors") && computerMove.equals("paper"))) {
            result = "PLAYERS WINS!";
            playerScore++;
        } else if ((computerMove.equals("rock") && playerMove.equals("scissors"))
                || (computerMove.equals("paper") && playerMove.equals("rock"))
                || (computerMove.equals("scissors") && playerMove.equals("paper"))) {
            result = "COMPUTER WINS!";
            computerScore++;
        } else {
            result = "IT'S A DRAW!";
        }
        return result;
    }

    /**
     * Method used to return computer choice as String to display on canvas
     *
     * @return computerChoice
     */
    public String getComputerPlays() {
        return computerChoice;
    }

    /**
     * toString returns player score and computer score
     *
     * @return player score and computer score
     */
    public String getScoreboard() {
        return "Player score: " + playerScore + " - Computer score: " + computerScore;
    }
}