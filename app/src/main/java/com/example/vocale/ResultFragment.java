package com.example.vocale;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

public class ResultFragment extends Fragment {

    @SuppressLint("SetTextI18n")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_result, container, false);

        TextView result = view.findViewById(R.id.result);
        MainActivity mainActivity = (MainActivity) getActivity();
        assert mainActivity != null;
        Integer uniqueNumber = mainActivity.getUniqueNumber();
        if (uniqueNumber == null) {
            result.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 22);
            result.setText(R.string.few_numbers);
        } else {
            result.setText(uniqueNumber.toString());
        }

        return view;
    }
}
