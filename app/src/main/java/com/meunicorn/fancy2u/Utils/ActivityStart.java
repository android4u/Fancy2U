package com.meunicorn.fancy2u.Utils;

import android.app.Activity;
import android.content.Intent;

import com.meunicorn.fancy2u.Bean.Shots.Shot;
import com.meunicorn.fancy2u.UI.Activivty.DetailActivity;
import com.meunicorn.fancy2u.UI.Activivty.LoginActivity;
import com.meunicorn.fancy2u.UI.Activivty.MainActivity;

/**
 * Created by Fancy on 2016/3/30.
 */
public class ActivityStart {
    public static void toLogin(Activity activity){
        activity.startActivity(new Intent(activity, LoginActivity.class));
    }
    public static void toDetail(Activity activity,Shot shot){
        Intent intent=new Intent(activity,DetailActivity.class);
        intent.putExtra("shot",shot);
        activity.startActivity(intent);
    }
}
