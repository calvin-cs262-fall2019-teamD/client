package edu.calvin.cs262.fdn2;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class UserProfileScreen extends AppCompatActivity {

    RecyclerView recyclerview;
    String[] thescores = {"2-21", "1-21", "21-5", "21-9", "2-21"};
    String[] thewinrates = {"80", "60", "40", "84", "66"};
    UserProfileScreenAdapter adapter;

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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.nav_menu, menu);

        // return true so that the menu pop up is opened
        return true;
    }

    public void gotoUserProfileScreen() {
        Intent userProfileIntent = new Intent(getApplicationContext(), UserProfileScreen.class);
        startActivity(userProfileIntent);
    }


    public void gotoGameRequestScreen() {
        Intent userProfileIntent = new Intent(getApplicationContext(), GameRequestScreen.class);
        startActivity(userProfileIntent);
    }

    public void gotoLeaderboardScreen() {
        Intent userProfileIntent = new Intent(getApplicationContext(), LeaderBoardScreen.class);
        startActivity(userProfileIntent);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        //we get the ID of particular view which is clicked
        int profileId = item.getItemId();
        //we then use the ID to check against the various ID's we set in our activity_main.xml file
        switch (profileId) {

            case R.id.nav_game_request:
                gotoGameRequestScreen();
                break;

            case R.id.nav_leaderboard:
                gotoLeaderboardScreen();
                break;

            default:
                Toast.makeText(this, "Clicked on a Nothing!", Toast.LENGTH_SHORT).show();
                break;
        }
        return true;
    }
}
