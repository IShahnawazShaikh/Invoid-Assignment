package com.example.piclab;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.widget.ImageView;
import android.widget.Toast;

public class UploadLibrary extends Activity {
    Activity activity;
    Uri imgUri;
    ImageView imageView;
    UploadLibrary(Activity activity){
       this.activity=activity;
    }
    public void test(Context context,String msg){
        Toast.makeText(context,msg,Toast.LENGTH_LONG).show();
    }


    public  Uri select(ImageView imageView){
        this.imageView=imageView;
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        activity.startActivityForResult(intent,100);

        return imgUri;
    }
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data)
    {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 100 && data!=null && data.getData()!=null) {
          imgUri=data.getData();
          imageView.setImageURI(imgUri);
        }
    }



}
