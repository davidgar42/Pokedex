package com.example.pokedex.pokemon;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.pokedex.R;

public class PokemonViewHolder extends RecyclerView.ViewHolder {
    TextView tvPokemonName;
    LinearLayout llPokemonContainer;


    public PokemonViewHolder(@NonNull View v) {
        super(v);

        tvPokemonName = v.findViewById(R.id.tvPokemonName);
        llPokemonContainer = v.findViewById(R.id.llPokemonContainer);

    }
}
