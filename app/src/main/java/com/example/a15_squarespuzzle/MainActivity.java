package com.example.a15_squarespuzzle;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;

/**
 * MainActivity: Calls methods to create and display puzzle board
 * Creates array of buttons and uses their corresponding listeners
 *
 * @author **** Emily Do ****
 * @version **** 10/2/22 ****
 */

public class MainActivity extends AppCompatActivity {
    PuzzleView puzzle;

    /**
     * Displays puzzle and creates PuzzleView and PuzzleController
     */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // creates a new random puzzle
        puzzle = new PuzzleView();
        puzzle.createPuzzle();

        PuzzleController pc = new PuzzleController(puzzle);
        setArrayList(puzzle,pc); // array list of buttons
        pc.checkPuzzle(); // checks if the buttons start in the correct position to begin with

        // creates reset button
        Button reset = findViewById(R.id.resetButton);
        reset.setOnClickListener(pc);
    }

    /**
     * Sets arrayList of buttons with the click listeners and button values
     */

    public void setArrayList(PuzzleView puzzle, PuzzleController pc) {
        // create array list for buttons
        Button one = findViewById(R.id.button1);
        puzzle.buttons.add(one);
        one.setOnClickListener(pc);

        Button two = findViewById(R.id.button2);
        puzzle.buttons.add(two);
        two.setOnClickListener(pc);

        Button three = findViewById(R.id.button3);
        puzzle.buttons.add(three);
        three.setOnClickListener(pc);

        Button four = findViewById(R.id.button4);
        puzzle.buttons.add(four);
        four.setOnClickListener(pc);

        Button five = findViewById(R.id.button5);
        puzzle.buttons.add(five);
        five.setOnClickListener(pc);

        Button six = findViewById(R.id.button6);
        puzzle.buttons.add(six);
        six.setOnClickListener(pc);

        Button seven = findViewById(R.id.button7);
        puzzle.buttons.add(seven);
        seven.setOnClickListener(pc);

        Button eight = findViewById(R.id.button8);
        puzzle.buttons.add(eight);
        eight.setOnClickListener(pc);

        Button nine = findViewById(R.id.button9);
        puzzle.buttons.add(nine);
        nine.setOnClickListener(pc);

        Button ten = findViewById(R.id.button10);
        puzzle.buttons.add(ten);
        ten.setOnClickListener(pc);

        Button eleven = findViewById(R.id.button11);
        puzzle.buttons.add(eleven);
        eleven.setOnClickListener(pc);

        Button twelve = findViewById(R.id.button12);
        puzzle.buttons.add(twelve);
        twelve.setOnClickListener(pc);

        Button thirteen = findViewById(R.id.button13);
        puzzle.buttons.add(thirteen);
        thirteen.setOnClickListener(pc);

        Button fourteen = findViewById(R.id.button14);
        puzzle.buttons.add(fourteen);
        fourteen.setOnClickListener(pc);

        Button fifteen = findViewById(R.id.button15);
        puzzle.buttons.add(fifteen);
        fifteen.setOnClickListener(pc);

        Button empty = findViewById(R.id.emptyButton);
        puzzle.buttons.add(empty);
        empty.setOnClickListener(pc);

        // Changes the button numbers
        for (int i = 0; i < puzzle.size; i++) {
            for (int j = 0; j < puzzle.size; j++) {
                if (puzzle.puzzleArray[i][j] == -1) {
                    puzzle.buttons.get((i*4) + j).setText("");
                }
                else puzzle.buttons.get((i*4) + j).setText("" + puzzle.puzzleArray[i][j]);
            }
        }
    }
}