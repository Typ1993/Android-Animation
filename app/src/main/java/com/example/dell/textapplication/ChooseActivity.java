package com.example.dell.textapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.dell.textapplication.rxjav.RxJavaTestActivity;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

@SuppressWarnings("ResourceType")
public class ChooseActivity extends AppCompatActivity {

    @BindView(R.id.listview)
    ListView listView;
    private List<String> list = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose);
        ButterKnife.bind(this);
        list.add("Animation");
        list.add("RxJava");
        ArrayAdapter arrayAdapter = new ArrayAdapter(this, R.layout.list_item_layout,list);
        listView.setAdapter(arrayAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position){
                    case 0:
                        Intent intent = new Intent(ChooseActivity.this,MainActivity.class);
                        startActivity(intent);
                        break;
                    case 1:
                        Intent intent1 = new Intent(ChooseActivity.this,RxJavaTestActivity.class);
                        startActivity(intent1);
                        break;
                }
            }
        });
    }
}
