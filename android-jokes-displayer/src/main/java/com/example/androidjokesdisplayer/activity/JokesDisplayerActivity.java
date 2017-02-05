package com.example.androidjokesdisplayer.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.example.androidjokesdisplayer.R;
import com.example.androidjokesdisplayer.utils.Constants;

public class JokesDisplayerActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.joke_container);

        Intent intent = getIntent();
        String joke;
        if (intent != null && intent.hasExtra(Constants.Extra.EXTRA_JOKE)) {
            joke = intent.getStringExtra(Constants.Extra.EXTRA_JOKE);
        } else {
            joke = getString(R.string.joke_not_found);
        }

        TextView jokeTextView = (TextView) findViewById(R.id.joke_text_view);
        jokeTextView.setText(joke);
    }
}
