package com.example.android.notifapp;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by Keerthi Suresh on 25-05-2016.
 */
public class Interval extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_interval, container,false);

       final EditText mEdit = (EditText) v.findViewById(R.id.interval);

        mEdit.addTextChangedListener(new TextWatcher() {

            public void afterTextChanged(Editable s) {

            }

            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            public void onTextChanged(CharSequence s, int start, int before, int count) {int interval = Integer.parseInt(s.toString());
                ((MainActivity)getActivity()).IntervalChanged(interval);
            }
        });


        return v;

    }

}
