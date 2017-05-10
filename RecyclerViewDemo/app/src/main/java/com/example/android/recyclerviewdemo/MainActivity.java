package com.example.android.recyclerviewdemo;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    RecyclerView.Adapter adapter;
    RecyclerView.LayoutManager layoutManager;
    String[] F_name,D_name;
    int[] Img_Res={R.drawable.download1,R.drawable.download2,R.drawable.download3,R.drawable.download4,R.drawable.download5,R.drawable.download7};
ArrayList<Dataprovider> arrayList=new ArrayList<Dataprovider>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView=(RecyclerView)findViewById(R.id.recycler_view);
        F_name=getResources().getStringArray(R.array.filmname);
        D_name=getResources().getStringArray(R.array.dirname);
        int i=0;
        for(String name:F_name)
        {
            Dataprovider dataprovider=new Dataprovider(Img_Res[i],name,D_name[i]);
            arrayList.add(dataprovider);
            i++;
        }
adapter=new RecyclerAdapter(arrayList);
        recyclerView.setHasFixedSize(true);//improve the performance
        layoutManager=new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
    }

    public void dosomething(View view) {
        Intent i1 = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.google.com"));
        startActivity(i1);
    }
}
