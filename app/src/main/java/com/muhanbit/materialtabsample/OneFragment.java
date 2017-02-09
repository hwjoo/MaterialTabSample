package com.muhanbit.materialtabsample;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.muhanbit.materialtabsample.rxeventbus.RxBus;
import com.muhanbit.materialtabsample.rxeventbus.RxEventBus;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import rx.Subscription;

/**
 * Created by hwjoo on 2016-12-22.
 */

public class OneFragment extends Fragment {
    @BindView(R.id.one_edittext)
    EditText editText;
    @BindView(R.id.one_textview)
    TextView textView;
    @BindView(R.id.one_btn)
    Button btn;

    Subscription mSubscription;

    private static int count = 1;

    public OneFragment(){
        //required empry public constructor
    }
    public static OneFragment newInstance(){
        OneFragment oneFragment = new OneFragment();
        return oneFragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Log.d("TEST","one fragment onCreatview");
        View oneView = inflater.inflate(R.layout.fragment_one, container, false);
        ButterKnife.bind(this, oneView);

        if(count==1) {
            count+=1;
            mSubscription = RxBus.get().register("test", String.class)
                    .subscribe(s->{
                        Log.d("TEST","oneFragment : "+s);
                    });
            RxEventBus.getInstance().getBusObservable().subscribe(
                    s->{
                        Log.d("TEST","oneFragment : "+s);
                    }
            );
        }
        return oneView;
    }
    @OnClick(R.id.one_btn)
    void btnClick(){
//        RxEventBus.getInstance().post(editText.getText().toString());
//        RxBus.get().post("test", "hwjoo");
        mSubscription.unsubscribe();
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.d("TEST","one fragment onStop");
    }
}
