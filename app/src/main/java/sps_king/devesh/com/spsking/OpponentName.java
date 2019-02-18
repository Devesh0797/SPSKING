package sps_king.devesh.com.spsking;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class OpponentName extends Activity {

    public EditText nam;
    public static String name;
    private Button don;
    private int a=0,b=0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_opponent_name);

        nam=(EditText)findViewById(R.id.et_opp);
        don=(Button)findViewById(R.id.btn_ok);



        don.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                name=nam.getText().toString();

                if(TextUtils.isEmpty(name)){
                    Toast.makeText(getApplicationContext(),"Enter name",Toast.LENGTH_SHORT).show();
                }
                else{
                    a=1;
                    startActivity(new Intent(OpponentName.this,Twoplayer.class));
                    finish();

                }
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
            New_Game.media = MediaPlayer.create(OpponentName.this, R.raw.safe);
            New_Game.media.start();
            New_Game.media.setLooping(true);
            b=0;
        }

    }
}
