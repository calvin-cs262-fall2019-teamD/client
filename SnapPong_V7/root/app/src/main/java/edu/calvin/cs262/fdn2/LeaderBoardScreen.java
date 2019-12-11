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
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.widget.TextView;
import android.widget.Toast;

import com.snapchat.kit.sdk.Bitmoji;
import com.snapchat.kit.sdk.SnapLogin;
import com.snapchat.kit.sdk.bitmoji.networking.FetchAvatarUrlCallback;
import com.snapchat.kit.sdk.core.controller.LoginStateController;
import com.snapchat.kit.sdk.login.models.MeData;
import com.snapchat.kit.sdk.login.models.UserDataResponse;
import com.snapchat.kit.sdk.login.networking.FetchUserDataCallback;

import java.util.List;
import java.util.Map;


public class LeaderBoardScreen extends AppCompatActivity {

    RecyclerView recyclerView;
    LeaderBoardAdapter adapter;
    String query = "{me{bitmoji{avatar},displayName}}";
    Map<String ,Object> variables = null;
    public String username = "empty";
    private PlayerViewModel mplayerViewModel;



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

        //checks to see if we are logged in
//        boolean isUserLoggedIn = SnapLogin.isUserLoggedIn(getApplicationContext());
//        Toast.makeText(this, Boolean.toString(isUserLoggedIn),Toast.LENGTH_SHORT).show();

        //we get a View model from the ViewModelProviders class provided by android


        recyclerView = findViewById(R.id.recyclerview2);

        //this is for testing the player adapter
        final PlayerAdapter adapter = new PlayerAdapter(this);
        recyclerView.setAdapter(adapter);

        //setting the layout structure to be linear
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        mplayerViewModel = ViewModelProviders.of(this).get(PlayerViewModel.class);

        //we add an observer for the LiveData returned by getAllPlayers()
        mplayerViewModel.getPlayers().observe(this, new Observer<List<Player>>() {
            @Override
            public void onChanged(List<Player> players) {
                //update the cached copy of the words in the adapter
                adapter.setPlayers(players);
            }
        });
//        //we pass into our adapter random elos and win rates to be displayed every time
//        adapter = new LeaderBoardAdapter(this, randomElos,randomWinrate, bitmojiImgs);
//
//        //we set the layoutmanager for our recyclerview
//        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
//        recyclerView.setLayoutManager(layoutManager);
//
//        //we let our recyclerview use the adapter we created.
//        recyclerView.setAdapter(adapter);
    }

    /**
     * Checks what the status of our login is
     * If it is a success, you get the data.
     */
    public void checkLoginStatus(){
        final LoginStateController.OnLoginStateChangedListener mLoginStateChangedListener =
                new LoginStateController.OnLoginStateChangedListener() {
                    @Override
                    public void onLoginSucceeded() { getSnapChatData(); }

                    @Override
                    public void onLoginFailed() { }

                    @Override
                    public void onLogout() { }
                };

        // Add the LoginStateChangedListener you’ve defined to receive LoginInState updates
        SnapLogin.getLoginStateController(getApplicationContext()).addOnLoginStateChangedListener(mLoginStateChangedListener);
    }

    /**
     * Gets both the bitmoji and display name from Snapchat
     */
    public void getSnapChatData(){
        //getting data after logging in
        SnapLogin.fetchUserData(getApplicationContext(), query, null, new FetchUserDataCallback() {

            /**
             * Goes here if getting the data is a success
             * @param userDataResponse- the user's response
             */
            @Override
            public void onSuccess(@Nullable UserDataResponse userDataResponse) {


                if (userDataResponse == null || userDataResponse.getData() == null) {
                    return;
                }
                MeData meData = userDataResponse.getData().getMe();


                if (meData == null){
                    return;
                }

            }

            /**
             * Goes here if getting the data is a success
             * @param b,i
             */
            @Override
            public void onFailure(boolean b, int i) { }
        });

    }

    /**
     * Sends the user to the profile screen
     */
    public void gotoUserProfileScreen(){
        Intent userProfileIntent = new Intent(getApplicationContext(), UserProfileScreen.class);
        startActivity(userProfileIntent);
    }

    /**
     * Sends the user to the game request screen.
     */
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
