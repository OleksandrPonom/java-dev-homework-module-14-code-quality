package org.example;

import java.util.Scanner;
import java.util.logging.Logger;

import static org.example.GameBox.*;
import static org.example.InfoMassage.*;

public class ProcessGame {
    private static final Logger LOGGER = Logger.getLogger(ProcessGame.class.getName());
    private final GameBox gameBox = new GameBox();
    public void gameStart(){

        Scanner scan = new Scanner(System.in);
        boolean boxEmpty = false;
        byte winner = 0;

        printInformationMassage(CHOOSE_POSITION);

        while (true) {
            gameBox.displayBox();

            if(!boxEmpty){
                gameBox.createGameBox();
                boxEmpty = true;
            }

            if (isGameOver(winner)) {
                outputMassageInformation(winner);
                break;
            }

            winner = playGame(scan);
        }
        scan.close();
    }
    private byte playGame(Scanner scan) {
        byte winner;
        playerCheckPositionInBox(scan);
        winner = checkWinner(FIRST_PLAYER);

        if (winner == 0) {
            if (!gameBox.boxEmpty()) {
                computerCheckPositionInBox();
                winner = checkWinner(SECOND_PLAYER);
            } else {
                winner = 3;
            }
        }
        return winner;
    }
    private void playerCheckPositionInBox(Scanner scan) {
        byte input;
        while (true) {
            input = scan.nextByte();
            if (input > 0 && input < 10 && gameBox.boxIsAvailable(input - 1)) {
                    gameBox.markFullBox(input - 1, FIRST_PLAYER);
                    break;
            } else if(input < 1 || input > 9){
                printInformationMassage(MASSAGE_FROM_CHOOSE_INVALID_POSITION);
            } else{
                printInformationMassage(MASSAGE_FROM_SECOND_CHOOSE_POSITION);
            }
        }
    }
    private void computerCheckPositionInBox() {
        byte rand;
        while (true) {
            rand = (byte) (Math.random() * 9);
            if (gameBox.boxIsAvailable(rand)) {
                gameBox.markFullBox(rand, SECOND_PLAYER);
                break;
            }
        }
    }
    private byte checkWinner(char player) {
        if (gameBox.winnerPositionInBox(player)) {
            if (player == FIRST_PLAYER) {
                return 1;
            } else {
                return 2;
            }
        } else {
            return 0;
        }
    }
    private void outputMassageInformation(byte winner) {
        if(winner == 1){
            printInformationMassage(MASSAGE_FROM_WINNER);
        } else if(winner == 2){
            printInformationMassage( MASSAGE_FROM_LOSER);
        } else if(winner == 3){
            printInformationMassage(MASSAGE_FROM_DRAW);
        }
    }
    private boolean isGameOver(byte winner) {
        return winner == 1 || winner == 2 || winner == 3;
    }
    private void printInformationMassage(InfoMassage infoMassage) {
        LOGGER.info(infoMassage.getInformationMassage());
    }
}
