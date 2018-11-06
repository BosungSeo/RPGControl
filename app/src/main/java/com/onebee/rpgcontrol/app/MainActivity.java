package com.onebee.rpgcontrol.app;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.onebee.rpgcontrol.R;
import com.onebee.rpgcontrol.app.Core.EngineCore;

public class MainActivity extends AppCompatActivity {
    EngineCore mCore;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mCore = new EngineCore();
    }
}
