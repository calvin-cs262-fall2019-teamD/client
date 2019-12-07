package edu.calvin.cs262.fdn2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

public class GameRequestScreen extends AppCompatActivity {

    ImageButton sendChallengeButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_request_screen);

        //access the sencChallenge button
        sendChallengeButton = findViewById(R.id.sendChallengeButton);

        //set action when send challenge button clicked
        sendChallengeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gotoGameComplete();
                //SnapLogin.getAuthTokenManager(getApplicationContext()).startTokenGrant();
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.nav_menu, menu);

        // return true so that the menu pop up is opened
        return true;
    }

    public void gotoGameComplete()
    {
        Intent gameCompleteIntent = new Intent(getApplicationContext(), game_complete_screen.class);
        startActivity(gameCompleteIntent);
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
