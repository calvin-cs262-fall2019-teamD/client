package edu.calvin.cs262.fdn2;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.snapchat.kit.sdk.Bitmoji;
import com.snapchat.kit.sdk.SnapLogin;
import com.snapchat.kit.sdk.bitmoji.networking.FetchAvatarUrlCallback;
import com.snapchat.kit.sdk.core.controller.LoginStateController;
import com.snapchat.kit.sdk.login.models.MeData;
import com.snapchat.kit.sdk.login.models.UserDataResponse;
import com.snapchat.kit.sdk.login.networking.FetchUserDataCallback;

import java.util.Map;

public class MainActivity extends AppCompatActivity {

    Button login;
    String query = "{me{bitmoji{avatar},displayName}}";
    Map<String ,Object> variables = null;
    public String username = "empty";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //access the login button
        login = findViewById(R.id.login_button);



////        TODO://this function sends us to snapchat to get the data: Uncomment if you want to want to log in via snapchat
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

                        //getting data after logging in
                        SnapLogin.fetchUserData(getApplicationContext(), query, variables, new FetchUserDataCallback() {
                            @Override
                            public void onSuccess(@Nullable UserDataResponse userDataResponse) {



                                if (userDataResponse == null || userDataResponse.getData() == null) {
                                    return;
                                }
                                MeData meData = userDataResponse.getData().getMe();
                                if (meData == null){
                                    return;
                                }

                                username = meData.getDisplayName();

                            }


                            @Override
                            public void onFailure(boolean b, int i) {
                                Log.d("myusername", username);
                            }
                        });
                    }

                    @Override
                    public void onLoginFailed() { }

                    @Override
                    public void onLogout() { }
                };

        // Add the LoginStateChangedListener you’ve defined to receive LoginInState updates
        SnapLogin.getLoginStateController(getApplicationContext()).addOnLoginStateChangedListener(mLoginStateChangedListener);

    }

    public String getUsername(){
        return username;
    }


//

}
