package com.company.tic_tac_toe.test;

import java.util.InputMismatchException;
import java.util.Scanner;
import com.company.tic_tac_toe.model.Board;
import com.company.tic_tac_toe.model.CellAlreadyMarkedException;
import com.company.tic_tac_toe.model.Mark;
import com.company.tic_tac_toe.model.ResultAnalyzer;
import com.company.tic_tac_toe.model.ResultType;

public class GameTest {
    private static final Scanner scanner = new Scanner(System.in);
    private static Board board;
    private static ResultAnalyzer resultAnalyzer;
    private static char player1Sign, player2Sign;

    public static void main(String[] args) throws CellAlreadyMarkedException {
        while (true) {
            initializeGame();
            playGame();

            if (!askPlayAgain()) {
                System.out.println("Thank you for playing! Goodbye.");
                break;
            }
        }
    }

    private static void initializeGame() {
        board = new Board();
        resultAnalyzer = new ResultAnalyzer(board);
        displayMain();
        player1Sign = getValidSign();
        if (player1Sign == 'X') {
            player2Sign = 'O';
        } else {
            player2Sign = 'X';
        }
    }

    private static void playGame() throws CellAlreadyMarkedException {
        for (int i = 0; i < 9; i++) {
        	int playerNumber;
        	if (i % 2 == 0) {
        	    playerNumber = 1;
        	} else {
        	    playerNumber = 2;
        	}

        	char currentSign;
        	if (playerNumber == 1) {
        	    currentSign = player1Sign;
        	} else {
        	    currentSign = player2Sign;
        	}
            displayGrid();
            int location = getValidMove();
            Mark mark;
            if (currentSign == 'X') {
                mark = Mark.X;
            } else {
                mark = Mark.O;
            }
            board.setCellMark(location - 1, mark);


            if (i >= 4) {  
                ResultType gameResult = resultAnalyzer.analyzeResult();
                if (gameResult == ResultType.WIN) {
                    System.out.println("Player " + playerNumber + " wins!!!");
                    displayGrid();
                    return;
                } else if (i == 8 && gameResult == ResultType.DRAW) {
                    System.out.println("Match Draw!");
                    displayGrid();
                    return;
                }
            }
        }
    }

    private static char getValidSign() {
        System.out.print("Please select X/O for Player 1: ");
        while (true) {
            try {
                char ch = scanner.next().toUpperCase().charAt(0);
                if (ch == 'X' || ch == 'O') {
                    return ch;
                } else {
                    System.out.print("Invalid choice! Choose X or O: ");
                }
            } catch (Exception e) {
                System.out.print("Invalid input! Choose X or O: ");
                scanner.next(); 
            }
        }
    }

    private static int getValidMove() {
        int loc;
        while (true) {
            System.out.print("Enter the location (1-9): ");
            try {
                loc = scanner.nextInt();
                if (loc >= 1 && loc <= 9 && board.getCells()[loc - 1].getMark() == Mark.E) {
                    return loc;
                } else {
                    System.out.println("Invalid move! Choose an empty location between 1-9.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input! Enter a number between 1-9.");
                scanner.next();
            }
        }
    }

    private static void displayGrid() {
        System.out.println("\nCurrent Board:");
        for (int i = 0; i < 9; i++) {
        	char displayMark;
        	if (board.getCells()[i].getMark() == Mark.E) {
        	    displayMark = 'E';
        	} else {
        	    displayMark = board.getCells()[i].getMark().toString().charAt(0);
        	}

            System.out.print(" " + displayMark + " ");
            if ((i + 1) % 3 == 0) System.out.println();
        }
        System.out.println();
    }

    private static void displayMain() {
        System.out.println("----- WELCOME TO TIC-TAC-TOE ----- \n");
        System.out.println("TIC| X | O");
        System.out.println(" X |TAC| X");
        System.out.println(" O | X |TOE\n");
    }

    private static boolean askPlayAgain() {
        System.out.print("Do you want to play again? (Y/N): ");
        while (true) {
            try {
                char choice = scanner.next().toUpperCase().charAt(0);
                if (choice == 'Y') {
                    return true;
                } else if (choice == 'N') {
                    return false;
                } else {
                    System.out.print("Invalid choice! Enter Y (Yes) or N (No): ");
                }
            } catch (Exception e) {
                System.out.print("Invalid input! Enter Y (Yes) or N (No): ");
                scanner.next();
            }
        }
    }
}
