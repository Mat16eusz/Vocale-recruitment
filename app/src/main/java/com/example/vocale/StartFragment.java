package com.example.vocale;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

/**
 * A simple {@link Fragment} subclass.
 */
public class StartFragment extends Fragment {

    private StartFragmentListener listener;
    private EditText enterNumbers;
    private Button searchByNumber;

    public interface StartFragmentListener {
        void onInputNumbersSent(CharSequence charSequence);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_start, container, false);

        enterNumbers = view.findViewById(R.id.enterNumbers);
        searchByNumber = view.findViewById(R.id.searchByNumber);
        searchByNumber.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CharSequence charSequence = enterNumbers.getText();
                listener.onInputNumbersSent(charSequence);
            }
        });

        return view;
    }

    public void updateEnterNumbers(CharSequence newText) {
        enterNumbers.setText(newText);
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
