package com.udacity.gradle.builditbigger.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.widget.Toast;

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
        if (TextUtils.isEmpty(result)) {
            Toast.makeText(this, R.string.error_connecting_server, Toast.LENGTH_LONG).show();
        } else {
            Intent intent = new Intent();
            intent.setClass(this, JokesDisplayerActivity.class);
            intent.putExtra(Constants.Extra.EXTRA_JOKE, result);
            startActivity(intent);
        }
    }
}
