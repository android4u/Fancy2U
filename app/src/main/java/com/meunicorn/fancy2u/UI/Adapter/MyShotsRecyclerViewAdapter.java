package com.meunicorn.fancy2u.UI.Adapter;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.meunicorn.fancy2u.Bean.Shots.Shot;
import com.meunicorn.fancy2u.R;
import com.meunicorn.fancy2u.UI.Fragment.ShotFragment;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;


public class MyShotsRecyclerViewAdapter extends RecyclerView.Adapter<MyShotsRecyclerViewAdapter.ViewHolder> {

    List<Shot> shotList = new ArrayList<>();
    private final ShotFragment.OnListFragmentInteractionListener mListener;
    Context mContext;

    public MyShotsRecyclerViewAdapter(Context context, List<Shot> shots, ShotFragment.OnListFragmentInteractionListener listener) {
        shotList = shots;
        mListener = listener;
        mContext = context;
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_shots, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        Shot item = shotList.get(position);
        holder.mItem = item;
        holder.titieTv.setText(item.getTitle());
        holder.designerTv.setText(item.getUser().getName());
        try {
            holder.descriptionTv.setVisibility(View.VISIBLE);
            holder.descriptionTv.setText(Html.fromHtml(item.getDescription()));
        }catch (Exception e){
            holder.descriptionTv.setVisibility(View.GONE);
        }
        holder.viewsTv.setText(item.getViewsCount().toString());
        holder.likeTv.setText(item.getLikesCount().toString());
        holder.commentTv.setText(item.getCommentsCount().toString());
        Picasso.with(mContext).load(shotList.get(position).getImages().getNormal()).into(holder.shotIv);
        holder.mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (null != mListener) {
                    // Notify the active callbacks interface (the activity, if the
                    // fragment is attached to one) that an item has been selected.
                    mListener.onListFragmentInteraction(holder.mItem);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return shotList.size();
    }

    public void refreshShots(List<Shot> shots) {
        this.shotList.clear();
        this.shotList.addAll(shots);
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final View mView;
        public CardView shotCv;
        public ImageView shotIv;
        public TextView titieTv;
        public TextView designerTv;
        public TextView descriptionTv;
        public TextView viewsTv;
        public TextView likeTv;
        public TextView commentTv;
        public Shot mItem;

        public ViewHolder(View view) {
            super(view);
            mView = view;
            shotCv = (CardView) view.findViewById(R.id.cv_shots_card);
            shotIv = (ImageView) view.findViewById(R.id.iv_shots_pic);
            titieTv = (TextView) view.findViewById(R.id.tv_shots_title);
            designerTv = (TextView) view.findViewById(R.id.tv_shots_designer);
            descriptionTv = (TextView) view.findViewById(R.id.tv_shots_description);
            viewsTv = (TextView) view.findViewById(R.id.tv_shots_views);
            likeTv = (TextView) view.findViewById(R.id.tv_shots_like);
            commentTv = (TextView) view.findViewById(R.id.tv_shots_comment);
        }

        @Override
        public String toString() {
            return super.toString() + " '" + titieTv.getText() + "'";
        }

    }
}
