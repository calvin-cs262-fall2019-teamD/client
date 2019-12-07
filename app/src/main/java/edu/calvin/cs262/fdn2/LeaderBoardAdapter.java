package edu.calvin.cs262.fdn2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

public class LeaderBoardAdapter extends RecyclerView.Adapter<LeaderBoardAdapter.LeaderBoardViewHolder> {

    //data types this class is expected to receive
    private String[] eloData;
    private String[] winRateData;
    private Context mContext;

    public LeaderBoardAdapter(Context context, String[] playerEloData, String[] playerWinRateData){
        this.eloData = playerEloData;
        this.winRateData = playerWinRateData;
        this.mContext = context;

    }

    @NonNull
    @Override
    public LeaderBoardViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        //here, we inflate the single item xml file (profile_item.xml) as this is what would
        //be displayed for each player.
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.profile_item,parent,false);
        return new LeaderBoardViewHolder(view);
    }

    /**
     * This is where the data of the Player is bound to the UI elements
     * @param holder A ViewHolder class
     * @param position The position in RecyclerView
     */
    @Override
    public void onBindViewHolder(@NonNull LeaderBoardViewHolder holder, final int position) {

        //we're setting the rank to the current postion(starting at 0) + 1 so that it
        //automatically increments by 1 for each userprofile card
        holder.rank.setText(String.valueOf(position + 4));

        //setting both the elo values and winrate to each of the random elos and winrate passed
        //to the adapter in Main Activity.
        holder.elo.setText(eloData[position]);
        holder.winrate.setText(winRateData[position]);

        //we bind each card view created to a dummy function which displays the particular rank of the player
        holder.profilecardview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //displays a toast about which player rank you have clicked
                Toast.makeText(mContext,"Clicked on player rank " + (position + 4), Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return eloData.length;
    }


    /**
     * This class gets all our view elements needed for the recyclerview to bind the data elements
     */
    class LeaderBoardViewHolder extends RecyclerView.ViewHolder{

        //getting the textview elements from our row
        TextView changingrate, elo, rank, winrate;
        CardView profilecardview;

        //Constructor for our View holder class.
        LeaderBoardViewHolder(@NonNull View itemView) {
            super(itemView);
            changingrate = itemView.findViewById(R.id.changerate);
            elo = itemView.findViewById(R.id.elo);
            rank = itemView.findViewById(R.id.ranknumber);
            winrate = itemView.findViewById(R.id.winrate);
            profilecardview = itemView.findViewById(R.id.profilecard);

        }
    }
}
