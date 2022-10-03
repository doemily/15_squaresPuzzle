package com.example.a15_squarespuzzle;

import android.graphics.Color;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

/**
 * External Citation
 * Date: 9/27/22
 * Problem: Needed a refresher on switch cases
 * Resource: https://docs.oracle.com/javase/tutorial/java/nutsandbolts/switch.html
 * Solution: I used the example code to remind me of the layout and syntax of switch cases.
 */

public class PuzzleController implements View.OnClickListener{
    private PuzzleView pv;
    private ArrayList<Button> buttons;

    /**
     * Constructor for view and buttons
     * @param view
     */

    public PuzzleController(PuzzleView view) {
        pv = view;
        buttons = pv.buttons;
    }
    @Override
    public void onClick(View view) {
        boolean isTrue; // puzzle pieces and solutions match
        switch (view.getId()) {
            case R.id.button1:
                // determines which direction to move if a move is possible
                onClickHelper(0);
                // checks if the whole puzzle has a matching puzzle and winning array
                isTrue = checkPuzzle();
                break;
            case R.id.button2:
                onClickHelper(1);
                isTrue = checkPuzzle();
                break;
            case R.id.button3:
                onClickHelper(2);
                isTrue = checkPuzzle();
                break;
            case R.id.button4:
                onClickHelper(3);
                isTrue = checkPuzzle();
                break;
            case R.id.button5:
                onClickHelper(4);
                isTrue = checkPuzzle();
                break;
            case R.id.button6:
                onClickHelper(5);
                isTrue = checkPuzzle();
                break;
            case R.id.button7:
                onClickHelper(6);
                isTrue = checkPuzzle();
                break;
            case R.id.button8:
                onClickHelper(7);
                isTrue = checkPuzzle();
                break;
            case R.id.button9:
                onClickHelper(8);
                isTrue = checkPuzzle();
                break;
            case R.id.button10:
                onClickHelper(9);
                isTrue = checkPuzzle();
                break;
            case R.id.button11:
                onClickHelper(10);
                isTrue = checkPuzzle();
                break;
            case R.id.button12:
                onClickHelper(11);
                isTrue = checkPuzzle();
                break;
            case R.id.button13:
                onClickHelper(12);
                isTrue = checkPuzzle();
                break;
            case R.id.button14:
                onClickHelper(13);
                isTrue = checkPuzzle();
                break;
            case R.id.button15:
                onClickHelper(14);
                isTrue = checkPuzzle();
                break;
            case R.id.emptyButton:
                onClickHelper(15);
                isTrue = checkPuzzle();
                break;
            case R.id.resetButton:
                // resets the puzzle array
                pv.reset();
                // checks if the puzzle is initially randomized to the solution
                isTrue = checkPuzzle();
                break;
        }
    }

    /**
     * Checks puzzle to see how many buttons are in the correct position
     * Sets button color to green if in correct position
     * @return: All values of puzzleArray and winArray are the same; all buttons are in correct position
     */
    public boolean checkPuzzle() {
        int correct = 0; // number of puzzle pieces in the correct spot
        for (int i = 0; i < pv.size; i++) {
            for (int j = 0; j < pv.size; j++) {
                // set color to green if puzzle piece is in correct spot
                if (pv.puzzleArray[i][j] == pv.winArray[i][j]) {
                    buttons.get((i * 4) + j).setBackgroundColor(Color.GREEN);
                    correct++;
                    }
                // buttons are set black if not in correct position
                else {
                    buttons.get((i * 4) + j).setBackgroundColor(Color.BLACK);
                }
            }
        }
        // all buttons are in correct position
        if (correct == 16) {
            return true;
        }
        // not all buttons are in correct position
        else {
            return false;
        }
    }

    /**
     * Checks if the button can perform a legal move or not
     * Switches the puzzleArray and buttonText values
     * @param arrayValue: the button value
     */

    public void onClickHelper(int arrayValue) {
        // gets values from buttons of the row and column
        int row = arrayValue / 4;
        int column = arrayValue % 4;

        // determines above, below, left, and right positions of the button
        int rowAbove = row - 1;
        int rowBelow = row + 1;
        int leftCol = column - 1;
        int rightCol = column + 1;

        // stores the value of the button clicked from puzzleArray
        int value = pv.puzzleArray[row][column];


        // checks if button is empty or not
        if (value != -1) {
            // checks if the button above is out of bounds or not
            if (rowAbove >= 0) {
                // checks if button above is the empty button
                if(pv.puzzleArray[rowAbove][column] == -1) {
                    // switch the pv values
                    int temp = pv.puzzleArray[row][column];
                    pv.puzzleArray[row][column] = pv.puzzleArray[rowAbove][column];
                    pv.puzzleArray[rowAbove][column] = temp;

                    // switch the array values
                    CharSequence tempString = pv.buttons.get(arrayValue).getText();
                    pv.buttons.get(arrayValue).setText(pv.buttons.get(arrayValue - 4).getText());
                    pv.buttons.get(arrayValue - 4).setText(tempString);
                }
            }

            // checks if the button below is out of bounds
            if (rowBelow <= 3) {
                // checks if the button below is the empty button
                if (pv.puzzleArray[rowBelow][column] == -1) {
                    // switch the pv values
                    int temp = pv.puzzleArray[row][column];
                    pv.puzzleArray[row][column] = pv.puzzleArray[rowBelow][column];
                    pv.puzzleArray[rowBelow][column] = temp;

                    // switch the array values
                    CharSequence tempString = pv.buttons.get(arrayValue).getText();
                    pv.buttons.get(arrayValue).setText(pv.buttons.get(arrayValue + 4).getText());
                    pv.buttons.get(arrayValue + 4).setText(tempString);
                }
            }

            // checks if the button to the left is out of bounds or not
            if (leftCol >= 0) {
                // checks if the button to the left is the empty button
                if(pv.puzzleArray[row][leftCol] == -1) {
                    // switch the pv values
                    int temp = pv.puzzleArray[row][column];
                    pv.puzzleArray[row][column] = pv.puzzleArray[row][leftCol];
                    pv.puzzleArray[row][leftCol] = temp;

                    // switch the array values
                    CharSequence tempString = pv.buttons.get(arrayValue).getText();
                    pv.buttons.get(arrayValue).setText(pv.buttons.get(arrayValue - 1).getText());
                    pv.buttons.get(arrayValue - 1).setText(tempString);
                }
            }

            // checks if the button to the right is out of bounds or not
            if (rightCol <= 3) {
                // checks if the button to the right is the empty button
                if (pv.puzzleArray[row][rightCol] == -1) {
                    // switch the pv values
                    int temp = pv.puzzleArray[row][column];
                    pv.puzzleArray[row][column] = pv.puzzleArray[row][rightCol];
                    pv.puzzleArray[row][rightCol] = temp;

                    // switch the array values
                    CharSequence tempString = pv.buttons.get(arrayValue).getText();
                    pv.buttons.get(arrayValue).setText(pv.buttons.get(arrayValue + 1).getText());
                    pv.buttons.get(arrayValue + 1).setText(tempString);
                }
            }
        }
    }
}
