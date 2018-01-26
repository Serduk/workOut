package com.example.sserdiuk.workout;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        WorkoutDetailFragment fragment = (WorkoutDetailFragment) getSupportFragmentManager()
                .findFragmentById(R.id.detail_frag);

        fragment.setWorkout(1);
    }
}
