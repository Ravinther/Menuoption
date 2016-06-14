package com.example.ux.menuoption;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

/**
 * Created by Ravi on 6/14/2016.
 */
public class callsms extends Activity {
    ListView listView;
    String[] contacts={"Ravi","Kevin","Arun","Gokul"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout);
        listView=(ListView)findViewById(R.id.listview1);

        ArrayAdapter<String> adapter=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,contacts);
        listView.setAdapter(adapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.callsms, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.sms:
                Toast.makeText(getBaseContext(), "You are clicked sms", Toast.LENGTH_LONG).show();
                return true;
            case R.id.call:
                Toast.makeText(getBaseContext(), "You are clicked Call", Toast.LENGTH_LONG).show();
                return true;
     default:
            return super.onOptionsItemSelected(item);
        }
    }

    @Override
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
