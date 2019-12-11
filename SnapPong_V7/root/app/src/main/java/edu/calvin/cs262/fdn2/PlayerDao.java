package edu.calvin.cs262.fdn2;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

/**
 * This class speciy SQL queriesand associate them with method calls
 */
@Dao
public interface PlayerDao {


    /**
     * inserts data into our table
     * @param player, a player in our app
     */
    @Insert
    void insert(Player player);

    /**
     * Deletes data from our table
     */
    @Query("DELETE FROM player_table")
    void deleteAll();


    /**
     * This method is specifically for data observaion and helps the
     * app respond to data changes
     */
    @Query("SELECT * from player_table")
   LiveData<List<Player>> getAllPlayers();
}
