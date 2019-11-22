package edu.calvin.cs262.fdn2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;

import com.snapchat.kit.sdk.creative.exceptions.SnapStickerSizeException;
import com.snapchat.kit.sdk.creative.media.SnapMediaFactory;
import com.snapchat.kit.sdk.creative.media.SnapSticker;

import java.io.File;

public class GameRequestScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_request_screen);

        SnapSticker stickerSnap = null;
        try {
            File file = new File("/home/Downloads/creativetest.png");
            stickerSnap = SnapMediaFactory.getSnapStickerFromFile(file);
        }
        catch (SnapStickerSizeException e) {
            handleError(e);
            return;
        }
        // Height and width~~ ~~in pixels
        stickerSnap.setWidth(300);
        stickerSnap.setHeight(300);

        // Position is specified as a ratio between 0 & 1 to place the center of the sticker
        stickerSnap.setPosX(0.5f);
        stickerSnap.setPosY(0.5f);

        // Specify clockwise rotation desired
        stickerSnap.setRotationDegreesClockwise(0); // degrees clockwise
    <your-snap-content>.setSnapSticker(stickerSnap);
        // Note: Your snap content can be video, photo, or live-camera content
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.nav_menu, menu);

        // return true so that the menu pop up is opened
        return true;
    }
}
