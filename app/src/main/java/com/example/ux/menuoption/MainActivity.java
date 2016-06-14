package com.example.ux.menuoption;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView=(TextView)findViewById(R.id.textview1);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
       getMenuInflater().inflate(R.menu.textcolor,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId())
        {
            case R.id.Red:
                textView.setTextColor(Color.parseColor("#ff0000"));
                return true;
            case R.id.Greed:
                textView.setTextColor(Color.parseColor("#60fc00"));
                return true;
            case R.id.Blue:
                textView.setTextColor(Color.parseColor("#6038f8"));
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }

    }
}
