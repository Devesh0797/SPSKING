package sps_king.devesh.com.spsking;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Multiplayer extends AppCompatActivity {


    private Button b1,b3,b4,b2;
    private int a=0,b=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_multiplayer);



        b1=(Button)findViewById(R.id.btn_cret);
        b2=(Button)findViewById(R.id.btn_roomrequest);
        b3=(Button)findViewById(R.id.btnde);
        b4=(Button)findViewById(R.id.btn_request);



        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                a=1;
                startActivity(new Intent(Multiplayer.this,RoundActivity.class));
                finish();

            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                a=1;
                startActivity(new Intent(Multiplayer.this,RoomRequest_Activity.class));
                finish();
            }
        });

        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                a=1;
                startActivity(new Intent(Multiplayer.this,Search_Activity.class));
                finish();
            }
        });

        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                a=1;
                startActivity(new Intent(Multiplayer.this,Friend_requestActivity.class));
                finish();
            }
        });


    }

    @Override
    protected void onUserLeaveHint() {
        super.onUserLeaveHint();


        if(a==1){

        }
        else if(New_Game.media.isPlaying()){
            New_Game.media.stop();
            b = 1;
        }

        else if (About_us.medi.isPlaying()) {
            About_us.medi.stop();
            b = 1;
        }




    }
    @Override
    protected void onResume(){
        super.onResume();
        if(b==1){

            New_Game.media = MediaPlayer.create(Multiplayer.this, R.raw.safe);
            New_Game.media.start();
            New_Game.media.setLooping(true);
            b=0;
        }

    }


}
