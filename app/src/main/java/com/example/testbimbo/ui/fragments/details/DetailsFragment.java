package com.example.testbimbo.ui.fragments.details;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.testbimbo.databinding.FragmentDetailsBinding;
import com.example.testbimbo.utils.Common;
import com.example.testbimbo.viewmodel.MainViewModel;
import com.squareup.picasso.Picasso;

import java.util.Arrays;

public class DetailsFragment extends Fragment {

    FragmentDetailsBinding mBinding;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mBinding = FragmentDetailsBinding.inflate(inflater, container, false);
        return mBinding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        MainViewModel viewModel = new ViewModelProvider(requireActivity()).get(MainViewModel.class);

        mBinding.txtNameBeer.setText(viewModel.getBeerSelected().getName());
        mBinding.txtYeastValue.setText(viewModel.getBeerSelected().getIngredients() == null ?
                viewModel.getBeerSelected().getYeast() : viewModel.getBeerSelected().getIngredients().yeast);

        Boolean isNetwork = Common.isNetwork(getContext());
        if (isNetwork) {
            Picasso.get().load(viewModel.getBeerSelected().getImage_url()).into(mBinding.imgBeer);
        }

        mBinding.txtTagLine.setText(viewModel.getBeerSelected().getTagline());
        mBinding.txtLiters.setText(viewModel.getBeerSelected().getVolume() == null ?
                viewModel.getBeerSelected().getDataVolume() : viewModel.getBeerSelected().getVolume().value + " Lts.");
        mBinding.txtAbvValue.setText(viewModel.getBeerSelected().getAbv() + " %");
        mBinding.txtIbuValue.setText(String.valueOf(viewModel.getBeerSelected().getIbu()));
        mBinding.txtOgValue.setText(String.valueOf(viewModel.getBeerSelected().getTarget_og()));
        mBinding.txtFgValue.setText(String.valueOf(viewModel.getBeerSelected().getTarget_fg()));
        mBinding.txtFirstBrewed.setText("First Brewed: " + viewModel.getBeerSelected().getFirst_brewed());
        mBinding.txtBrewersTip.setText(viewModel.getBeerSelected().getBrewers_tips());

        final String[] listed = {""};
        if (viewModel.getBeerSelected().getFood_pairing() == null) {
            listed[0] = viewModel.getBeerSelected().getFoodPairing();
        } else {
            viewModel.getBeerSelected().getFood_pairing().forEach((item) -> {
                listed[0] += "- " + item + "\n";
            });
        }

        mBinding.txtFoodPairing.setText(Arrays.toString(listed).replace(
                "[", "").replace("]", ""));
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        mBinding = null;
    }
}