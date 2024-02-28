package com.example.pokedex;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.example.pokedex.network.PokemonLoader;
import com.example.pokedex.network.models.Pokemon;
import com.example.pokedex.network.models.PokemonListResponse;
import com.example.pokedex.pokemon.PokemonAdapter;
import com.example.pokedex.utils.Constant;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final RecyclerView rvPokemonList = findViewById(R.id.rvPokemonList);

        PokemonLoader loader = new PokemonLoader();

        Call<PokemonListResponse> call = loader.getPokemonList();

        call.enqueue(new Callback<PokemonListResponse>() {
            @Override
            public void onResponse(Call<PokemonListResponse> call, Response<PokemonListResponse> response) {
                List<Pokemon> pokemonList = response.body().getPokemonList();

                PokemonAdapter adapter = new PokemonAdapter(pokemonList, MainActivity.this);
                rvPokemonList.setAdapter(adapter);
                rvPokemonList.setHasFixedSize(true); //mejora el manejo de memoria, tiene un tamaño fijo
                RecyclerView.LayoutManager manager = new LinearLayoutManager(MainActivity.this);//como se maneja la vista, linearlayout
                rvPokemonList.setLayoutManager(manager);


            }

            @Override
            public void onFailure(Call<PokemonListResponse> call, Throwable t) {
                Log.e(Constant.DEBUG_POKEMON, t.getMessage());
            }
        });
    }
}