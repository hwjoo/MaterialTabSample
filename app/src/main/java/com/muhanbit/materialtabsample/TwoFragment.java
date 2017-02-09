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
import rx.Scheduler;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import rx.subjects.PublishSubject;
import rx.subjects.Subject;

/**
 * Created by hwjoo on 2016-12-22.
 */

public class TwoFragment extends Fragment {
    @BindView(R.id.two_textview)
    TextView textView;
    private static int count1 =1;

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
        Log.d("TEST","two fragment onCreatview");
        View twoView = inflater.inflate(R.layout.fragment_two, container, false);
        ButterKnife.bind(this, twoView);

        if(count1==1) {
            count1+=1;
            RxBus.get().register("test", String.class)
                    .subscribe(s->{
                        Log.d("TEST","twoFragment : "+s);
                    });
            RxEventBus.getInstance().getBusObservable().subscribe(
                    s->{
                        Log.d("TEST","twoFragment : "+s);
                    }
            );
        }

        return twoView;
    }
    @Override
    public void onStop() {
        super.onStop();
        Log.d("TEST","two fragment onStop");
    }
}
