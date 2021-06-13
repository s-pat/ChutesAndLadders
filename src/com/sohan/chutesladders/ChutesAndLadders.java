package com.sohan.chutesladders;

import com.sohan.chutesladders.Board.Chutes;
import com.sohan.chutesladders.Board.Ladders;
import com.sohan.chutesladders.Player.Player;
import com.sohan.chutesladders.Spinner.Spinner;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicBoolean;

    
/*
TODO:
    1. Allow for Manual play or automatic
    2. Add exemption handling for user input
    3. Refactor classes
    4. Implement player number order
    5. Unit Testing

*/
public class ChutesAndLadders {

    /**
     * The constant spinner.
     */
    public static Spinner spinner = new Spinner();
    /**
     * The constant chutes.
     */
    public static Chutes chutes = new Chutes();
    /**
     * The constant ladders.
     */
    public static Ladders ladders = new Ladders();

    /**
     * Holds Max amount of players required.
     */
    public static final int MAX_PLAYERS = 4;

    /**
     * Holds Min amount of players required.
     */
    public static final int MIN_PLAYERS = 2;


    /**
     * Is winner boolean.
     *
     * @param player the player
     * @return the boolean
     */
    public static boolean isWinner(Player player) {
            return player.getPosition() == 80 || player.getPosition() == 100;
    }

    /**
     * Initiate game array list.
     *
     * @return an array of players
     */
    public static ArrayList<Player> initiateGame() {
        ArrayList<Player> players = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        int countOfPlayers = 0;
        boolean countFlag = false;

        while (!countFlag) {
            System.out.println("Enter the number of total players(2-4): ");
            countOfPlayers = Integer.parseInt(scanner.nextLine());
            if (countOfPlayers < MIN_PLAYERS || countOfPlayers > MAX_PLAYERS) {
                System.out.println("Enter the number of total players(2-4): ");
                countOfPlayers = Integer.parseInt(scanner.nextLine());
            } else {
                countFlag = true;

            }
        }
        for (int i = 1; i <= countOfPlayers; i++) {
            System.out.println("Enter the name of Player " + (i) + ": ");
            players.add(new Player(scanner.nextLine()));
        }
        return players;
    }

    /**
     * Game is played thought this method.
     *
     * @param players the players
     */
    public static void playGame(ArrayList<Player> players) {
        AtomicBoolean winnerFlag = new AtomicBoolean(false);
        while (!winnerFlag.get()) {

            players.forEach(player -> {
                        int spinNum = spinner.getSpinNumber();
                        System.out.println("Player " + player.getName() + " spun a " + spinNum);
                        if (player.getPosition() == 0) {
                            if (chutes.isChute(spinNum)) {
                                chutes.rideChute(player, spinNum);
                            } else if (ladders.isLadder(spinNum)) {
                                ladders.climbLadder(player, spinNum);
                            } else {
                                player.setPosition(spinNum);
                            }
                        } else {
                            if (chutes.isChute(player.getPosition() + spinNum)) {
                                chutes.rideChute(player, player.getPosition() + spinNum);
                            } else if (ladders.isLadder(player.getPosition() + spinNum)) {
                                ladders.climbLadder(player, player.getPosition() + spinNum);
                            } else if (player.getPosition() + spinNum > 100) {
                                player.setPosition(player.getPosition());

                            } else {
                                player.setPosition(player.getPosition() + spinNum);
                            }
                            if (isWinner(player)) {
                                System.out.println("Winner is Player: " + player.getName());
                                winnerFlag.set(true);
                                System.exit(0);
                            }
                        }
                        player.printPosition();


                    }//end of forEach lambda
            );

        }
    }

    /**
     * The driver of the game.
     */
    public static void main(String[] args) {
        ArrayList<Player> players = initiateGame();
        playGame(players);

    }
}
