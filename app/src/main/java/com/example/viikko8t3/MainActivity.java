package com.example.viikko8t3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    BottleDispenser bottle = BottleDispenser.getInstance();
    TextView etCurrentMoney;
    TextView etMessageConsole;
    TextView etProduct1Name;
    TextView etProduct2Name;
    TextView etProduct3Name;
    TextView etProduct4Name;
    TextView etProduct5Name;
    SeekBar seekBar;
    TextView seekBarNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etCurrentMoney = findViewById(R.id.currentMoney);
        etMessageConsole = findViewById(R.id.messageConsole);
        etProduct1Name = findViewById(R.id.product1Name);
        etProduct1Name.setText(bottle.getArrayElementName(1) + " " + bottle.getArrayElementSize(1));
        etProduct2Name = findViewById(R.id.product2Name);
        etProduct2Name.setText(bottle.getArrayElementName(2) + " " + bottle.getArrayElementSize(2));
        etProduct3Name = findViewById(R.id.product3Name);
        etProduct3Name.setText(bottle.getArrayElementName(3) + " " + bottle.getArrayElementSize(3));
        etProduct4Name = findViewById(R.id.product4Name);
        etProduct4Name.setText(bottle.getArrayElementName(4) + " " + bottle.getArrayElementSize(4));
        etProduct5Name = findViewById(R.id.product5Name);
        etProduct5Name.setText(bottle.getArrayElementName(5) + " " + bottle.getArrayElementSize(5));
        seekBar = findViewById(R.id.seekBar);
        seekBarNumber = findViewById(R.id.seekBarNumber);
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                seekBarNumber.setText(String.valueOf(progress));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }

    public void addMoney(View view) {
        bottle.addMoney(Integer.parseInt(seekBarNumber.getText().toString()));
        seekBar.setProgress(0);
        etCurrentMoney.setText(String.valueOf(bottle.getMoney()));
        etMessageConsole.setText("Klink! Added more money!");
        return;
    }

    public void buy1(View view) {
        buyBottle(1);
        return;
    }

    public void buy2(View view) {
        buyBottle(2);
        return;
    }

    public void buy3(View view) {
        buyBottle(3);
        return;
    }

    public void buy4(View view) {
        buyBottle(4);
        return;
    }

    public void buy5(View view) {
        buyBottle(5);
        return;
    }

    public void buyBottle(int choice) {
        int errCode = bottle.buyBottle(choice);
        if (errCode == 0) {
            etCurrentMoney.setText(String.valueOf(bottle.getMoney()));
            etMessageConsole.setText("KACHUNK! " + bottle.getArrayElementName(choice) + " came out of the dispenser!");
            bottle.removeArray(choice);
            etProduct1Name.setText(bottle.getArrayElementName(1) + " " + bottle.getArrayElementSize(1));
            etProduct2Name.setText(bottle.getArrayElementName(2) + " " + bottle.getArrayElementSize(2));
            etProduct3Name.setText(bottle.getArrayElementName(3) + " " + bottle.getArrayElementSize(3));
            etProduct4Name.setText(bottle.getArrayElementName(4) + " " + bottle.getArrayElementSize(4));
            etProduct5Name.setText(bottle.getArrayElementName(5) + " " + bottle.getArrayElementSize(5));
        } else if (errCode == 1) {
            etMessageConsole.setText("Not enough bottles!");
        } else if (errCode == 2) {
            etMessageConsole.setText("Add money first!");
        }
        return;
    }

    public void returnMoney(View view) {
        etMessageConsole.setText("Klink klink. Money came out! You got " + String.format("%.2f", bottle.getMoney()) + "€ back");
        bottle.returnMoney();
        etCurrentMoney.setText(String.valueOf(bottle.getMoney()));
        return;
    }

}