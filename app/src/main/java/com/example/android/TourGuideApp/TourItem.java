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

/**
 * {@link TourItem} represents a touristic item that the user wants to know about
 * It contains resource IDs for the different text (title, short description ...), and
 * optional image file for that item.
 */
public class TourItem {
    private int mItemTitle;
    private int mItemData1Short;
    private int mItemData1Long;
    //we may grow in future with more data (independent of its visualization order)
    private int mImageResourceId = NO_IMAGE_PROVIDED;


    /** Constant value that represents no image was provided for this item */
    private static final int NO_IMAGE_PROVIDED = -1;

    /**
     * Create a new Item object without image
     *
     * @param itemTitleId is the string resource ID for the title of teh item
     * @param itemData1Short is the string resource Id for the short data field of the item
     * @param itemData1Long is the string resource Id for the long data field of the item
     */
    public TourItem(int itemTitleId, int itemData1Short, int itemData1Long) {
        mItemTitle = itemTitleId;
        mItemData1Short = itemData1Short;
        mItemData1Long = itemData1Long;
    }

    /**
     * Create a new Item object without image
     *
     * @param itemTitleId is the string resource ID for the title of teh item
     * @param itemData1Short is the string resource Id for the short data field of the item
     * @param itemData1Long is the string resource Id for the long data field of the item
     * @param imageResourceId is the drawable resource ID for the image associated with the word
     */
    public TourItem(int itemTitleId, int itemData1Short, int itemData1Long, int imageResourceId) {
        mItemTitle = itemTitleId;
        mItemData1Short = itemData1Short;
        mItemData1Long = itemData1Long;
        mImageResourceId = imageResourceId;
    }

    /**
     * Get the string resource ID for the title
     */
    public int getTitleId() {
        return mItemTitle;
    }

    /**
     * Get the string resource ID for the short data field
     */
    public int getShortDataId() {
        return mItemData1Short;
    }

    /**
     * Get the string resource ID for the long data field
     */
    public int getLongDataId() {
        return mItemData1Long;
    }

    /**
     * Return the image resource ID of the item.
     */
    public int getImageResourceId() {
        return mImageResourceId;
    }

    /**
     * Returns whether or not there is an image for this item.
     */
    public boolean hasImage() {
        return mImageResourceId != NO_IMAGE_PROVIDED;
    }

}