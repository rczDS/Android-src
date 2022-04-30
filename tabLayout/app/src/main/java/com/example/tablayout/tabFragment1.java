package com.example.tablayout;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentResultListener;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.LinkedList;



public class tabFragment1 extends Fragment {
    private static final String LOG_TAG = tabFragment1.class.getSimpleName();

    private final LinkedList<String> my_trendList = new LinkedList<>();
    private RecyclerView my_recyclerView;
    private TrendListAdapter my_adapter;

//    private static final String REPLY_TITLE = "";
//    private static final String REPLY_CONTENT = "";

    public tabFragment1(){}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View viewContent =  inflater.inflate(R.layout.tab_fragment1, container, false);
        FloatingActionButton fab = viewContent.findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                int trendListSize = my_trendList.size();
                for (int i = trendListSize; i < trendListSize + 10; i++ ){
                    my_trendList.addLast("New Trend " + i);
                }
                my_recyclerView.getAdapter().notifyItemInserted(trendListSize);
                my_recyclerView.smoothScrollToPosition(trendListSize);
            }
        });

        for (int i = 0; i<20; i++ ){
            my_trendList.addLast("Trend " + i);
        }

        my_recyclerView = viewContent.findViewById(R.id.recyclerview);
        my_adapter = new TrendListAdapter(getContext(), my_trendList);
        my_recyclerView.setAdapter(my_adapter);
        my_recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        ListViewModel my_listViewModel = new ViewModelProvider(requireActivity()).get(ListViewModel.class);
        my_listViewModel.getTrend().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(String s) {
                my_trendList.addFirst("Trend " + s);
            }
        });

//        getParentFragmentManager().setFragmentResultListener("resultkey", this, new FragmentResultListener() {
//            @Override
//            public void onFragmentResult(@NonNull String requestKey, @NonNull Bundle bundle) {
//                Log.d(LOG_TAG, "clicked button in page 2. ");
//                String reply_title = bundle.getString("title");
//                String reply_content = bundle.getString("content");
//                my_trendList.addFirst(reply_title + " " + reply_content);
//            }
//        });
//        try{
//            String reply_title = getArguments().getString("title");
//            String reply_content = getArguments().getString("content");
//            if (reply_title != null && reply_content != null) {
//                Log.d(LOG_TAG, "get message. " + reply_title + reply_content);
//                my_trendList.addFirst(reply_title + " " + reply_content);
//            }
//        }
//        catch (Exception e) {
//            Log.d(LOG_TAG, e.getMessage());
//        }

        return viewContent;
    }


}
