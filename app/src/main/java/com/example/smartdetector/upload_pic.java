package com.example.smartdetector;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.content.ContentValues;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class upload_pic extends AppCompatActivity {

    private static final int PERMISSION_CODE = 1000;
    private static final int IMAGE_CAPTURE_CODE = 1001;
    private static final int PERMISSION_CODE_1 =1002;
    private static final int IMAGE_CAPTURE_CODE_1 = 1003;
    private ImageView imageViewBefore;
    private ImageView imageViewAfter;
    private Button button_before;
    private Button button_after;
    private Button button_submit;

    Uri image_uri_1;
    Uri image_uri_2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_upload_pic);

        imageViewBefore = (ImageView) findViewById(R.id.before_imageview);
        imageViewAfter = (ImageView) findViewById(R.id.after_imageview);

        button_before = (Button) findViewById(R.id.captureimage_before);
        button_after = (Button) findViewById(R.id.captureimage_after);
        button_submit = (Button) findViewById(R.id.submit);

        button_before.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M)
                {
                    if (checkSelfPermission(Manifest.permission.CAMERA) == PackageManager.PERMISSION_DENIED ||
                            checkSelfPermission(Manifest.permission.WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_DENIED)
                    {
                        String [] permission = {Manifest.permission.CAMERA, Manifest.permission.WRITE_EXTERNAL_STORAGE};

                        requestPermissions(permission, PERMISSION_CODE);
                    }
                    else
                    {
                        activateCamera1();
                    }
                }
                else
                {
                    activateCamera1();
                }
            }
        });

        button_after.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.M)
                {
                    if (checkSelfPermission(Manifest.permission.CAMERA) == PackageManager.PERMISSION_DENIED
                            || checkSelfPermission(Manifest.permission.WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_DENIED)
                    {
                        String [] permission1 = {Manifest.permission.CAMERA, Manifest.permission.WRITE_EXTERNAL_STORAGE};

                        requestPermissions(permission1, PERMISSION_CODE_1);
                    }
                    else
                    {
                        activateCamera2();
                    }
                }
                else
                {
                    activateCamera2();
                }
            }
        });

        button_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                activity_home_screen();
            }
        });
    }
    private void activateCamera1()
    {
        ContentValues values = new ContentValues();
        values.put(MediaStore.Images.Media.TITLE, "Before's Click");
        values.put(MediaStore.Images.Media.DESCRIPTION, "From the Camera 1");
        image_uri_1 = getContentResolver().insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, values);

        Intent intent_camera = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        intent_camera.putExtra(MediaStore.EXTRA_OUTPUT, image_uri_1);
        startActivityForResult(intent_camera, IMAGE_CAPTURE_CODE);
    }

    private void activateCamera2()
    {
        ContentValues values1 = new ContentValues();
        values1.put(MediaStore.Images.Media.TITLE, "After's Click");
        values1.put(MediaStore.Images.Media.DESCRIPTION, "From the Camera 2");
        image_uri_2 = getContentResolver().insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, values1);

        Intent intent_camera_1 = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        intent_camera_1.putExtra(MediaStore.EXTRA_OUTPUT, image_uri_2);
        startActivityForResult(intent_camera_1, IMAGE_CAPTURE_CODE_1);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults)
    {
        switch (requestCode)
        {
            case PERMISSION_CODE:
            {
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED)
                {
                    activateCamera1();
                }
                else
                {
                    Toast.makeText(this,"Permission Denied", Toast.LENGTH_SHORT).show();
                }
            }
            case PERMISSION_CODE_1:
            {
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED)
                {
                    activateCamera2();
                }
                else
                {
                    Toast.makeText(this,"Permission Denied", Toast.LENGTH_SHORT).show();
                }
            }
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data)
    {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK)
        {
            imageViewBefore.setImageURI(image_uri_1);
        }
        if (resultCode == RESULT_OK)
        {
            imageViewAfter.setImageURI(image_uri_2);
        }
    }

    public void activity_home_screen()
    {
        Intent intent_submit = new Intent(this,home_screen.class);
        startActivity(intent_submit);
        Toast.makeText(this, "Issue escalated to admin",Toast.LENGTH_LONG).show();
    }
}