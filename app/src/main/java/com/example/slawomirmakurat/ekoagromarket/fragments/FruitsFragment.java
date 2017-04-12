package com.example.slawomirmakurat.ekoagromarket.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.slawomirmakurat.ekoagromarket.R;
import com.example.slawomirmakurat.ekoagromarket.RecyclerView.DataProvider.DataProvider;
import com.example.slawomirmakurat.ekoagromarket.RecyclerView.DataProvider.FakeDataFruit;
import com.example.slawomirmakurat.ekoagromarket.RecyclerView.DataProvider.FruitAdapter;

import java.util.ArrayList;



/**
 * A simple {@link Fragment} subclass.
 */
public class FruitsFragment extends Fragment{

    private static RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    public  RecyclerView recyclerView;
    private static ArrayList<DataProvider> data;

    public FruitsFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_fruits, container, false);

        recyclerView = (RecyclerView) rootView.findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);

        layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        data = new ArrayList<DataProvider>();
        for (int i = 0; i < FakeDataFruit.fruitTitleArray.length; i++) {
            data.add(new DataProvider(
                    FakeDataFruit.fruitTitleArray[i],
                    FakeDataFruit.fruitTextArray[i],
                    FakeDataFruit.userArray[i],
                    FakeDataFruit.user_cityArray[i],
                    FakeDataFruit.user_phoneArray[i],
                    FakeDataFruit.user_emailArray[i],
                    FakeDataFruit.user_distanceArray[i],
                    FakeDataFruit.fruit_drawableArray[i],
                    FakeDataFruit.id[i],
                    FakeDataFruit.user_certyArray[i],
                    FakeDataFruit.time_Array[i]
            ));
        }
        adapter = new FruitAdapter(data);
        recyclerView.setAdapter(adapter);
        return rootView;
    }


    }


