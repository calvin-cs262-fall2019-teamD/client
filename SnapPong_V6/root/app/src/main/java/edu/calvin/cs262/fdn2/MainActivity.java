package edu.calvin.cs262.fdn2;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.snapchat.kit.sdk.SnapLogin;
import com.snapchat.kit.sdk.core.controller.LoginStateController;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //access the login button
        Button login = findViewById(R.id.login_button);


//        TODO://this function sends us to snapchat to get the data.
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SnapLogin.getAuthTokenManager(getApplicationContext()).startTokenGrant();
            }
        });

        final LoginStateController.OnLoginStateChangedListener mLoginStateChangedListener =
                new LoginStateController.OnLoginStateChangedListener() {
                    @Override
                    public void onLoginSucceeded() {

                    }

                    @Override
                    public void onLoginFailed() {
                        // Here you could update UI to show login failure
                    }

                    @Override
                    public void onLogout() {
                        // Here you could update UI to reflect logged out state
                    }
                };

        // Add the LoginStateChangedListener you’ve defined to receive LoginInState updates
        SnapLogin.getLoginStateController(getApplicationContext()).addOnLoginStateChangedListener(mLoginStateChangedListener);

        //checking if the user is currently logged in
        boolean isUserLoggedIn = SnapLogin.isUserLoggedIn(getApplicationContext());


    }

    public void gotoLeaderboard(View view) {
    }


//    //TODO:Change this to snapchat using the commented code above
//    public void gotoLeaderboard(View view) {
//        Intent leaderboardIntent = new Intent(getApplicationContext(), LeaderBoardScreen.class);
//        startActivity(leaderboardIntent);
//    }
}
