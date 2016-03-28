package com.android.apps.heartrateapp;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageButton;
import android.widget.ImageView;


public class FragmentDecision extends Fragment {

    private ImageButton brainButton;
    private ImageButton distillButton;
    private ImageView decisionBackground;

    private int screenWidth;
    private int screenHeight;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View home = (View)inflater.inflate(R.layout.fragment_decision, container, false);

        final MainActivity currentActivity = (MainActivity)getActivity();
        screenWidth = ((WindowManager)currentActivity.getSystemService(currentActivity.WINDOW_SERVICE)).getDefaultDisplay().getWidth();
        screenHeight = ((WindowManager)currentActivity.getSystemService(currentActivity.WINDOW_SERVICE)).getDefaultDisplay().getHeight();

        brainButton = (ImageButton) home.findViewById(R.id.brain_button);
        brainButton.setImageBitmap(ImageConverter.decodeSampledBitmapFromResource(getResources(), R.drawable.dec_b_brain_custom,
                screenWidth/3, screenHeight/5));

        decisionBackground = (ImageView) home.findViewById(R.id.decision_background);
        decisionBackground.setImageBitmap(ImageConverter.decodeSampledBitmapFromResource(getResources(), R.drawable.dec_background,
                screenWidth, screenHeight));

        distillButton = (ImageButton) home.findViewById(R.id.brain_button);
        distillButton.setImageBitmap(ImageConverter.decodeSampledBitmapFromResource(getResources(), R.drawable.dec_b_distill_custom,
                screenWidth/3, screenHeight/5));;


        brainButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentActivity.setCurrentFragment(new FragmentHome());
                currentActivity.getFragmentManager().beginTransaction().replace(R.id.fragment_container, currentActivity.getCurrentFragment()).commit();
            }
        });

        distillButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentActivity.setCurrentFragment(new FragmentDistilling());
                currentActivity.getFragmentManager().beginTransaction().replace(R.id.fragment_container, currentActivity.getCurrentFragment()).commit();
            }
        });

        // Inflate the layout for this fragment
        return home;
    }
}
