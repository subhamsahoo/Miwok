package com.example.android.miwok;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by subham on 11-10-2017.
 */

public class wordAdapter extends ArrayAdapter<word> {

    private int backgroundColor;


    public wordAdapter(Context context,ArrayList<word> words,int colorId) {
        super(context, 0, words);
        backgroundColor=colorId;
    }

    @NonNull
    @Override
    public View getView(int position,View convertView, ViewGroup parent) {

        View listItemView = convertView;

        if(listItemView==null)
        {
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.list_item,parent,false);
        }

        word currentWord = getItem(position);

        TextView defaultTextView = (TextView)listItemView.findViewById(R.id.default_text_view);
        defaultTextView.setText(currentWord.getDefaultTranslation());


        TextView miwokTextView = (TextView)listItemView.findViewById(R.id.miwok_text_view);
        miwokTextView.setText(currentWord.getMiwokTranslation());

        ImageView img = (ImageView)listItemView.findViewById(R.id.image);

        if(currentWord.hasImage()) {
            img.setVisibility(View.VISIBLE);
            img.setImageResource(currentWord.getImageResourceId());
        }
        else img.setVisibility(View.GONE);

        LinearLayout v=(LinearLayout)listItemView.findViewById(R.id.textContainer);
        int color = ContextCompat.getColor(getContext(),backgroundColor);
        v.setBackgroundColor(color);

        return listItemView;
    }
}
