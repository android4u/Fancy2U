package com.meunicorn.fancy2u.UI.Fragment;

import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.meunicorn.fancy2u.Bean.Shots.Images;
import com.meunicorn.fancy2u.Bean.Shots.Shot;
import com.meunicorn.fancy2u.Bean.Shots.User;
import com.meunicorn.fancy2u.R;
import com.meunicorn.fancy2u.Util.GsonRequest;

import org.json.JSONArray;
import org.json.JSONException;

import java.util.ArrayList;
import java.util.List;

/**
 * A fragment representing a list of Items.
 * <p/>
 * Activities containing this fragment MUST implement the {@link OnListFragmentInteractionListener}
 * interface.
 */
public class ShotFragment extends Fragment {
    List<Shot> shotList=new ArrayList<>();

    // TODO: Customize parameter argument names
    private static final String ARG_COLUMN_COUNT = "column-count";
    // TODO: Customize parameters
    private int mColumnCount = 1;
    private OnListFragmentInteractionListener mListener;

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public ShotFragment() {
    }

    // TODO: Customize parameter initialization
    @SuppressWarnings("unused")
    public static ShotFragment newInstance(int columnCount) {
        ShotFragment fragment = new ShotFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_COLUMN_COUNT, columnCount);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null) {
            mColumnCount = getArguments().getInt(ARG_COLUMN_COUNT);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_shots_list, container, false);
        JsonArrayRequest jsonArrayRequest=new JsonArrayRequest("https://api.dribbble.com/v1/shots?access_token="+ getResources().getString(R.string.dribbble_api_key),
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        for (int i = 0; i < response.length(); i++) {
                            Shot shot=new Shot();
                            try {
                                shot.setTitle(response.getJSONObject(i).getString("title"));
                                shot.setDescription(response.getJSONObject(i).getString("description"));
                                shot.setViewsCount(response.getJSONObject(i).getInt("views_count"));
                                shot.setLikesCount(response.getJSONObject(i).getInt("likes_count"));
                                shot.setCommentsCount(response.getJSONObject(i).getInt("comments_count"));
                                User user=new User();
                                user.setName(response.getJSONObject(i).getJSONObject("user").getString("name"));
                                shot.setUser(user);
                                Images images=new Images();
                                images.setNormal(response.getJSONObject(i).getJSONObject("images").getString("normal"));
                                shot.setImages(images);
                                shotList.add(shot);
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }

                        // Set the adapter
                        if (view instanceof RecyclerView) {
                            Context context = view.getContext();
                            RecyclerView recyclerView = (RecyclerView) view;
                            if (mColumnCount <= 1) {
                                recyclerView.setLayoutManager(new LinearLayoutManager(context));
                            } else {
                                recyclerView.setLayoutManager(new GridLayoutManager(context, mColumnCount));
                            }
                            recyclerView.setAdapter(new MyShotsRecyclerViewAdapter(getContext(),shotList, mListener));
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        Volley.newRequestQueue(getContext()).add(jsonArrayRequest);

        return view;
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnListFragmentInteractionListener) {
            mListener = (OnListFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnListFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p/>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnListFragmentInteractionListener {
        // TODO: Update argument type and name
        void onListFragmentInteraction(Shot item);
    }
}
