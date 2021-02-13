package io.github.teamdonut.proj.NPC;

import io.github.teamdonut.proj.Board;
import io.github.teamdonut.proj.listener.EventManager;
import io.github.teamdonut.proj.utils.DataValidation;

import java.util.Random;

/**
 * @author utsavparajuli
 * @version 3.0
 *
 * This class will implement the NPC interface as an easy difficulty. The logic in making the move for the NPC
 * is based on just finding an empty spot.
 */
public class NPCEasyMode implements NPC{

    /**
     * Constructor for the NPCEasyMode class. Does not initialize anything. Overrides the compiler generated
     * constructor
     */
    public NPCEasyMode() {
    }

    /**
     * This method will make a move for the NPC which is in easy difficulty mode. It will generate a x and y
     * number which will be placed in the board. The method will iterate through the board until it finds
     * any empty spaces. Once the spot is found it will exit the loop and update the call the notify method of
     * the EventManager and pass the data.
     * @param board : the tic tac toe board
     * @param c : the token
     */
    @Override
    public void makeMove(Board board, char c) {
        DataValidation.ensureObjectNotNull("Board", board);

        int x;      //row
        int y;      //col
        char[][] boardAr = board.getBoard();    //tic tac toe board

        //initialization for random class
        Random num = new Random();

        boolean valid = false;

        //loops until the NPC finds an empty spot
        do{
            x = num.nextInt(3);
            y = num.nextInt(3);

            //checks if the board is not empty
            if (boardAr[x][y] != ' ') {
                System.out.println("That spot is taken already - try again!\n");
            }
            else {
                valid = true;
            }

        }while(!valid);

        //notify method called for the event manager
        EventManager.notify(this, new NPC.BoardMoveInfo(x, y, c));
    }
}
