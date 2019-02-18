package sps_king.devesh.com.spsking;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Handler;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

public class Splash2Activity extends Activity {

    private static int SPLASH_TIME_OUT = 4000;
    private Handler handler= new Handler();
    private ImageView img;
    private int x=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash2);

        img=(ImageView)findViewById(R.id.changeimg);




        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                Intent homeIntent = new Intent(Splash2Activity.this, New_Game.class);
                startActivity(homeIntent);
                finish();
            }
        },SPLASH_TIME_OUT);

        handler.postDelayed(mToastRunnable,500);

    }
    private Runnable mToastRunnable = new Runnable() {
        @Override
        public void run() {
            next();
        }
    };
    private void next(){
        if(x==0){

           // img.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.zeroth));
            x++;
        }
        else if(x==1){
            img.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.ten));
            x++;
        }
        else if(x==2){
            img.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.twen));
            x++;
        }
        else if(x==3){
            img.setImageDrawable(ContextCompat.getDrawable(this,R.drawable.forty));
            x++;
        }
        else if(x==4){
            img.setImageDrawable(ContextCompat.getDrawable(this,R.drawable.fifty));
            x++;
        }
        else if(x==5){
            img.setImageDrawable(ContextCompat.getDrawable(this,R.drawable.seventy));
            x++;
        }
        else if(x==6){
            img.setImageDrawable(ContextCompat.getDrawable(this,R.drawable.eighty));
            x++;
        }
        else if(x==7){
            img.setImageDrawable(ContextCompat.getDrawable(this,R.drawable.hundred));
            x++;
        }

        handler.postDelayed(mToastRunnable, 500);
    }
}
