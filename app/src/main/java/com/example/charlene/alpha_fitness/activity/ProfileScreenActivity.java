package com.example.charlene.alpha_fitness.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.ListView;

import com.example.charlene.alpha_fitness.R;
import com.example.charlene.alpha_fitness.database.DatabaseHelper;
import com.example.charlene.alpha_fitness.model.User;
import com.example.charlene.alpha_fitness.model.Workout;

import java.util.ArrayList;
import java.util.Date;

public class ProfileScreenActivity extends AppCompatActivity {
    public static final String TAG = "ProfileScreenActivity";

    private User user;
    private Workout workout;

    private ListView lvAverage;
    private ListView lvAllTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_sceen);
        setUp();
    }

    public void setUp(){
        // get distance time workouts and calories from textView
        DatabaseHelper db = DatabaseHelper.getInstance(this);

        /* How to get user info and update it, username is not updatable
        User u = db.getUser();
        db.updateUser(new User("Charlene Jiang", "male", 100.0));
        User u1 = db.getUser();*/

        // ************************* checked *************************
        // get data from db and display on front-end
        // db getWorkout according to the date, find the whole week
        Date date = new Date();
        int weekday = date.getDay();
        lvAverage = findViewById(R.id.ListViewAverage);
        lvAllTime = findViewById(R.id.ListViewAllTime);

        String[] averageWorkout = db.getWorkoutAverage();
        ArrayAdapter<String> adapterAve = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1, averageWorkout);
        lvAverage.setAdapter(adapterAve);

        String[] alltimeWorkout = db.getWorkoutAllTime();
        ArrayAdapter<String> adapterAllTime = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1, alltimeWorkout);
        lvAllTime.setAdapter(adapterAllTime);

    }







}
