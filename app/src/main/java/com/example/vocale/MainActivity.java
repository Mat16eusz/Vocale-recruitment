package com.example.vocale;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements StartFragment.StartFragmentListener {

    private StartFragment startFragment;
    private ResultFragment resultFragment;
    private int uniqueNumber;

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

    /**
     * A method that runs the algorithm for finding a unique number from an array and displays it.
     *
     * @param charSequence: string with numbers separated by ",".
     */
    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    public void onInputNumbersSent(CharSequence charSequence) {
        try {
            Algorithm algorithm = new Algorithm(charSequence);
            uniqueNumber = algorithm.getUnique();

            getSupportFragmentManager().beginTransaction()
                    .detach(startFragment)
                    .replace(R.id.container_result, resultFragment)
                    .commit();
        } catch (Exception e) {
            Toast.makeText(this, R.string.few_numbers, Toast.LENGTH_SHORT).show();
        }
    }

    /**
     * Returns a different number.
     *
     * @return int: a different number.
     */
    public int getUniqueNumber() {
        return uniqueNumber;
    }
}
