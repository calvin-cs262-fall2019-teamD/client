package edu.calvin.cs262.fdn2;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupWindow;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class PlayerAdapter extends RecyclerView.Adapter<PlayerAdapter.PlayerViewHolder> {

    //cached copy of players
    private List<Player> mPlayers;
    private Context mContext;

    private final LayoutInflater mInflater;

    public PlayerAdapter(Context context) {
        mContext = context;
        mInflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public PlayerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.profile_item, parent, false);
        return new PlayerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final PlayerViewHolder holder, int position) {
        if (mPlayers != null){
            Player current = mPlayers.get(position);
            holder.elo.setText(current.getName());
        }

        //we're setting the rank to the current postion(starting at 0) + 1 so that it
        //automatically increments by 1 for each userprofile card
        holder.rank.setText(String.valueOf(position + 4));

        //increase the change rate by 1
        String increasedChangeRate = position+1 + "+";

        //changing the change rate to increase by 1
        holder.changingrate.setText(increasedChangeRate);

        holder.profilecardview.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                showPopup(holder.profilecardview);
                return true;
            }
        });
    }

    void setPlayers (List<Player> players){
        mPlayers = players;
        notifyDataSetChanged();
    }

    /**
     * This function is called many times, and when it is first called,
     * mPlayers has not been updated (means initially, it's null, and we can't return null so we
     * return 0
     * @return
     */
    @Override
    public int getItemCount() {

        if (mPlayers != null){
            return mPlayers.size();
        }
        else {
            return 0;
        }
    }

    private void showPopup(View anchorview) {
        LayoutInflater layoutInflater = LayoutInflater.from(mContext);
        View popupView = layoutInflater.inflate(R.layout.profilepopup, null);

        PopupWindow popupWindow = new PopupWindow(popupView, 900,
                ViewGroup.LayoutParams.WRAP_CONTENT);

        // If the PopupWindow should be focusable
        popupWindow.setFocusable(true);

        // If you need the PopupWindow to dismiss when when touched outside
        popupWindow.setBackgroundDrawable(new ColorDrawable());

        int location[] = new int[2];

        // Get the View's(the one that was clicked in the Fragment) location
        anchorview.getLocationOnScreen(location);

        // Using location, the PopupWindow will be displayed right under anchorView
        popupWindow.showAtLocation(anchorview, Gravity.CENTER_HORIZONTAL,
                location[0], anchorview.getHeight());

    }

    class PlayerViewHolder extends RecyclerView.ViewHolder {

        TextView elo, rank, changingrate;
        CardView profilecardview;

        private PlayerViewHolder(@NonNull View itemView) {
            super(itemView);
            elo = itemView.findViewById(R.id.elo);
            changingrate = itemView.findViewById(R.id.changerate);
            rank = itemView.findViewById(R.id.ranknumber);
            profilecardview = itemView.findViewById(R.id.profilecard);
        }
    }
}
