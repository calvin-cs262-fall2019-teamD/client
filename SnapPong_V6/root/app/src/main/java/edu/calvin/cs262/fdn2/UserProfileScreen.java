package edu.calvin.cs262.fdn2;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class UserProfileScreen extends AppCompatActivity {

    private RecyclerView recyclerview;
    private String[] thescores = {"2-21", "1-21", "21-5", "21-9", "2-21"};
    private String[] thewinrates = {"80", "60", "40", "84", "66"};
    private UserProfileScreenAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_profile_screen);

        //get our recyclerview
        recyclerview = findViewById(R.id.recyclerView);

        //get our adapter to display the values
        adapter = new UserProfileScreenAdapter(thescores, thewinrates);

        //set our adapter for our recycler view
        recyclerview.setAdapter(adapter);

        //get the layout structure for our recyclerview
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);

        //set the layout structure
        recyclerview.setLayoutManager(layoutManager);
    }
}
