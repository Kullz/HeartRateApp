package com.android.apps.heartrateapp;

import android.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;


public class MainActivity extends FragmentActivity {

    private static Fragment currentFragment = new FragmentHome();

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getFragmentManager().beginTransaction().replace(R.id.fragment_container, currentFragment).commit();

    }

    public void setCurrentFragment(Fragment fragment){
        currentFragment = fragment;
    }

    public Fragment getCurrentFragment(){
        return currentFragment;
    }

}
