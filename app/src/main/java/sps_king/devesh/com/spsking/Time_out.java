package sps_king.devesh.com.spsking;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.Random;

public class Time_out extends Activity {

    Button ok;
    private long backPressedTime;
    private Toast backToast;
    private DatabaseReference rootRef,demoRef;
    TextView dare;
    Random r;
    ProgressDialog progressDialog;
    public static int Player1score=0,Player2score =0 ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_time_out);

        rootRef = FirebaseDatabase.getInstance().getReference();
        demoRef = rootRef.child("Dares");

        r = new Random();
        int task = r.nextInt(4);

        dare = (TextView)findViewById(R.id.tv_task);
        ok=(Button)findViewById(R.id.ok);

        progressDialog = new ProgressDialog(Time_out.this);
        progressDialog.setTitle("Dares");
        progressDialog.setMessage("Loading");
        progressDialog.show();


        demoRef.child("ID"+task).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String value = dataSnapshot.getValue(String.class);
                //Log.d(TAG,"Value is"+ value);
                //Toast.makeText(Details.this,"value is"+value,Toast.LENGTH_SHORT).show();
                if(haveNetwork()) {
                    if (value != null) {
                        dare.setText(value);
                        progressDialog.dismiss();

                    } else {
                        Toast.makeText(Time_out.this,"Error Occured",Toast.LENGTH_SHORT).show();
                        progressDialog.dismiss();

                    }
                }
                else{
                    Toast.makeText(Time_out.this,"Check your Internet Connection",Toast.LENGTH_SHORT).show();
                    progressDialog.dismiss();
                }
            }
            @Override
            public void onCancelled(DatabaseError databaseError) {
                Toast.makeText(Time_out.this,"Check your Internet Connection",Toast.LENGTH_SHORT).show();
            }
        });


        ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ok();
            }
        });
    }
    private Boolean haveNetwork() {
        boolean have_WIFI = false;
        boolean have_MobileData = false;

        ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService(CONNECTIVITY_SERVICE);
        NetworkInfo[] networkInfos = connectivityManager.getAllNetworkInfo();

        for (NetworkInfo info : networkInfos) {
            if (info.getTypeName().equalsIgnoreCase("WIFI"))
                if (info.isConnected())
                    have_WIFI = true;
            if (info.getTypeName().equalsIgnoreCase("MOBILE"))
                if (info.isConnected())
                    have_MobileData = true;
        }
        return have_MobileData || have_WIFI;

    }

    public void ok() {
        // Twoplayer.flag_time=0;
        // Twoplayer.loop=0;
        if (Gameoptions.no == Gameoptions.round) {

            Intent intent = new Intent(this, Final2UserResult.class);
            startActivity(intent);
            this.finish();
        } else {

            if (TwoUserResult.Player1 == "Win" && TwoUserResult.Player2 == "Loose") {
                Player1score = Player1score + 10;
                Player2score = Player2score + 0;

            } else if (TwoUserResult.Player2 == "Win" && TwoUserResult.Player1 == "Loose") {
                Player2score = Player2score + 10;
                Player1score = Player1score + 0;

            } else if (TwoUserResult.Player1 == "Draw" && TwoUserResult.Player2 == "Draw") {
                Player1score = Player1score + 0;
                Player2score = Player2score + 0;


            }
            Intent intent = new Intent(this, Twoplayer.class);
            startActivity(intent);
            finish();
        }
    }
    @Override
    public void onBackPressed(){
        if (backPressedTime + 2000 > System.currentTimeMillis()){
            backToast.cancel();
            super.onBackPressed();
            Intent intent = new Intent(this, New_Game.class);
            startActivity(intent);
            this.finish();
            return;

        }else{
            backToast = Toast.makeText(getBaseContext(),"Press Back Again To Exit",Toast.LENGTH_SHORT);
            backToast.show();
        }
        backPressedTime = System.currentTimeMillis();
    }
}
