package edu.calvin.cs262.fdn2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import edu.calvin.cs262.fdn2.R;

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

                //if no score has been entered, we set our result to be sent to be FLAGGED Canceled
                if(TextUtils.isEmpty(mScoreview.getText())){
                    setResult(RESULT_CANCELED, replyIntent);
                }

                //We get the data from our entry box and pass that through our intent
                else{
                    String score = mScoreview.getText().toString();
                    replyIntent.putExtra(EXTRA_REPLY,score);
                    setResult(RESULT_OK,replyIntent);
                }
                finish();
            }
        });
    }
}
