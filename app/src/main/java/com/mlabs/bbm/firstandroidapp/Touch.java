package com.mlabs.bbm.firstandroidapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

public class Touch extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_touch);

        final ImageView imgTouch = (ImageView) findViewById(R.id.imgTouch);
        final EditText txtXY1 = (EditText) findViewById(R.id.txtXY1);
        final EditText txtXY2 = (EditText) findViewById(R.id.txtXY2);
        final EditText txtXYd = (EditText) findViewById(R.id.txtXYd);
        final EditText txtMotion = (EditText) findViewById(R.id.txtMotion);
        final EditText txtQuadrant = (EditText) findViewById(R.id.txtQuadrant);


        imgTouch.setOnTouchListener(new View.OnTouchListener(){
            float iX,iY,fX,fY,dX,dY;
            String mess = "";
            String quad = "";

            @Override
            public boolean onTouch(View v, MotionEvent motionEvent)
            {
                if(motionEvent.getAction() == MotionEvent.ACTION_DOWN)
                {
                    iX = motionEvent.getX();
                    iY = motionEvent.getY();
                }
                if(motionEvent.getAction() == MotionEvent.ACTION_UP)
                {
                    fX = motionEvent.getX();
                    fY = motionEvent.getY();
                    //Toast.makeText(getBaseContext(), mess, Toast.LENGTH_SHORT).show();

                    txtXY1.setText(iX + " , "+ iY);
                    txtXY2.setText(fX + " , "+ fY);

                    txtQuadrant.setText("");
                    txtMotion.setText("");
                    txtXYd.setText(Math.abs(iX-fX) + " , "+ Math.abs(iY-fY));

                    if(iX>fX && iY==fY)
                    {
                        mess = "Swiped Left";
                    }
                    else if(iX<fX && iY==fY)
                    {
                        mess = "Swiped Right";
                    }
                    else if(iX==fX && iY>fY)
                    {
                        mess = "Swiped Up";
                    }
                    else if(iX==fX && iY<fY)
                    {
                        mess = "Swiped Down";
                    }
                    else if(iX>fX && iY>fY)
                    {
                        mess = "Swiped Left, Swiped Up";
                    }
                    else if(iX<fX && iY>fY)
                    {
                        mess = "Swiped Right, Swiped Up";

                    }
                    else if(iX>fX && iY<fY)
                    {
                        mess = "Swiped Left, Swiped Down";
                    }
                    else if(iX<fX && iY<fY)
                    {
                        mess = "Swiped Right, Swiped Down";
                    }
                    else if(iX==fX && iY==fY)
                    {
                        mess = "No Motion";
                    }

                    if(iX == imgTouch.getWidth()/2 && fX == imgTouch.getWidth()/2 && fX == imgTouch.getWidth()/2 && fY == imgTouch.getHeight()/2)
                    {
                        quad = "Center";
                    }
                    else if(fX < imgTouch.getWidth()/2 && fY > imgTouch.getHeight()/2)
                    {
                        quad = "Quadrant III";
                    }
                    else if(fX > imgTouch.getWidth()/2 && fY > imgTouch.getHeight()/2)
                    {
                        quad = "Quadrant VI";
                    }
                    else if(fX > imgTouch.getWidth()/2 && fY < imgTouch.getHeight()/2)
                    {
                        quad = "Quadrant I";
                    }
                    else if(fX < imgTouch.getWidth()/2 && fY < imgTouch.getHeight()/2)
                    {
                        quad = "Quadrant II";
                    }
                    txtMotion.setText(mess);
                    txtQuadrant.setText(quad);

                }

                return true;
            }


        });
    }

    @Override
    protected  void onPause(){
        super.onPause();
        finish();
    }
}
