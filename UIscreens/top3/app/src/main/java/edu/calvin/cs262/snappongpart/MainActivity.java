package edu.calvin.cs262.snappongpart;

import androidx.annotation.IdRes;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void profileClicked(View view) {
        int profileId = view.getId();

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
