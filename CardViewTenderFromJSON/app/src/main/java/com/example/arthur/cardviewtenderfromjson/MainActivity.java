package com.example.arthur.cardviewtenderfromjson;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {
    private CardViewFragment cardViewFragment;
    private DetailFragment detailFragment;

    private FragmentManager fragmentManager;
    private FragmentTransaction fragmentTransaction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d("MyTag", "onCreate");

        //Create FragmentManager
        fragmentManager = getSupportFragmentManager();

        //Initialization fragments
        cardViewFragment = new CardViewFragment();
        detailFragment = new DetailFragment();


        fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.container, cardViewFragment, CardViewFragment.TAG);
        fragmentTransaction.commit();
    }
}
