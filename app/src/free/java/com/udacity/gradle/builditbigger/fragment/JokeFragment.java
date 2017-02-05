package com.udacity.gradle.builditbigger.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.udacity.gradle.builditbigger.R;
import com.udacity.gradle.builditbigger.sync.EndpointsAsyncTask;

/**
 * Fragment with ads
 */
public class JokeFragment extends BaseJokeFragment
        implements EndpointsAsyncTask.AsyncResponse {

    private AdView mAdView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_main, container, false);

        mTellJokeButton = (Button) root.findViewById(R.id.tellJokeButton);
        mTellJokeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Start async task to fetch jokes from GCE
                tellJoke();

            }
        });

        mProgressBar = (ProgressBar) root.findViewById(R.id.progressBar);

        // Display ads only in the free version
        mAdView = (AdView) root.findViewById(R.id.adView);
        // Create an ad request. Check logcat output for the hashed device ID to
        // get test ads on a physical device. e.g.
        // "Use AdRequest.Builder.addTestDevice("ABCDEF012345") to get test ads on this device."
        AdRequest adRequest = new AdRequest.Builder()
                .addTestDevice(AdRequest.DEVICE_ID_EMULATOR).build();
        mAdView.loadAd(adRequest);
        mAdView.setVisibility(View.VISIBLE);

        // Restore objects value
        if (savedInstanceState != null) {
            if (savedInstanceState.getBoolean(SAVE_TASK_RUNNING, false)) {
                tellJoke();
            }
        }

        return root;
    }


}
