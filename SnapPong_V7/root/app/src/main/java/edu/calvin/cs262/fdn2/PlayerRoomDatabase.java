package edu.calvin.cs262.fdn2;

import android.content.Context;
import android.os.AsyncTask;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

@Database(entities = Player.class, version = 1, exportSchema = false)
public abstract class PlayerRoomDatabase extends RoomDatabase {

    public abstract PlayerDao playerDao();
    private static PlayerRoomDatabase INSTANCE;

    private static RoomDatabase.Callback sRoomDatabaseCallback =
            new RoomDatabase.Callback() {
                @Override
                public void onOpen(@NonNull SupportSQLiteDatabase db) {
                    super.onOpen(db);
                    new PopulateDbAsync(INSTANCE).execute();
                }
            };

    public static PlayerRoomDatabase getDatbase(final Context context){
        if (INSTANCE == null){
            synchronized (PlayerRoomDatabase.class){

                if (INSTANCE == null){
                    //we create database here
                    INSTANCE = Room.databaseBuilder(context,
                    PlayerRoomDatabase.class, "player_database")
                            //wipes and rebuilds instead o fmigrating
                            //if no Migration object
                            //Migration is not part of this practical
                            .fallbackToDestructiveMigration()
                            .addCallback(sRoomDatabaseCallback)
                            .build();
                }
            }
        }
        return INSTANCE;
    }

    /**
     * Populates the database in the Background
     */
    private static class PopulateDbAsync extends AsyncTask<Void, Void, Void> {
        private final PlayerDao mDao;
        String[] playernames = {"Bernard"};

        PopulateDbAsync(PlayerRoomDatabase db) {
            mDao = db.playerDao();
        }


        @Override
        protected Void doInBackground(Void... voids) {
            // Start the app with a clean database every time.
            // Not needed if you only populate the database
            // when it is first created
            mDao.deleteAll();

            for (int i =0; i <= playernames.length -1 ; i++){

                //we create a player with that particular name for each time
                Player player = new Player(playernames[i]);

                //we insert that player into our Dao
                mDao.insert(player);
            }
            return null;
        }
    }
}
