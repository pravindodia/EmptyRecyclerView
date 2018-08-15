package com.example.emptyrecyclerview;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Jiyyo on 28/07/18.
 */
public class CustomRecylerViewAdaptor extends RecyclerView.Adapter<CustomRecylerViewAdaptor.MyViewHolder> {

    private final ArrayList<String> mArrayList;

    public CustomRecylerViewAdaptor(ArrayList<String> arrayList) {
        this.mArrayList = arrayList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recylcerview_item, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.txtsampledatatitle.setText(mArrayList.get(position));
    }

    @Override
    public int getItemCount() {
        return mArrayList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView txtsampledatatitle;

        public MyViewHolder(View view) {
            super(view);
            txtsampledatatitle = (TextView) view.findViewById(R.id.txtsampledatatitle);

        }
    }
}
