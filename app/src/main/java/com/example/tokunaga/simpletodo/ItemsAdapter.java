package com.example.tokunaga.simpletodo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

/**
 * Created by tokunaga on 8/23/17.
 */

public class ItemsAdapter extends ArrayAdapter<String> {
    public ItemsAdapter(Context context){
        super(context, 0);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.itemsview, null);
            holder = new ViewHolder();
            holder.nameView = (TextView) convertView.findViewById(R.id.name);
            holder.ctgrView = (TextView) convertView.findViewById(R.id.categories);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        String currentItem = getItem(position);
        //TODO

//        if (currentItem.length() ==0) {
//
//        } else {
            holder.nameView.setText(currentItem);
            holder.ctgrView.setText("");
//        }
        return convertView;

    }

    private static class ViewHolder {

        private TextView nameView;
        private TextView ctgrView;
    }



}
