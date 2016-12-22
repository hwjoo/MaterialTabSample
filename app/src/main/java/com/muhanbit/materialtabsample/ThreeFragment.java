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

public class ThreeFragment extends Fragment {
    public ThreeFragment(){
        //required empry public constructor
    }

    public static ThreeFragment newInstance(){
        ThreeFragment threeFragment = new ThreeFragment();
        return threeFragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_three, container, false);
    }
}
