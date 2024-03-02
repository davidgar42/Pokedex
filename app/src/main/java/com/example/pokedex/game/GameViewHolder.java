package com.example.pokedex.game;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.pokedex.R;

public class GameViewHolder extends RecyclerView.ViewHolder {
    TextView tvGame;

    public GameViewHolder(@NonNull View v) {
        super(v);

        tvGame = v.findViewById(R.id.tvGame);
    }
}
