package com.example.pokedex.network.models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class PokemonListResponse {
    private int count;
    private String next;
    private String previous;
    @SerializedName("results")
    private List<Pokemon> pokemonList;

    public int getCount() {
        return count;
    }

    public String getNext() {
        return next;
    }

    public String getPrevious() {
        return previous;
    }

    public List<Pokemon> getPokemonList() {
        return pokemonList;
    }
}
