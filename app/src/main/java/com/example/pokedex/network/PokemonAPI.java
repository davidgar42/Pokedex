package com.example.pokedex.network;

import com.example.pokedex.network.models.PokemonByIDResponse;
import com.example.pokedex.network.models.PokemonListResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface PokemonAPI {
    @GET("pokemon")
    Call<PokemonListResponse>getPokemonList();

    @GET("pokemon/{id}")
    Call<PokemonByIDResponse> getPokemonById(@Path("id")String id);
}
