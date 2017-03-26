package com.example.luv.image_in_list_view;

/**
 * Created by luv on 26/3/17.
 */

import android.content.Context;
import android.content.Intent;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.util.Log;
import android.widget.ImageView;

        import android.app.Activity;
        import android.view.LayoutInflater;
        import android.view.View;
        import android.view.ViewGroup;
        import android.widget.ArrayAdapter;
        import android.widget.ImageView;
        import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import static android.content.ContentValues.TAG;

public class CustomListAdapter extends ArrayAdapter<String> {


    Context context;
    ArrayList<String> name;
    ArrayList<Integer> imgId;

    public CustomListAdapter(@NonNull Context context, @NonNull ArrayList<String> objects, ArrayList<Integer> intArray) {
        super(context, 0, objects);
        this.context = context;
        name = objects;
        imgId = intArray;
    }

    @Override
    public View getView(int position,View view,ViewGroup parent) {

        View rowView = View.inflate(context, R.layout.mylist, null);

        TextView txtTitle = (TextView) rowView.findViewById(R.id.item);
        ImageView imageView = (ImageView) rowView.findViewById(R.id.icon);
        TextView extratxt = (TextView) rowView.findViewById(R.id.textView1);

        txtTitle.setText(name.get(position));
        imageView.setImageResource(imgId.get(position));
//        imageView.setImageResource(R.drawable.cam);
        extratxt.setText("Description "+name.get(position));
        return rowView;

    };
}
