package com.android.apps.heartrateapp;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageButton;
import android.widget.ImageView;


public class FragmentInstructions extends Fragment {

    private ImageView instructionsBackground;
    private ImageButton instructionsStartButtonPressed;
    private ImageButton instructionsStartButton;
    private ImageButton custom;

    private int screenWidth;
    private int screenHeight;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View home = (View)inflater.inflate(R.layout.fragment_instructions, container, false);

        final MainActivity currentActivity = (MainActivity)getActivity();
        screenWidth = ((WindowManager)currentActivity.getSystemService(currentActivity.WINDOW_SERVICE)).getDefaultDisplay().getWidth();
        screenHeight = ((WindowManager)currentActivity.getSystemService(currentActivity.WINDOW_SERVICE)).getDefaultDisplay().getHeight();

        instructionsBackground = (ImageView) home.findViewById(R.id.instructions_background);
        instructionsBackground.setImageBitmap(ImageConverter.decodeSampledBitmapFromResource(getResources(), R.drawable.instr_background,
                screenWidth, screenHeight));

//        instructionsStartButtonPressed = (ImageButton) home.findViewById(R.id.instr_b_start_pressed);
//        instructionsStartButtonPressed.setImageBitmap(ImageConverter.decodeSampledBitmapFromResource(getResources(), R.drawable.instr_b_start_pressed,
//                screenWidth / 3, screenHeight / 10));
//
//        instructionsStartButton = (ImageButton) home.findViewById(R.id.inst_b_start);
//        instructionsStartButton.setImageBitmap(ImageConverter.decodeSampledBitmapFromResource(getResources(), R.drawable.inst_b_start,
//                screenWidth / 3, screenHeight / 10));

        custom = (ImageButton) home.findViewById(R.id.start_button);

        custom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentActivity.setCurrentFragment(new FragmentPulse());
                currentActivity.getFragmentManager().beginTransaction().replace(R.id.fragment_container, currentActivity.getCurrentFragment()).commit();
            }
        });

        // Inflate the layout for this fragment
        return home;
    }

}
