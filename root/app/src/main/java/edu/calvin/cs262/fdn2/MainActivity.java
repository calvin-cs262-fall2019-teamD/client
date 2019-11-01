package edu.calvin.cs262.fdn2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.snapchat.kit.sdk.SnapLogin;
import com.snapchat.kit.sdk.core.controller.LoginStateController; // Import needed for LoginStateControllerd
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

   /* RecyclerView recyclerview;
    String[] thescores = {"2-21", "15-21", "21-5", "21-9", "19-21"};
    String[] thewinrates = {"80", "60", "40", "84", "66"};
    UserProfileScreenAdapter adapter;*/

       /* setContentView(R.layout.activity_main);

        recyclerview = findViewById(R.id.recyclerView);

        UserProfileScreenAdapter adapter = new UserProfileScreenAdapter(thescores, thewinrates);

        recyclerview.setAdapter(adapter);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(MainActivity.this);

        recyclerview.setLayoutManager(layoutManager);*/

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

    }
}
