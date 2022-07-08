package com.example.vocale;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements StartFragment.StartFragmentListener {

    private StartFragment startFragment;
    private ResultFragment resultFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        startFragment = new StartFragment();
        resultFragment = new ResultFragment();

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.container_start, startFragment)
                .commit();
    }

    @Override
    public void onInputNumbersSent(CharSequence charSequence) {

    }
}
