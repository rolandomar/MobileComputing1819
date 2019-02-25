package com.example.testapplication;

import android.os.Bundle;
import android.os.NetworkOnMainThreadException;
import android.os.StrictMode;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        if (android.os.Build.VERSION.SDK_INT > 9)
        {
            StrictMode.ThreadPolicy policy = new
                    StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
        }

//        try {
//
//            URL url = new URL("https://www.gutenberg.org/files/1342/1342-0.txt");
//
//            // read text returned by server
//            BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));
//
//            String line;
//            while ((line = in.readLine()) != null) {
//                System.out.println(line);
//            }
//            in.close();
//
//        }
//        catch (MalformedURLException e) {
//            System.out.println("Malformed URL: " + e.getMessage());
//        }
//        catch (NetworkOnMainThreadException e) {
//            System.out.println("Net Error: " + e.getMessage());
//        }
//        catch (IOException e) {
//            System.out.println("I/O Error: " + e.getMessage());
//        }
        TextView myAwesomeTextView = (TextView)findViewById(R.id.textView3);

        try {
            URL url = new URL("https://www.gutenberg.org/files/1342/1342-0.txt");
            URLConnection urlConnection = url.openConnection();
            InputStream stream = urlConnection.getInputStream();
            BufferedReader in = new BufferedReader(new InputStreamReader(stream));
            String line;
            StringBuffer sb = new StringBuffer();
            while ((line = in.readLine()) != null) {
                //System.out.println(line);
                sb.append(line);
            }
            in.close();
            myAwesomeTextView.setText(sb.toString());
        }catch (IOException e) {
            System.out.println("******************************I/O Error: " + e.getMessage());
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
