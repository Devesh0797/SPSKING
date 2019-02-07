package sps_king.devesh.com.spsking;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class result extends Activity {

    private static TextView  tv_result;
    Button Mn;
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


        this.finish();
        Intent intent = new Intent(result.this, New_Game.class);
        startActivity(intent);

    }
    @Override
    public void onBackPressed(){
        Mainmenu();
        finish();
    }
}
