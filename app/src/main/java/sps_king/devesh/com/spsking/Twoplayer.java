package sps_king.devesh.com.spsking;

import android.app.Activity;
import android.content.Intent;
import android.os.Handler;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class Twoplayer extends Activity {

    private long backPressedTime;
    private Toast backToast;
    //public static int flag_time=0;
    ImageView iv_user1,iv_user2;
    Button user1,user2;
    //TextView tv_time;
    // private static int i = 10;
    protected static int flag_user1=0,flag_user2=0;
    private TextView user;



    protected static String user1choice,user2choice;
    TextView tv_round4,opp;
    private Handler handler= new Handler();

    TextView Score1,Score2;

    Random r1,r2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_twoplayer);

        user1 = (Button)findViewById(R.id.bt_user1);
        user2 = (Button)findViewById(R.id.bt_user2);

        opp=(TextView)findViewById(R.id.et_opponent);
        user=(TextView)findViewById(R.id.tv_playername);


        tv_round4=(TextView)findViewById(R.id.tv_round2);

        iv_user1 = (ImageView)findViewById(R.id.imagebutton);
        iv_user1.setImageDrawable(ContextCompat.getDrawable(this,R.drawable.hand));

        iv_user2 = (ImageView)findViewById(R.id.imagebutton2);
        iv_user2.setImageDrawable(ContextCompat.getDrawable(this,R.drawable.hand_rot));

        Score1 = (TextView)findViewById(R.id.tv_score1);
        Score2 = (TextView)findViewById(R.id.tv_score2);

        Score1.setText("Score:-" + Integer.toString(Time_out.Player1score));
        Score2.setText("Score:-" + Integer.toString(Time_out.Player2score));

        user1.setText(New_Game.Username);
        user2.setText(OpponentName.name);

        tv_round4.setText("Round:-" + Integer.toString(Gameoptions.no));

        opp.setText(OpponentName.name);
        user.setText(New_Game.Username);

        handler.postDelayed(mToastRunnable,200);

        r1 = new Random();
        r2 = new Random();


    }

    private Runnable mToastRunnable = new Runnable() {
        @Override
        public void run() {
            // if (flag_time == 0) {
            // loop = loop + 200;
            //}
            next();
        }
    };

    private void next(){

        int ran1 = r1.nextInt(3);
        int ran2 = r2.nextInt(3);


        if (flag_user1 == 0) {
            if(ran1==0) {

                iv_user1.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.hand1));
                iv_user1.setTag("hand1");
                user1choice="hand1";
            }
            else if(ran1==1){
                iv_user1.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.hand2));
                iv_user1.setTag("hand2");
                user1choice="hand2";
            }
            else if(ran1==2){
                iv_user1.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.hand));
                iv_user1.setTag("hand");
                user1choice="hand";
            }
        }
        if(flag_user2==0) {
            if(ran2==0){
                iv_user2.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.hand_rot1));
                iv_user2.setTag("hand1");
                user2choice="hand1";
            }
            else if(ran2==1){
                iv_user2.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.hand_rot2));
                iv_user2.setTag("hand2");
                user2choice="hand2";
            }
            else if(ran2==2){
                iv_user2.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.hand_rot));
                iv_user2.setTag("hand");
                user2choice="hand";
            }
        }


        user1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                flag_user1=1;
                if(iv_user1.getTag()=="hand") {
                    iv_user1.setImageDrawable(ContextCompat.getDrawable(Twoplayer.this, R.drawable.hand));
                    user1choice = "hand";
                    new_page();
                }
                else if(iv_user1.getTag()=="hand1"){
                    iv_user1.setImageDrawable(ContextCompat.getDrawable(Twoplayer.this, R.drawable.hand1));
                    user1choice="hand1";
                    new_page();
                }
                else if(iv_user1.getTag()=="hand2"){
                    iv_user1.setImageDrawable(ContextCompat.getDrawable(Twoplayer.this, R.drawable.hand2));
                    user1choice="hand2";
                    new_page();
                }


            }
        });
        user2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                flag_user2=1;
                if(iv_user2.getTag()=="hand") {
                    iv_user2.setImageDrawable(ContextCompat.getDrawable(Twoplayer.this, R.drawable.hand_rot));
                    user2choice = "hand";
                    new_page();
                }
                else if(iv_user2.getTag()=="hand1"){
                    iv_user2.setImageDrawable(ContextCompat.getDrawable(Twoplayer.this, R.drawable.hand_rot1));
                    user2choice="hand1";
                    new_page();
                }
                else if(iv_user2.getTag()=="hand2"){
                    iv_user2.setImageDrawable(ContextCompat.getDrawable(Twoplayer.this, R.drawable.hand_rot2));
                    user2choice="hand2";
                    new_page();
                }


            }
        });
        // if(loop%1000==0 && flag_time==0){
        //   i=i-1;
        // if(i==0 && flag_user1==0 && flag_user2==0){

        //   loop=0;
        // Intent intent= new Intent(this,Time_out.class);
        //startActivity(intent);
        //i=10;
        // flag_time=1;
        // finish();
        //}
        //else if(i==0  && flag_user2==0 && flag_user1==1){
        //  loop=0;
        // Intent intent= new Intent(this,Time_out.class);
        //    startActivity(intent);
        //  i=10;
        //    flag_time=1;
        //   finish();
        //}
        // else if(i==0 && flag_user2==1 && flag_user1==0){
        //  loop=0;
        //  Intent intent= new Intent(this,Time_out.class);
        // startActivity(intent);
        //  i=10;
        // flag_time=1;
        //   finish();
        //}
        //  tv_time.setText(Integer.toString(i));
        // loop=0;
        // }
        handler.postDelayed(mToastRunnable, 200);




    }
    public void new_page(){
        if(flag_user1==1 && flag_user2==1) {

            Gameoptions.no=Gameoptions.no+1;
            Intent intent = new Intent(this, TwoUserResult.class);
            startActivity(intent);
            this.finish();
        }
        else if(flag_user2==1){
            user2.setEnabled(false);
            if(iv_user1.getTag()=="hand"){
                user1choice="hand";
                handler.postDelayed(mToastRunnable,200);
            }
            else if(iv_user1.getTag()=="hand1"){
                user1choice="hand1";
                handler.postDelayed(mToastRunnable, 200);
            }
            else if(iv_user1.getTag()=="hand2"){
                user1choice="hand2";
                handler.postDelayed(mToastRunnable, 200);
            }
        }
        else if(flag_user1==1){
            user1.setEnabled(false);
            if(iv_user2.getTag()=="hand"){
                user2choice="hand";
                handler.postDelayed(mToastRunnable,200);
            }
            else if(iv_user2.getTag()=="hand1"){
                user2choice="hand1";
                handler.postDelayed(mToastRunnable, 200);
            }
            else if(iv_user2.getTag()=="hand2"){
                user2choice="hand2";
                handler.postDelayed(mToastRunnable, 200);
            }
        }
    }
    @Override
    public void onBackPressed(){
        if (backPressedTime + 2000 > System.currentTimeMillis()){
            backToast.cancel();
            super.onBackPressed();

            //  flag_time=0;
            finish();
            return;

        }else{
            backToast = Toast.makeText(getBaseContext(),"Press Back Again To Exit",Toast.LENGTH_SHORT);
            backToast.show();
        }
        backPressedTime = System.currentTimeMillis();
    }
}
