package sps_king.devesh.com.spsking;

import android.app.Activity;
import android.content.Intent;
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
                    startActivity(new Intent(OpponentName.this,Twoplayer.class));
                    finish();

                }
            }
        });



    }
}
