package com.example.lenovoz51.lab1;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import org.xml.sax.helpers.AttributeListImpl;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Lenovo Z51 on 2018-09-23.
 */

public class SecondActivity extends AppCompatActivity {

    private ListView mylist;
    private ListAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.secondactivitydesign);

        mylist = (ListView) findViewById(R.id.listView);
        List<ListItem> items = new ArrayList<>();
        Intent intent = getIntent();
        if(intent.getBooleanExtra("flag",true)){
            Bundle bundle = intent.getExtras();
            items = (List<ListItem>) bundle.getSerializable("list");
        }
        else{
            items.add(new ListItem("Mathematics",R.drawable.ic_3d_rotation_black_24dp,"Mathematics is the study of topics such as quantity structure, space and change."));
            items.add(new ListItem("Physics", R.drawable.ic_announcement_black_24dp, "Physics is the natural science that involves the study of matter and its motion through space and time along with related concepts such as energy and forme"));
            items.add(new ListItem("Chemistry",R.drawable.ic_access_alarm_black_24dp,"Chemistry is a branch of physical science thet studies the composition, structure, properties and change of matter."));
            items.add(new ListItem("Informatics", R.drawable.ic_account_box_black_24dp, "Informatics is the science of informatic and computer information systems."));
            items.add(new ListItem("Geography", R.drawable.ic_accessibility_black_24dp,"geography is a field of science devoted to the study of the lands, the features, the inhabitant, and the phenomena of Earth"));
        }
        adapter = new ListAdapter(this,items);
        mylist.setAdapter(adapter);
    }


}
