package io.github.teamdonut.proj.controllers;

import io.github.teamdonut.proj.common.Board;
import io.github.teamdonut.proj.common.Player;
import io.github.teamdonut.proj.listener.EventManager;
import io.github.teamdonut.proj.listener.IObserver;
import io.github.teamdonut.proj.listener.ISubject;
import io.github.teamdonut.proj.utils.Logger;

import java.util.Random;

/**
 * Game logic controller
 * @author Kord Boniadi
 * @author Brandon Nguyen
 */
public class GameController implements ISubject, IObserver {

    /**
     * Container for data to be sent out to IObservers subscribed to this class
     * @see EventManager#notify(ISubject, Object)
     * @author Kord Boniadi
     */
    public static class DrawInfo {
        private final Board updatedBoard;

        public DrawInfo(Board board) {
            this.updatedBoard = board;
        }

        public Board getUpdatedBoard() {
            return updatedBoard;
        }

    }

    private final Board board;
    private final Player player1;
    private final Player player2;
    private Player swap;

    /**
     * Constructor
     * @author Kord Boniadi
     * @author Brandon Nguyen
     */
    public GameController() {
        this(
                new Player("JohnnyP1", 'X'),
                new Player("Computer", 'O'),
                new Board()
        );
    }

    /**
     * Constructor
     * @author Utsav Parajuli
     * @param player1 player object instance
     */
    public GameController(Player player1) {
        this(
                new Player(player1.getPlayerName(), 'X'),
                new Player("Computer", 'O'),
                new Board()
        );
    }

    /**
     * Constructor
     * @param player1 player object instance
     * @param player2 player object instance
     * @author Kord Boniadi
     * @author Brandon Nguyen
     */
    public GameController(Player player1, Player player2) {
        this(player1, player2, new Board());
    }

    /**
     * Constructor
     * @param player1 player object instance
     * @param player2 player object instance
     * @param board Object instance
     * @author Kord Boniadi
     * @author Brandon Nguyen
     */
    public GameController(Player player1, Player player2, Board board) {
        this.board = board;
        this.player1 = player1;
        this.player2 = player2;
        Random rand = new Random();
        swap = (rand.nextInt(2) == 0) ? this.player1 : this.player2;
        EventManager.register(player1, this);
        EventManager.register(player2, this);
    }

    /**
     * @return bard instance
     * @author Kord Boniadi
     * @author Brandon Nguyen
     */
    public Board getBoard() {
        return board;
    }

    /**
     * @return player instance
     * @author Brandon Nguyen
     */
    public Player getPlayer1() {
        return player1;
    }

    /**
     * @return player instance
     * @author Brandon Nguyen
     */
    public Player getPlayer2() {
        return player2;
    }

//    /**
//     * Creates the necessary linkage between ISubject and IObserver
//     * @author Kord Boniadi
//     */
//    public void initialize() {
//        EventManager.register(player1, this);
//        EventManager.register(player2, this);
//    }

    /**
     * New info is received through this method. Object decoding is needed
     *
     * @param eventType General Object type
     * @author Kord Boniadi
     */
    @Override
    public void update(Object eventType) {
        if (eventType instanceof Player.MoveInfo) {
            Player.MoveInfo info = (Player.MoveInfo) eventType;

            if (swap == info.getPlayerInstance() && board.getToken(info.getX(), info.getY()) == board.EMPTY_VALUE) {
                board.updateToken(info.getX(), info.getY(), info.getPlayerInstance().getPlayerToken());
                EventManager.notify(this, new DrawInfo(this.board));
                swap = (swap == player1) ? player2 : player1;
            }
        }
    }
}
