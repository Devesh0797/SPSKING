package sps_king.devesh.com.spsking;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class RoomRequest_Activity extends AppCompatActivity {
    private DatabaseReference rootRef,demoRef;
    private Handler handler= new Handler();
    private String value1;
    private int count=1;
    public static String comp;
    private Button b1,b2;
    private TextView t1;
    private CardView c1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_room_request_);

        b1=(Button)findViewById(R.id.btn_accept);
        b2=(Button)findViewById(R.id.btn_reject);

        t1=(TextView)findViewById(R.id.tv_pla98);

        c1=(CardView)findViewById(R.id.cv_player);

        c1.setVisibility(View.GONE);

        rootRef = FirebaseDatabase.getInstance().getReference();
        demoRef = rootRef.child("Users").child(New_Game.USerID);

        handler.postDelayed(mToastRunnable,200);
    }

    private Runnable mToastRunnable = new Runnable() {
        @Override
        public void run() {

            demoRef.child("Multiplayer").addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    value1 = dataSnapshot.getValue(String.class);
                    String value= value1.trim();


                    if (value.equals("Online") || value.equals("online") || value.equals("ONLINE")) {
                        value = "Offline";
                        demoRef.child("Multiplayer").setValue(value);

                        if(count==1){
                            count = 0;
                            handler.postDelayed(mToastRunnable1,2000);
                        }else{

                        }
                    }

                    else{
                        handler.postDelayed(mToastRunnable, 3000);
                    }
                }


                @Override
                public void onCancelled(DatabaseError databaseError) {
                    Toast.makeText(RoomRequest_Activity.this, "Check your Internet Connection", Toast.LENGTH_SHORT).show();
                    finish();
                }
            });



        }
    };
    private Runnable mToastRunnable1 = new Runnable() {
        @Override
        public void run() {
            demoRef.child("Competitor").addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    comp = dataSnapshot.getValue(String.class);


                    demoRef.child("Friends").child(comp).child("name").addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(DataSnapshot dataSnapshot) {
                            String name = dataSnapshot.getValue(String.class);

                            t1.setText(name+" Wants To connect.");
                            c1.setVisibility(View.VISIBLE);
                            b1.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    New_Game.player="player2";
                                    startActivity(new Intent(RoomRequest_Activity.this,Room2Activity.class));
                                }
                            });
                            b2.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {

                                }
                            });



                        }


                        @Override
                        public void onCancelled(DatabaseError databaseError) {
                            Toast.makeText(RoomRequest_Activity.this, "Check your Internet Connection", Toast.LENGTH_SHORT).show();
                            finish();
                        }
                    });






                }


                @Override
                public void onCancelled(DatabaseError databaseError) {
                    Toast.makeText(RoomRequest_Activity.this, "Check your Internet Connection", Toast.LENGTH_SHORT).show();
                    finish();
                }
            });



        }
    };

}
