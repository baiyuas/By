package com.baiyuas.ui.project;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.baiyuas.R;
import com.baiyuas.model.bean.ProjectBean;
import com.baiyuas.utils.SystemUtils;
import com.baiyuas.utils.image.GlideTarget;
import com.baiyuas.utils.image.WanAndroidImageLoader;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Copyright (c)2017
 * 欣网互联网络科技有限公司
 * author: lpc
 * created on: 2018/4/16 0016
 * description:
 */
public class ProjectAdapter extends RecyclerView.Adapter<ProjectAdapter.ProjectAdapterViewHolder> {


    List<ProjectBean> data;
    Context mContext;

    public ProjectAdapter(List<ProjectBean> data) {
        this.data = data;
    }

    public void setNewData(List<ProjectBean> list) {
        this.data = list == null ? new ArrayList<>() : list;
        notifyDataSetChanged();
    }

    public void addData(List<ProjectBean> list) {
        data.addAll(list);
        notifyItemRangeInserted(data.size() - list.size(), list.size());
    }

    @NonNull
    @Override
    public ProjectAdapterViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        this.mContext = parent.getContext();
        View item = LayoutInflater.from(parent.getContext()).inflate(R.layout.project_provider_falls, null);
        return new ProjectAdapterViewHolder(item);
    }

    @Override
    public void onBindViewHolder(@NonNull ProjectAdapterViewHolder holder, int position) {
        ProjectBean item = data.get(position);
        holder.tv.setText(item.getTitle());
        ImageView iv = holder.iv;
        WanAndroidImageLoader.loadAsBimmap(mContext,
                item.getEnvelopePic(),
                (GlideTarget<Bitmap>) bitmap -> {
                    iv.setImageBitmap(bitmap);
                    int screenWidth = SystemUtils.getScreenWidth(mContext);
                    int height = (int) ((screenWidth * 1.0f / 2 - 16 * 4) / bitmap.getWidth() * bitmap.getHeight());
                    ViewGroup.LayoutParams vlp = iv.getLayoutParams();
                    vlp.height = height;
                    iv.setLayoutParams(vlp);
                });
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public static class ProjectAdapterViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.iv_project_img)
        ImageView iv;

        @BindView(R.id.tv_project_name)
        TextView tv;

        public ProjectAdapterViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
