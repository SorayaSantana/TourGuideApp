/*
 * Copyright (C) 2016 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.android.TourGuideApp;


import android.app.SearchManager;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.fragment.app.Fragment;
import java.util.ArrayList;


/**
 * {@link Fragment} that displays a list of Islands items
 */
public class IslandsFragment extends Fragment {

    public IslandsFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.tour_item_list, container, false);

        // Create a list of tour items
        final ArrayList<TourItem> tourItems = new ArrayList<>();

        tourItems.add(new TourItem(R.string.island_fuerte, R.string.island_fuerte_citizens,
                                    R.string.island_fuerte_mains, R.drawable.fuerte));
        tourItems.add(new TourItem(R.string.island_lanza, R.string.island_lanza_citizens,
                R.string.island_lanza_mains, R.drawable.lanza));
        tourItems.add(new TourItem(R.string.island_gc, R.string.island_gc_citizens,
                                    R.string.island_gc_mains,R.drawable.granca));
        tourItems.add(new TourItem(R.string.island_tf, R.string.island_tf_citizens,
                                    R.string.island_tf_mains, R.drawable.tenerife));
        tourItems.add(new TourItem(R.string.island_gomera, R.string.island_gomera_citizens,
                                    R.string.island_gomera_mains, R.drawable.gomera));
        tourItems.add(new TourItem(R.string.island_hierro, R.string.island_hierro_citizens,
                                    R.string.island_hierro_mains, R.drawable.hierro));
        tourItems.add(new TourItem(R.string.island_lapalma, R.string.island_lapalma_citizens,
                                    R.string.island_lapalma_mains, R.drawable.lapalma));

        // Create an Adapter, whose data source is a list of tour items. The
        // adapter knows how to create list items for each item in the list.
        TourItemAdapter adapter = new TourItemAdapter(getActivity(), tourItems, R.color.category_color);

        ListView listView = rootView.findViewById(R.id.list);
        listView.setAdapter(adapter);

        // Set a click listener to search on google when item clicked
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {

                // Get the item object at the given position the user clicked on
                TourItem tourItem = tourItems.get(position);

                String query = getResources().getString(tourItem.getTitleId());

                Intent intent = new Intent(Intent.ACTION_WEB_SEARCH);
                intent.putExtra(SearchManager.QUERY, query); // query contains search string
                startActivity(intent);
            }

        });

        return rootView;
    }
}
