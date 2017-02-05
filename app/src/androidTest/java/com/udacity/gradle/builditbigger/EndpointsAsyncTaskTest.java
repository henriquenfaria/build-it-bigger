package com.udacity.gradle.builditbigger;

import android.text.TextUtils;

import com.udacity.gradle.builditbigger.sync.EndpointsAsyncTask;

import org.junit.Before;
import org.junit.Test;

import java.util.concurrent.CountDownLatch;

import static junit.framework.Assert.assertFalse;

public class EndpointsAsyncTaskTest {

    private CountDownLatch mSignal;

    @Before
    public void setUp() {
        mSignal = new CountDownLatch(1);
    }

    @Test
    public void testNewEndpointsAsyncTask() throws InterruptedException {
        new com.udacity.gradle.builditbigger.sync.EndpointsAsyncTask(new EndpointsAsyncTask
                .AsyncResponse() {
            @Override
            public void processResult(String result) {
                assertFalse(TextUtils.isEmpty(result));
                mSignal.countDown();
            }
        }).execute();
        mSignal.await();
    }
}