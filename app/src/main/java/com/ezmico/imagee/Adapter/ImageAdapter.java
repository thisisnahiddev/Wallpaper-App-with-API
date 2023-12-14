package com.ezmico.imagee.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.ezmico.imagee.R;

import com.ezmico.imagee.Model.Pexels.PexelsImageModel;

import java.util.ArrayList;


public class ImageAdapter extends RecyclerView.Adapter {

    private Context context;
    private ArrayList<PexelsImageModel> pexelsWallpaperList;
    private AdapterClick adapterClick;
   private int adapterType;

    public ImageAdapter(Context context, ArrayList<PexelsImageModel> pexelsWallpaperList, AdapterClick adapterClick, int adapterType) {
        this.context = context;
        this.pexelsWallpaperList = pexelsWallpaperList;
        this.adapterClick = adapterClick;
        this.adapterType = adapterType;
    }

    public ImageAdapter(AdapterClick adapterClick) {
        this.adapterClick = adapterClick;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater layoutInflater = LayoutInflater.from(context);

        if (adapterType == 0){
            View view = layoutInflater.inflate(R.layout.item,parent,false);
            return new ImageListViewHolder(view);

        }else {
            View view = layoutInflater.inflate(R.layout.full_screen_item,parent,false);
            return new FullScreenViewHolder(view);
        }

    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

        if (adapterType==0){
            ((ImageListViewHolder)holder).bindData(pexelsWallpaperList.get(position));


        }else {
            ((FullScreenViewHolder)holder).bindData(pexelsWallpaperList.get(position));
        }

    }

    @Override
    public int getItemCount() {
        return pexelsWallpaperList.size();
    }


    public class ImageListViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        ImageView image;
        public ImageListViewHolder(@NonNull View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.image);
            itemView.setOnClickListener(this);
        }

        public void bindData(PexelsImageModel pexelsImageModel) {

            Glide.with(context).load(pexelsImageModel.getSrc().getPortrait()).into(image);


        }


        @Override
        public void onClick(View v) {

            if (adapterClick != null){
                int position = getAdapterPosition();
                String getImage = pexelsWallpaperList.get(position).getSrc().getPortrait();
                adapterClick.itemClick(pexelsWallpaperList.get(position), position,getImage);
            }



        }
    }



    public class FullScreenViewHolder extends RecyclerView.ViewHolder{


        ImageView full_screen_image;
        public FullScreenViewHolder(@NonNull View itemView) {
            super(itemView);
            full_screen_image = itemView.findViewById(R.id.full_screen_image);
        }

        public void bindData(PexelsImageModel pexelsImageModel) {

            Glide.with(context).load(pexelsImageModel.getSrc().getOriginal()).into(full_screen_image);




        }

    }
}
