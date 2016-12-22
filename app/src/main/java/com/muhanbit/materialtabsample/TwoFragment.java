package com.muhanbit.materialtabsample;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by hwjoo on 2016-12-22.
 */

public class TwoFragment extends Fragment {
    public TwoFragment(){
        //required empry public constructor
    }

    public static TwoFragment newInstance(){
        TwoFragment twoFragment = new TwoFragment();
        return twoFragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_two, container, false);
    }
}
