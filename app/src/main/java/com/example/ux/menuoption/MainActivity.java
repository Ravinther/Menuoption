package com.example.ux.menuoption;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
TextView textView;
    ListView lst;
    String[] contacts={"Ravi","Kevin","Arun","Gokul"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView=(TextView)findViewById(R.id.textview1);
        lst=(ListView)findViewById(R.id.lstview1);
        ArrayAdapter<String> adapter=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,contacts);
        lst.setAdapter(adapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
       getMenuInflater().inflate(R.menu.callsms,menu);
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
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        menu.setHeaderTitle("Call And Sms Icon");
        menu.add(0, v.getId(), 0, "Call");
        menu.add(0,v.getId(),0,"Sms");
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        if (item.getTitle()=="Call") {
            call();
        }
        else if(item.getTitle()=="Sms")
        {
            sms();
        }
        else
        {
            return false;
        }

        return true;
    }
    public void  call()
    {
        try {
            Intent intentcall = new Intent(Intent.ACTION_CALL);
            intentcall.setData(Uri.parse("tel:" + "9751410036"));
            startActivity(intentcall);
        }
        catch (ActivityNotFoundException ex)
        {
        }
    }
    public void sms()
    {
        try
        {
            SmsManager smsManager=SmsManager.getDefault();
            smsManager.sendTextMessage("+919751410036",null,"Please Call me",null,null);
            Toast.makeText(getBaseContext(),"Sms Sent",Toast.LENGTH_LONG).show();
        }
        catch (Exception e)
        {
            Toast.makeText(getApplicationContext(), "SMS faild, please try again.", Toast.LENGTH_LONG).show();
            e.printStackTrace();
        }
    }
}
