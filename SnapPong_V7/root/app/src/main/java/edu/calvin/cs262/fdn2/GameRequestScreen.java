package edu.calvin.cs262.fdn2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

public class GameRequestScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_request_screen);
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
            case R.id.nav_profile:
                gotoUserProfileScreen();
                break;

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
