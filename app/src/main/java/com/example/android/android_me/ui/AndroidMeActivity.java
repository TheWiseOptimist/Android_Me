/*
 * Copyright (C) 2017 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *  	http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.android.android_me.ui;

import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.android.android_me.R;
import com.example.android.android_me.data.AndroidImageAssets;

import static com.example.android.android_me.data.AndroidImageAssets.updateBPFragment;

// This activity will display a custom Android image composed of three body parts: head, body, and legs
public class AndroidMeActivity extends AppCompatActivity {
    int headIndex, bodyIndex, legIndex;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_android_me);

        // Only create new fragments when there is no previously saved state
        if (savedInstanceState == null) {

            FragmentManager fragmentManager = getSupportFragmentManager();

            // Retrieve list index values that were sent through an intent; use them to display the desired Android-Me body part image
            // Use setListindex(int index) to set the list index for all BodyPartFragments
            // Create a new head BodyPartFragment
            // Set the list of image id's for the head fragment and set the position to the second image in the list
            // Get the correct index to access in the array of head images from the intent
            // Set the default value to 0
            // Add the fragment to its container using a FragmentManager and a Transaction
            headIndex = getIntent().getIntExtra("headIndex", 0);
            updateBPFragment(headIndex, fragmentManager, 0);

            // Create and display the body and leg BodyPartFragments
            bodyIndex = getIntent().getIntExtra("bodyIndex", 0);
            updateBPFragment(bodyIndex, fragmentManager, 1);

            legIndex = getIntent().getIntExtra("legIndex", 0);
            updateBPFragment(legIndex, fragmentManager, 2);
        }
    }
}
