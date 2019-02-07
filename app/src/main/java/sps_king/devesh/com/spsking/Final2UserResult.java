package sps_king.devesh.com.spsking;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class Final2UserResult extends Activity {

    private Button mai;
    private TextView result;

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
                finish();
            }
        });



    }
    private void Mainmenu(){
        this.finishActivity(1);

        this.finish();
        Intent intent = new Intent(Final2UserResult.this, New_Game.class);
        startActivity(intent);

    }
    @Override
    public void onBackPressed(){
        Mainmenu();
        finish();
    }
}
