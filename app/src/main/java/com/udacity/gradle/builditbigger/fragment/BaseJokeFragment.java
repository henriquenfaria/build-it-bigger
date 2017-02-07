package com.udacity.gradle.builditbigger.fragment;

import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;

import com.udacity.gradle.builditbigger.sync.EndpointsAsyncTask;

/**
 * Base Joke Fragment
 */
public class BaseJokeFragment extends Fragment implements EndpointsAsyncTask.AsyncResponse {

    protected final static String SAVE_TASK_RUNNING = "SAVE_TASK_RUNNING";
    protected Context mContext;
    protected OnTellJokeListener mTellJokeListener;
    protected Button mTellJokeButton;
    protected ProgressBar mProgressBar;
    protected boolean mIsTaskRunning;
    protected EndpointsAsyncTask mAsyncTask;

    public interface OnTellJokeListener {
        void onReturnJoke(String joke);
    }

    public BaseJokeFragment() {
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnTellJokeListener) {
            mTellJokeListener = (OnTellJokeListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnTellJokeListener");
        }

        mContext = context;
    }


    @Override
    public void onStart() {
        super.onStart();
        setProgressBarVisibility(mIsTaskRunning);
        setTellJokeButtonEnabled(!mIsTaskRunning);
    }

    private boolean isTaskRunning() {
        return (mAsyncTask != null) && (mAsyncTask.getStatus() == AsyncTask.Status.RUNNING);
    }

    @Override
    public void processResult(String result) {
        // Hide progress bar
        setProgressBarVisibility(false);
        setTellJokeButtonEnabled(true);
        mIsTaskRunning = false;
        mTellJokeListener.onReturnJoke(result);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        // Cancel the task if it's running
        if (isTaskRunning()) {
            mAsyncTask.cancel(true);
        }
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putBoolean(SAVE_TASK_RUNNING, mIsTaskRunning);
    }


    // Get joke from GCE
    protected void tellJoke() {
        // Display progress bar
        setProgressBarVisibility(true);
        setTellJokeButtonEnabled(false);
        mIsTaskRunning = true;
        mAsyncTask = new EndpointsAsyncTask(this);
        mAsyncTask.execute();
    }


    protected void setProgressBarVisibility(boolean isVisible) {
        if (mProgressBar != null) {
            if (isVisible) {
                mProgressBar.setVisibility(View.VISIBLE);
            } else {
                mProgressBar.setVisibility(View.GONE);
            }
        }
    }

    protected void setTellJokeButtonEnabled(boolean isEnabled) {
        if (mTellJokeButton != null) {
            mTellJokeButton.setClickable(isEnabled);
            mTellJokeButton.setEnabled(isEnabled);
        }
    }
}
