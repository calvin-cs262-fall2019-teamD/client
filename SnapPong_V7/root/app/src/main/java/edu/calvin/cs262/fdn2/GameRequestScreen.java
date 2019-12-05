package edu.calvin.cs262.fdn2;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import com.snapchat.kit.sdk.Bitmoji;
import com.snapchat.kit.sdk.bitmoji.networking.FetchAvatarUrlCallback;

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
     * @param view: Button you clicked on (GameRequestButton)
     */

    public void sendGameRequest(View view) {
//        Toast.makeText(this,"Sending Game Request...",Toast.LENGTH_SHORT).show();


    }


    public void gotoUserProfileScreen(){
        Intent userProfileIntent = new Intent(getApplicationContext(), UserProfileScreen.class);
        startActivity(userProfileIntent);
    }


    public void gotLeaderBoardScreen(){
        Intent userProfileIntent = new Intent(getApplicationContext(), LeaderBoardScreen.class);
        startActivity(userProfileIntent);
    }

    /**
     * Creates the menu icons at the top of the screen
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
     * Decides what to do when you select a particular icon
     * @param item: the item you're clicking on
     * @return true
     */
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId())
        {

            case R.id.nav_leaderboard:
                gotLeaderBoardScreen();
                break;

            //if the icon is the game request screen, we hint that we are already on that page
            case R.id.nav_game_request:
                Toast.makeText(this,"Already viewing Game Request", Toast.LENGTH_SHORT).show();
                break;

            case R.id.nav_profile:
                gotoUserProfileScreen();
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
