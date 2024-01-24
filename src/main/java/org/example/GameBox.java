package org.example;

import java.util.Arrays;

public class GameBox {
    static final char FIRST_PLAYER = 'X';
    static final char SECOND_PLAYER = '0';
    private final char[] box = new char[] {'1', '2', '3', '4', '5', '6', '7', '8', '9'};
    public void displayBox(){
        System.out.printf("\n  %s | %s | %s\n -----------\n  %s | %s | %s\n -----------\n  %s | %s | %s\n\n",
                box[0], box[1], box[2], box[3], box[4],
                box[5], box[6], box[7], box[8]);
    }
    public void createGameBox(){
        Arrays.fill(box, ' ');
    }
    public boolean boxIsAvailable(int i) {
        return box[i] != FIRST_PLAYER && box[i] != SECOND_PLAYER;
    }
    public void markFullBox(int i, char player) {
        box[i] = player;
    }
    public boolean boxEmpty() {
        for (char value : box) {
            if (value != FIRST_PLAYER && value != SECOND_PLAYER) {
                return false;
            }
        }
        return true;
    }
    public boolean winnerPositionInBox(char player) {
        for (int i = 0; i < 3; i++) {
            if ((box[i * 3] == player && box[i * 3 + 1] == player && box[i * 3 + 2] == player) ||
                    (box[i] == player && box[i + 3] == player && box[i + 6] == player)) {
                return true;
            }
        }

        return (box[0] == player && box[4] == player && box[8] == player) ||
                (box[2] == player && box[4] == player && box[6] == player);
    }
}


