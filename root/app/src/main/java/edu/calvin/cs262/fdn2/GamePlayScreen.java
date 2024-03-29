package edu.calvin.cs262.fdn2;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

/**
 * Entering scores after ping pong game
 */

public class GamePlayScreen extends AppCompatActivity {

    public static final String EXTRA_REPLY = "com.example.android.roomwordssample.REPLY";
    private EditText mScoreview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_play_screen);

        mScoreview = findViewById(R.id.edit_score);

        final Button button = findViewById(R.id.button_save);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent replyIntent = new Intent();

                //if no score has been entered, we set our result to be sent to be FLAGGED Cancelled
                if (TextUtils.isEmpty(mScoreview.getText())) {
                    setResult(RESULT_CANCELED, replyIntent);
                }

                //We get the data from our entry box and pass that through our intent
                else {
                    String score = mScoreview.getText().toString();

                    //before we insert the data into the database, we change the score to get the ELO
                    int computedscore = Integer.parseInt(score) * 10000;

                    //then we revert back the string and pass it into the database
                    score = String.valueOf(computedscore);
                    replyIntent.putExtra(EXTRA_REPLY, score);
                    setResult(RESULT_OK, replyIntent);
                }
                finish();
            }
        });
    }
}
