package com.sohan.chutesladders.Board;

import com.sohan.chutesladders.Player.Player;

import java.util.HashMap;

/**
 * The type Ladders.
 */
public class Ladders {
    /**
     * The Ladder.
     */
    public HashMap<Integer, Integer> ladder = new HashMap<>();

    /**
     * Instantiates a new Ladders.
     */
    public Ladders() {
        this.ladder.put(1, 38);
        this.ladder.put(4, 14);
        this.ladder.put(9, 31);
        this.ladder.put(21, 42);
        this.ladder.put(28, 84);
        this.ladder.put(36, 44);
        this.ladder.put(51, 67);
        this.ladder.put(71, 91);
        this.ladder.put(80, 100);

    }

    /**
     * Gets chutes.
     *
     * @return the chutes
     */
    public HashMap<Integer, Integer> getChutes() {
        return ladder;
    }

    /**
     * Is ladder boolean.
     *
     * @param tile the tile
     * @return the boolean
     */
    public boolean isLadder(Integer tile) {
        return ladder.containsKey(tile);
    }

    /**
     * Climb ladder.
     *
     * @param player the player
     * @param tile   the tile
     */
    public void climbLadder(Player player, Integer tile) {
        if (isLadder(tile)) {
            System.out.println("Player " + player.getName() + " climbed up a ladder");
            player.setPosition(ladder.get(tile));
        }
    }
}




