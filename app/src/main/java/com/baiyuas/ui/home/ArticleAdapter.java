package com.baiyuas.ui.home;

import android.content.Context;
import android.content.res.Resources;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.baiyuas.R;
import com.baiyuas.model.bean.ArticleBean;
import com.baiyuas.utils.toast.Toasty;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * @作者: Leo
 * @时间:2018/4/7
 * @描述:https://baiyuas.github.io/
 */
public class ArticleAdapter extends RecyclerView.Adapter<ArticleAdapter.ArticleAdapterViewHolder> {

    List<ArticleBean> list;
    int[] navs = new int[]{R.color.nav_01, R.color.nav_02, R.color.nav_03, R.color.nav_04, R.color.nav_05, R.color.nav_06};
    Random mRandom = new Random();

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
        holder.tvArticleAuthor.setText(String.format(holder.getRes().getString(R.string.item_article_author_str), articleBean.getAuthor()));
        holder.tvArticleTitle.setText(articleBean.getTitle());
        holder.tvArticleCatalog.setText(String.format(holder.getRes().getString(R.string.item_article_catalog_str), articleBean.getSuperChapterName()));
        holder.tvTime.setText(articleBean.getNiceDate());

        int colorRandom = mRandom.nextInt(5);
        holder.navLine.setBackgroundColor(holder.context.getResources().getColor(navs[colorRandom]));
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

        @BindView(R.id.tv_article_date)
        TextView tvTime;

        @BindView(R.id.nav_line)
        View navLine;

        Context context;

        Resources getRes() {
            return context.getResources();
        }

        public ArticleAdapterViewHolder(View itemView) {
            super(itemView);
            context = itemView.getContext();
            itemView.setOnClickListener(v -> Toasty.show(itemView.getContext(), "jjjjjj"));
            ButterKnife.bind(this, itemView);
        }

    }
}
