package com.example.testbimbo.viewmodel;

import android.content.Context;
import android.util.Pair;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.testbimbo.core.model.BeerItemModel;
import com.example.testbimbo.data.MainRepository;
import com.example.testbimbo.ui.StatusRequests;

import java.util.List;


public class MainViewModel extends ViewModel {

    private final MainRepository repository = new MainRepository();

    public MutableLiveData<Pair<StatusRequests, List<BeerItemModel>>> beerData = new MutableLiveData<>(
            new Pair<>(StatusRequests.NONE, null));


    public List<BeerItemModel> getBeersList() {

        boolean result = false;
        //*******  IF THEN   ELSE
        result = 4 > 3 ? true : false;
        return beerData.getValue().second;
    }

    public void getBeer(Context context) {
        repository.getBeer(context,beerResponseModels -> {
            beerData.setValue(beerResponseModels);
        });
    }

    private BeerItemModel beerSelected;

    public void setSelectedModel(BeerItemModel modelSelected) {
        beerSelected = modelSelected;
    }

    public BeerItemModel getBeerSelected() {
        return beerSelected;
    }
}