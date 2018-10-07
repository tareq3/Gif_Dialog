/*
 * Created by Tareq Islam on 10/6/18 12:47 PM
 *
 *  Last modified 10/6/18 12:47 PM
 */

package com.mti.gifdialog;

import android.app.Activity;
import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.GradientDrawable;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import pl.droidsonroids.gif.GifImageView;

/***
 * Created by Tareq on 06,October,2018.
 */
public class GifDialog {
    private String title,message,positiveBtnText,okButtonText,negativeBtnText,pBtnColor,nBtnColor,oBtnColor,tTextColor,mTextColor;
    private Activity activity;
    private GifDialogListener pListener,nListener,oListener;
    private boolean cancel;

    int gifImageResource;
    public static Dialog mDialog;


    private GifDialog(Builder builder){
        this.title=builder.title;
        this.message=builder.message;
        this.activity=builder.activity;

        this.pListener=builder.pListener;
        this.nListener=builder.nListener;
        this.pBtnColor=builder.pBtnColor;
        this.nBtnColor=builder.nBtnColor;
        this.oBtnColor=builder.oBtnColor;
        this.tTextColor=builder.tTextColor;
        this.mTextColor=builder.mTextColor;
        this.positiveBtnText=builder.positiveBtnText;
        this.okButtonText=builder.okButtonText;
        this.negativeBtnText=builder.negativeBtnText;
        this.gifImageResource=builder.gifImageResource;
        this.cancel=builder.cancel;
    }

    public  void dismiss(){

        mDialog.dismiss();
    }

    public void show(){
        mDialog.show();
    }



    public static class Builder{
        private String title,message,positiveBtnText,okButtonText,negativeBtnText,pBtnColor,oBtnColor,nBtnColor,tTextColor,mTextColor;
        private Activity activity;
        private GifDialogListener pListener,nListener,oListener;
        private boolean cancel;
        int gifImageResource;

        public Builder(Activity activity){
            this.activity=activity;
        }
        public Builder setTitle(String title){
            this.title=title;
            return this;
        }


        public Builder setMessage(String message){
            this.message=message;
            return this;
        }

        public Builder setPositiveBtnText(String positiveBtnText){
            this.positiveBtnText=positiveBtnText;
            return this;
        }

        public Builder setOkBtnText(String okBtnText){
            this.okButtonText=okBtnText;
            return this;
        }


        public Builder setPositiveBtnBackground(String pBtnColor){
            this.pBtnColor=pBtnColor;
            return this;
        }


        public Builder setNegativeBtnText(String negativeBtnText){
            this.negativeBtnText=negativeBtnText;
            return this;
        }

        public Builder setNegativeBtnBackground(String nBtnColor){
            this.nBtnColor=nBtnColor;
            return this;
        }

        public Builder setOkBtnBackground(String oBtnColor){
            this.oBtnColor=oBtnColor;
            return this;
        }
        public Builder setTitleTextColor(String tTextColor){
            this.tTextColor=tTextColor;
            return this;
        }

        public Builder setMessageTextColor(String mTextColor){
            this.mTextColor=mTextColor;
            return this;
        }
        //set Positive listener
        public Builder OnPositiveClicked(GifDialogListener pListener){
            this.pListener=pListener;
            return this;
        }

        //set Positive listener
        public Builder OnOkClicked(GifDialogListener oListener){
            this.oListener=oListener;
            return this;
        }

        //set Negative listener
        public Builder OnNegativeClicked(GifDialogListener nListener){
            this.nListener=nListener;
            return this;
        }

        public Builder isCancellable(boolean cancel){
            this.cancel=cancel;
            return this;
        }
        public Builder setGifResource(int gifImageResource){
            this.gifImageResource=gifImageResource;
            return this;
        }


        public GifDialog build(){
            TextView message1,title1;
            ImageView iconImg;
            Button nBtn,pBtn,oBtn;
            GifImageView gifImageView;


            mDialog=new Dialog(activity);
            mDialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
            mDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
            mDialog.setCancelable(cancel);
            mDialog.setContentView(R.layout.gif_dialog);


            //getting resources
            title1= (TextView) mDialog.findViewById(R.id.title);
            message1=(TextView)mDialog.findViewById(R.id.message);
            nBtn=(Button)mDialog.findViewById(R.id.negativeBtn);
            pBtn=(Button)mDialog.findViewById(R.id.positiveBtn);
            oBtn=mDialog.findViewById(R.id.okBtn);

            gifImageView=mDialog.findViewById(R.id.gifImageView);
            gifImageView.setImageResource(gifImageResource);

            title1.setText(title);
            message1.setText(message);
            if(positiveBtnText!=null)
                pBtn.setText(positiveBtnText);
            else
                pBtn.setVisibility(View.GONE);

            if(okButtonText!=null)
                oBtn.setText(okButtonText);
            else
                oBtn.setVisibility(View.GONE);


            if(negativeBtnText!=null)
                nBtn.setText(negativeBtnText);
            else
                nBtn.setVisibility(View.GONE);

            if(message==null){
                message1.setVisibility(View.GONE);
            }
            if(title==null){
                title1.setVisibility(View.GONE);
            }

            if(tTextColor!=null){

               title1.setTextColor(Color.parseColor(tTextColor));
            }

            if(mTextColor!=null){

                message1.setTextColor(Color.parseColor(mTextColor));
            }


            if(pBtnColor!=null)
            { GradientDrawable bgShape = (GradientDrawable)pBtn.getBackground();
                bgShape.setColor(Color.parseColor(pBtnColor));
            }
            if(nBtnColor!=null)
            { GradientDrawable bgShape = (GradientDrawable)nBtn.getBackground();
                bgShape.setColor(Color.parseColor(nBtnColor));
            }

            if(oBtnColor!=null)
            { GradientDrawable bgShape = (GradientDrawable)oBtn.getBackground();
                bgShape.setColor(Color.parseColor(oBtnColor));
            }

            if(pListener!=null) {
                pBtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        pListener.onClick();
                        mDialog.dismiss();
                    }
                });
            }
            else{
                pBtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        mDialog.dismiss();
                    }

                });
            }


            if(oListener!=null) {
                oBtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        oListener.onClick();
                        mDialog.dismiss();
                    }
                });
            }
            else{
                oBtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        mDialog.dismiss();
                    }

                });
            }
                if (nListener != null) {

                    nBtn.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            nListener.onClick();

                            mDialog.dismiss();
                        }
                    });

                 }else{
                    nBtn.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {

                            mDialog.dismiss();
                        }
                    });
                }


           // mDialog.show();

            return new GifDialog(this);

        }
    }

}
