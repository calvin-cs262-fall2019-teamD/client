package edu.calvin.cs262.fdn2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.widget.Toast;


public class LeaderBoardScreen extends AppCompatActivity {

    RecyclerView recyclerView;
    LeaderBoardAdapter adapter;

    //we create a random set of elo values and winRates to be displayed
    private String[] randomElos = {"578697","475425","465693","455731","374657","364291","321697","245594","271456","213477"};
    private String[] randomWinrate = {"80","50","96","88","36","17","36","19","38","40"};
    private int[] bitmojiImgs = {R.drawable.bitmoji1,R.drawable.bitmoji2,R.drawable.bitmoji3};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_leader_board_screen);

        //this receives the intent that the app is coming to this screen thus we get ready for it
        //with a toast
        Intent intent = getIntent();
        String action = intent.getAction();
        Uri data = intent.getData();

        Toast.makeText(getBaseContext(),"Welcome to SnapPong!", Toast.LENGTH_SHORT).show();




        recyclerView = findViewById(R.id.recyclerview2);

        //we pass into our adapter random elos and win rates to be displayed every time
        adapter = new LeaderBoardAdapter(this, randomElos,randomWinrate, bitmojiImgs);

        //we set the layoutmanager for our recyclerview
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);

        //we let our recyclerview use the adapter we created.
        recyclerView.setAdapter(adapter);
    }


    public void gotoUserProfileScreen(){
        Intent userProfileIntent = new Intent(getApplicationContext(), UserProfileScreen.class);
        startActivity(userProfileIntent);
    }


    public void gotoGameRequestScreen(){
        Intent userProfileIntent = new Intent(getApplicationContext(), GameRequestScreen.class);
        startActivity(userProfileIntent);
    }

    public void gotoLeaderboardScreen(){
        Intent userProfileIntent = new Intent(getApplicationContext(), LeaderBoardScreen.class);
        startActivity(userProfileIntent);
    }
//
//            public void onClick(View v) {
//                Intent userProfileIntent = new Intent(getApplicationContext(), UserProfileScreen.class);
//                startActivity(userProfileIntent);
//            }
//        });

    public void profileClicked(View view) {
        //we get the ID of particular view which is clicked
        int profileId = view.getId();

        //we then use the ID to check against the various ID's we set in our activity_main.xml file
        switch (profileId){
            case R.id.rank1bitmoji:
                gotoGameRequestScreen();
                break;

            case R.id.rank2bitmoji:
                gotoUserProfileScreen();
                break;


            default:
                Toast.makeText(this, "Clicked on a Nothing!",Toast.LENGTH_SHORT).show();
                break;
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.nav_menu, menu);

        // return true so that the menu pop up is opened
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        //we get the ID of particular view which is clicked
        int profileId = item.getItemId();
        //we then use the ID to check against the various ID's we set in our activity_main.xml file
        switch (profileId){
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
                Toast.makeText(this, "Clicked on a Nothing!",Toast.LENGTH_SHORT).show();
                break;
        }
        return true;
    }
}

//        setContentView(R.layout.nav_drawer);

//        //getting the toolbar stuff
//        Toolbar toolbar = findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);