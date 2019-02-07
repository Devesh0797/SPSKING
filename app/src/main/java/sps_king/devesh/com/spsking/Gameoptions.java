package sps_king.devesh.com.spsking;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Gameoptions extends Activity {

    Button Singleplayer, Twoplayer, mode, round1, round2, round3, selectround;
    public static int round=0;
    public static int no = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gameoptions);

        mode = (Button) findViewById(R.id.select_mode);
        Singleplayer = (Button) findViewById(R.id.Go_solo);
        Twoplayer = (Button) findViewById(R.id.vsmode);
        selectround = (Button) findViewById(R.id.select_round);
        round1 = (Button) findViewById(R.id.button8);
        round2 = (Button) findViewById(R.id.button9);
        round3 = (Button) findViewById(R.id.button10);
        // Exit = (Button) findViewById(R.id.Exit);

        Singleplayer.setVisibility(View.INVISIBLE);
        Twoplayer.setVisibility(View.INVISIBLE);
        selectround.setVisibility(View.INVISIBLE);
        round1.setVisibility(View.INVISIBLE);
        round2.setVisibility(View.INVISIBLE);
        round3.setVisibility(View.INVISIBLE);



        mode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Singleplayer.setVisibility(View.VISIBLE);
                Twoplayer.setVisibility(View.VISIBLE);
            }
        });

        Singleplayer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mode.setEnabled(false);
                selectround.setVisibility(View.VISIBLE);
                Twoplayer.setVisibility(View.INVISIBLE);
                Single();

            }
        });
        Twoplayer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mode.setEnabled(false);
                selectround.setVisibility(View.VISIBLE);
                Singleplayer.setVisibility(View.INVISIBLE);
                Twoplayer();
            }
        });


    }


    public void Single() {
        selectround.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                round1.setVisibility(View.VISIBLE);
                round2.setVisibility(View.VISIBLE);
                round3.setVisibility(View.VISIBLE);

                round1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        round=5;
                        Single.Humanscore = 0;
                        Single.Computerscore = 0;
                        startActivity(new Intent(Gameoptions.this, Single.class));
                        finish();
                    }
                });
                round2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        round=10;
                        Single.Humanscore = 0;
                        Single.Computerscore = 0;
                        startActivity(new Intent(Gameoptions.this, Single.class));
                        finish();
                    }
                });
                round3.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        round=15;
                        Single.Humanscore = 0;
                        Single.Computerscore = 0;
                        startActivity(new Intent(Gameoptions.this, Single.class));
                        finish();
                    }
                });
            }
        });

    }

    public void Twoplayer() {
        selectround.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                round1.setVisibility(View.VISIBLE);
                round2.setVisibility(View.VISIBLE);
                round3.setVisibility(View.VISIBLE);

                round1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        round=5;
                        no=0;
                        Time_out.Player1score=0;
                        Time_out.Player2score=0;
                        startActivity(new Intent(Gameoptions.this, OpponentName.class));
                        finish();
                    }
                });
                round2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        round=10;
                        no=0;
                        Time_out.Player1score=0;
                        Time_out.Player2score=0;
                        startActivity(new Intent(Gameoptions.this, OpponentName.class));
                        finish();
                    }
                });
                round3.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        round=15;
                        no=0;
                        Time_out.Player1score=0;
                        Time_out.Player2score=0;
                        startActivity(new Intent(Gameoptions.this, OpponentName.class));
                        finish();
                    }
                });
            }

        });

    }
}
