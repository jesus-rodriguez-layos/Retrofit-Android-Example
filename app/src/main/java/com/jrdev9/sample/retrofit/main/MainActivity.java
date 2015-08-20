package com.jrdev9.sample.retrofit.main;

import android.app.Activity;
import android.os.Bundle;

import com.jrdev9.sample.retrofit.R;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        new MainPresenter(this);
    }
}
