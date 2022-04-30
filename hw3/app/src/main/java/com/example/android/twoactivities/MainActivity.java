package com.example.android.twoactivities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;


public class MainActivity extends AppCompatActivity {
    private static final String LOG_TAG = MainActivity.class.getSimpleName();

    public static final String EXTRA_MESSAGE
            = "com.example.android.twoactivities.extra.MESSAGE";
    
    public static final int TEXT_REQUEST = 1;

    private Button mButton;
    private Button mButton2;

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(LOG_TAG, "onStart");
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("reply_text", mButton.getText().toString());
        outState.putString("reply_text2", mButton2.getText().toString());
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.d(LOG_TAG, "-------");
        Log.d(LOG_TAG, "onCreate");

        mButton = findViewById(R.id.button_main);
        mButton2 = findViewById(R.id.button);

        if (savedInstanceState != null) {
            mButton.setText(savedInstanceState.getString("reply_text"));
            mButton2.setText(savedInstanceState.getString("reply2_text"));
        }
    }

    public void launchSecondActivity(View view) {
        Log.d(LOG_TAG, "Button clicked!");
        Intent intent = new Intent(this, SecondActivity.class);
        String message = mButton.getText().toString();
        intent.putExtra(EXTRA_MESSAGE, message);
        intent.putExtra("whichButton", 1);
        startActivityForResult(intent, TEXT_REQUEST);
    }

    public void launchSecondActivity2(View view) {
        Log.d(LOG_TAG, "Button2 clicked!");
        Intent intent = new Intent(this, SecondActivity.class);
        String message = mButton2.getText().toString();
        intent.putExtra(EXTRA_MESSAGE, message);
        intent.putExtra("whichButton", 2);
        startActivityForResult(intent, TEXT_REQUEST);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == TEXT_REQUEST) {
            if (resultCode == RESULT_OK) {
                String reply = data.getStringExtra(SecondActivity.EXTRA_REPLY);

                int whichButton = data.getIntExtra("replyButton", 0);

                if (whichButton == 1)
                    mButton.setText(reply);
                else
                    mButton2.setText(reply);

            }
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(LOG_TAG, "onPause");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(LOG_TAG, "onRestart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(LOG_TAG, "onResume");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(LOG_TAG, "onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(LOG_TAG, "onDestroy");
    }
}
