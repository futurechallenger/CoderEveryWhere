package com.service.codereverywhere.codereverywhere.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

/**
 * Created by uncle_charlie on 12/10/15.
 */
public class CategoryListAdapter extends BaseAdapter {

    private Context _context;
    private LayoutInflater _inflater;

    public CategoryListAdapter(Context context, List) {
        this._context = context;
        this._inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return 0;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if (convertView == null) {
            viewHolder = new ViewHolder();
            convertView =
        }
    }

    static class ViewHolder {
        public TextView _textView;
    }
}
