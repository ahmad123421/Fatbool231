package com.example.hp1.fatbool;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
Button bt1,bt2,bt3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bt1=(Button)findViewById(R.id.btTeams);
        bt1.setOnClickListener(this);
        bt2=(Button)findViewById(R.id.btHighscore);
        bt2.setOnClickListener(this);
        bt3=(Button)findViewById(R.id.btPictures);
        bt3.setOnClickListener(this);



    }
    @Override
    public void onClick(View v)
    {
        Intent i = new Intent(this,Teams2.class);
        Intent k= new Intent(this,Pictures.class);
if(v==bt1){
startActivity(i);
}
        if(v==bt3){
            startActivity(k);
        }



    }
}
