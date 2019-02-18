package sps_king.devesh.com.spsking;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class TwoUserResult extends Activity {

    private long backPressedTime;
    private Toast backToast;
    TextView tv_result_user1,tv_result_user2;
    private int a=0,b=0;
    public static String Player1,Player2;
    Button Return,mai;
    ImageView Imageresult_rot_user,Imageresult_rot_opp,Imageresult_user,Imageresult_opp;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_two_user_result);

        tv_result_user1 =(TextView)findViewById(R.id.tv_result_user1);
        tv_result_user2=(TextView)findViewById(R.id.tv_result_user2);

        Return = (Button)findViewById(R.id.return1);
        mai = (Button)findViewById(R.id.button);
        Imageresult_opp=(ImageView)findViewById(R.id.iv_result_op);
        Imageresult_user=(ImageView)findViewById(R.id.iv_result_us);
        Imageresult_rot_opp=(ImageView)findViewById(R.id.iv_result_op_r);
        Imageresult_rot_user=(ImageView)findViewById(R.id.iv_result_us_r);



        if(Twoplayer.user1choice=="hand" && Twoplayer.user2choice=="hand"){
            tv_result_user2.setText("DRAW");
            tv_result_user1.setText("DRAW");
            Player1="Draw";
            Player2="Draw";
            Imageresult_user.setImageDrawable(ContextCompat.getDrawable(TwoUserResult.this, R.drawable.hand));
            Imageresult_opp.setImageDrawable(ContextCompat.getDrawable(TwoUserResult.this, R.drawable.hand));
            Imageresult_rot_user.setImageDrawable(ContextCompat.getDrawable(TwoUserResult.this, R.drawable.hand_rot));
            Imageresult_rot_opp.setImageDrawable(ContextCompat.getDrawable(TwoUserResult.this, R.drawable.hand_rot));
        }
        else if(Twoplayer.user1choice=="hand" && Twoplayer.user2choice=="hand1"){
            tv_result_user2.setText("You Win");
            tv_result_user1.setText("You Loose");
            Player2="Win";
            Player1="Loose";
            Imageresult_user.setImageDrawable(ContextCompat.getDrawable(TwoUserResult.this, R.drawable.hand));
            Imageresult_opp.setImageDrawable(ContextCompat.getDrawable(TwoUserResult.this, R.drawable.hand1));
            Imageresult_rot_user.setImageDrawable(ContextCompat.getDrawable(TwoUserResult.this, R.drawable.hand_rot1));
            Imageresult_rot_opp.setImageDrawable(ContextCompat.getDrawable(TwoUserResult.this, R.drawable.hand_rot));
        }
        else if(Twoplayer.user1choice=="hand" && Twoplayer.user2choice=="hand2"){
            tv_result_user2.setText("You Loose");
            tv_result_user1.setText("You Win");
            Player1="Win";
            Player2="Loose";
            Imageresult_user.setImageDrawable(ContextCompat.getDrawable(TwoUserResult.this, R.drawable.hand));
            Imageresult_opp.setImageDrawable(ContextCompat.getDrawable(TwoUserResult.this, R.drawable.hand2));
            Imageresult_rot_user.setImageDrawable(ContextCompat.getDrawable(TwoUserResult.this, R.drawable.hand_rot2));
            Imageresult_rot_opp.setImageDrawable(ContextCompat.getDrawable(TwoUserResult.this, R.drawable.hand_rot));
        }
        else if(Twoplayer.user1choice=="hand1" && Twoplayer.user2choice=="hand"){
            tv_result_user2.setText("You Loose");
            tv_result_user1.setText("You Win");
            Player1="Win";
            Player2="Loose";
            Imageresult_user.setImageDrawable(ContextCompat.getDrawable(TwoUserResult.this, R.drawable.hand1));
            Imageresult_opp.setImageDrawable(ContextCompat.getDrawable(TwoUserResult.this, R.drawable.hand));
            Imageresult_rot_user.setImageDrawable(ContextCompat.getDrawable(TwoUserResult.this, R.drawable.hand_rot));
            Imageresult_rot_opp.setImageDrawable(ContextCompat.getDrawable(TwoUserResult.this, R.drawable.hand_rot1));
        }
        else if(Twoplayer.user1choice=="hand1" && Twoplayer.user2choice=="hand1"){
            tv_result_user2.setText("DRAW");
            tv_result_user1.setText("DRAW");
            Player1="Draw";
            Player2="Draw";
            Imageresult_user.setImageDrawable(ContextCompat.getDrawable(TwoUserResult.this, R.drawable.hand1));
            Imageresult_opp.setImageDrawable(ContextCompat.getDrawable(TwoUserResult.this, R.drawable.hand1));
            Imageresult_rot_user.setImageDrawable(ContextCompat.getDrawable(TwoUserResult.this, R.drawable.hand_rot1));
            Imageresult_rot_opp.setImageDrawable(ContextCompat.getDrawable(TwoUserResult.this, R.drawable.hand_rot1));
        }
        else if(Twoplayer.user1choice=="hand1" && Twoplayer.user2choice=="hand2"){
            tv_result_user2.setText("You Win");
            tv_result_user1.setText("You Loose");
            Player2="Win";
            Player1="Loose";
            Imageresult_user.setImageDrawable(ContextCompat.getDrawable(TwoUserResult.this, R.drawable.hand1));
            Imageresult_opp.setImageDrawable(ContextCompat.getDrawable(TwoUserResult.this, R.drawable.hand2));
            Imageresult_rot_user.setImageDrawable(ContextCompat.getDrawable(TwoUserResult.this, R.drawable.hand_rot2));
            Imageresult_rot_opp.setImageDrawable(ContextCompat.getDrawable(TwoUserResult.this, R.drawable.hand_rot1));
        }
        else if(Twoplayer.user1choice=="hand2" && Twoplayer.user2choice=="hand"){
            tv_result_user2.setText("You Win");
            tv_result_user1.setText("You Loose");
            Player2="Win";
            Player1="Loose";
            Imageresult_user.setImageDrawable(ContextCompat.getDrawable(TwoUserResult.this, R.drawable.hand2));
            Imageresult_opp.setImageDrawable(ContextCompat.getDrawable(TwoUserResult.this, R.drawable.hand));
            Imageresult_rot_user.setImageDrawable(ContextCompat.getDrawable(TwoUserResult.this, R.drawable.hand_rot));
            Imageresult_rot_opp.setImageDrawable(ContextCompat.getDrawable(TwoUserResult.this, R.drawable.hand_rot2));
        }
        else if(Twoplayer.user1choice=="hand2" && Twoplayer.user2choice=="hand1"){
            tv_result_user2.setText("You Loose");
            tv_result_user1.setText("You Win");
            Player1="Win";
            Player2="Loose";
            Imageresult_user.setImageDrawable(ContextCompat.getDrawable(TwoUserResult.this, R.drawable.hand2));
            Imageresult_opp.setImageDrawable(ContextCompat.getDrawable(TwoUserResult.this, R.drawable.hand1));
            Imageresult_rot_user.setImageDrawable(ContextCompat.getDrawable(TwoUserResult.this, R.drawable.hand_rot1));
            Imageresult_rot_opp.setImageDrawable(ContextCompat.getDrawable(TwoUserResult.this, R.drawable.hand_rot2));
        }
        else if(Twoplayer.user1choice=="hand2" && Twoplayer.user2choice=="hand2"){
            tv_result_user2.setText("DRAW");
            tv_result_user1.setText("DRAW");
            Player1="Draw";
            Player2="Draw";
            Imageresult_user.setImageDrawable(ContextCompat.getDrawable(TwoUserResult.this, R.drawable.hand2));
            Imageresult_opp.setImageDrawable(ContextCompat.getDrawable(TwoUserResult.this, R.drawable.hand2));
            Imageresult_rot_user.setImageDrawable(ContextCompat.getDrawable(TwoUserResult.this, R.drawable.hand_rot2));
            Imageresult_rot_opp.setImageDrawable(ContextCompat.getDrawable(TwoUserResult.this, R.drawable.hand_rot2));
        }

        Return.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                get();
            }
        });
        mai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                a=1;
                startActivity(new Intent(TwoUserResult.this,New_Game.class));
                finish();
            }
        });
    }

    public void get(){
        if(TwoUserResult.Player1=="Draw" && TwoUserResult.Player2=="Draw") {
            if(Gameoptions.no==Gameoptions.round){
                Twoplayer.flag_user1=0;
                Twoplayer.flag_user2=0;
                a=1;
                Intent intent = new Intent(this,Final2UserResult.class);
                startActivity(intent);
                this.finish();
            }
            else {
                Twoplayer.flag_user1 = 0;
                Twoplayer.flag_user2 = 0;
                a=1;
                Intent intent = new Intent(this, Twoplayer.class);
                startActivity(intent);
                this.finish();
            }
        }
        else {
            Twoplayer.flag_user1 = 0;
            Twoplayer.flag_user2 = 0;
            a=1;
            Intent intent = new Intent(this, Time_out.class);
            startActivity(intent);
            this.finish();
        }
    }

    @Override
    public void onBackPressed(){
        if (backPressedTime + 2000 > System.currentTimeMillis()){
            backToast.cancel();
            super.onBackPressed();
            a=1;
            finish();
            Intent intent = new Intent(this, New_Game.class);
            startActivity(intent);
            return;

        }else{
            backToast = Toast.makeText(getBaseContext(),"Press Back Again To Exit",Toast.LENGTH_SHORT);
            backToast.show();
        }
        backPressedTime = System.currentTimeMillis();
    }
    @Override
    protected void onUserLeaveHint() {
        super.onUserLeaveHint();


        if(a==1){

        }
        else if(New_Game.media.isPlaying()){
            New_Game.media.stop();
        }

        else if (About_us.medi.isPlaying()) {
            About_us.medi.stop();
        }
        b = 1;



    }
    @Override
    protected void onResume(){
        super.onResume();
        if(b==1){
            New_Game.media = MediaPlayer.create(TwoUserResult.this, R.raw.safe);
            New_Game.media.start();
            New_Game.media.setLooping(true);
            b=0;
        }

    }
}
