package com.sohan.chutesladders.Player;

import java.util.UUID;

/**
 * The type Player.
 */
public class Player {
    private String name;
    private int position;
    private int orderNumber;

    /**
     * Instantiates a new Player.
     *
     * @param name the name
     */
    public Player(String name) {
        this.name = name;
        this.position = 0;
    }

    /**
     * Gets name.
     *
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets name.
     *
     * @param name the name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets position.
     *
     * @return the position
     */
    public int getPosition() {
        return position;
    }

    /**
     * Sets position.
     *
     * @param position the position
     */
    public void setPosition(int position) {
        this.position = position;
    }

    /**
     * Gets order number.(Not being used right now)
     *
     * @return the order number
     */
    public int getOrderNumber() {
        return orderNumber;
    }

    /**
     * Sets order number.(Not being used right now)
     *
     * @param orderNumber the order number
     */
    public void setOrderNumber(int orderNumber) {
        this.orderNumber = orderNumber;
    }


    /**
     * Print's a players current position.
     */
    public void printPosition() {
        System.out.println("Player " + name + "'s position is " + position);
    }

    @Override
    public String toString() {
        return "Player{" +
                "name='" + name + '\'' +
                ", position=" + position +
                ", orderNumber=" + orderNumber +
                '}';
    }
}
