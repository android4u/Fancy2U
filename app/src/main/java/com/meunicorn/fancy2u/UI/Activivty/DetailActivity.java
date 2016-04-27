package com.meunicorn.fancy2u.UI.Activivty;

import android.content.Intent;
import android.graphics.Color;
import android.inputmethodservice.Keyboard;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.text.Html;
import android.transition.ChangeBounds;
import android.transition.ChangeImageTransform;
import android.transition.ChangeTransform;
import android.transition.Explode;
import android.transition.Fade;
import android.transition.Slide;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.meunicorn.fancy2u.API.DribbbleApi;
import com.meunicorn.fancy2u.Bean.Shots.Shot;
import com.meunicorn.fancy2u.R;
import com.meunicorn.fancy2u.Utils.DribbbleConstant;
import com.squareup.picasso.Picasso;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class DetailActivity extends AppCompatActivity {
    ImageView shotIv;
    CircleImageView userIconIv;
    TextView authorTv;
    Shot shot;
    FloatingActionButton fab;
    TextView viewsTv, likeTv, commentTv;
    TextView titleTv, descriptionTv;
    RecyclerView tagRv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {

//            ChangeImageTransform transition = new ChangeImageTransform();
//            transition.excludeTarget(R.id.imageView, true);
//            getWindow().setEnterTransition(transition);
//            getWindow().setReturnTransition(transition);
//        }
        setContentView(R.layout.activity_detail);
        initFirst();
        initView();
        initData();

    }

    private void initFirst() {
        Intent intent = getIntent();
        shot = intent.getExtras().getParcelable("shot");
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle(shot.getTitle());
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
    }

    private void initData() {
        Picasso.with(this).load(shot.getUser().getAvatarUrl()).into(userIconIv);
        Picasso.with(this).load(shot.getImages().getNormal()).into(shotIv);
        authorTv.setText(shot.getUser().getName());
        viewsTv.setText(shot.getViewsCount().toString());
        likeTv.setText(shot.getLikesCount().toString());
        commentTv.setText(shot.getCommentsCount().toString());
        titleTv.setText(shot.getTitle());
        try {
            descriptionTv.setVisibility(View.VISIBLE);
            descriptionTv.setText(Html.fromHtml(shot.getDescription()));
        } catch (Exception e) {
            descriptionTv.setVisibility(View.GONE);
        }

    }


    private void initView() {
        shotIv = (ImageView) findViewById(R.id.iv_detail_shot);
        userIconIv = (CircleImageView) findViewById(R.id.iv_detail_icon);
        authorTv = (TextView) findViewById(R.id.tv_detail_author);
        fab = (FloatingActionButton) findViewById(R.id.fab);
        viewsTv = (TextView) findViewById(R.id.tv_detail_views);
        likeTv = (TextView) findViewById(R.id.tv_detail_like);
        commentTv = (TextView) findViewById(R.id.tv_detail_comment);
        titleTv = (TextView) findViewById(R.id.tv_detail_title);
        descriptionTv = (TextView) findViewById(R.id.tv_detail_description);
        tagRv= (RecyclerView) findViewById(R.id.rv_detail_tag);
    }

}
