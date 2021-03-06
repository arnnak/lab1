package com.example.lenovoz51.lab1;

import android.content.Context;
import android.content.Intent;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private Button button;
    private TextView textView;
    private Button secondActivityButton;
    private Context context = this;
    private List<ListItem> items, nauji;
    private EditText pavadinimas;
    private EditText aprasymas;
    private Button prideti;
    private Button paveikslelis;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        items = new ArrayList<>();
        nauji = new ArrayList<>();
        //button = (Button) findViewById(R.id.button);
        textView = (TextView) findViewById(R.id.textView);
        pavadinimas = (EditText) findViewById(R.id.pavadinimas);
        aprasymas = (EditText) findViewById(R.id.aprasymas);
        prideti = (Button) findViewById(R.id.prideti);
        prideti.setOnClickListener(pridetiClick);
        paveikslelis = (Button) findViewById(R.id.paveikslelio_activity);
        secondActivityButton = (Button) findViewById(R.id.secondActivityButton);
        //button.setOnClickListener(buttonClick);
        secondActivityButton.setOnClickListener(startSecondActivity);
        paveikslelis.setOnClickListener(paveikslelisClick);
        secondActivityButton.setOnLongClickListener(startSecondActivityLong);
    }

    /*View.OnClickListener buttonClick = new View.OnClickListener(){
        @Override
        public void onClick(View v){
            textView.setText(textView.getText()+"\n"+"Next line");
        }
    };*/

    View.OnClickListener pridetiClick = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            //items = new ArrayList<>();
            nauji.add(new ListItem(pavadinimas.getText().toString(),R.drawable.ic_3d_rotation_black_24dp,aprasymas.getText().toString()));
        }
    };

    View.OnClickListener paveikslelisClick = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(context, PictureActivity.class);
            context.startActivity(intent);
        }
    };

    View.OnClickListener startSecondActivity = new View.OnClickListener(){
        @Override
        public void onClick(View v){
            items = new ArrayList<>();
            for (int i=0; i<nauji.size(); i++) {
                items.add(nauji.get(i));
            }
            items.add(new ListItem("Jack",R.drawable.ic_3d_rotation_black_24dp,"Mathematics, Chemistry"));
            items.add(new ListItem("Jane",R.drawable.ic_announcement_black_24dp,"Physics, Informatics"));
            items.add(new ListItem("Bob",R.drawable.ic_access_alarm_black_24dp,"Mathematics, Informatics"));
            items.add(new ListItem("Clara",R.drawable.ic_account_box_black_24dp,"Geography, Chemistry"));
            items.add(new ListItem("Sam",R.drawable.ic_accessibility_black_24dp,"Mathematics, Physics"));
            items.add(new ListItem("Tom",R.drawable.ic_accessibility_black_24dp,"Chemistry, Physics"));
            items.add(new ListItem("Cynthia",R.drawable.ic_accessibility_black_24dp,"Informatics, Geography"));
            items.add(new ListItem("John",R.drawable.ic_accessibility_black_24dp,"Mathematics, Physics"));
            items.add(new ListItem("Ann",R.drawable.ic_accessibility_black_24dp,"Geography, Physics"));
            items.add(new ListItem("Peter",R.drawable.ic_accessibility_black_24dp,"Mathematics, Physics"));
            /*for (int i=0; i<nauji.size(); i++) {
                items.add(nauji.get(i));
            }*/
            runSecondActivity(true);
        }
    };

    View.OnLongClickListener startSecondActivityLong = new View.OnLongClickListener(){
        @Override
        public boolean onLongClick(View v){
            runSecondActivity(false);
            return true;
        }
    };

    private void runSecondActivity(boolean b) {
        Intent intent = new Intent(context, SecondActivity.class);
        intent.putExtra("flag",b);
        Bundle bundle = new Bundle();
        if(b){
            bundle.putSerializable("list", (Serializable) items);
        }
        else{
            nauji.add(items.get(0));
            bundle.putSerializable("list", (Serializable)nauji);
        }
        intent.putExtras(bundle);
        context.startActivity(intent);
    }
}
