package edu.calvin.cs262.userprofile;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class UserProfileAdapter extends RecyclerView.Adapter<UserProfileAdapter.UserProfileView> {

    private String[] mscores;
    private String[] mwinrates;

    public UserProfileAdapter(String[] scores, String[] winrates) {
        this.mscores = scores;
        this.mwinrates = winrates;

    }

    @NonNull
    @Override
    public UserProfileView onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.game_history_item, parent, false);
        return new UserProfileView(view);
    }

    @Override
    public void onBindViewHolder(@NonNull UserProfileView holder, int position) {
        holder.scoreTextView.setText(mscores[position]);
        holder.winrateTextView.setText(mwinrates[position]);

    }

    @Override
    public int getItemCount() {
        return mscores.length;
    }

    /////////////////////////////////////////////////////////////////////////////////////
    public class UserProfileView extends RecyclerView.ViewHolder {
        TextView scoreTextView, winrateTextView;

        public UserProfileView(@NonNull View itemView) {
            super(itemView);
            scoreTextView = itemView.findViewById(R.id.score);
            winrateTextView = itemView.findViewById(R.id.winrate);
        }
    }
}
