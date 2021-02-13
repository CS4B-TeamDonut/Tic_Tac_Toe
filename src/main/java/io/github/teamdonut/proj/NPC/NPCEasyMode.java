package io.github.teamdonut.proj.NPC;

import java.util.Random;

public class NPCEasyMode implements NPC{
    private char c;     //token
    final int BOARD_WIDTH = 3;
    final int BOARD_HEIGHT = 3;
    private int x;
    private int y;

    //constructor
    public NPCEasyMode() {
    }

    /**
     * This method will return the token of the NPC
     * @return c : the token
     */
    public char returnToken() {
        return c;
    }

    /**
     * This method will return the row of the placement in board
     * @return x : the row
     */
    public int returnX() {
        return x;
    }

    /**
     * This method will return the column of the placement
     * @return
     */
    public int returnY() {
        return y;
    }

    @Override
    public void makeMove(char[][] board, char c) {
        this.c = c;

        Random num = new Random();

        boolean valid = false;

        do{
            x = num.nextInt(3);
            y = num.nextInt(3);

            System.out.println(x);
            System.out.println(y);

            if (board[x][y] != ' ') {
                System.out.println("That spot is taken already - try again!\n");
            }
            else {
                valid = true;
            }
            System.out.println(x);
            System.out.println(y);
        }while(!valid);


        //board.updateToken(x,y,c); //once methods are implemented

        /*or
        boardAr[x][y];

        can do this when the observer class is implemented in NPC
         */
    }

    //have the update method from the observer here
    //the update should contain the current board. There should also be a way to get an X or O assigned
    //as a token inside the NPC class during the update.
}
