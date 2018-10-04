package com.example.lenovoz51.lab1;

import android.content.Context;
import android.content.Intent;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private Button button;
    private TextView textView;
    private Button secondActivityButton;
    private Context context = this;
    private List<ListItem> items = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //List<ListItem> items = new ArrayList<>();
        //button = (Button) findViewById(R.id.button);
        textView = (TextView) findViewById(R.id.textView);
        secondActivityButton = (Button) findViewById(R.id.secondActivityButton);

        //button.setOnClickListener(buttonClick);
        secondActivityButton.setOnClickListener(startSecondActivity);
        secondActivityButton.setOnLongClickListener(startSecondActivityLong);
    }

    /*View.OnClickListener buttonClick = new View.OnClickListener(){
        @Override
        public void onClick(View v){
            textView.setText(textView.getText()+"\n"+"Next line");
        }
    };*/

    View.OnClickListener startSecondActivity = new View.OnClickListener(){
        @Override
        public void onClick(View v){
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
        intent.putParcelableArrayListExtra("list", (ArrayList<? extends Parcelable>) items);
        context.startActivity(intent);
    }
}
