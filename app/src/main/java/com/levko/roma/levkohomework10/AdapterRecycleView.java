package com.levko.roma.levkohomework10;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by User on 16.03.2016.
 */
public class AdapterRecycleView extends RecyclerView.Adapter<AdapterRecycleView.ViewHolder> {

    private Context context;
    private ArrayList<String> items;

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView text;
        private FrameLayout container;

        public ViewHolder(View itemView) {
            super(itemView);
            container = (FrameLayout) itemView.findViewById(R.id.fl_container_IFR);
            text = (TextView) itemView.findViewById(R.id.tv_IFR);
        }
    }

    public AdapterRecycleView(ArrayList<String> items, Context context) {
        this.items = items;
        this.context = context;
    }

    @Override
    public AdapterRecycleView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.items_for_rv, parent, false);

        return new ViewHolder(v);
    }


    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        TextView textFirstName = holder.text;
        textFirstName.setText(items.get(position));

        FrameLayout container = holder.container;
        setAnimation(container);
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    private void setAnimation(View view) {
        Animation animation = AnimationUtils.loadAnimation(context, R.anim.list);
        view.startAnimation(animation);
    }
}

