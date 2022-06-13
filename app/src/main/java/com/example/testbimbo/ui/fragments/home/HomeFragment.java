package com.example.testbimbo.ui.fragments.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;

import com.example.testbimbo.R;
import com.example.testbimbo.databinding.FragmentHomeBinding;
import com.example.testbimbo.viewmodel.MainViewModel;

public class HomeFragment extends Fragment {

    FragmentHomeBinding mBinding;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mBinding = FragmentHomeBinding.inflate(getLayoutInflater());
        return mBinding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        MainViewModel viewModel = new ViewModelProvider(requireActivity()).get(MainViewModel.class);

        BeerAdapter beerAdapter = new BeerAdapter();
        beerAdapter.setOnItemClickListener(itemModel -> {
            viewModel.setSelectedModel(itemModel);
            Navigation.findNavController(view).navigate(R.id.action_homeFragment_to_detailsFragment);
        });

        mBinding.beerRecyclerView.setAdapter(beerAdapter);
        viewModel.beerData.observe(getViewLifecycleOwner(), beerList -> {
            beerAdapter.submitList(beerList.second);

            switch (beerList.first) {
                case LOADING:
                    mBinding.beerRecyclerView.setVisibility(View.GONE);
                    mBinding.txtEmpty.setVisibility(View.GONE);
                    mBinding.shimmer.setVisibility(View.VISIBLE);
                    break;

                case SUCCESS:
                    if (beerList.second == null || beerList.second.isEmpty()) {
                        mBinding.shimmer.setVisibility(View.GONE);
                        mBinding.beerRecyclerView.setVisibility(View.GONE);
                        mBinding.txtEmpty.setVisibility(View.VISIBLE);
                    } else {
                        mBinding.shimmer.setVisibility(View.GONE);
                        mBinding.txtEmpty.setVisibility(View.GONE);
                        mBinding.beerRecyclerView.setVisibility(View.VISIBLE);
                    }
                    break;

                case FAILURE:
                    mBinding.shimmer.setVisibility(View.GONE);
                    mBinding.beerRecyclerView.setVisibility(View.GONE);
                    mBinding.txtEmpty.setVisibility(View.VISIBLE);
                    break;
            }
        });

        viewModel.getBeer(requireContext());
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        mBinding = null;
    }

}