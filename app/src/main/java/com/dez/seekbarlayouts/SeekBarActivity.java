/*
Lab 3
Programmer: D.W.H.
Date: September 5, 2017
File Name: SeekBar
Purpose:

 */
package com.dez.seekbarlayouts;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;


public class SeekBarActivity extends AppCompatActivity {

    public static final String EXTRA_SQUARE_SIZE = "com.dez.tapthesquare.square";

    private static final int SQUARE_REQUEST_CODE = 0;


    //Create a seek bar method
    @Override
    protected void onCreate(Bundle savedInstanceState) { //This is a method to create a button
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seek_bar);

        final TextView seekbarValueTV = (TextView) findViewById(R.id.seek_bar_value_label);
        final SeekBar seekBar = (SeekBar) findViewById(R.id.seek_bar);

        Button showSquare = (Button) findViewById(R.id.showSquareButton);

        showSquare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent launchSquareActivity = new Intent(SeekBarActivity.this, SquareActivity.class);
                //add data to the Intent using putExtra method
                launchSquareActivity.putExtra(EXTRA_SQUARE_SIZE, seekBar.getProgress());

                startActivityForResult(launchSquareActivity, SQUARE_REQUEST_CODE);

            }
        });

        int seekbarProgress = seekBar.getProgress();

        seekbarValueTV.setText("The initial SeekBar value is " + seekbarProgress);

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                //The onProgressChanged method supplies the current SeekBar Progress
                seekbarValueTV.setText("The seekbar value is " + progress);

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                //Don't need to respond to this event, but still need to implement this method

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                //same here

            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

//Need to check what request ended up with this result
// And need to verify if the result was OK  - and not the user cancelling, or pressing back button

        if (requestCode == SQUARE_REQUEST_CODE && resultCode == RESULT_OK) {

            //Get the data from the Intent. Again, must provide a default
            boolean tappedSquare = data.getBooleanExtra(SquareActivity.EXTRA_INSIDE_SQUARE, true);

            //Indicate result to user with a toast
            if (tappedSquare) {
                Toast.makeText(this, "You tapped the square!@", Toast.LENGTH_LONG).show();
            } else
                Toast.makeText(this, "Sorry, you missed the square", Toast.LENGTH_LONG).show();

        }

    }
}


    //https://github.com/minneapolis-edu/Android2417Examples/blob/master/TapTheSquare/app/src/main/java/com/clara/tapthesquare/SeekBarActivity.java