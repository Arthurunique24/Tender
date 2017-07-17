package com.example.arthur.cardviewtenderfromjson;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportFragmentManager().beginTransaction()
                .add(R.id.container, new CardViewFragment(), CardViewFragment.TAG).commit();

//        getSupportFragmentManager().beginTransaction()
//                .add(R.id.container, new MoreDetailFragment(), MoreDetailFragment.TAG).commit();
    }

}
