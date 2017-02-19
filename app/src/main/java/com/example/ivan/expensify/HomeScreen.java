package com.example.ivan.expensify;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.io.File;


public class HomeScreen extends AppCompatActivity {
    Button button;
    Button button2;

    //ImageView imageView;
    static final int CAM_REQUEST = 1;
    File picture = getFile();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //final File file = getFile();

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);
        button = (Button) findViewById(R.id.button);
        //imageView = (ImageView)findViewById(R.id.image_view);
        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
            Intent camera_intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            camera_intent.putExtra(MediaStore.EXTRA_OUTPUT, Uri.fromFile(picture));
            startActivityForResult(camera_intent, CAM_REQUEST);
            sendImageToServer();
            }
        });
        button2 = (Button) findViewById(R.id.button3);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                launchListActivity();
            }
        });
    }

    private File getFile(){
        File picture = new File("sdcard/camera_app");
        if(!picture.exists()){
            picture.mkdir();
        }
        File image_file = new File(picture, "cam_image.jpg");
        return image_file;
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent date){
        String path = "sdcard/camera_app/cam_image.jpg";
    }

    private void launchListActivity(){
        Intent intent = new Intent(this, ListViewActivity.class);
        startActivity(intent);
    }

    private void sendImageToServer(){

    }



}

