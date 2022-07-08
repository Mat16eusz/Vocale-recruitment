package com.example.vocale;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

/**
 * A simple {@link Fragment} subclass.
 */
public class ResultFragment extends Fragment {

    private TextView result;
    private MainActivity mainActivity;
    private Integer uniqueNumber;

    @SuppressLint("SetTextI18n")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_result, container, false);

        result = view.findViewById(R.id.result);
        mainActivity = (MainActivity) getActivity();
        assert mainActivity != null;
        uniqueNumber = mainActivity.getUniqueNumber();
        result.setText(uniqueNumber.toString());

        return view;
    }
}
