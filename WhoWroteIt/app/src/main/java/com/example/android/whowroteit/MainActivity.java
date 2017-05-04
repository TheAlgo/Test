package com.example.android.whowroteit;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText editText;
    private TextView mTitleText;
    private TextView mAuthorText;
    private Button b1;
    private TextView t1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText=(EditText)findViewById(R.id.bookInput);
        t1=(TextView)findViewById(R.id.instructions);
        mTitleText=(TextView)findViewById(R.id.titleText);
        mAuthorText=(TextView)findViewById(R.id.authorText);
        b1=(Button)findViewById(R.id.searchButton);


    }

    public void searchBooks(View view) {
        String queryString=editText.getText().toString();
       // new FetchBook(mTitleText,mAuthorText).execute(queryString);
        InputMethodManager inputManager = (InputMethodManager)
                getSystemService(Context.INPUT_METHOD_SERVICE);
        inputManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(),
                InputMethodManager.HIDE_NOT_ALWAYS);
        ConnectivityManager connMgr = (ConnectivityManager)
                getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connMgr.getActiveNetworkInfo();
        if (networkInfo != null && networkInfo.isConnected() && queryString.length()!=0) {
            new FetchBook(mTitleText, mAuthorText).execute(queryString);
            mAuthorText.setText("");
            mTitleText.setText("Loading");
        }
        else {
            if (queryString.length() == 0) {
                mAuthorText.setText("");
                mTitleText.setText("Please enter a search term");
            } else {
                mAuthorText.setText("");
                mTitleText.setText("Please check your network connection and try again.");
            }
        }

    }
}
