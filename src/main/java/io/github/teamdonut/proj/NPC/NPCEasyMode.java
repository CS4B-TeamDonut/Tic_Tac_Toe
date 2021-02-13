package io.github.teamdonut.proj.NPC;

import io.github.teamdonut.proj.Board;
import io.github.teamdonut.proj.listener.EventManager;

import java.util.Random;

public class NPCEasyMode implements NPC{

    //constructor
    public NPCEasyMode() {
    }

    @Override
    public void makeMove(Board board, char c) {
        int x;
        int y;
        char[][] boardAr = board.getBoard();

        Random num = new Random();

        boolean valid = false;

        do{
            x = num.nextInt(3);
            y = num.nextInt(3);

            if (boardAr[x][y] != ' ') {
                System.out.println("That spot is taken already - try again!\n");
            }
            else {
                valid = true;
            }

        }while(!valid);

        EventManager.notify(this, new NPC.BoardMoveInfo(x, y, c));


//        can do this when the observer class is implemented in NPC
//         */
    }

    //have the update method from the observer here
    //the update should contain the current board. There should also be a way to get an X or O assigned
    //as a token inside the NPC class during the update.
}
