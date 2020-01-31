package com.example.myapplication;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.provider.MediaStore;

public class Camera extends AppCompatActivity{
    private static int VIDEO_CAPTURE = 101;

    public void video()
    {
        Intent videoIntent  = new Intent(MediaStore.ACTION_VIDEO_CAPTURE);
        if(videoIntent.resolveActivity(getPackageManager()) != null)
        {
            startActivityForResult(videoIntent,VIDEO_CAPTURE);
        }
    }
}
