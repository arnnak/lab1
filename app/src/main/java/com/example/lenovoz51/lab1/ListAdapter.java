package com.example.lenovoz51.lab1;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Lenovo Z51 on 2018-09-23.
 */

public class ListAdapter extends ArrayAdapter<ListItem> {

    public ListAdapter(Context context, List<ListItem> objects) {
        super(context,R.layout.listitemdesign, objects);
    }

    @Override
    public View getView(int position, View contentView, ViewGroup parent){
        View v = contentView;
        if (v==null){
            LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            v = inflater.inflate(R.layout.listitemdesign,null);
        }

        TextView title = (TextView) v.findViewById(R.id.title);
        TextView description = (TextView) v.findViewById(R.id.description);
        ImageView image = (ImageView) v.findViewById(R.id.image);

        ListItem item = getItem(position);

        title.setText(item.getTitle());
        description.setText(item.getDescription());
        image.setImageResource(item.getImageId());

        return v;
    }
}
