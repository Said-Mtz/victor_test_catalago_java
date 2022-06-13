package com.example.testbimbo.ui.fragments.home;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.example.testbimbo.core.model.BeerItemModel;
import com.example.testbimbo.databinding.ItemBeerBinding;
import com.example.testbimbo.utils.Common;
import com.squareup.picasso.Picasso;

public class BeerAdapter extends ListAdapter<BeerItemModel, BeerAdapter.BeerViewHolder> {

    public static final DiffUtil.ItemCallback<BeerItemModel> DIFF_CALLBACK =
            new DiffUtil.ItemCallback<BeerItemModel>() {
                @Override
                public boolean areItemsTheSame(@NonNull BeerItemModel oldItem, @NonNull BeerItemModel newItem) {
                    return oldItem.getId().equals(newItem.getId());
                }

                @Override
                public boolean areContentsTheSame(@NonNull BeerItemModel oldItem, @NonNull BeerItemModel newItem) {
                    return oldItem.equals(newItem);
                }
            };

    protected BeerAdapter() {
        super(DIFF_CALLBACK);
    }

    OnItemClickListener onItemClickListener;

    interface OnItemClickListener {
        void onItemClick(BeerItemModel beerItem);
    }

    public void setOnItemClickListener(OnItemClickListener onClickListener) {
        this.onItemClickListener = onClickListener;
    }

    @NonNull
    @Override
    public BeerAdapter.BeerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemBeerBinding mBinding = ItemBeerBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new BeerViewHolder(mBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull BeerAdapter.BeerViewHolder holder, int position) {
        BeerItemModel beerItem = getItem(position);
        holder.bind(beerItem);
    }

    class BeerViewHolder extends RecyclerView.ViewHolder {
        private ItemBeerBinding mBinding;

        public BeerViewHolder(@NonNull ItemBeerBinding mBinding) {
            super(mBinding.getRoot());
            this.mBinding = mBinding;
        }

        public void bind(BeerItemModel beerItem) {
            mBinding.txtNameBeer.setText(beerItem.getName());
            mBinding.txtTaglineBeer.setText(beerItem.getTagline());

            Boolean isNetwork = Common.isNetwork(mBinding.getRoot().getContext());
            if (isNetwork) {
                Picasso.get().load(beerItem.getImage_url()).into(mBinding.img);
            }

            mBinding.getRoot().setOnClickListener(v -> {
                onItemClickListener.onItemClick(beerItem);
            });

            mBinding.executePendingBindings();

        }
    }
}
