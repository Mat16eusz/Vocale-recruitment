package com.example.vocale;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

public class StartFragment extends Fragment {

    private StartFragmentListener listener;
    private EditText enterNumbers;

    public interface StartFragmentListener {
        void onInputNumbersSent(CharSequence charSequence);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_start, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        NavController navController = Navigation.findNavController(view);

        enterNumbers = view.findViewById(R.id.enterNumbers);
        Button searchByNumber = view.findViewById(R.id.searchByNumber);
        searchByNumber.setOnClickListener(view1 -> {
            CharSequence charSequence = enterNumbers.getText();
            listener.onInputNumbersSent(charSequence);
            navController.navigate(R.id.action_startFragment_to_resultFragment);
        });
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);

        if (context instanceof StartFragmentListener) {
            listener = (StartFragmentListener) context;
        } else {
            throw new RuntimeException(context + " must implement StartFragmentListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();

        listener = null;
    }
}
