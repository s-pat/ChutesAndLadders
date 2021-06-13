package com.sohan.chutesladders.Board;

import com.sohan.chutesladders.Player.Player;

import java.util.HashMap;


/**
 * The type Chutes.
 */
public class Chutes {
    /**
     * The Chutes.
     */
    public HashMap<Integer, Integer> chutes = new HashMap<>();

    /**
     * Instantiates a new Chutes.
     */
    public Chutes() {
        this.chutes.put(16, 6);
        this.chutes.put(47, 26);
        this.chutes.put(49, 11);
        this.chutes.put(56, 53);
        this.chutes.put(62, 19);
        this.chutes.put(64, 60);
        this.chutes.put(87, 24);
        this.chutes.put(93, 73);
        this.chutes.put(95, 75);
        this.chutes.put(98, 78);


    }

    /**
     * Gets chutes.
     *
     * @return the chutes
     */
    public HashMap<Integer, Integer> getChutes() {
        return chutes;
    }

    /**
     * Is chute boolean.
     *
     * @param tile the tile
     * @return the boolean
     */
    public boolean isChute(Integer tile) {
        return chutes.containsKey(tile);
    }

    /**
     * Ride chute.
     *
     * @param player the player
     * @param tile   the tile
     */
    public void rideChute(Player player, Integer tile) {
        if (isChute(tile)) {
            System.out.println("Player " + player.getName() + " rode down a chute");
            player.setPosition(chutes.get(tile));
        }
    }
}


