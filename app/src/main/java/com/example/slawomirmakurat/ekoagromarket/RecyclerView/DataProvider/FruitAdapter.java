package com.example.slawomirmakurat.ekoagromarket.RecyclerView.DataProvider;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.slawomirmakurat.ekoagromarket.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by slawomir.makurat on 2017-04-11.
 */

public class FruitAdapter extends RecyclerView.Adapter<FruitAdapter.ViewHolder> {


    private List<DataProvider> dataSet;



    public static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public TextView title;
        public TextView text;
        public TextView city;
        public TextView user;
        public TextView time;
        public TextView certy;
        public ImageView image;


        public ViewHolder(View itemView) {
            super(itemView);
            title = (TextView) itemView.findViewById(R.id.title_itemlist_textView);
            text = (TextView) itemView.findViewById(R.id.text_itemlist_textView);
            city = (TextView) itemView.findViewById(R.id.city_itemlist_textView);
            user = (TextView) itemView.findViewById(R.id.user_itemlist_textView);
            time = (TextView) itemView.findViewById(R.id.time_itemlist_textView);
            certy = (TextView) itemView.findViewById(R.id.certyfiakte_itemlist_textView);
            image = (ImageView) itemView.findViewById(R.id.imageView);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // otwieranie nowego okna
                }
            });

        }

        @Override
        public void onClick(View v) {

        }
    }

    public FruitAdapter(ArrayList<DataProvider> data) {
        this.dataSet = data;
    }

    @Override
    public FruitAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout, parent, false);
        return new FruitAdapter.ViewHolder(view);
    }


    @Override
    public void onBindViewHolder(final FruitAdapter.ViewHolder holder, int position) {

        TextView textViewtile = holder.title;
        TextView textViewtext = holder.text;
        TextView textViewcity = holder.city;
        TextView textViewuser = holder.user;
        TextView textViewtime = holder.time;
        TextView textViewcerty = holder.certy;
        ImageView imageView = holder.image;

        textViewtile.setText(dataSet.get(position).getTitle());
        textViewtext.setText(dataSet.get(position).getText());
        textViewcity.setText(dataSet.get(position).getCity());
        textViewuser.setText(dataSet.get(position).getUser());
        textViewtime.setText(dataSet.get(position).getTime());
        textViewcerty.setText(dataSet.get(position).getCerty());
        imageView.setImageResource(dataSet.get(position).getImg_res());
    }

    @Override
    public int getItemCount() {
        return dataSet.size();
    }

}

