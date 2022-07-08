package com.example.vocale;

import android.os.Build;

import androidx.annotation.RequiresApi;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Algorithm {

    private final List<Integer> numbersList;
    private int unique;

    /**
     * The constructor converts a string of characters separated by commas into a list of integers.
     *
     * @param charSequence: string with numbers separated by ",".
     */
    @RequiresApi(api = Build.VERSION_CODES.N)
    public Algorithm(CharSequence charSequence) {
        String numbers = charSequence.toString();
        numbersList = Arrays.asList(numbers.split(",")).stream().map(s -> Integer.parseInt(s.trim())).collect(Collectors.toList());

        uniqueNumber(numbersList);
    }

    /**
     * A method that returns a number from the int list that is distinct from the rest. For example:
     * 2,4,0,100,4,11,2602,36 will return 11 and 160,3,1719,19,11,13,-21 will return 160.
     *
     * @param numbersList: a list with integers.
     * @return int: a number different from the rest of the numbers in the list.
     */
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

    /**
     * Returns a different number.
     *
     * @return int: a different number.
     */
    public int getUnique() {
        return unique;
    }
}
