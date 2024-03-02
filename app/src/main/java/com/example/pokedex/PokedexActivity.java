package com.example.pokedex;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.pokedex.network.PokeCallBack;
import com.example.pokedex.network.models.Pokemon;
import com.example.pokedex.network.models.PokemonListResponse;
import com.example.pokedex.pokemon.PokemonAdapter;
import com.example.pokedex.utils.DialogManager;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PokedexActivity extends BaseActivity {
    List<Pokemon> pokemonList;
    PokemonAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pokedex);
        EditText etPokeAdd = findViewById(R.id.etPokeAdd);
        Button btPokemonAdd = findViewById(R.id.btPokemonAdd);

        btPokemonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String poke = etPokeAdd.getText().toString();
                if(poke.isEmpty()){
                    return;
                }
                Pokemon pokemon = new Pokemon(poke, "");
                pokemonList.add(0, pokemon);
                adapter.notifyDataSetChanged();

            }
        });


        final RecyclerView rvPokemonList = findViewById(R.id.rvPokemonList);

        Call<PokemonListResponse> call = loader.getPokemonList();

        call.enqueue(new PokeCallBack<PokemonListResponse>(PokedexActivity.this, true) {
            @Override
            public void onResponse(Call<PokemonListResponse> call, Response<PokemonListResponse> response) {
                super.onResponse(call, response);

                if (response.isSuccessful()){
                    pokemonList = response.body().getPokemonList();

                    adapter = new PokemonAdapter(pokemonList, PokedexActivity.this);
                    rvPokemonList.setAdapter(adapter);
                    rvPokemonList.setHasFixedSize(true); //mejora el manejo de memoria, tiene un tamaño fijo
                    RecyclerView.LayoutManager manager = new LinearLayoutManager(PokedexActivity.this);//como se maneja la vista, linearlayout
                    rvPokemonList.setLayoutManager(manager);
                } else {
                    showDialogError();
                }
            }

            @Override
            public void onFailure(Call<PokemonListResponse> call, Throwable t) {
                super.onFailure(call, t);
                showDialogError();
            }
        });
    }

}