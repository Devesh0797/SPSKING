package sps_king.devesh.com.spsking;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class result extends Activity {

    private static TextView  tv_result;
    Button Mn;
    private int a=0,b=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        tv_result = (TextView) findViewById(R.id.tv_result);
        Mn = (Button)findViewById(R.id.mainmenu);



        if(Single.Humanscore == Single.Computerscore){

            tv_result.setVisibility(View.INVISIBLE);
            RelativeLayout layout =(RelativeLayout)findViewById(R.id.rela);
            layout.setBackgroundResource(R.drawable.draw);

        }
        else if(Single.Humanscore<Single.Computerscore){
            RelativeLayout layout =(RelativeLayout)findViewById(R.id.rela);
            layout.setBackgroundResource(R.drawable.loserpage);
            tv_result.setText(New_Game.Username);

        }
        else{
            tv_result.setText(New_Game.Username);
            RelativeLayout layout =(RelativeLayout)findViewById(R.id.rela);
            layout.setBackgroundResource(R.drawable.winners);
        }
        Mn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Mainmenu();
            }
        });
    }
    private void Mainmenu(){
        this.finishActivity(1);
        a=1;
        this.finish();
        Intent intent = new Intent(result.this, New_Game.class);
        startActivity(intent);

    }
    @Override
    public void onBackPressed(){
        Mainmenu();
        finish();
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
            New_Game.media = MediaPlayer.create(result.this, R.raw.safe);
            New_Game.media.start();
            New_Game.media.setLooping(true);
            b=0;
        }

    }
}
