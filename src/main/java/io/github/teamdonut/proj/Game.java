package io.github.teamdonut.proj;

public class Game {

    private Board board;
    private Player player1;
    private Player player2;

//    public boolean isBoardFull() {
//        for (int i = 0; i < 3; i++) {
//            for (int j = 0; j < 3; j++) {
//                if (board[i][j].getPlayer() == ' ') {
//                    return false;
//                }
//            }
//        }
//        return true;
//    }

//    public boolean hasWon(char player) {
//        for (int i = 0; i < 3; i++) {
//            if(board[i][[0].getPlayer == player && board[i][1].getPlayer() == player && board[i][2].getPlayer() == player) {
//                return true;
//               System.out.println(player + " has won");
//            }
//        }
//
//        for (int i = 0; i < 3; i++) {
//            if(board[0][[i].getPlayer() == player && board[1][i].getPlayer() == player && board[2][i].getPlayer() == player) {
//                return true;
//                System.out.println(player + " has won");
//            }
//        }
//
//        if (board[0][0].getPlayer() == player && board[1][1].getPlayer() == player && board[2][2].getPlayer() == player) {
//            return true;
//            System.out.println(player + " has won");
//        }
//
//        if (board[0][2].getPlayer() == player && board[1][1].getPlayer() == player && board[2][0].getPlayer() == player) {
//            return true;
//            System.out.println(player + "has won");
//        }
//        return false;
//    }
}