package com.example.slawomirmakurat.ekoagromarket.RecyclerView;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.slawomirmakurat.ekoagromarket.R;

/**
 * Created by slawomir.makurat on 2017-04-10.
 */

public class MyViewHolder extends RecyclerView.ViewHolder {
    public final TextView title;
    public final TextView text;
    public final ImageView image;


    public MyViewHolder(View itemView) {
        super(itemView);
        title = (TextView) itemView.findViewById(R.id.title_itemlist_textView);
        text = (TextView) itemView.findViewById(R.id.text_itemlist_textView);
        image = (ImageView) itemView.findViewById(R.id.imageView);

        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            }
        });

    }
}
