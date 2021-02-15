package io.github.teamdonut.proj;

//public class Game {
//
//    private final char currentPlayer = 'X';
//    private final Board[][] board = new Board[3][3];
//
//
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
//
//    public char currentPlayer(char currentPlayer) {
//        if (currentPlayer == 'X') {
//            return 'O';
//        }
//        else {
//            return 'X';
//        }
//
//    }
//
//    public boolean hasWon(char player) {
//        for (int i = 0; i < 3; i++) {
//            if(board[i][[0].getPlayer == player && board[i][1].getPlayer() == player && board[i][2].getPlayer() == player) {
//                return true;
//                System.out.println(player + " has won");
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
//        if(board[0][0].getPlayer() == player && board[1][1].getPlayer() == player && board[2][2].getPlayer() == player) {
//            return true;
//            System.out.println(player + " has won");
//        }
//
//        if(board[0][2].getPlayer() == player && board[1][1].getPlayer() == player && board[2][0].getPlayer() == player) {
//            return true;
//            System.out.println(player + "has won");
//        }
//
//
//        return false;
//    }
//
//    public static class Board {
//
//        private char player = ' ';
//
//        public char getPlayer() {
//            return player;
//        }
//
//        public void setPlayer(char c) {
//            player = c;
//
//            if (player == 'X') {
//                System.out.println("X");
//
//            } else if (player == 'O') {
//                System.out.println("O");
//            }
//        }
//
//
//    }
//
//}