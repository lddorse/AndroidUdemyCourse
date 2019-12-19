package com.dorsey.tipcalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText enteredAmount;
    private SeekBar seekBar;
    private Button calculateButton;
    private TextView totalResultTextView;
    private TextView textViewSeekbar;
    private int seekbarPercentage;
    private float enteredBillFloat;
    private TextView totalBillTV;

    //public static final String TAG = "MainAvtivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        enteredAmount = (EditText) findViewById(R.id.billAmountID);
        seekBar = (SeekBar) findViewById(R.id.percentageSeekBar);
        calculateButton = (Button) findViewById(R.id.calculateButton);
        totalResultTextView = (TextView) findViewById(R.id.resultID);
        textViewSeekbar = (TextView) findViewById(R.id.textViewSeekbar);
        totalBillTV = (TextView) findViewById(R.id.totalBillTextView);

        //Toast.makeText(getApplication(), "Hello", Toast.LENGTH_LONG).show();

        //Log.v(TAG, getApplicationContext().getString(R.string.app_name));

        calculateButton.setOnClickListener(this);

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

                textViewSeekbar.setText(String.valueOf(seekBar.getProgress()) + "%");

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

                seekbarPercentage = seekBar.getProgress();


            }
        });


    }

    @Override
    public void onClick(View v) {
        calculate();

        //TODO: Fix this code


    }

    public void calculate() {
        float result = 0.0f;

        if (!enteredAmount.getText().toString().equals("")) {

            enteredBillFloat = Float.parseFloat(enteredAmount.getText().toString());
            result = enteredBillFloat * seekbarPercentage / 100;
            totalResultTextView.setText("Your tip will be $" + String.valueOf(result));
            totalBillTV.setText("Total bill: " + String.valueOf(enteredBillFloat + result));

        } else {
            Toast.makeText(MainActivity.this, "Please enter a bill amount.", Toast.LENGTH_LONG).show();
        }
    }
}