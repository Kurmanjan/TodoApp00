package com.example.todoapp.ui.gallery;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.todoapp.R;

import java.util.ArrayList;


public class GalleryAdapter extends RecyclerView.Adapter<GalleryViewHolder> {
    ArrayList<String> list;

    public GalleryAdapter() {
        list = new ArrayList<>();
        list.add("Nurzhamal");
        list.add("Aygerim");
        list.add("Kunduz");
        list.add("Ayima");
        list.add("Pavel");
        list.add("Kubat");
        list.add("Syimyk");
        list.add("Nursultan");
        list.add("Kurmanjan");
        list.add("Bakyt");
        list.add("Perizat");
    }

    @NonNull
    @Override
    public GalleryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.viewholder_gallery, parent, false);
        GalleryViewHolder galleryViewHolder = new GalleryViewHolder(view);
        return galleryViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull GalleryViewHolder holder, int position) {
        holder.setTextViewGallery(list.get(position));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

}
