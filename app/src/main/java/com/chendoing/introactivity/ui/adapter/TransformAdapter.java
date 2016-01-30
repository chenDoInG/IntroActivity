/*
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */
package com.chendoing.introactivity.ui.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.chendoing.introactivity.R;
import com.chendoing.introactivity.model.entities.Transform;
import com.chendoing.introactivity.ui.RecyclerClickListener;

import java.util.List;

import butterknife.Bind;
import butterknife.BindColor;
import butterknife.ButterKnife;

public class TransformAdapter extends RecyclerView.Adapter<TransformAdapter.TransformViewHolder> {

//    private final String NOT_AVAILABLE_URL = "https://www.baidu.com";
    private final RecyclerClickListener recyclerClickListener;
    private final List<Transform.Data> datas;

    private Context context;

    public TransformAdapter(List<Transform.Data> data, Context context, RecyclerClickListener recyclerClickListener) {
        this.datas = data;
        this.context = context;
        this.recyclerClickListener = recyclerClickListener;
    }

    @Override
    public TransformViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View rootView = LayoutInflater.from(context).inflate(
                R.layout.item_display_message_data, parent, false);

        return new TransformViewHolder(rootView, recyclerClickListener);
    }

    @Override
    public void onBindViewHolder(TransformViewHolder holder, int position) {
        holder.bindData(datas.get(position));
    }

    @Override
    public int getItemCount() {
        return datas.size();
    }

    public class TransformViewHolder extends RecyclerView.ViewHolder {

        @Bind(R.id.item_title)
        TextView title;
        @Bind(R.id.item_thumb)
        ImageView thumb;
        @Bind(R.id.item_placeholder_name)
        TextView placeholderTitleTextView;
        @BindColor(R.color.brand_primary)
        int mColorPrimary;

        public TransformViewHolder(View itemView, final RecyclerClickListener recyclerClickListener) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            bindListener(itemView, recyclerClickListener);
        }

        public void bindData(Transform.Data data) {
            title.setText(data.getUidatas().get(0).getName());
            title.setTransitionName(data.getUidatas().get(0).getName());
//            if(transform.getUrl().equals(NOT_AVAILABLE_URL)){
//                ColorDrawable colorDrawable = new ColorDrawable(mColorPrimary);
//                thumb.setDrawingCacheEnabled(true);
//                thumb.setImageDrawable(colorDrawable);
//            }else {
//                Glide.with(context).load(transform.getUrl()).crossFade().into(thumb);
//            }

        }

        private void bindListener(View itemView, final RecyclerClickListener recyclerClickListener) {
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    recyclerClickListener.onElementClick(getAdapterPosition(), title, thumb);
                }
            });
        }
    }
}
