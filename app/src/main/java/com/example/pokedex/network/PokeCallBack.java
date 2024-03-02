package com.example.pokedex.network;

import com.example.pokedex.BaseActivity;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public abstract class PokeCallBack<T> implements Callback<T> {
    private BaseActivity activity;
    private boolean progressActive;

    public PokeCallBack(BaseActivity activity, boolean progressActive) {
        this.activity = activity;
        this.progressActive = progressActive;

        if (progressActive) activity.showProgress();
    }

    @Override
    public void onResponse(Call<T> call, Response<T> response) {
        if (progressActive) activity.hideProgress();

    }

    @Override
    public void onFailure(Call<T> call, Throwable t) {
        if (progressActive) activity.hideProgress();
    }
}
