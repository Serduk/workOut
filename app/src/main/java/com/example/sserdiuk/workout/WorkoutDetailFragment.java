package com.example.sserdiuk.workout;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class WorkoutDetailFragment extends Fragment {
    private long workoutID;

    public WorkoutDetailFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        if (savedInstanceState != null) {
            workoutID = savedInstanceState.getLong("workoutID");
        } else {
//        Open transaction
            FragmentTransaction ft = getChildFragmentManager().beginTransaction();
            StopwatchFragment stopwatchFragment = new StopwatchFragment();
//        replace fragment in frame
            ft.replace(R.id.stopwatch_container, stopwatchFragment);
//        add transaction to stack for returning
            ft.addToBackStack(null);
//        choose stile for animation
            ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
//        zakrepit transaction
            ft.commit();
        }

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_workout_detail, container, false);
    }

    @Override
    public void onStart() {
        super.onStart();
        /*
        * Method getView get root object View of fragment
        * Nex: received object used for receive links for text,
        * which should be displayed in title and description
        * */
        View view = getView();

        if (view != null) {
            TextView title = (TextView) view.findViewById(R.id.textTitle);
            Workout workout = Workout.workouts[(int) workoutID];
            title.setText(workout.getName());
            TextView description = (TextView) view.findViewById(R.id.textDescription);
            description.setText(workout.getDescription());
        }
    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        savedInstanceState.putLong("workoutID", workoutID);
    }

    public void setWorkout(long id) {
        this.workoutID = id;
    }

}
