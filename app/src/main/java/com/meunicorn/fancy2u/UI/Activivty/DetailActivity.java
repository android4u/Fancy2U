package com.meunicorn.fancy2u.UI.Activivty;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import com.meunicorn.fancy2u.Bean.Shots.Shot;
import com.meunicorn.fancy2u.R;
import com.squareup.picasso.Picasso;

public class DetailActivity extends AppCompatActivity {
    ImageView shotIv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        Intent intent=getIntent();
        Shot shot=intent.getParcelableExtra("shot");
        toolbar.setTitle(shot.getTitle());
        initView();
        Log.i("DETAIL", "onCreate: "+shot.toString());
//        Picasso.with(this).load(shot.getImages().getNormal())
//                .into(shotIv);
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    private void initView() {
        shotIv= (ImageView) findViewById(R.id.iv_detail_shot);
    }
}
