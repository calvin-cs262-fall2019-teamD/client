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


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        Button login = findViewById(R.id.login_butt);


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

///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        /* TO BERNARD: Tried to create a button to open up the User Profile Screen on the main page to test if it works but was not able to get it to work.
        *  Once integrated, everything should work... hopefully*/

///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


        Button userProfileButton = findViewById(R.id.UserProfileButton);
        userProfileButton.setOnClickListener(new View.OnClickListener() {


            public void onClick(View v) {
                Intent userProfileIntent = new Intent(getApplicationContext(), UserProfileScreen.class);
                startActivity(userProfileIntent);
            }
        });


    }
}
