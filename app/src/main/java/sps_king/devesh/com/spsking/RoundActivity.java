package sps_king.devesh.com.spsking;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class RoundActivity extends AppCompatActivity {
    private Button b1,b2,b3;
    public static String ren;
    private int a=0,b=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_round);

        b1=(Button)findViewById(R.id.btn_3round);
        b2=(Button)findViewById(R.id.btn_mn);
        b3=(Button)findViewById(R.id.btn10round);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ren="3";
                a=1;
                startActivity(new Intent(RoundActivity.this,Userlist_Activity.class));
                finish();
            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ren="5";
                a=1;
                startActivity(new Intent(RoundActivity.this,Userlist_Activity.class));
                finish();
            }
        });
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ren="10";
                a=1;
                startActivity(new Intent(RoundActivity.this,Userlist_Activity.class));
                finish();
            }
        });

    }
    @Override
    public void onBackPressed(){
        a=1;
        startActivity(new Intent(RoundActivity.this,Multiplayer.class));
        finish();
    }

    @Override
    protected void onUserLeaveHint() {
        super.onUserLeaveHint();


        if(a==1){

        }
        else if(New_Game.media.isPlaying()){
            New_Game.media.stop();
            b=1;
        }

        else if (About_us.medi.isPlaying()) {
            About_us.medi.stop();
            b=1;
        }




    }
    @Override
    protected void onResume(){
        super.onResume();
        if(b==1){
            New_Game.media = MediaPlayer.create(RoundActivity.this, R.raw.safe);
            New_Game.media.start();
            New_Game.media.setLooping(true);
            b=0;
        }

    }
}
