package edu.calvin.cs262.fdn2;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class PlayerViewModel extends AndroidViewModel {

    private PlayerRepository mRepository;
    private LiveData<List<Player>> mAllPlayers;

    /**
     * Constructor
     *
     * @param application, application context
     */
    public PlayerViewModel(Application application) {
        super(application);
        mRepository = new PlayerRepository(application);
        mAllPlayers = mRepository.getAllPlayers();
    }

    /**
     * This functions hides the implementation from the UI
     *
     * @return
     */
    LiveData<List<Player>> getPlayers() {
        return mAllPlayers;
    }


    /**
     * This functions calls the Repository's insert() method.
     * This implementation thus hides it completely from the UI
     *
     * @param player
     */
    public void insert(Player player) {
        mRepository.insert(player);
    }
}
