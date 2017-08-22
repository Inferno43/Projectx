package com.inferno.projectx;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by saravana.subramanian on 8/21/17.
 */

public class BaseActivity extends AppCompatActivity implements ActivityCallback,FragmentCallback {

    @Override
    public void startActivity(Class<? extends AppCompatActivity> activity, Bundle extras, int requestCode) {

        Intent intent = new Intent(this,activity);
        if(extras!=null)intent.putExtras(extras);
        startActivityForResult(intent,requestCode);

    }

    @Override
    public void startFrgament() {

    }
}
