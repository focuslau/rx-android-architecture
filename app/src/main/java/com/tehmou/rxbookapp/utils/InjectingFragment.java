package com.tehmou.rxbookapp.utils;

import android.os.Bundle;
import android.support.v4.app.Fragment;

import com.tehmou.rxbookapp.MainActivity;

/**
 * Created by ttuo on 11/06/14.
 */
public class InjectingFragment extends Fragment {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ((MainActivity) getActivity()).getObjectGraph().inject(this);
    }
}
