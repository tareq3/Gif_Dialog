# Gif_Dialog
## it's a lib to show dialog for everthing

```
allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
  ```
  ```
  dependencies {
	        implementation 'com.github.tareq3:Gif_Dialog:Tag'
	}
  ```
  
  ## Initializing
  
  ```
        //Initializing Dialog
     final GifDialog gifDialog=   new GifDialog.Builder(this)
                .setTitle("Granny eating chocolate dialog box")
                .setMessage("This is a granny eating chocolate dialog box. This library is used to help you easily create fancy gify dialog.")
                .setNegativeBtnText("Cancel")
                .setPositiveBtnBackground("#FF4081")
                .setPositiveBtnText("Ok")
                .setNegativeBtnBackground("#FFA9A7A8")
                .setGifResource(R.drawable.gif_dialog_gif1)   //Pass your Gif here
                .isCancellable(false)
                .OnPositiveClicked(new GifDialogListener() {
                    @Override
                    public void onClick() {
                        Toast.makeText(MainActivity.this,"Ok",Toast.LENGTH_SHORT).show();
                    }
                })
                .OnNegativeClicked(new GifDialogListener() {
                    @Override
                    public void onClick() {
                        Toast.makeText(MainActivity.this,"Cancel",Toast.LENGTH_SHORT).show();
                    }
                })
                .build();
   ```
   
  ## Showing Diaog
  ```
   //Showing Dialog
     gifDialog.show();
  ```
  
  ## Dismissing Dialog
  
  ```
    //Dismissing dialog Note : handler is not mandatory
        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                //Do something after 9000ms
                gifDialog.dismiss();
            }
        }, 9000);
    }
  ```
