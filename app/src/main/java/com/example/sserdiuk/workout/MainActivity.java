package com.example.sserdiuk.workout;


import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MainActivity extends AppCompatActivity implements WorkoutListFragment.WorkoutListListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }




    /**
     * Method for replacing fragments in frame
     * */
    @Override
    public void itemClicked(long id) {
        View fragmentContainer = findViewById(R.id.fragment_container);

        /*
        * Part for large size displays
        * If we open on tablet -> we'll see all in 2 fragments on main screen
        * Else: open in new screen
        * */
        if (fragmentContainer != null) {
            WorkoutDetailFragment details = new WorkoutDetailFragment();
            FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
            details.setWorkout(id);
            fragmentTransaction.replace(R.id.fragment_container, details);
            fragmentTransaction.addToBackStack(null);
            fragmentTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
            fragmentTransaction.commit();
        } else {
            Intent intent = new Intent(this, DetailActivity.class);
            intent.putExtra(DetailActivity.EXTRA_WORKOUT_ID, (int) id);
            startActivity(intent);
        }
    }
}
