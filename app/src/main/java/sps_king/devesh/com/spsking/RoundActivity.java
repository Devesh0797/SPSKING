package sps_king.devesh.com.spsking;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class RoundActivity extends AppCompatActivity {
    private Button b1,b2,b3;
    public static String ren;

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
                startActivity(new Intent(RoundActivity.this,Userlist_Activity.class));
            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ren="5";
                startActivity(new Intent(RoundActivity.this,Userlist_Activity.class));
            }
        });
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ren="10";
                startActivity(new Intent(RoundActivity.this,Userlist_Activity.class));
            }
        });

    }
}
