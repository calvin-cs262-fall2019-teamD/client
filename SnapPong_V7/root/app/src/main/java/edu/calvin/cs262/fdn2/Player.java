package edu.calvin.cs262.fdn2;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

/**
 * Our Player Class
 */
@Entity(tableName = "Player_table")
public class Player {

    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "word")
    private String mName;

    /**
     * Constructor
     * @param name, a player's name
     */

    public Player(@NonNull String name){
        this.mName = name;
    }

    /**
     * Gets the player's name
     * @return mName
     */
    public String getName(){
        return this.mName;
    }
}
