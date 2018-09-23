package com.example.lenovoz51.lab1;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Button button;
    private TextView textView;
    private Button secondActivityButton;
    private Context context = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = (Button) findViewById(R.id.button);
        textView = (TextView) findViewById(R.id.textView);
        secondActivityButton = (Button) findViewById(R.id.secondActivityButton);

        button.setOnClickListener(buttonClick);
        secondActivityButton.setOnClickListener(startSecondActivity);
        secondActivityButton.setOnLongClickListener(startSecondActivityLong);
    }

    View.OnClickListener buttonClick = new View.OnClickListener(){
        @Override
        public void onClick(View v){
            textView.setText(textView.getText()+"\n"+"Next line");
        }
    };

    View.OnClickListener startSecondActivity = new View.OnClickListener(){
        @Override
        public void onClick(View v){
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
        context.startActivity(intent);
    }
}
