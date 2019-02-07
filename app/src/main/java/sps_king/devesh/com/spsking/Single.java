package sps_king.devesh.com.spsking;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class Single extends Activity {

    private long backPressedTime;
    private Toast backToast;
    ImageView rock, paper, scissor;
    ImageView iv_cpu, iv_me;
    private static TextView tv_CPU,tv_user,tv_round,cpu;
    int n=0;
    private TextView user;


    String mychoice, cpuchoice, result;
    public static int Humanscore, Computerscore = 0;


    private Handler handler= new Handler();

    Random r;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single);


        iv_cpu = (ImageView) findViewById(R.id.iV_cpu);
        iv_me = (ImageView) findViewById(R.id.iV_me);


        tv_user = (TextView) findViewById(R.id.tv_user);
        user=(TextView)findViewById(R.id.tv_username1);
        tv_CPU = (TextView) findViewById(R.id.tv_CPU);
        tv_round = (TextView) findViewById(R.id.tv_round);
        cpu=(TextView)findViewById(R.id.tv_cpu1);

        rock = (ImageView) findViewById(R.id.rock);
        paper = (ImageView) findViewById(R.id.paper);
        scissor = (ImageView) findViewById(R.id.scissor);


        rock.setImageResource(R.drawable.hand);
        paper.setImageResource(R.drawable.hand1);
        scissor.setImageResource(R.drawable.hand2);

        user.setText(New_Game.Username);


        r = new Random();
        rock.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mychoice = "rock";
                n=n+1;
                iv_me.setImageResource(R.drawable.hand);
                Calculate();

            }
        });

        paper.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mychoice = "paper";
                n=n+1;
                iv_me.setImageResource(R.drawable.hand1);
                Calculate();

            }
        });

        scissor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mychoice = "scissor";
                n=n+1;
                iv_me.setImageResource(R.drawable.hand2);
                Calculate();

            }
        });

        if(n==5){
            next();
        }
        if (Gameoptions.round==n){
            next();
        }
    }

    private Runnable mToastRunnable = new Runnable() {
        @Override
        public void run() {
            next();
        }
    };



    public void next(){
        this.finishActivity(1);
        Intent intent = new Intent(this, result.class);
        startActivity(intent);
        finish();
    }
    @Override
    public void onBackPressed(){
        if (backPressedTime + 2000 > System.currentTimeMillis()){
            backToast.cancel();
            super.onBackPressed();
            Intent intent = new Intent(this, New_Game.class);
            startActivity(intent);
            return;

        }else{
            backToast = Toast.makeText(getBaseContext(),"Press Back Again To Exit",Toast.LENGTH_SHORT);
            backToast.show();
        }
        backPressedTime = System.currentTimeMillis();
    }

    public void Calculate() {

        int cpu = r.nextInt(3);

        tv_round.setText("Round- " + Integer.toString(n));

        if (cpu == 0) {
            cpuchoice = "rock";
            iv_cpu.setImageResource(R.drawable.hand);
            if (mychoice == "rock") {
                result = "Draw";
            } else if (mychoice == "scissor") {
                result = "You Loose";
                Computerscore++;
                tv_CPU.setText("Score:- " + Integer.toString (Computerscore));
            } else {
                result = "You win";
                Humanscore++;
                tv_user.setText("Score:- " + Integer.toString(Humanscore));
            }
        } else if (cpu == 1) {
            cpuchoice = "paper";
            iv_cpu.setImageResource(R.drawable.hand1);
            if (mychoice == "paper") {
                result = "Draw";
            } else if (mychoice == "rock") {
                result = "You Loose";
                Computerscore++;
                tv_CPU.setText("Score:- " + Integer.toString(Computerscore));
            } else {
                result = "You win";
                Humanscore++;
                tv_user.setText("Score:- " + Integer.toString(Humanscore));
            }
        } else if (cpu == 2) {
            cpuchoice = "scissor";
            iv_cpu.setImageResource(R.drawable.hand2);
            if (mychoice == "scissor") {
                result = "Draw";
            } else if (mychoice == "paper") {
                result = "You Loose";
                Computerscore++;
                tv_CPU.setText("Score:- " + Integer.toString(Computerscore));
            } else {
                result = "You win";
                Humanscore++;
                tv_user.setText("Score:- " + Integer.toString(Humanscore));
            }

        }

        Toast.makeText(Single.this, result, Toast.LENGTH_SHORT).show();

        if(n==Gameoptions.round){
            rock.setEnabled(false);
            scissor.setEnabled(false);
            paper.setEnabled(false);
            Toast.makeText(Single.this, result, Toast.LENGTH_SHORT).show();
            handler.postDelayed(mToastRunnable,4000);

        }

    }
}
