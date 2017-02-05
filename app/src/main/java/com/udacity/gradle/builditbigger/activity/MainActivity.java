package com.udacity.gradle.builditbigger.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.example.androidjokesdisplayer.activity.JokesDisplayerActivity;
import com.example.androidjokesdisplayer.utils.Constants;
import com.udacity.gradle.builditbigger.R;
import com.udacity.gradle.builditbigger.sync.EndpointsAsyncTask;


public class MainActivity extends AppCompatActivity implements EndpointsAsyncTask.AsyncResponse {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    // Get joke from GCE
    public void tellJoke(View view) {
        new EndpointsAsyncTask(this).execute();
    }


    @Override
    // Once the joke is retrieved from GCE, call the Displayer lib to display the joke
    public void processResult(String result) {
        Intent intent = new Intent();
        intent.setClass(this, JokesDisplayerActivity.class);
        intent.putExtra(Constants.Extra.EXTRA_JOKE, result);
        startActivity(intent);
    }
}
