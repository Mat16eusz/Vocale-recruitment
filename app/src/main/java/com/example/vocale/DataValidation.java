package com.example.vocale;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class DataValidation {

    private final List<Integer> numbersList;

    public DataValidation(CharSequence charSequence) {
        String numbers = charSequence.toString();

        numbersList = Arrays.stream(numbers.split(",")).map(s -> Integer.parseInt(s.trim())).collect(Collectors.toList());

        if (numbersList.size() < 3) {
            throw new ArrayStoreException("You have entered too few items!");
        }
    }

    public List<Integer> getNumbersList() {
        return numbersList;
    }
}
