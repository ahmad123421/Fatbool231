package com.example.hp1.fatbool;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.FileNotFoundException;

public class CameraActivity extends AppCompatActivity implements View.OnClickListener {
    Button bt1,bt2;
    ImageView Img4;
    Bitmap bitmap;

    static final int SELECT_IMAGE=1;
    static final int TAKE_IMAGE=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_camera);
        bt1 = (Button) findViewById(R.id.tkph);
        bt2=(Button) findViewById(R.id.tkgal);
        bt1.setOnClickListener(this);
        bt2.setOnClickListener(this);
        Img4 = (ImageView) findViewById(R.id.img2);


    }

    @Override
    public void onClick(View v)
    {
        //start another activirty and receive a result back in case the activity exisits.
      if(v==bt1){
          Intent i =new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
          startActivityForResult(i,TAKE_IMAGE);
      }else{
          Intent i=new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
          startActivityForResult(i, SELECT_IMAGE);
      }

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(requestCode== TAKE_IMAGE && resultCode== RESULT_OK){
            Bundle extra = data.getExtras();
            bitmap = (Bitmap) extra.get("data");
            Img4.setImageBitmap(bitmap);

        }
        else if(requestCode == SELECT_IMAGE && resultCode == RESULT_OK){
            Uri targetUri= data.getData();
            Toast.makeText(getApplicationContext(), targetUri.toString(), 1000).show();
            //textTargetUri.setText(targetUri.toString());
            Bitmap bitmap;
           try {
               bitmap= BitmapFactory.decodeStream(getContentResolver().openInputStream(targetUri));
               Img4.setImageBitmap(bitmap);
           } catch (FileNotFoundException e) {
               e.printStackTrace();
           }

        }

    }
}
