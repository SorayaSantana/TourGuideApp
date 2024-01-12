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
 * {@link Fragment} that displays a list of Locations is every island
 */
public class LocationsFragment extends Fragment {

    public LocationsFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.tour_item_list, container, false);

        // Create a list of tour items
        final ArrayList<TourItem> tourItems = new ArrayList<TourItem>();
        tourItems.add(new TourItem(R.string.location_one, R.string.location_one_island,
                                    R.string.location_one_desc,
                                    R.drawable.maspalomas));
        tourItems.add(new TourItem(R.string.location_two, R.string.location_two_island,
                                    R.string.location_two_desc,
                                    R.drawable.teide));
        tourItems.add(new TourItem(R.string.location_three, R.string.location_three_island,
                                    R.string.location_three_desc,
                                    R.drawable.timanfaya));
        tourItems.add(new TourItem(R.string.location_four, R.string.location_four_island,
                                    R.string.location_four_desc, R.drawable.garajonay));
        tourItems.add(new TourItem(R.string.location_five, R.string.location_five_island,
                                    R.string.location_five_desc,R.drawable.marcalmas));
        tourItems.add(new TourItem(R.string.location_six, R.string.location_six_island,
                                    R.string.location_six_desc, R.drawable.calderataburiente));
        tourItems.add(new TourItem(R.string.location_seven, R.string.location_seven_island,
                                    R.string.location_seven_desc,
                                    R.drawable.cofete));

        // Create an Adapter, whose data source is a list of tour items. The
        // adapter knows how to create list items for each item in the list.
        TourItemAdapter adapter = new TourItemAdapter(getActivity(), tourItems, R.color.category_color);

        ListView listView = (ListView) rootView.findViewById(R.id.list);
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
