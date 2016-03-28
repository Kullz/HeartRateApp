package com.android.apps.heartrateapp;


import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageButton;
import android.widget.ImageView;


public class FragmentHome extends Fragment {

    private ImageView homeBackground;
    private ImageButton homeNextButton;
    private int screenWidth;
    private int screenHeight;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View home = (View)inflater.inflate(R.layout.home_fragment, container, false);

        final MainActivity currentActivity = (MainActivity)getActivity();
        screenWidth = ((WindowManager)currentActivity.getSystemService(currentActivity.WINDOW_SERVICE)).getDefaultDisplay().getWidth();
        screenHeight = ((WindowManager)currentActivity.getSystemService(currentActivity.WINDOW_SERVICE)).getDefaultDisplay().getHeight();

        homeBackground = (ImageView) home.findViewById(R.id.home_background);
        homeBackground.setImageBitmap(ImageConverter.decodeSampledBitmapFromResource(getResources(), R.drawable.home_background,
                screenWidth, screenHeight));

        homeNextButton = (ImageButton) home.findViewById(R.id.home_next_button);
        homeNextButton.setImageBitmap(ImageConverter.decodeSampledBitmapFromResource(getResources(), R.drawable.home_b,
                screenWidth / 5, screenHeight / 13));

        homeNextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentActivity.setCurrentFragment(new FragmentInstructions());
                currentActivity.getFragmentManager().beginTransaction().replace(R.id.fragment_container, currentActivity.getCurrentFragment()).commit();
            }
        });

        // Inflate the layout for this fragment
        return home;
    }

}
