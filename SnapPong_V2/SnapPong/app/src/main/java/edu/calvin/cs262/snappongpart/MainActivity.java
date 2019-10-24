package edu.calvin.cs262.snappongpart;

import androidx.annotation.IdRes;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    LeaderBoardAdapter adapter;

    //we create a random set of elo values and winRates to be displayed
    private String[] randomElos = {"578697","475425","465693","455731","374657","364291","321697","245594","271456","213477"};
    private String[] randomWinrate = {"80","50","96","88","36","17","36","19","38","40"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerview);

        //we pass into our adapter random elos and win rates to be displayed every time
        adapter = new LeaderBoardAdapter(this, randomElos,randomWinrate);

        //we set the layoutmanager for our recyclerview
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(MainActivity.this);
        recyclerView.setLayoutManager(layoutManager);

        //we let our recyclerview use the adapter we created.
        recyclerView.setAdapter(adapter);

    }

    /**
     * This function determines which of the Top three ranks has been clicked
     * @param view
     */
    public void profileClicked(View view) {

        //we get the ID of particular view which is clicked
        int profileId = view.getId();

        //we then use the ID to check against the various ID's we set in our activity_main.xml file
        switch (profileId){
            case R.id.rank1bitmoji:
                Toast.makeText(this, "Rank 1 player",Toast.LENGTH_SHORT).show();
                break;

            case R.id.rank2bitmoji:
                Toast.makeText(this, "Rank 2 player",Toast.LENGTH_SHORT).show();
                break;

            case R.id.rank3bitmoji:
                Toast.makeText(this, "Rank 3 player",Toast.LENGTH_SHORT).show();
                break;

            default:
                Toast.makeText(this, "Clicked on a User Profile!",Toast.LENGTH_SHORT).show();
                break;
        }


    }
}
