package edu.calvin.cs262.fdn2;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class UserProfileScreen extends AppCompatActivity {

    RecyclerView recyclerview;
    String[] thescores = {"2-21", "15-21", "21-5", "21-9", "19-21"};
    String[] thewinrates = {"80", "60", "40", "84", "66"};
    UserProfileScreenAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerview = findViewById(R.id.recyclerView);

        UserProfileScreenAdapter adapter = new UserProfileScreenAdapter(thescores, thewinrates);

        recyclerview.setAdapter(adapter);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(UserProfileScreen.this);

        recyclerview.setLayoutManager(layoutManager);
    }
}
