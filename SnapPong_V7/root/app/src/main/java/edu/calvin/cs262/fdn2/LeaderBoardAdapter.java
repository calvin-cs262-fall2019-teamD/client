package edu.calvin.cs262.fdn2;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.Random;

/**
 * Adapter for the LeaderBoardScreen class
 */
public class LeaderBoardAdapter extends RecyclerView.Adapter<LeaderBoardAdapter.LeaderBoardViewHolder> {

    //data types this class is expected to receive
    private String[] eloData;
    private String[] winRateData;
    private int[] mbitmojiImgs;
    private Context mContext;


    public LeaderBoardAdapter(Context context, String[] playerEloData, String[] playerWinRateData, int[] bitmojiimgs) {
        this.eloData = playerEloData;
        this.winRateData = playerWinRateData;
        this.mContext = context;
        this.mbitmojiImgs = bitmojiimgs;

    }

    @NonNull
    @Override
    public LeaderBoardViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        //here, we inflate the single item xml file (profile_item.xml) as this is what would
        //be displayed for each player.
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.profile_item, parent, false);
        return new LeaderBoardViewHolder(view);
    }

    /**
     * This is where the data of the Player is bound to the UI elements
     *
     * @param holder
     * @param position
     */
    @Override
    public void onBindViewHolder(@NonNull final LeaderBoardViewHolder holder, final int position) {

        //generate a random number as for choosing the bitmoji and get that
        Random random = new Random();
        final int randombitmojiImgpos = mbitmojiImgs[random.nextInt(mbitmojiImgs.length)];


        //setting the bitmoji at each position to be a random bitmoji
        holder.bitmojiIcon.setImageResource(randombitmojiImgpos);

        //we're setting the rank to the current postion(starting at 0) + 1 so that it
        //automatically increments by 1 for each userprofile card
        holder.rank.setText(String.valueOf(position + 4));

        //setting both the elo values and winrate to each of the random elos and winrate passed
        //to the adapter in Main Activity.
        holder.elo.setText(eloData[position]);
        holder.winrate.setText(winRateData[position]);

        //increase the change rate by 1
        String increasedChangeRate = position + 1 + "+";

        //changing the change rate to increase by 1
        holder.changingrate.setText(increasedChangeRate);

        //we bind each card view created to a dummy function which displays the particular rank of the player
        holder.profilecardview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //displays a toast about which player rank you have clicked
                Toast.makeText(mContext, "Clicked on player rank " + (position + 4), Toast.LENGTH_SHORT).show();
            }
        });
        holder.profilecardview.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                showPopup(holder.profilecardview);
                return true;
            }
        });
    }

    @Override
    public int getItemCount() {
        return eloData.length;
    }


    /**
     * Popup window for other players' profiles
     *
     * @param anchorview Link to popupwindow = https://stackoverflow.com/questions/18461990/pop-up-window-to-display-some-stuff-in-a-fragment
     */

    private void showPopup(View anchorview) {
        LayoutInflater layoutInflater = LayoutInflater.from(mContext);
        View popupView = layoutInflater.inflate(R.layout.profilepopup, null);

        PopupWindow popupWindow = new PopupWindow(popupView, 900,
                ViewGroup.LayoutParams.WRAP_CONTENT);

        // If the PopupWindow should be focusable
        popupWindow.setFocusable(true);

        // If you need the PopupWindow to dismiss when when touched outside
        popupWindow.setBackgroundDrawable(new ColorDrawable());

        int[] location = new int[2];

        // Get the View's(the one that was clicked in the Fragment) location
        anchorview.getLocationOnScreen(location);

        // Using location, the PopupWindow will be displayed right under anchorView
        popupWindow.showAtLocation(anchorview, Gravity.CENTER_HORIZONTAL,
                location[0], anchorview.getHeight());

    }

    /**
     * This class gets all our view elements needed for the recyclerview to bind the data elements
     */
    class LeaderBoardViewHolder extends RecyclerView.ViewHolder {

        //getting the textview elements from our row
        TextView changingrate, elo, rank, winrate;
        CardView profilecardview;
        ImageView bitmojiIcon;

        //Constructor for our View holder class.
        LeaderBoardViewHolder(@NonNull View itemView) {
            super(itemView);
            changingrate = itemView.findViewById(R.id.changerate);
            elo = itemView.findViewById(R.id.elo);
            rank = itemView.findViewById(R.id.ranknumber);
//            winrate = itemView.findViewById(R.id.winrate);
            profilecardview = itemView.findViewById(R.id.profilecard);
            bitmojiIcon = itemView.findViewById(R.id.playerbitmoji);

        }
    }
}
