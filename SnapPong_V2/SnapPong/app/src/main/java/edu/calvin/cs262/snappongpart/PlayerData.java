package edu.calvin.cs262.snappongpart;

public class PlayerData {
    private int[] mEloData;
    private int[] mWinRate;

    PlayerData(int[] someEloData, int[]someWinRate){
        mEloData = someEloData;
        mWinRate = someWinRate;
    }

    public int[] getEloData(){
       return mEloData;
    }

    public int[] getWinRateData(){
        return mWinRate;
    }


}
