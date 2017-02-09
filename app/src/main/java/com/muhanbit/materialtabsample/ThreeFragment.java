package com.muhanbit.materialtabsample;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.muhanbit.materialtabsample.rxeventbus.RxBus;
import com.muhanbit.materialtabsample.rxeventbus.RxEventBus;

import butterknife.BindView;
import butterknife.ButterKnife;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import rx.subjects.PublishSubject;
import rx.subjects.Subject;

import static com.muhanbit.materialtabsample.R.string.three;

/**
 * Created by hwjoo on 2016-12-22.
 */

public class ThreeFragment extends Fragment {
    @BindView(R.id.three_textview)
    TextView textView;

    private static int count2 = 1;
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
        Log.d("TEST","three fragment onCreatview");
        View threeView = inflater.inflate(R.layout.fragment_three, container, false);
        ButterKnife.bind(this, threeView);
//        RxEventBus.getInstance().getBusObservable()
//                .map(s->s+" hello.")
//                .subscribe(textView::setText);
        if(count2==1) {
            count2+=1;
            RxBus.get().register("test", String.class)
                    .subscribe(s->{
                        Log.d("TEST","threeFragment : "+s);
                    });
        }


        return threeView;
    }
    @Override
    public void onStop() {
        super.onStop();
        Log.d("TEST","three fragment onStop");
    }
}
