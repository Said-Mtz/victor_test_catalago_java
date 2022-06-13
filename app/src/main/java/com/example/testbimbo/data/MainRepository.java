package com.example.testbimbo.data;

import android.content.Context;
import android.util.Log;
import android.util.Pair;

import androidx.lifecycle.Observer;

import com.example.testbimbo.core.api.BeerApiService;
import com.example.testbimbo.core.model.BeerItemModel;
import com.example.testbimbo.core.model.BeerResponseModel;
import com.example.testbimbo.room.AppDataBase;
import com.example.testbimbo.room.BeerEntity;
import com.example.testbimbo.ui.StatusRequests;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainRepository {


    public void getBeer(Context context, Observer<Pair<StatusRequests, List<BeerItemModel>>> executeBeerData) {

        executeBeerData.onChanged(new Pair<>(StatusRequests.LOADING, null));

        List<BeerEntity> list = AppDataBase.getDatabase(context).beerDao().getBeerListRoom();
        if (list.isEmpty()) {
            Log.d("Repository", "Room obtencion, datos de internet");
            BeerApiService.getInstance().getService().getBeer().enqueue(new Callback<BeerResponseModel>() {
                @Override
                public void onResponse(Call<BeerResponseModel> call, Response<BeerResponseModel> response) {
                    List<BeerItemModel> beerResponseList;
                    try {
                        beerResponseList = response.body();
                    } catch (Exception e) {
                        beerResponseList = new ArrayList<>();
                    }
                    insertLocalData(context, beerResponseList);
                    executeBeerData.onChanged(new Pair<>(StatusRequests.SUCCESS, beerResponseList));
                }

                @Override
                public void onFailure(Call<BeerResponseModel> call, Throwable t) {
                    executeBeerData.onChanged(new Pair<>(StatusRequests.FAILURE, null));
                }
            });
        } else {
            Log.d("Repository", "Room obtencion, datos locales");
            BeerResponseModel localList = new BeerResponseModel();
            list.forEach(item -> {
                BeerItemModel beerItemModel = new BeerItemModel();
                beerItemModel.setId(item.getId());
                beerItemModel.setName(item.getName());
                beerItemModel.setTagline(item.getTagline());
                beerItemModel.setImage_url(item.getImage_url());
                beerItemModel.setYeast(item.getYeast());
                beerItemModel.setAbv(item.getAbv());
                beerItemModel.setIbu(item.getIbu());
                beerItemModel.setTarget_og(item.getTarget_og());
                beerItemModel.setTarget_fg(item.getTarget_fg());
                beerItemModel.setFirst_brewed(item.getFirst_brewed());
                beerItemModel.setBrewers_tips(item.getBrewers_tips());
                beerItemModel.setFoodPairing(item.getFood_pairing());

                localList.add(beerItemModel);
            });
            executeBeerData.onChanged(new Pair(StatusRequests.SUCCESS, localList));
        }


    }

    private void insertLocalData(Context context, List<BeerItemModel> list) {
        Log.d("Repository", "Room insercion, datos locales");
        List<BeerEntity> entityList = new ArrayList<>();
        list.forEach(item -> {
            BeerEntity beerItemModel = new BeerEntity();
            beerItemModel.setId(item.getId());
            beerItemModel.setName(item.getName());
            beerItemModel.setTagline(item.getTagline());
            beerItemModel.setImage_url(item.getImage_url());
            beerItemModel.setYeast(item.getIngredients().yeast);
            beerItemModel.setValue(item.getVolume().value);
            beerItemModel.setAbv(item.getAbv());
            beerItemModel.setIbu(item.getIbu());
            beerItemModel.setTarget_og(item.getTarget_og());
            beerItemModel.setTarget_fg(item.getTarget_fg());
            beerItemModel.setFirst_brewed(item.getFirst_brewed());
            beerItemModel.setBrewers_tips(item.getBrewers_tips());
            String foodPairing = item.getFood_pairing().toString();
            beerItemModel.setFood_pairing(foodPairing);

            entityList.add(beerItemModel);
        });

        AppDataBase.getDatabase(context).beerDao().inserAll(entityList);
    }

}
