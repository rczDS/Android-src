package com.example.tablayout;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;


public class Fragment2 extends Fragment {
    private static final String LOG_TAG = Fragment2.class.getSimpleName();

    private static final String REPLY_TITLE = "";
    private static final String REPLY_CONTENT = "";

    private EditText my_reply_title;
    private EditText my_reply_content;
    private Button my_button;

    private ListViewModel my_listViewModel;

    public Fragment2(){

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View viewContent = inflater.inflate(R.layout.fragment2, container, false);

        my_reply_title = viewContent.findViewById(R.id.input_title);
        my_reply_content = viewContent.findViewById(R.id.input_content);
        my_button = viewContent.findViewById(R.id.new_trend);

        my_listViewModel = new ViewModelProvider(requireActivity()).get(ListViewModel.class);

        my_button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Log.d(LOG_TAG, "clicked button in page 2. ");
//                Bundle result = new Bundle();
//                Intent intent = new Intent(getActivity().getBaseContext(), MainActivity.class);
                String reply_title = my_reply_title.getText().toString();
                String reply_content = my_reply_content.getText().toString();
//                intent.putExtra("title", my_reply_title.getText().toString());
//                intent.putExtra("content", my_reply_content.getText().toString());
                Log.d(LOG_TAG, "sent message. " + reply_title + reply_content);
                my_listViewModel.setTrend(reply_title + " " + reply_content);
//                getActivity().startActivity(intent);
//                result.putString("title", my_reply_title.getText().toString());
//                result.putString("content", my_reply_content.getText().toString());
//                getChildFragmentManager().setFragmentResult("requestkey", result);


            }
        });

        return  viewContent;
    }

//    @OnClick(R.id.new_trend)
//    public void onApplyButtonClick(View view){
//        Log.d(LOG_TAG, "clicked button in page 2. ");
//        String reply_title = my_reply_title.getText().toString();
//        String reply_content = my_reply_content.getText().toString();
//
//        Intent replyIntent = new Intent();
//        replyIntent.putExtra(REPLY_TITLE, reply_title);
//        replyIntent.putExtra(REPLY_CONTENT, reply_content);
//        getActivity().setResult(Activity.RESULT_OK, replyIntent);
//        getActivity().finish();
//    }
}
