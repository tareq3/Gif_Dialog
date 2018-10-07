package com.mti.gif_dialog;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.mti.gifdialog.GifDialog;
import com.mti.gifdialog.GifDialogListener;

public class MainActivity extends AppCompatActivity {

    private GifDialog gifDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Initializing Dialog
      gifDialog=   new GifDialog.Builder(this)
                .setTitle("Granny eating chocolate dialog box")
                .setMessage("This is a granny eating chocolate dialog box. This library is used to help you easily create fancy gify dialog.")

                .setTitleTextColor("#FF4081")
                 .setMessageTextColor("#F57F17")

              .setPositiveBtnText("pos")//iF WE NEED TO hIDE ANY BUTTON JUST DON'T ADD THIS LINE , NO TEXT MEANS NO BUTTON
              .setPositiveBtnBackground("#FF4081")

              .setNegativeBtnText("cancel")
              .setNegativeBtnBackground("#FFA9A7A8")


              .setOkBtnText("OK")
              .setOkBtnBackground("#FFA9A7A8")

                .setGifResource(R.drawable.gif_dialog_gif1)   //Pass your Gif here


                .isCancellable(false)


                .OnPositiveClicked(new GifDialogListener() {
                    @Override
                    public void onClick() {
                        Toast.makeText(MainActivity.this,"Done",Toast.LENGTH_SHORT).show();
                    }
                })
                .OnNegativeClicked(new GifDialogListener() {
                    @Override
                    public void onClick() {
                        Toast.makeText(MainActivity.this,"Cancel",Toast.LENGTH_SHORT).show();

                    }
                })
              .OnOkClicked(new GifDialogListener() {
                  @Override
                  public void onClick() {
                      Toast.makeText(MainActivity.this,"OK",Toast.LENGTH_SHORT).show();
                  }
              })
                .build();

     //Showing Dialog
     gifDialog.show();

     //Dismissing dialog
        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                //Do something after 100ms
                gifDialog.dismiss();
            }
        }, 9000);
    }
}
