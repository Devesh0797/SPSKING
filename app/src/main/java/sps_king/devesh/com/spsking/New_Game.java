package sps_king.devesh.com.spsking;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.media.MediaPlayer;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Handler;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;

public class New_Game extends Activity {

    private Button profile, newgame,resume1,aboutus;
    private DatabaseReference rootRef,demoRef;
    private FirebaseAuth firebaseAuth;
    ProgressDialog progressDialog;
    public static String Username;
    public static String USerID;
    private Button b1;
    private int fl=0;
    public static String imageurl,USerAge,player;

    private int a=0;
    private int b=0;
    public static MediaPlayer media;
    private int v=0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new__game);


        profile = (Button) findViewById(R.id.prof);
        newgame = (Button) findViewById(R.id.new_game);
        resume1=(Button)findViewById(R.id.rees);
        aboutus=(Button)findViewById(R.id.about_button);
        b1=(Button)findViewById(R.id.btn_mulonl);
       // t1=(TextView)findViewById(R.id.tv_check);



        if (haveNetwork()) {


            firebaseAuth = FirebaseAuth.getInstance();
            rootRef = FirebaseDatabase.getInstance().getReference();

            progressDialog = new ProgressDialog(New_Game.this);
            progressDialog.setTitle("Your Account");
            progressDialog.setMessage("Loading");
            progressDialog.show();
            fl=1;

            progressDialog.setCanceledOnTouchOutside(false);
            progressDialog.setCancelable(false);

            FirebaseUser user = firebaseAuth.getCurrentUser();
            if (user == null) {
                progressDialog.dismiss();
                a=1;
                startActivity(new Intent(New_Game.this, RegisterActivity.class));
                finish();

            }

            else {
                String currentUser = firebaseAuth.getCurrentUser().getUid();
                USerID=currentUser;
                demoRef = rootRef.child("Users").child(currentUser);

                demoRef.child("name").addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        final String value = dataSnapshot.getValue(String.class);

                        if (value != null) {
                            Toast.makeText(New_Game.this, "All Perfect", Toast.LENGTH_SHORT).show();
                            if(v==0) {
                                if (media == null) {
                                    media = MediaPlayer.create(New_Game.this, R.raw.safe);
                                    if (!media.isPlaying()) {
                                        media.start();
                                        media.setLooping(true);
                                    }
                                }
                            }
                            fl=0;
                            Username = value;
                            progressDialog.dismiss();


                            demoRef.child("age").addValueEventListener(new ValueEventListener() {
                                @Override
                                public void onDataChange(DataSnapshot dataSnapshot) {
                                    USerAge = dataSnapshot.getValue(String.class);

                                }
                                @Override
                                public void onCancelled(DatabaseError databaseError) {
                                    Toast.makeText(New_Game.this,"Check your Internet Connection",Toast.LENGTH_SHORT).show();
                                }
                            });
                            demoRef.child("Image").addValueEventListener(new ValueEventListener() {
                                @Override
                                public void onDataChange(DataSnapshot dataSnapshot) {
                                    imageurl = dataSnapshot.getValue(String.class);
                                }
                                @Override
                                public void onCancelled(DatabaseError databaseError) {
                                    Toast.makeText(New_Game.this,"Check your Internet Connection",Toast.LENGTH_SHORT).show();
                                }
                            });





                            //   Thread t=new Thread(){


                            //   @Override
                            // public void run(){

                            //   while(!isInterrupted()){

                            //     try {
                            //       Thread.sleep(5000);  //1000ms = 1 sec

                            //     runOnUiThread(new Runnable() {

                            //   @Override
                            //    public void run() {

                            //           t1.setText(String.valueOf(count));

                            //         demoRef.child("Multiplayer").addValueEventListener(new ValueEventListener() {
                            //           @Override
                            //         public void onDataChange(DataSnapshot dataSnapshot) {
                            //            value1 = dataSnapshot.getValue(String.class);
                            //          String online="Online";



                            //       if (value1 == online) {
                            //  value1 = "0";
                            //  demoRef.child("Multiplayer").setValue("0");

                            // finish();
                            // startActivity(new Intent(New_Game.this,Userlist_Activity.class));
                            //         b1.setText("satisfied");
                            //       t1.setText("satisfied");



                            // }
                            //  else if(value1=="offline"){
                            //    b1.setText("not satisfied");
                            //  t1.setText("not satisfied");
                            //   }
                            //   else{
                            //     b1.setText(value1);
                            //    t1.setText(online);
                            //    }
                            //  }


                            //   @Override
                            //    public void onCancelled(DatabaseError databaseError) {
                            //      Toast.makeText(New_Game.this, "Check your Internet Connection", Toast.LENGTH_SHORT).show();
                            //    finish();
                            //    }
                            //    });



                            //                   }
                            //             });

                            //       } catch (InterruptedException e) {
                            //         e.printStackTrace();
                            //   }

                            //                       }
                            //                 }
                            //           };

                            //         t.start();
                            //       if(value1==){
                            //         t.stop();
                            //   }
                        }
                        else {
                            a=1;
                            progressDialog.dismiss();
                            startActivity(new Intent(New_Game.this, Profile.class));
                            finish();

                        }
                    }


                    @Override
                    public void onCancelled(DatabaseError databaseError) {
                        Toast.makeText(New_Game.this, "Check your Internet Connection", Toast.LENGTH_SHORT).show();
                        finish();
                    }
                });
            }

            profile.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    a=1;
                    startActivity(new Intent(New_Game.this, DetailsActivity.class));
                }
            });

            newgame.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    a=1;
                    startActivity(new Intent(New_Game.this, Gameoptions.class));
                }
            });
            aboutus.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    a=1;
                    startActivity(new Intent(New_Game.this,About_us.class));
                    finish();
                }
            });
            resume1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    a=1;
                    startActivity(new Intent(New_Game.this,Rules.class));
                    finish();
                }
            });

            b1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    a=1;
                    startActivity(new Intent(New_Game.this,Multiplayer.class));
                }
            });









            //Called each time when 1000 milliseconds (1 second) (the period parameter)

        }
        else

        {
            Toast.makeText(New_Game.this, "Check your Internet Connection", Toast.LENGTH_SHORT).show();
            finish();
        }

    }


    @Override
    public void onBackPressed() {
        if (fl == 1) {

        } else {
            Exit();
        }
    }
    public void Button(){


    }

    public void Exit() {
        final AlertDialog.Builder builder = new AlertDialog.Builder(New_Game.this);
        builder.setMessage("Are you Sure you Want to Exit");
        builder.setCancelable(true);
        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                moveTaskToBack(true);
                android.os.Process.killProcess(android.os.Process.myPid());
                System.exit(1);
                finish();
            }
        });
        AlertDialog alertDialog = builder.create();
        alertDialog.show();
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
    public void data(){


    }
    @Override
    public void onStart() {
        super.onStart();


    }
    @Override
    protected void onUserLeaveHint() {
        super.onUserLeaveHint();
        if(a==1){
            a=0;
        }
        else if(fl==1){
            v=1;
        }
        else{
            if(media.isPlaying()) {
                media.stop();
            }
            else if(About_us.medi.isPlaying()){
                About_us.medi.stop();
            }
            b=1;
        }

    }
    @Override
    protected void onResume(){
        super.onResume();
        if(b==1){
            Toast.makeText(New_Game.this, "Check your Internet Connection", Toast.LENGTH_SHORT).show();
            media = MediaPlayer.create(New_Game.this, R.raw.safe);
            media.start();
            media.setLooping(true);
            b=0;
        }

    }
}
