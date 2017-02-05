package com.udacity.gradle.builditbigger.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;

import com.udacity.gradle.builditbigger.R;
import com.udacity.gradle.builditbigger.sync.EndpointsAsyncTask;

/**
 * Fragment without ads
 */
public class JokeFragment extends BaseJokeFragment
        implements EndpointsAsyncTask.AsyncResponse {

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

        // Restore objects value
        if (savedInstanceState != null) {
            if (savedInstanceState.getBoolean(SAVE_TASK_RUNNING, false)) {
                tellJoke();
            }
        }

        return root;
    }


}
