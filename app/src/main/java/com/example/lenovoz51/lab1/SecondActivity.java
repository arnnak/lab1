package com.example.lenovoz51.lab1;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import org.xml.sax.helpers.AttributeListImpl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by Lenovo Z51 on 2018-09-23.
 */

public class SecondActivity extends AppCompatActivity {

    private ListView mylist;
    private Context context = this;
    private ListAdapter adapter;
    private Button rikiuoti, atrinkti;
    private List<ListItem> items;
    private EditText raide;
    private List<ListItem> atrinktasSarasas;
    private ListAdapter atrinkimui;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.secondactivitydesign);

        mylist = (ListView) findViewById(R.id.listView);
        rikiuoti = (Button) findViewById(R.id.rikiavimo);
        atrinkti = (Button) findViewById(R.id.atrinkimo);
        items = new ArrayList<>();
        atrinktasSarasas = new ArrayList<>();
        List<ListItem> nauji = new ArrayList<>();
        Intent intent = getIntent();
        if(intent.getBooleanExtra("flag",true)){
            Bundle bundle = intent.getExtras();
            items = (List<ListItem>) bundle.getSerializable("list");
            nauji = (List<ListItem>) bundle.getSerializable("nauji");
            if(nauji.size() != 0){
                for(int i = 0; i<nauji.size(); i++){
                    items.add(nauji.get(i));
                }
            }
        }
        else{
            Bundle bundle = intent.getExtras();
            items.add(new ListItem("Mathematics",R.drawable.ic_3d_rotation_black_24dp,"Mathematics is the study of topics such as quantity structure, space and change."));
            items.add(new ListItem("Physics", R.drawable.ic_announcement_black_24dp, "Physics is the natural science that involves the study of matter and its motion through space and time along with related concepts such as energy and forme"));
            items.add(new ListItem("Chemistry",R.drawable.ic_access_alarm_black_24dp,"Chemistry is a branch of physical science thet studies the composition, structure, properties and change of matter."));
            items.add(new ListItem("Informatics", R.drawable.ic_account_box_black_24dp, "Informatics is the science of informatic and computer information systems."));
            items.add(new ListItem("Geography", R.drawable.ic_accessibility_black_24dp,"geography is a field of science devoted to the study of the lands, the features, the inhabitant, and the phenomena of Earth"));
            nauji = (List<ListItem>) bundle.getSerializable("nauji");
            if(nauji.size() != 0){
                for(int i = 0; i<nauji.size(); i++){
                    items.add(nauji.get(i));
                }
            }
        }
        adapter = new ListAdapter(this,items);
        mylist.setAdapter(adapter);
        rikiuoti.setOnClickListener(rikiuoticlick);
        atrinkti.setOnClickListener(atrinkticlick);
    }

    View.OnClickListener rikiuoticlick = new View.OnClickListener(){
        @Override
        public void onClick(View v){
            Rikiuoti();
        }
    };

    View.OnClickListener atrinkticlick = new View.OnClickListener(){
        @Override
        public void onClick(View v){
            atrinkti();
            atrinkimui = new ListAdapter(context, atrinktasSarasas);
            mylist.setAdapter((atrinkimui));
        }
    };

    private void Rikiuoti (){
        Collections.sort(items, new Comparator<ListItem>() {
            @Override
            public int compare(ListItem listItem, ListItem t1) {
                return listItem.getTitle().compareTo(t1.getTitle());
            }
        });
        adapter.notifyDataSetChanged();
    }

    private void atrinkti(){
       char [] r = raide.getText().toString().toCharArray();
       for (int i = 0; i < items.size(); i++){
           char [] raides = items.get(i).getTitle().toCharArray();
           if (raides[0] == r[0]){
               atrinktasSarasas.add(items.get(i));
           }
       }
    }

}
