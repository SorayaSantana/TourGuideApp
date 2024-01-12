# TourGuideApp
This is a simple small Android application as training exercise for the Android Basics
training from Audacity.

## Tech details for review and use
Build gradle: 
        minSdkVersion 21
        targetSdkVersion 31

Tested on Pixel API 30 virtual device. Android 11.0

## Criteria to cover
- App contains at least 4 lists of relevant attractions for a location
- User navigates between lists in Fragments using either a Navigation Drawer or a ViewPager plus TabLayout.
- Each list item contains information about an event, restaurant, historical site, or similar.
- At least one list includes pictures of the location.
- The code adheres to all of the following best practices:
  * Text sizes are defined in sp
  * Lengths are defined in dp
  * Padding and margin is used appropriately, such that the views are not crammed up against each other.
- App contains a custom object for storing location information .
- App uses a custom adapter to populate the layout with views based on instances of the custom class.
- All strings are stored in the strings.xml resource file.
- All images are stored as drawables.
- All drawables are stored at multiple densities.
- The code runs without errors.

## Extras
Functionallyty to launch a web search when items clicked.
