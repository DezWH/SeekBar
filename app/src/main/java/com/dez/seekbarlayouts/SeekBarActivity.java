/*
Lab 3
Programmer: D.W.H.
Date: September 5, 2017
File Name: SeekBar
Purpose:

 */
package com.dez.seekbarlayouts;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.SeekBar;
import android.widget.TextView;


public class SeekBarActivity extends AppCompatActivity {

    //Global vars for widgets
    SeekBar mSeekBar;        //Identifier Buttom
    TextView mSeekBarLabel;

    //Create a seek bar method
    @Override
    protected void onCreate(Bundle savedInstanceState) { //This is a method to create a button
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seek_bar);

        //Initialize vars
        mSeekBar = (SeekBar) findViewById(R.id.seek_bar);
        mSeekBarLabel = (TextView) findViewById(R.id.seek_bar_value_label);

        //Set initial TextView value using a format string resource
        //Set Textview Text to SeekBar's progress
        mSeekBarLabel.setText(getString(R.string.seekbar_progress, mSeekBar.getProgress()));

        //Set up listenser
        addSeekBarListener();
    }
    //Set up listenr
    private void addSeekBarListener() {

        //Set a Listener method on the object mSeekBar
        mSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                mSeekBarLabel.setText(getString(R.string.seekbar_progress, progress));
            }

            //OnStart will start tracking the Touch of the user
            @Override
            public void onStartTrackingTouch(SeekBar seeker) {
                //We don't care about this event in this app, but are required to implement this methoid.
                //It's ok that nothing happens here, our app doens't need to do anything when this event happens

            }
            //
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                //Same as previous method, can leave this empty.

            }

        });

    }
}
