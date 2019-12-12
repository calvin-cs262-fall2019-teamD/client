package edu.calvin.cs262.fdn2;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

/**
 * Game requests screen pulls up user's friend list from Snapchat (currently not working)
 */

public class GameRequestScreen extends AppCompatActivity {

    ImageButton gamerequestButt;
    ImageView secondplayer;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_request_screen);

        gamerequestButt = findViewById(R.id.send_gamerequestButt);
        secondplayer = findViewById(R.id.secondplayerfromgamerequest);


    }

    /**
     * Sends a game Request Via SnapChat
     *
     * @param view: Button you clicked on (GameRequestButton)
     */

    public void sendGameRequest(View view) {
//        Toast.makeText(this,"Sending Game Request...",Toast.LENGTH_SHORT).show();


    }

    /**
     * Goes to the logged in user's profile page
     */
    public void gotoUserProfileScreen() {
        Intent userProfileIntent = new Intent(getApplicationContext(), UserProfileScreen.class);
        startActivity(userProfileIntent);
    }

    /**
     * Goes to the leaderboard page
     */

    public void gotLeaderBoardScreen() {
        Intent userProfileIntent = new Intent(getApplicationContext(), LeaderBoardScreen.class);
        startActivity(userProfileIntent);
    }

    /**
     * Creates the menu icons at the top of the screen
     *
     * @param menu: the menu you're inflating
     * @return true
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.nav_menu, menu);
        // return true so that the menu pop up is opened
        return true;
    }

    /**
     * Sends the user to the help page
     */
    public void gotoHelp() {
        Intent helpIntent = new Intent(this, HelpScreen.class);
        startActivity(helpIntent);
    }

    /**
     * Decides what to do when you select a particular icon
     *
     * @param item: the item you're clicking on
     * @return true
     */
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {

            case R.id.nav_leaderboard:
                gotLeaderBoardScreen();
                break;

            //if the icon is the game request screen, we hint that we are already on that page
            case R.id.nav_game_request:
                Toast.makeText(this, "Already viewing Game Request", Toast.LENGTH_SHORT).show();
                break;

            case R.id.nav_profile:
                gotoUserProfileScreen();
                break;

            case R.id.help:
                gotoHelp();
                break;

        }
        return true;
    }

    @Override
    public void onBackPressed() {
        gotLeaderBoardScreen();
        finish();
    }


}
