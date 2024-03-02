package com.example.pokedex.game;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.pokedex.R;
import com.example.pokedex.network.models.Games;

import java.util.List;

public class GameAdapter extends RecyclerView.Adapter<GameViewHolder> {
    private List<Games> games;

    public GameAdapter(List<Games> games) {
        this.games = games;
    }

    @NonNull
    @Override
    public GameViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_game, parent, false);

        return new GameViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull GameViewHolder holder, int i) {
        holder.tvGame.setText(games.get(i).getVersion().getName());
    }

    @Override
    public int getItemCount() {
        return games.size();
    }
}
