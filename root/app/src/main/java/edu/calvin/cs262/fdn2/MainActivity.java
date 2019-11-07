package edu.calvin.cs262.fdn2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.snapchat.kit.sdk.SnapLogin;
import com.snapchat.kit.sdk.core.controller.LoginStateController;

public class MainActivity extends AppCompatActivity {

    Button login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        final LoginStateController.OnLoginStateChangedListener mLoginStateChangedListener =
                new LoginStateController.OnLoginStateChangedListener() {
                    @Override
                    public void onLoginSucceeded() {
                        // Here you could update UI to show login success
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


        login = findViewById(R.id.login_button);
        login.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                Intent userProfileIntent = new Intent(getApplicationContext(), LeaderBoardScreen.class);
                startActivity(userProfileIntent);
                finish();
            }
        });


    }

    public void gotoLeaderboard(View view) {
        Intent leaderboardIntent = new Intent(getApplicationContext(), LeaderBoardScreen.class);
        startActivity(leaderboardIntent);
    }
}
