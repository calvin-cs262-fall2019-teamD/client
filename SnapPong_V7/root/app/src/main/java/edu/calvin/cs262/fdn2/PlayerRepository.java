package edu.calvin.cs262.fdn2;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import java.util.List;

public class PlayerRepository {

    private PlayerDao mPlayerDao;
    private LiveData<List<Player>> mAllPlayers;

    PlayerRepository(Application application){
        PlayerRoomDatabase db = PlayerRoomDatabase.getDatbase(application);
        mPlayerDao = db.playerDao();
        mAllPlayers = mPlayerDao.getAllPlayers();

    }

    /**
     * This method returns all the cached players as LiveData
     */
    LiveData<List<Player>> getAllPlayers(){
        return mAllPlayers;
    }

    public void insert (Player player) {
        new insertAsyncTask(mPlayerDao).execute(player);
    }

    /**
     * Makes our inserts run on the UI thread
     */
    private static class insertAsyncTask extends AsyncTask<Player, Void, Void> {

        private PlayerDao mAsyncTaskDao;

        insertAsyncTask(PlayerDao dao) {
            mAsyncTaskDao = dao;
        }

        @Override
        protected Void doInBackground(final Player... params) {
            mAsyncTaskDao.insert(params[0]);
            return null;
        }
    }
}
