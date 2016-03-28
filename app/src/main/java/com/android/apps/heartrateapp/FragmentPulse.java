package com.android.apps.heartrateapp;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageButton;
import android.widget.ImageView;


public class FragmentPulse extends Fragment {

    private ImageButton pulseNextButton;
    private ImageView pulseBackground;

    private int screenWidth;
    private int screenHeight;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View home = (View)inflater.inflate(R.layout.fragment_pulse, container, false);

        final MainActivity currentActivity = (MainActivity)getActivity();
        screenWidth = ((WindowManager)currentActivity.getSystemService(currentActivity.WINDOW_SERVICE)).getDefaultDisplay().getWidth();
        screenHeight = ((WindowManager)currentActivity.getSystemService(currentActivity.WINDOW_SERVICE)).getDefaultDisplay().getHeight();

        pulseBackground = (ImageView) home.findViewById(R.id.pulse_background);
        pulseBackground.setImageBitmap(ImageConverter.decodeSampledBitmapFromResource(getResources(), R.drawable.pulse_background,
                screenWidth, screenHeight));

        pulseNextButton = (ImageButton) home.findViewById(R.id.pulse_next_button);
        pulseNextButton.setImageBitmap(ImageConverter.decodeSampledBitmapFromResource(getResources(), R.drawable.pulse_button,
                screenWidth / 4, screenHeight / 13));


        pulseNextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentActivity.setCurrentFragment(new FragmentDecision());
                currentActivity.getFragmentManager().beginTransaction().replace(R.id.fragment_container, currentActivity.getCurrentFragment()).commit();
            }
        });

        // Inflate the layout for this fragment
        return home;
    }

}
