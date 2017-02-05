package com.udacity.gradle.builditbigger.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.androidjokesdisplayer.activity.JokesDisplayerActivity;
import com.example.androidjokesdisplayer.utils.Constants;
import com.udacity.gradle.builditbigger.R;
import com.udacity.gradle.builditbigger.fragment.JokeFragment;


public class MainActivity extends AppCompatActivity implements JokeFragment.OnTellJokeListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void onReturnJoke(String result) {
        Intent intent = new Intent();
        intent.setClass(this, JokesDisplayerActivity.class);
        intent.putExtra(Constants.Extra.EXTRA_JOKE, result);
        startActivity(intent);
    }
}
