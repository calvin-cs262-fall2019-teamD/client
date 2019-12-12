package edu.calvin.cs262.fdn2;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class UserProfileScreen extends AppCompatActivity {

    RecyclerView recyclerview;
    ImageView profileImageView;
    String[] thescores = {"2-21", "1-21", "21-5", "21-9", "2-21"};
    String[] thewinrates = {"80", "60", "40", "84", "66"};
    UserProfileScreenAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_profile_screen);

//        Intent receiveBitmojiIntent = getIntent();
//        int bitmojiID = receiveBitmojiIntent.getIntExtra("userprofilebitmoji",0);
//        Log.d("idsearch", String.valueOf(bitmojiID));

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

    public void gotoGameRequestScreen(){
        Intent userProfileIntent = new Intent(getApplicationContext(), GameRequestScreen.class);
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
    /**Sends the user to the help page
     */
    public void gotoHelp(){
        Intent helpIntent = new Intent(this, HelpScreen.class);
        startActivity(helpIntent);
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


            case R.id.nav_game_request:
               gotoGameRequestScreen();
                break;

            //if the icon is the profile screen, we hint that we are already on that page
            case R.id.nav_profile:
                Toast.makeText(this,"Already viewing your profile", Toast.LENGTH_SHORT).show();
                break;

            case R.id.help:
                gotoHelp();
                break;

            default:
                break;

        }
        return true;
    }

//    @Override
//    public void onBackPressed() {
//        gotLeaderBoardScreen();
//        finish();
//    }
}
