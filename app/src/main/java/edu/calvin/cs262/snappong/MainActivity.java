package edu.calvin.cs262.snappong;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import com.snapchat.kit.sdk.SnapLogin;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

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
//        ViewGroup mViewRoot = findViewById(R.id.rootview);
//        View mLoginButton = SnapLogin.getButton(this, mViewRoot );
    }
}
