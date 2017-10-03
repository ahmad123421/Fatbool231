package com.example.hp1.fatbool;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, DialogInterface.OnClickListener {
    Button bt1, bt2, bt3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bt1 = (Button) findViewById(R.id.btTeams);
        bt1.setOnClickListener(this);
        bt2 = (Button) findViewById(R.id.btHighscore);
        bt2.setOnClickListener(this);
        bt3 = (Button) findViewById(R.id.btPictures);
        bt3.setOnClickListener(this);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menue, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.t1:
                Toast.makeText(getBaseContext(), "Hi", Toast.LENGTH_LONG).show();
                break;


        }

        return true;
    }

    public void onClick(View v) {
        Intent i = new Intent(this, Teams2.class);
        Intent k = new Intent(this, Pictures.class);
        Intent j = new Intent(this, Highscores.class);

        if (v == bt1) {
            startActivity(i);
        }
        if (v == bt3) {
            startActivity(k);
        }
        if (v == bt2) {
            startActivity(j);
        }


    }

    public void onBackPressed() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Are you sure you want to exit?")
                .setCancelable(false)
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        MainActivity.this.finish(); //
                    }
                })
                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                });
        AlertDialog alert = builder.create();
        alert.show();

    }


    @Override
    public void onClick(DialogInterface dialog, int which) {
        if (which == dialog.BUTTON_POSITIVE) {
            super.onBackPressed();
            dialog.cancel();
            if (which == dialog.BUTTON_NEGATIVE) {
                dialog.cancel();
            }
        }
    }
}