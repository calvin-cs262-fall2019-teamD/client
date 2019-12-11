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


//        //send the user to the snapchat authentication screen
//        login.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                SnapLogin.getAuthTokenManager(getApplicationContext()).startTokenGrant();
//                getSnapChatData();
//            }
//        });

        //TODO: to be removed
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), LeaderBoardScreen.class);
                startActivity(intent);
            }
        });

    }

    /**
     * Gets both the bitmoji and display name from Snapchat
     */
    public String getSnapChatData(){
        //getting data after logging in
        SnapLogin.fetchUserData(getApplicationContext(), query, null, new FetchUserDataCallback() {

            /**
             * Goes here if getting the data is a success
             * @param userDataResponse- the user's response
             */
            @Override
            public void onSuccess(@Nullable UserDataResponse userDataResponse) {
                Toast.makeText(getApplicationContext(), "Got Data",Toast.LENGTH_SHORT).show();
                if (userDataResponse == null || userDataResponse.getData() == null) {
                    return;
                }

                MeData meData = userDataResponse.getData().getMe();


                if (meData == null){
                    return;
                }
                else{
                   username = meData.getDisplayName();
                }

            }

            /**
             * Goes here if getting the data is a success
             * @param b,i
             */
            @Override
            public void onFailure(boolean b, int i) {
                Toast.makeText(getApplicationContext(), "failed to get data",Toast.LENGTH_SHORT).show();
            }
        });

        return username;

    }

    public String getUsername(){
        return username;
    }

}
