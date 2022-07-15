package com.example.vocale;

import android.os.Build;

import androidx.annotation.RequiresApi;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Algorithm {

    private final List<Integer> numbersList;
    private int unique;

    @RequiresApi(api = Build.VERSION_CODES.N)
    public Algorithm(CharSequence charSequence) {
        String numbers = charSequence.toString();
        numbersList = Arrays.asList(numbers.split(",")).stream().map(s -> Integer.parseInt(s.trim())).collect(Collectors.toList());

        uniqueNumber(numbersList);
    }

    private int uniqueNumber(List<Integer> numbersList) {
        if (numbersList.size() < 3) {
            throw new ArrayStoreException("You have entered too few items!");
        }

        int even = (numbersList.get(0) | numbersList.get(1)) &
               (numbersList.get(0) | numbersList.get(2)) &
               (numbersList.get(1) | numbersList.get(2)) & 1;

        for (Integer number : numbersList) {
            if ((number & 1) != even) {
                unique = number;

                break;
            }
        }

        return unique;
    }

    public int getUnique() {
        return unique;
    }
}
