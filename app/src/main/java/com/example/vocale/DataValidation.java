package com.example.vocale;

import androidx.annotation.NonNull;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class DataValidation {

    public List<Integer> listValidation(@NonNull CharSequence charSequence) {
        String numbers = charSequence.toString();

        List<Integer> numbersList = Arrays.stream(numbers.split(",")).map(s -> Integer.parseInt(s.trim())).collect(Collectors.toList());

        if (numbersList.size() < 3) {
            throw new ArrayStoreException("You have entered too few items!");
        }

        return numbersList;
    }
}
