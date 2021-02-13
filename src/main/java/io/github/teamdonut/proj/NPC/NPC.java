package io.github.teamdonut.proj.NPC;

import io.github.teamdonut.proj.Board;
import io.github.teamdonut.proj.listener.ISubject;

import java.util.Objects;

public interface NPC extends ISubject {  //need to implement IObserver and ISubject

     class BoardMoveInfo {
        private int x;
        private int y;
        private char c;

        BoardMoveInfo(int x, int y, char c) {
            this.x = x;
            this.y = y;
            this.c = c;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }

        public char getC() {
            return c;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            BoardMoveInfo that = (BoardMoveInfo) o;

            return  getX() == that.getX() &&
                    getY() == that.getY() &&
                    getC() == that.getC();
        }

        @Override
        public int hashCode() {
            return Objects.hash(getX(), getY(), getC());
        }

        @Override
        public String toString() {
            return "BoardMoveInfo{" +
                    "x=" + x +
                    ", y=" + y +
                    ", c=" + c +
                    '}';
        }
    }

    public void makeMove(Board board, char c);
}
