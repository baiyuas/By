package com.lib.adapter;

import android.content.Context;
import android.support.annotation.IntRange;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import com.lib.adapter.delegate.MultiTypeDelegate;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * @作者: Leo
 * @时间:2018/4/7
 * @描述:https://baiyuas.github.io/
 */
public abstract class BaseRecycleViewAdapter<T, V extends BaseRecycleViewHolder> extends RecyclerView.Adapter<V> {

    public static final int EMPTY_VIEW = -0x0009999;

    protected List<T> data;

    protected Context mContext;
    protected int mLayoutResId;
    protected LayoutInflater mLayoutInflater;

    protected FrameLayout mEmptyViewLayout;

    private MultiTypeDelegate mMultiTypeDelegate;

    /**
     * View 点击时间
     */
    private OnItemClickListener mOnItemClickListener;
    private OnItemLongClickListener mOnItemLongClickListener;
    private OnItemChildClickListener mOnItemChildClickListener;
    private OnItemChildLongClickListener mOnItemChildLongClickListener;

    public BaseRecycleViewAdapter(List<T> data) {
        this(0, data);
    }

    public BaseRecycleViewAdapter(@LayoutRes int layoutResId, List<T> data) {
        this.data = data;
        mLayoutResId = layoutResId;
    }

    public BaseRecycleViewAdapter(@LayoutRes int layoutResId) {
        this(layoutResId, null);
    }

