package com.example.a15_squarespuzzle;

import android.graphics.Color;
import android.graphics.Paint;
import android.widget.Button;

import java.util.ArrayList;

/**
 * Resets the puzzle board
 */

public class PuzzleView {
    public ArrayList<Button> buttons; // stores button objects
    public static final int size = 4;
    int [][] puzzleArray; // random values
    int [][] winArray; // array that has winning solution

    /**
     * Creates arrays that store the winning solution
     */

    public PuzzleView() {
        super();
        puzzleArray = new int [size][size];
        buttons = new ArrayList<Button>(16);
        winArray = new int[][]{{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, -1}};
    }

    /**
     * Creates a random puzzle by assigning a number to each button
     */
    public void createPuzzle() {
        // sets all values to -1 in order to be randomized
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                puzzleArray[i][j] = -1;
            }
        }

        // randomizes locations of buttons based one whether the space is empty or not
        for (int i = 1; i <= size*size-1; i++) {
            int randomRow = (int) ((size)*Math.random());
            int randomCol = (int) ((size)*Math.random());
            if (puzzleArray[randomRow][randomCol] == -1) {
                puzzleArray[randomRow][randomCol] = i;
            }
            else {
                i--;
            }
        }
    }

    /**
     * Sets the text for each button and sets all button colors to black
     */

    public void reset() {
        this.createPuzzle(); // creates puzzle array
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                // if spot is empty, sets text to empty string
                if (puzzleArray[i][j] == -1) {
                    this.buttons.get((i * 4) + j).setText("");
                }
                // sets the text to the number
                else {
                    this.buttons.get((i * 4) + j).setText("" + this.puzzleArray[i][j]);
                }
                // sets button color to black when reset
                this.buttons.get((i*4) + j).setBackgroundColor(Color.BLACK);
            }
        }
    }
}
