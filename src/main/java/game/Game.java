package game;

import java.util.Arrays;

import player.Player;
import player.RobotPlayer;

public class Game {

    private static final int[] CORRECT_ANSWER_COWS_AND_BULLS = new int[]{4, 4};

    private boolean isGameFinished;
    private final Player[] players;

    public Game() {
        players = new Player[2];
    }

    public void start() {
        isGameFinished = false;
        initPlayers();
        while (!isGameFinished()) {
            run();
        }
    }

    private void initPlayers() {
        players[0] = new RobotPlayer();
        players[1] = new RobotPlayer();
    }

    private void run() {
        boolean player1Won = turn(0, 1);
        boolean player2Won = turn(1, 0);
        if (player1Won && player2Won) {
            isGameFinished = true;
            System.out.println("It's a draw");
        } else if (player1Won || player2Won) {
            isGameFinished = true;
            if (player1Won) {
                System.out.printf("%s won!%n", players[0].getName());
            } else {
                System.out.printf("%s won!%n", players[1].getName());
            }
        }
    }

    private boolean turn(int p1, int p2) {
        System.out.printf("It's %s's turn.\n", players[p1].getName());
        int guessedNumber = players[p1].guessNumber();
        int[] cowsAndBulls = players[p2].checkNumber(guessedNumber);
        players[p1].handleNumberWithCowsAndBulls(guessedNumber, cowsAndBulls);
        return checkIfGameIsFinished(cowsAndBulls);
    }

    private boolean checkIfGameIsFinished(int[] cowsAndBulls) {
        return Arrays.equals(cowsAndBulls, CORRECT_ANSWER_COWS_AND_BULLS);
    }

    private boolean isGameFinished() {
        return isGameFinished;
    }
}
