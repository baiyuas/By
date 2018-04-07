package com.baiyuas.ui.home;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.baiyuas.R;
import com.baiyuas.model.bean.ArticleBean;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * @作者: Leo
 * @时间:2018/4/7
 * @描述:https://baiyuas.github.io/
 */
public class ArticleAdapter extends RecyclerView.Adapter<ArticleAdapter.ArticleAdapterViewHolder> {

    List<ArticleBean> list;

    public ArticleAdapter() {
        list = new ArrayList<>();
    }

    public void addData(List<ArticleBean> data) {
        list.addAll(data);
        notifyDataSetChanged();
    }

    public void removeAll() {
        list.clear();
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ArticleAdapterViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_article_list, null, false);
        return new ArticleAdapterViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ArticleAdapterViewHolder holder, int position) {
        ArticleBean articleBean = list.get(position);
        holder.tvArticleAuthor.setText(articleBean.getAuthor());
        holder.tvArticleTitle.setText(articleBean.getTitle());
        holder.tvArticleCatalog.setText(articleBean.getSuperChapterName());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    static class ArticleAdapterViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.tv_article_author)
        TextView tvArticleAuthor;

        @BindView(R.id.tv_article_title)
        TextView tvArticleTitle;

        @BindView(R.id.tv_article_catalog)
        TextView tvArticleCatalog;

        public ArticleAdapterViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

    }
}
