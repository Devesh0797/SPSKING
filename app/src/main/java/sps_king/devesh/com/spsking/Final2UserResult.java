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
import android.widget.Toast;

public class Final2UserResult extends Activity {

    private Button mai;
    private TextView result;
    private int a=0;
    private int b=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_final2_user_result);

        mai=(Button)findViewById(R.id.btn_main_menu);
        result=(TextView)findViewById(R.id.tv_result6);



        if(Time_out.Player1score == Time_out.Player2score){

            result.setVisibility(View.INVISIBLE);
            RelativeLayout layout =(RelativeLayout)findViewById(R.id.relative);
            layout.setBackgroundResource(R.drawable.draw);
            //RelativeLayout layout = new RelativeLayout(this);
            //layout.setBackgroundResource(R.drawable.dare); //or whatever your image is
            //setContentView(layout);
            mai.setVisibility(View.VISIBLE);

        }
        else if(Time_out.Player1score <Time_out.Player2score){
            result.setText(OpponentName.name);
            RelativeLayout layout =(RelativeLayout)findViewById(R.id.relative);
            layout.setBackgroundResource(R.drawable.winners);

        }
        else{
            result.setText(New_Game.Username);
            RelativeLayout layout =(RelativeLayout)findViewById(R.id.relative);
            layout.setBackgroundResource(R.drawable.winners);
        }




        mai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Final2UserResult.this,New_Game.class));
                a=1;
                finish();
            }
        });



    }
    private void Mainmenu(){
        this.finishActivity(1);
        a=1;

        this.finish();
        Intent intent = new Intent(Final2UserResult.this, New_Game.class);
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
            New_Game.media = MediaPlayer.create(Final2UserResult.this, R.raw.safe);
            New_Game.media.start();
            New_Game.media.setLooping(true);
            b=0;
        }

    }
}
