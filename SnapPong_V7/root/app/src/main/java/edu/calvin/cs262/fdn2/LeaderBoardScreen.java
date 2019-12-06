package edu.calvin.cs262.fdn2;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.widget.TextView;
import android.widget.Toast;

import com.snapchat.kit.sdk.Bitmoji;
import com.snapchat.kit.sdk.SnapLogin;
import com.snapchat.kit.sdk.bitmoji.networking.FetchAvatarUrlCallback;
import com.snapchat.kit.sdk.login.models.MeData;
import com.snapchat.kit.sdk.login.models.UserDataResponse;
import com.snapchat.kit.sdk.login.networking.FetchUserDataCallback;

import java.util.Map;


public class LeaderBoardScreen extends AppCompatActivity {

    RecyclerView recyclerView;
    LeaderBoardAdapter adapter;




    //we create a random set of elo values and winRates to be displayed
    private String[] randomElos = {"578697","475425","465693","455731","374657","364291","321697","245594","271456","213477"};
    private String[] randomWinrate = {"80%","50%","96%","88%","36%","17%","36%","19%","38%","40%"};
    private int[] bitmojiImgs = {R.drawable.bitmoji1,R.drawable.bitmoji2};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_leader_board_screen);

        //this receives the intent that the app is coming to this screen thus we get ready for it
        //with a toast
        Intent intent = getIntent();
        String action = intent.getAction();
        Uri data = intent.getData();






//        Toast.makeText(getBaseContext(),"Welcome to SnapPong!", Toast.LENGTH_SHORT).show();

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
//
//            public void onClick(View v) {
//                Intent userProfileIntent = new Intent(getApplicationContext(), UserProfileScreen.class);
//                startActivity(userProfileIntent);
//            }
//        });

    /**
     *This function takes the user to the profile page of the top Ranked player.
     * @param view: the view being displayed - in this case the different bitmojis
     */
    public void profileClicked(View view) {
//        we get the ID of particular view which is clicked
        Intent userProfileIntent = new Intent(getApplicationContext(), UserProfileScreen.class);

//        userProfileIntent.putExtra("userprofilebitmoji",view.getId() );
        startActivity(userProfileIntent);
//
//        //we then use the ID to check against the various ID's we set in our activity_main.xml file
//        switch (profileId){
//            case R.id.rank1bitmoji:
//                gotoGameRequestScreen();
//                break;
//
//            case R.id.rank2bitmoji  R.id.rank3bitmoji:
//                gotoUserProfileScreen();
//                break;
//
//
//            default:
//                Toast.makeText(this, "Clicked on a Nothing!",Toast.LENGTH_SHORT).show();
//                break;
//        }
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
            //if the icon is the leaderboard, we hint that we are already on the leaderboard page
            case R.id.nav_leaderboard:
                Toast.makeText(this,"Already viewing Leaderboard", Toast.LENGTH_SHORT).show();
                break;

            case R.id.nav_game_request:
                gotoGameRequestScreen();
                break;

            case R.id.nav_profile:
                gotoUserProfileScreen();
                break;

        }
        return true;
    }

    @Override
    public void onBackPressed() {
        finish();
    }

}
