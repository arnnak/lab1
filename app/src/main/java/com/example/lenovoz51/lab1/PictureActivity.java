package com.example.lenovoz51.lab1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class PictureActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_picture);

        ImageView paveikslelis = (ImageView) findViewById(R.id.imageView);
        TextView pavadinimas = (TextView) findViewById(R.id.paveiksleleio_pavadinimas);
        TextView aprasymas = (TextView) findViewById(R.id.paveikslelio_aprasymas);

        paveikslelis.setImageResource(R.drawable.copyright);
        pavadinimas.setText("Copyright search");
        aprasymas.setText("Siame paveikslelyje vaizduojama autoriniu teisiu svarba interneto pasaulyje");
    }
}
