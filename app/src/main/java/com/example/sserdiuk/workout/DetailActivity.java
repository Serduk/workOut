package com.example.sserdiuk.workout;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class DetailActivity extends AppCompatActivity {
    public static final String EXTRA_WORKOUT_ID = "id";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        WorkoutDetailFragment fragment = (WorkoutDetailFragment) getFragmentManager().
                findFragmentById(R.id.detail_frag);

        int workoutID = (int) getIntent().getExtras().get(EXTRA_WORKOUT_ID);
        fragment.setWorkout(workoutID);
    }

}
