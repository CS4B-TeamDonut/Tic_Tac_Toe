package io.github.teamdonut.proj;

import java.util.Objects;

/**
 * Player is a data-only class that holds the data pertaining to a player.
 */
public class Player {
    private String playerName;
    private char playerToken;

    /**
     * Constructs a Player object with no arguments.
     */
    public Player() { }

    /**
     * Constructs a Player object with a set player name.
     * @param playerName The name of the player
     */
    public Player(String playerName) {
        this.playerName = playerName;
    }

    /**
     * Constructs a Player object with a set player name and player token ['X', 'O'].
     * @param playerName The name of the player
     * @param playerToken The token of the player ['X', 'O']
     */
    public Player(String playerName, char playerToken) {
        this.playerName = playerName;
        this.playerToken = playerToken;
    }

    /**
     * Gets the player's name.
     * @return A String holding the player's name
     */
    public String getPlayerName() { return playerName; }

    /**
     * Gets the player's token.
     * @return A char holding the player's token
     */
    public char getPlayerToken() { return playerToken; }

    /**
     * Sets the player's name.
     * @param playerName A String holding the player's token.
     */
    public void setPlayerName(String playerName) { this.playerName = playerName; }

    /**
     * Sets the player's token.
     * @param playerToken A char holding the player's token.
     */
    public void setPlayerToken(char playerToken) { this.playerToken = playerToken; }

    /**
     * Checks the equality of two Player objects.
     * @param o The Player that is being checked for equality
     * @return A boolean representing the equality of two Player objects
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Player player = (Player) o;
        return playerToken == player.playerToken && Objects.equals(playerName, player.playerName);
    }

    /**
     * Returns the hash code of the calling Player object.
     * @return An integer representing the hashcode of the calling Player object
     */
    @Override
    public int hashCode() {
        return Objects.hash(playerName, playerToken);
    }

    /**
     * Returns a String containing the name and token of the Player object
     * @return A String containing the name and token of the Player object
     */
    @Override
    public String toString() {
        return "Player{" +
                "playerName='" + playerName + '\'' +
                ", playerToken=" + playerToken +
                '}';
    }
}
