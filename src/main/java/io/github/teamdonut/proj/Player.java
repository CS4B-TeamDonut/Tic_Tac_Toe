package io.github.teamdonut.proj;

import java.util.Objects;

public class Player {
    private String playerName;
    private char playerToken;

    public Player() { }

    public Player(String playerName) {
        this.playerName = playerName;
    }

    public Player(String playerName, char playerToken) {
        this.playerName = playerName;
        this.playerToken = playerToken;
    }

    public String getPlayerName() { return playerName; }

    public char getPlayerToken() { return playerToken; }

    public void setPlayerName(String playerName) { this.playerName = playerName; }

    public void setPlayerToken(char playerToken) { this.playerToken = playerToken; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Player player = (Player) o;
        return playerToken == player.playerToken && Objects.equals(playerName, player.playerName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(playerName, playerToken);
    }

    @Override
    public String toString() {
        return "Player{" +
                "playerName='" + playerName + '\'' +
                ", playerToken=" + playerToken +
                '}';
    }
}
