package com.example.vocale;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements StartFragment.StartFragmentListener {

    private Integer uniqueNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void onInputNumbersSent(CharSequence charSequence) {
        try {
            Algorithm algorithm = new Algorithm(charSequence);
            uniqueNumber = algorithm.getUnique();
        } catch (Exception e) {
            uniqueNumber = null;
            Toast.makeText(this, R.string.few_numbers, Toast.LENGTH_SHORT).show();
        }
    }

    public Integer getUniqueNumber() {
        return uniqueNumber;
    }
}
