package com.example.testbimbo.core.api;

import com.example.testbimbo.core.model.BeerResponseModel;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;

public class BeerApiService {

    public interface BeerService {
        @GET("beers?page=1")
        Call<BeerResponseModel> getBeer();
    }

    private final Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("https://api.punkapi.com/v2/")
            .addConverterFactory(GsonConverterFactory.create())
            .build();


    private BeerService service;

    private static final BeerApiService ourInstance = new BeerApiService();

    public static BeerApiService getInstance() {
        return ourInstance;
    }

    private BeerApiService() {

    }

    public BeerService getService() {
        if (service == null) {
            service = retrofit.create(BeerService.class);
        }
        return service;
    }

}
