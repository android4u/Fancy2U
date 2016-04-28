package com.meunicorn.fancy2u.Utils;

import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.util.Pair;
import android.view.View;

import com.meunicorn.fancy2u.Bean.Shots.Shot;
import com.meunicorn.fancy2u.R;
import com.meunicorn.fancy2u.UI.Activivty.DetailActivity;
import com.meunicorn.fancy2u.UI.Activivty.LoginActivity;
import com.meunicorn.fancy2u.UI.Activivty.SearchShotActivity;

/**
 * Created by Fancy on 2016/3/30.
 */
public class ActivityStart {
    public static void toLogin(Activity activity) {
        activity.startActivity(new Intent(activity, LoginActivity.class));
    }

    public static void toDetail(Activity activity, Shot shot) {
        Intent intent = new Intent(activity, DetailActivity.class);
        intent.putExtra("shot", shot);
        View image = activity.findViewById(R.id.iv_shots_pic);
        View title = activity.findViewById(R.id.tv_shots_title);
        View author = activity.findViewById(R.id.tv_shots_designer);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
            activity.startActivity(intent, ActivityOptionsCompat.makeSceneTransitionAnimation(activity,
                    Pair.create(image, "transition_shot")
//                    Pair.create(title,"transition_title"),
//                    Pair.create(author,"transition_designer")
            ).toBundle());
        }
    }

    public static void toSearchShot(Activity activity) {
        activity.startActivity(new Intent(activity, SearchShotActivity.class));
    }
}
