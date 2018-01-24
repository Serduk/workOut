package com.example.sserdiuk.workout;


import android.app.Activity;
import android.os.Bundle;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        WorkoutDetailFragment fragment = (WorkoutDetailFragment) getFragmentManager().findFragmentById(R.id.detail_frag);
        fragment.setWorkout(1);
    }
}
