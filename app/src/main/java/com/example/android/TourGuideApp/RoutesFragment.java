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

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import androidx.fragment.app.Fragment;

import java.util.ArrayList;


/**
 * {@link Fragment} that displays a list of routes recommended around islands and locations.
 */
public class RoutesFragment extends Fragment {

    public RoutesFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.tour_item_list, container, false);

        // Create a list of tour items
        final ArrayList<TourItem> tourItems = new ArrayList<>();
        tourItems.add(new TourItem(R.string.route_one,R.string.route_one_island,
                                   R.string.route_one_desc));
        tourItems.add(new TourItem(R.string.route_two,R.string.route_two_island,
                                   R.string.route_two_desc));
        tourItems.add(new TourItem(R.string.route_three,R.string.route_three_island,
                                   R.string.route_three_desc));
        tourItems.add(new TourItem(R.string.route_three,R.string.route_three_island,
                R.string.route_three_desc));

        // Create an Adapter, whose data source is a list of tour items. The
        // adapter knows how to create list items for each item in the list.
        TourItemAdapter adapter = new TourItemAdapter(getActivity(), tourItems, R.color.category_color);

        ListView listView = rootView.findViewById(R.id.list);
        listView.setAdapter(adapter);

        //items no touchable in this fragment. We do it by hiding the visual feedback to user
        listView.setSelector(android.R.color.transparent);

        return rootView;
    }
}
