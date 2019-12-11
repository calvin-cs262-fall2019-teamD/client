package edu.calvin.cs262.fdn2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class PlayerAdapter extends RecyclerView.Adapter<PlayerAdapter.PlayerViewHolder> {

    //cached copy of players
    private List<Player> mPlayers;

    private final LayoutInflater mInflater;

    public PlayerAdapter(Context context) {
        mInflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public PlayerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.profile_item, parent, false);
        return new PlayerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PlayerViewHolder holder, int position) {
        if (mPlayers != null){
            Player current = mPlayers.get(position);
            holder.elo.setText(current.getName());
        }
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

    class PlayerViewHolder extends RecyclerView.ViewHolder {

        TextView elo, rank, winrate;

        private PlayerViewHolder(@NonNull View itemView) {
            super(itemView);
            elo = itemView.findViewById(R.id.elo);
        }
    }
}
