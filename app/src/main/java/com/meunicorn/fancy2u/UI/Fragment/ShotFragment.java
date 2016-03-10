package com.meunicorn.fancy2u.UI.Fragment;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.Parcelable;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.meunicorn.fancy2u.API.ShotsApi;
import com.meunicorn.fancy2u.Bean.Shots.Shot;
import com.meunicorn.fancy2u.R;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * A fragment representing a list of Items.
 * <p/>
 * Activities containing this fragment MUST implement the {@link OnListFragmentInteractionListener}
 * interface.
 */
public class ShotFragment extends Fragment {
    List<Shot> shotList = new ArrayList<>();
    SwipeRefreshLayout swipeRefresh;

    // TODO: Customize parameter argument names
    private static final String ARG_COLUMN_COUNT = "column-count";
    // TODO: Customize parameters
    private int mColumnCount = 1;
    private String orderType="popularity";//default order
    private OnListFragmentInteractionListener mListener;
    private int page = 1;
    MyShotsRecyclerViewAdapter adapter;
    static int refreshFirstVisibleItem, refreshVisibleItemCount, refreshTotalItemCount;
    private int previousTotal = 0; // The total number of items in the dataset after the last load
    private boolean loading = true; // True if we are still waiting for the last set of data to load.
    private int visibleThreshold = 1; // The minimum amount of items to have below your current scroll position before loading more.
    int firstVisibleItem, visibleItemCount, totalItemCount;
    RecyclerView recyclerView;

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public ShotFragment() {
    }

    // TODO: Customize parameter initialization
    @SuppressWarnings("unused")
    public static ShotFragment newInstance(String columnCount) {
        ShotFragment fragment = new ShotFragment();
        Bundle args = new Bundle();
        args.putString("type",columnCount);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null) {
            orderType = getArguments().getString("type");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_shots_list, container, false);
        swipeRefresh= (SwipeRefreshLayout) view.findViewById(R.id.srl_shots_refresh);
        adapter = new MyShotsRecyclerViewAdapter(getContext(), shotList, mListener);
        // Set the adapter

        recyclerView = (RecyclerView) view.findViewById(R.id.rv_shotslist_shot);
        recyclerViewMethod(recyclerView);
        recyclerView.setAdapter(adapter);
        swipeRefreshMethod(swipeRefresh);
        Log.i("TYPE", "onCreateView: "+orderType);
        new Thread(runnable).start();
        return view;
    }

    private void swipeRefreshMethod(final SwipeRefreshLayout swipeRefresh) {
        // TODO: 2016/3/2 add refresh
        swipeRefresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                // TODO: 2016/3/2 finish refresh
                swipeRefresh.setRefreshing(false);
                Snackbar.make(recyclerView,"刷新功能暂未完善",Snackbar.LENGTH_SHORT).show();
            }
        });
    }

    private void recyclerViewMethod(RecyclerView recyclerView) {
        final LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                visibleItemCount = recyclerView.getChildCount();
                totalItemCount = linearLayoutManager.getItemCount();
                firstVisibleItem = linearLayoutManager.findFirstVisibleItemPosition();

                if (loading) {
                    if (totalItemCount > previousTotal) {
                        loading = false;
                        previousTotal = totalItemCount;
                    }
                }
                if (!loading && (totalItemCount - visibleItemCount)
                        <= (firstVisibleItem + visibleThreshold)) {
                    page++;
                    new Thread(runnable).start();
                    loading = true;
                }
            }
        });
    }

    private List<Shot> getShots() throws IOException {
        String API="https://api.dribbble.com/v1/";
        Retrofit retrofit=new Retrofit.Builder().baseUrl(API).addConverterFactory(GsonConverterFactory.create()).build();
        ShotsApi shotsApi=retrofit.create(ShotsApi.class);
        Call<List<Shot>> shot=shotsApi.getShotList();
        return shot.execute().body();
    }
    Runnable runnable=new Runnable() {
        @Override
        public void run() {
            Bundle bundle=new Bundle();
            Message message=new Message();
            try {
                bundle.putParcelableArrayList("shots", (ArrayList<? extends Parcelable>) getShots());
                message.setData(bundle);
                handler.sendMessage(message);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    };

    Handler handler=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            Bundle data=msg.getData();
            List<Shot> shots=data.getParcelableArrayList("shots");
            Log.i("SHOTS", "getShots: "+data.size());
            adapter=new MyShotsRecyclerViewAdapter(getContext(),shots,mListener);
        }
    };


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
