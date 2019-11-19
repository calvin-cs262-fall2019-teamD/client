package edu.calvin.cs262.fdn2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
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


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_leader_board_screen);
//        setContentView(R.layout.nav_drawer);

        //getting the toolbar stuff
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        recyclerView = findViewById(R.id.recyclerview2);

        //we pass into our adapter random elos and win rates to be displayed every time
        adapter = new LeaderBoardAdapter(this, randomElos,randomWinrate);

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

            case R.id.rank3bitmoji:
                gotoUserProfileScreen();
                break;

            default:
                Toast.makeText(this, "Clicked on a Nothing!",Toast.LENGTH_SHORT).show();
                break;
        }
    }
}