    @NonNull
    @Override
    public V onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        V baseViewHolder = null;
        this.mContext = parent.getContext();
        this.mLayoutInflater = LayoutInflater.from(mContext);
        if (viewType == EMPTY_VIEW) {

        } else {
            baseViewHolder = onCreateDefineViewHolder(parent, viewType);
            bindViewClickListener(baseViewHolder);
        }
        baseViewHolder.setAdapter(this);
        return baseViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull V holder, int position) {
        //int viewType = holder.getItemViewType();
        convert(holder, getItem(position));
    }

    protected abstract void convert(V helper, T item);

    public T getItem(@IntRange(from = 0) int position) {
        if (position >= 0 && position < data.size())
            return data.get(position);
        else
            return null;
    }

    @Override
    public int getItemViewType(int position) {
        if (mEmptyViewLayout != null) {
            return EMPTY_VIEW;
        }
        return getDefItemViewType(position);
    }

    protected int getDefItemViewType(int position) {
        if (mMultiTypeDelegate != null) {
            return mMultiTypeDelegate.getDefItemViewType(data, position);
        }
        return super.getItemViewType(position);
    }


    @Override
    public int getItemCount() {
        return data.size();
    }

    public V onCreateDefineViewHolder(ViewGroup parent, int itemViewType) {
        int layoutId = mLayoutResId;
        if (mMultiTypeDelegate != null) {
            layoutId = mMultiTypeDelegate.getLayoutId(itemViewType);
        }
        return createBaseViewHolder(parent, layoutId);
    }

    private void bindViewClickListener(final BaseRecycleViewHolder baseViewHolder) {
        if (baseViewHolder == null) {
            return;
        }
        final View view = baseViewHolder.itemView;
        if (view == null) {
            return;
        }
        if (getOnItemClickListener() != null) {
            view.setOnClickListener(v -> setOnItemClick(v, baseViewHolder.getLayoutPosition()));
        }
        if (getOnItemLongClickListener() != null) {
            view.setOnLongClickListener(v -> setOnItemLongClick(v, baseViewHolder.getLayoutPosition()));
        }
    }

    public void setMultiTypeDelegate(MultiTypeDelegate multiTypeDelegate) {
        mMultiTypeDelegate = multiTypeDelegate;
    }

    public MultiTypeDelegate getMultiTypeDelegate() {
        return mMultiTypeDelegate;
    }

    protected V createBaseViewHolder(ViewGroup parent, int layoutResId) {
        return createBaseViewHolder(getItemView(layoutResId, parent));
    }

    public OnItemClickListener getOnItemClickListener() {
        return mOnItemClickListener;
    }

    public void setOnItemClick(View v, int position) {
        getOnItemClickListener().onItemClick(BaseRecycleViewAdapter.this, v, position);
    }

    public OnItemLongClickListener getOnItemLongClickListener() {
        return mOnItemLongClickListener;
    }

    public boolean setOnItemLongClick(View v, int position) {
        return getOnItemLongClickListener().onItemLongClick(BaseRecycleViewAdapter.this, v, position);
    }

    /**
     * if you want to use subclass of BaseViewHolder in the adapter,
     * you must override the method to create new ViewHolder.
     *
     * @param view view
     * @return new ViewHolder
     */
    @SuppressWarnings("unchecked")
    protected V createBaseViewHolder(View view) {
        Class temp = getClass();
        Class z = null;
        while (z == null && null != temp) {
            z = getInstancedGenericKClass(temp);
            temp = temp.getSuperclass();
        }
        V k;
        // 泛型擦除会导致z为null
        if (z == null) {
            k = (V) new BaseRecycleViewHolder(view);
        } else {
            k = createGenericKInstance(z, view);
        }
        return k != null ? k : (V) new BaseRecycleViewHolder(view);
    }

    protected View getItemView(@LayoutRes int layoutResId, ViewGroup parent) {
        return mLayoutInflater.inflate(layoutResId, parent, false);
    }

    /**
     * get generic parameter K
     *
     * @param z
     * @return
     */
    private Class getInstancedGenericKClass(Class z) {
        Type type = z.getGenericSuperclass();
        if (type instanceof ParameterizedType) {
            Type[] types = ((ParameterizedType) type).getActualTypeArguments();
            for (Type temp : types) {
                if (temp instanceof Class) {
                    Class tempClass = (Class) temp;
                    if (BaseRecycleViewHolder.class.isAssignableFrom(tempClass)) {
                        return tempClass;
                    }
                } else if (temp instanceof ParameterizedType) {
                    Type rawType = ((ParameterizedType) temp).getRawType();
                    if (rawType instanceof Class && BaseRecycleViewHolder.class.isAssignableFrom((Class<?>) rawType)) {
                        return (Class<?>) rawType;
                    }
                }
            }
        }
        return null;
    }

    /**
     * try to create Generic K instance
     *
     * @param z
     * @param view
     * @return
     */
    @SuppressWarnings("unchecked")
    private V createGenericKInstance(Class z, View view) {
        try {
            Constructor constructor;
            // inner and unstatic class
            if (z.isMemberClass() && !Modifier.isStatic(z.getModifiers())) {
                constructor = z.getDeclaredConstructor(getClass(), View.class);
                constructor.setAccessible(true);
                return (V) constructor.newInstance(this, view);
            } else {
                constructor = z.getDeclaredConstructor(View.class);
                constructor.setAccessible(true);
                return (V) constructor.newInstance(view);
            }
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void setOnItemLongClickListener(OnItemLongClickListener onItemLongClickListener) {
        mOnItemLongClickListener = onItemLongClickListener;
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        mOnItemClickListener = onItemClickListener;
    }

    /**
     * setting up a new instance to data;
     *
     * @param data
     */
    public void setNewData(@Nullable List<T> data) {
        this.data = data == null ? new ArrayList<>() : data;
        notifyDataSetChanged();
    }

    /**
     * insert  a item associated with the specified position of adapter
     *
     * @param position
     * @param item
     * @deprecated use {@link #addData(int, Object)} instead
     */
    @Deprecated
    public void add(@IntRange(from = 0) int position, @NonNull T item) {
        addData(position, item);
    }

    /**
     * add one new data in to certain location
     *
     * @param position
     */
    public void addData(@IntRange(from = 0) int position, @NonNull T data) {
        this.data.add(position, data);
        notifyItemInserted(position);
        compatibilityDataSizeChanged(1);
    }

    /**
     * compatible getLoadMoreViewCount and getEmptyViewCount may change
     *
     * @param size Need compatible data size
     */
    private void compatibilityDataSizeChanged(int size) {
        final int dataSize = this.data == null ? 0 : this.data.size();
        if (dataSize == size) {
            notifyDataSetChanged();
        }
    }

    /**
     * add one new data
     */
    public void addData(@NonNull T data) {
        this.data.add(data);
        notifyItemInserted(this.data.size());
        compatibilityDataSizeChanged(1);
    }

    /**
     * remove the item associated with the specified position of adapter
     *
     * @param position
     */
    public void remove(@IntRange(from = 0) int position) {
        this.data.remove(position);
        int internalPosition = position;
        notifyItemRemoved(internalPosition);
        compatibilityDataSizeChanged(0);
        notifyItemRangeChanged(internalPosition, this.data.size() - internalPosition);
    }

    /**
     * change data
     */
    public void setData(@IntRange(from = 0) int index, @NonNull T data) {
        this.data.set(index, data);
        notifyItemChanged(index);
    }

    /**
     * add new data in to certain location
     *
     * @param position the insert position
     * @param newData  the new data collection
     */
    public void addData(@IntRange(from = 0) int position, @NonNull Collection<? extends T> newData) {
        this.data.addAll(position, newData);
        notifyItemRangeInserted(position, newData.size());
        compatibilityDataSizeChanged(newData.size());
    }

    /**
     * add new data to the end of mData
     *
     * @param newData the new data collection
     */
    public void addData(@NonNull Collection<? extends T> newData) {
        this.data.addAll(newData);
        notifyItemRangeInserted(this.data.size() - newData.size(), newData.size());
        compatibilityDataSizeChanged(newData.size());
    }

    /**
     * use data to replace all item in mData. this method is different {@link #setNewData(List)},
     * it doesn't change the mData reference
     *
     * @param data data collection
     */
    public void replaceData(@NonNull Collection<? extends T> data) {
        // 不是同一个引用才清空列表
        if (data != this.data) {
            this.data.clear();
            this.data.addAll(data);
        }
        notifyDataSetChanged();
    }

    public List<T> getData() {
        return data;
    }

    public OnItemChildClickListener getOnItemChildClickListener() {
        return mOnItemChildClickListener;
    }

    public void setOnItemChildClickListener(OnItemChildClickListener onItemChildClickListener) {
        mOnItemChildClickListener = onItemChildClickListener;
    }

    public OnItemChildLongClickListener getOnItemChildLongClickListener() {
        return mOnItemChildLongClickListener;
    }

    public void setOnItemChildLongClickListener(OnItemChildLongClickListener onItemChildLongClickListener) {
        mOnItemChildLongClickListener = onItemChildLongClickListener;
    }

    public interface OnItemChildClickListener {

        void onItemChildClick(BaseRecycleViewAdapter adapter, View view, int position);
    }

    public interface OnItemChildLongClickListener {

        boolean onItemChildLongClick(BaseRecycleViewAdapter adapter, View view, int position);
    }

    public interface OnItemLongClickListener {

        boolean onItemLongClick(BaseRecycleViewAdapter adapter, View view, int position);
    }

    public interface OnItemClickListener {

        void onItemClick(BaseRecycleViewAdapter adapter, View view, int position);
    }
}
