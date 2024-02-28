package com.example.pokedex.network;

import com.example.pokedex.network.models.PokemonListResponse;

import retrofit2.Call;
import retrofit2.http.GET;

public interface PokemonAPI {
    @GET("pokemon")
    Call<PokemonListResponse>getPokemonList();
}
