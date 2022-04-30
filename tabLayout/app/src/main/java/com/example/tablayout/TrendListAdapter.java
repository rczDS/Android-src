package com.example.tablayout;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.LinkedList;

public class TrendListAdapter extends
        RecyclerView.Adapter<TrendListAdapter.TrendViewHolder> {
    private final LinkedList<String> mTrendList;
    private final LayoutInflater mInflater;

    public TrendListAdapter(Context context, LinkedList<String> trendList) {
        mInflater = LayoutInflater.from(context);
        this.mTrendList = trendList;
    }

    @NonNull
    @Override
    public TrendViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View mItemView = mInflater.inflate(
                R.layout.trendlist_item, parent, false);
        return new TrendViewHolder(mItemView, this);
    }

    @Override
    public void onBindViewHolder(@NonNull TrendViewHolder holder, int position) {
        String mCurrent = mTrendList.get(position);
        holder.my_trendItemView.setText(mCurrent);
    }

    @Override
    public int getItemCount() {
        return mTrendList.size();
    }

    class TrendViewHolder extends RecyclerView.ViewHolder
            implements View.OnClickListener{
        public final Button my_trendItemView;
        final TrendListAdapter my_adapter;

        public TrendViewHolder(View itemView, TrendListAdapter adapter){
            super(itemView);
            my_trendItemView = itemView.findViewById(R.id.trendButton);
            this.my_adapter = adapter;
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view){
            int mPosition = getLayoutPosition();

            String element = mTrendList.get(mPosition);

            mTrendList.set(mPosition, "Clicked! " + element);
            my_adapter.notifyDataSetChanged();
        }
    }

}
