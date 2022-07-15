package com.example.vocale;

import java.util.List;

public class Algorithm {

    public int uniqueNumber(List<Integer> numbersList) {
        int unique = 0;

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
}
