package com.example.pokedex.network.models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class PokemonByIDResponse {
    private List<Abilities> abilities;
    @SerializedName("base_experience")//para poder poner to_do en camelcase
    private int baseExperience;
    @SerializedName("game_indices")
    private List<Games> games;
    private String name;
    private int id;
    private Sprite sprites;

    public List<Abilities> getAbilities() {
        return abilities;
    }

    public int getBaseExperience() {
        return baseExperience;
    }

    public List<Games> getGames() {
        return games;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public Sprite getSprites() {
        return sprites;
    }
}
