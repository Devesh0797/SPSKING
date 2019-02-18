package sps_king.devesh.com.spsking;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Handler;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class Room_Activity extends Activity {

    private DatabaseReference rootRef, demoRef;
    private DatabaseReference rootRef1, demoRef1,mdata;
    private Handler handler = new Handler();
    private ImageView b1,b2,b3;
    private int Round=1;
    private int x=0;
    private int y=0;
    private int z=0;
    public static String player;
    public String fg;
    private int a=0,b=0;

    private RecyclerView mRecyclerView;
    private ResultAdapter mAdapter;
    private DatabaseReference mDatabaseRef;
    private List<ResultDatabase> mUploads;
    private int r1=0,r2=0,r3=0;
    private String pla1,pla2;
    private TextView t1,t2,t3;
    private TextView y1,y2;


    ProgressDialog progressDialog;
    ProgressDialog progressDialog1;
    ProgressDialog progressDialog2;
    //Player1 send request

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_room_);



        b1 = (ImageView) findViewById(R.id.rock);
        b2 = (ImageView) findViewById(R.id.paper);
        b3 = (ImageView) findViewById(R.id.scissor);

        b1.setImageResource(R.drawable.hand);
        b2.setImageResource(R.drawable.hand1);
        b3.setImageResource(R.drawable.hand2);

        t1=(TextView)findViewById(R.id.tv_wincr);
        t2=(TextView)findViewById(R.id.tv_loosecr);
        t3=(TextView)findViewById(R.id.tv_drawcr);

        y1=(TextView)findViewById(R.id.tv_totalro);
        y2=(TextView)findViewById(R.id.tv_noround);


       // b1.setText(RoundActivity.ren);



        player="player1";


        progressDialog= new ProgressDialog(Room_Activity.this);
        progressDialog.setTitle("WAITING");
        progressDialog.setMessage("Waiting For Your Competitor To Join");

        progressDialog2= new ProgressDialog(Room_Activity.this);
        progressDialog2.setTitle("Analysing");
        progressDialog2.setMessage(" Storing Your Choice ");

        progressDialog1= new ProgressDialog(Room_Activity.this);
        progressDialog1.setTitle("Analysis");
        progressDialog1.setMessage("Get Ready for your next round");

        progressDialog.setCanceledOnTouchOutside(false);
        progressDialog.setCancelable(false);
        progressDialog2.setCanceledOnTouchOutside(false);
        progressDialog2.setCancelable(false);
        progressDialog1.setCanceledOnTouchOutside(false);
        progressDialog1.setCancelable(false);

        String Competitior = getIntent().getStringExtra("userID");
        rootRef = FirebaseDatabase.getInstance().getReference();
        String game = New_Game.USerID + "-" + Competitior;
        fg=game;
        demoRef = rootRef.child("Users").child(Competitior);
        demoRef.child("Multiplayer").setValue("online");
        demoRef.child("Competitor").setValue(New_Game.USerID);


        rootRef1 = FirebaseDatabase.getInstance().getReference();
        demoRef1 = rootRef1.child("Multiplayer").child(game);
        demoRef1.child("Waiting").setValue("0.5");
        demoRef1.child("Rounds").setValue(RoundActivity.ren);
        demoRef1.child("Player1").setValue("0");

        mRecyclerView = (RecyclerView)findViewById(R.id.rec_resuly);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(Room_Activity.this));
        mUploads = new ArrayList<>();
        mDatabaseRef = FirebaseDatabase.getInstance().getReference("Multiplayer").child(game).child("Score");

        handler.postDelayed(mToastRunnable, 200);
        // demoRef1.child("Round 1").child("Waiting").setValue("0.5");


        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String round="Round"+Round;
                demoRef1.child("Score").child(round).child("Player1").setValue("1");
                demoRef1.child(round).child("Player1").setValue("1");


                if(x==0) {

                    progressDialog2.show();
                    handler.postDelayed(Stone, 1000);
                }
                else if(x==1){
                    progressDialog2.show();
                    handler.postDelayed(Stone1, 1000);
                }
                else if(x==2){
                    progressDialog2.show();
                    handler.postDelayed(Stone2, 1000);
                }
                else if(x==3){
                    progressDialog2.show();
                    handler.postDelayed(Stone3, 1000);
                }
                else if(x==4){
                    progressDialog2.show();
                    handler.postDelayed(Stone4, 1000);
                }
                else if(x==5){
                    progressDialog2.show();
                    handler.postDelayed(Stone5, 1000);
                }
                else if(x==6){
                    progressDialog2.show();
                    handler.postDelayed(Stone6, 1000);
                }
                else if(x==7){
                    progressDialog2.show();
                    handler.postDelayed(Stone7, 1000);
                }
                else if(x==8){
                    progressDialog2.show();
                    handler.postDelayed(Stone8, 1000);
                }
                else if(x==9){
                    progressDialog2.show();
                    handler.postDelayed(Stone9, 1000);
                }



            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String round="Round"+Round;
                demoRef1.child("Score").child(round).child("Player1").setValue("2");
                demoRef1.child(round).child("Player1").setValue("2");


                if(x==0) {
                    progressDialog2.show();
                    handler.postDelayed(Stone, 1000);
                }
                else if(x==1){
                    progressDialog2.show();
                    handler.postDelayed(Stone1, 1000);
                }
                else if(x==2){
                    progressDialog2.show();
                    handler.postDelayed(Stone2, 1000);
                }
                else if(x==3){
                    progressDialog2.show();
                    handler.postDelayed(Stone3, 1000);
                }
                else if(x==4){
                    progressDialog2.show();
                    handler.postDelayed(Stone4, 1000);
                }
                else if(x==5){
                    progressDialog2.show();
                    handler.postDelayed(Stone5, 1000);
                }
                else if(x==6){
                    progressDialog2.show();
                    handler.postDelayed(Stone6, 1000);
                }
                else if(x==7){
                    progressDialog2.show();
                    handler.postDelayed(Stone7, 1000);
                }
                else if(x==8){
                    progressDialog2.show();
                    handler.postDelayed(Stone8, 1000);
                }
                else if(x==9){
                    progressDialog2.show();
                    handler.postDelayed(Stone9, 1000);
                }
            }
        });

        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String round="Round"+Round;
                demoRef1.child("Score").child(round).child("Player1").setValue("3");
                demoRef1.child(round).child("Player1").setValue("3");


                if(x==0) {
                    progressDialog2.show();
                    handler.postDelayed(Stone, 1000);
                }
                else if(x==1){
                    progressDialog2.show();
                    handler.postDelayed(Stone1, 1000);
                }
                else if(x==2){
                    progressDialog2.show();
                    handler.postDelayed(Stone2, 1000);
                }
                else if(x==3){
                    progressDialog2.show();
                    handler.postDelayed(Stone3, 1000);
                }
                else if(x==4){
                    progressDialog2.show();
                    handler.postDelayed(Stone4, 1000);
                }
                else if(x==5){
                    progressDialog2.show();
                    handler.postDelayed(Stone5, 1000);
                }
                else if(x==6){
                    progressDialog2.show();
                    handler.postDelayed(Stone6, 1000);
                }
                else if(x==7){
                    progressDialog2.show();
                    handler.postDelayed(Stone7, 1000);
                }
                else if(x==8){
                    progressDialog2.show();
                    handler.postDelayed(Stone8, 1000);
                }
                else if(x==9){
                    progressDialog2.show();
                    handler.postDelayed(Stone9, 1000);
                }
            }
        });

    }

    private Runnable mToastRunnable = new Runnable() {
        @Override
        public void run() {
            progressDialog.show();

            demoRef1.child("Waiting").addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    String value = dataSnapshot.getValue(String.class);

                    if(value.equals("1")){
                        String round="Round"+Round;
                        progressDialog.dismiss();
                        demoRef1.child("Waiting").setValue("Done");
                        demoRef1.child(round).child("Waiting").setValue("0.5");
                        demoRef1.child(round).child("Sender").setValue("0");
                        y1.setText("Total Rounds:-" + String.valueOf(RoundActivity.ren));
                        y2.setText("Round Number:-" + String.valueOf(Round));
                    }
                    else if(value.equals("Done")){
                        progressDialog.dismiss();

                    }
                    else{
                        handler.postDelayed(mToastRunnable, 200);
                    }
                }
                @Override
                public void onCancelled(DatabaseError databaseError) {
                    Toast.makeText(Room_Activity.this, "Check your Internet Connection", Toast.LENGTH_SHORT).show();
                    finish();
                }
            });
        }
    };

    private Runnable Stone = new Runnable() {
        @Override
        public void run() {



            final String round="Round"+Round;
            demoRef1.child(round).child("finish").addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    String value = dataSnapshot.getValue(String.class);

                    if(x==0) {
                        if (value.equals("0")) {
                            demoRef1.child(round).child("finish").setValue("0.5");
                            demoRef1.child(round).child("Sender").setValue("1");
                            Round++;
                            progressDialog2.dismiss();
                            String round="Round" + Round;
                            demoRef1.child(round).child("Waiting").setValue("0.5");
                            demoRef1.child(round).child("finish").setValue("0");
                            demoRef1.child(round).child("Sender").setValue("0");
                            handler.postDelayed(Check, 200);
                            Round--;
                            x++;

                        } else if (value.equals("0.5")) {
                            demoRef1.child(round).child("finish").setValue("Done");
                            demoRef1.child(round).child("Sender").setValue("1");
                            Round++;
                            x++;
                            progressDialog2.dismiss();
                            String round1 = "Round" + Round;
                            demoRef1.child(round1).child("Waiting").setValue("Done");
                            demoRef1.child(round1).child("Sender").setValue("0");
                            handler.postDelayed(Check,200);
                            Round--;
                        }
                    }

                }
                @Override
                public void onCancelled(DatabaseError databaseError) {
                    Toast.makeText(Room_Activity.this, "Check your Internet Connection", Toast.LENGTH_SHORT).show();
                    finish();
                }
            });
        }
    };

    private Runnable Check = new Runnable() {
        @Override
        public void run() {
            if(z==0) {
                progressDialog1.show();
                z++;
            }

            final String round="Round"+Round;
            demoRef1.child(round).child("finish").addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    String value = dataSnapshot.getValue(String.class);

                    if(y==0) {
                        if (value.equals("0.5")) {
                            handler.postDelayed(Check, 200);


                            //progressDialog2.dismiss();
                        } else if (value.equals("Done")) {
                            progressDialog1.dismiss();

                            y++;
                            Round++;
                            y2.setText("Round Number:-" + String.valueOf(Round));
                            //handler.postDelayed(mToastRunnable,200);
                        }
                    }
                }
                @Override
                public void onCancelled(DatabaseError databaseError) {
                    Toast.makeText(Room_Activity.this, "Check your Internet Connection", Toast.LENGTH_SHORT).show();
                    finish();
                }
            });
        }
    };

    private Runnable Stone1 = new Runnable() {
        @Override
        public void run() {


            final String round="Round"+Round;
            demoRef1.child(round).child("finish").addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    String value = dataSnapshot.getValue(String.class);

                    if(x==1) {
                        if (value.equals("0")) {
                            demoRef1.child(round).child("finish").setValue("0.5");
                            demoRef1.child(round).child("Sender").setValue("1");
                            Round++;
                            progressDialog2.dismiss();
                            String round="Round" + Round;
                            demoRef1.child(round).child("Waiting").setValue("0.5");
                            demoRef1.child(round).child("finish").setValue("0");
                            demoRef1.child(round).child("Sender").setValue("0");
                            handler.postDelayed(Check1, 200);
                            Round--;
                            x++;

                        } else if (value.equals("0.5")) {
                            demoRef1.child(round).child("finish").setValue("Done");
                            demoRef1.child(round).child("Sender").setValue("1");
                            Round++;
                            x++;
                            progressDialog2.dismiss();
                            String round1 = "Round" + Round;
                            demoRef1.child(round1).child("Waiting").setValue("Done");
                            demoRef1.child(round1).child("Sender").setValue("0");
                            Round--;
                            handler.postDelayed(Check1,200);
                        }
                    }
                }
                @Override
                public void onCancelled(DatabaseError databaseError) {
                    Toast.makeText(Room_Activity.this, "Check your Internet Connection", Toast.LENGTH_SHORT).show();
                    finish();
                }
            });
        }
    };

    private Runnable Check1 = new Runnable() {
        @Override
        public void run() {
            if(z==1) {
                progressDialog1.show();
                z++;
            }

            final String round="Round"+Round;
            demoRef1.child(round).child("finish").addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    String value = dataSnapshot.getValue(String.class);

                    if(y==1) {
                        if (value.equals("0.5")) {
                            handler.postDelayed(Check1, 200);


                            //progressDialog2.dismiss();
                        } else if (value.equals("Done")) {
                            progressDialog1.dismiss();

                            y++;




                            Round++;
                            y2.setText("Round Number:-" + String.valueOf(Round));
                            //handler.postDelayed(mToastRunnable,200);

                        }
                    }
                }
                @Override
                public void onCancelled(DatabaseError databaseError) {
                    Toast.makeText(Room_Activity.this, "Check your Internet Connection", Toast.LENGTH_SHORT).show();
                    finish();
                }
            });
        }
    };

    private Runnable Stone2 = new Runnable() {
        @Override
        public void run() {
            final String round="Round"+Round;
            demoRef1.child(round).child("finish").addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    String value = dataSnapshot.getValue(String.class);

                    if(x==2) {
                        if (value.equals("0")) {
                            demoRef1.child(round).child("finish").setValue("0.5");
                            demoRef1.child(round).child("Sender").setValue("1");
                            Round++;
                            progressDialog2.dismiss();
                            String round="Round" + Round;
                            demoRef1.child(round).child("Waiting").setValue("0.5");
                            demoRef1.child(round).child("finish").setValue("0");
                            demoRef1.child(round).child("Sender").setValue("0");
                            handler.postDelayed(Check2, 200);
                            Round--;
                            x++;

                        } else if (value.equals("0.5")) {
                            demoRef1.child(round).child("finish").setValue("Done");
                            demoRef1.child(round).child("Sender").setValue("0");
                            Round++;
                            x++;
                            progressDialog2.dismiss();
                            String round1 = "Round" + Round;
                            demoRef1.child(round1).child("Waiting").setValue("Done");
                            demoRef1.child(round1).child("Sender").setValue("0");
                           handler.postDelayed(Check2,200);
                           Round--;
                        }
                    }

                }
                @Override
                public void onCancelled(DatabaseError databaseError) {
                    Toast.makeText(Room_Activity.this, "Check your Internet Connection", Toast.LENGTH_SHORT).show();
                    finish();
                }
            });
        }
    };



    private Runnable Check2 = new Runnable() {
        @Override
        public void run() {
            if(z==2) {
                progressDialog1.show();
                z++;
            }

            final String round="Round"+Round;
            demoRef1.child(round).child("finish").addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    String value = dataSnapshot.getValue(String.class);

                    if(y==2) {
                        if (value.equals("0.5")) {
                            handler.postDelayed(Check2, 200);

                            //progressDialog2.dismiss();
                        } else if (value.equals("Done")) {
                            progressDialog1.dismiss();

                            y++;

                            if(RoundActivity.ren.equals("3")) {
                                y2.setVisibility(View.GONE);
                                y1.setVisibility(View.GONE);

                                mDatabaseRef.addValueEventListener(new ValueEventListener() {
                                    @Override
                                    public void onDataChange(DataSnapshot dataSnapshot) {
                                        for (DataSnapshot postSnapshot : dataSnapshot.getChildren()) {
                                            ResultDatabase resultDatabase = postSnapshot.getValue(ResultDatabase.class);
                                            pla1=resultDatabase.getPlayer1();
                                            pla2=resultDatabase.getPlayer2();
                                            result2(pla1,pla2);
                                            mUploads.add(resultDatabase);

                                        }


                                        mAdapter = new ResultAdapter(Room_Activity.this, mUploads);
                                        mRecyclerView.setAdapter(mAdapter);
                                        t1.setText(String.valueOf(r1));
                                        t2.setText(String.valueOf(r2));
                                        t3.setText(String.valueOf(r3));

                                        //mProgressCircle.setVisibility(View.INVISIBLE);


                                    }

                                    @Override
                                    public void onCancelled(DatabaseError databaseError) {
                                        Toast.makeText(Room_Activity.this, databaseError.getMessage(), Toast.LENGTH_SHORT).show();
                                        //mProgressCircle.setVisibility(View.INVISIBLE);
                                    }
                                });
                            }


                            Round++;
                            y2.setText("Round Number:-" + String.valueOf(Round));
                          //  startActivity(new Intent(Room_Activity.this,New_Game.class));
                          //  finish();
                            //handler.postDelayed(mToastRunnable,200);

                        }

                    }
                }
                @Override
                public void onCancelled(DatabaseError databaseError) {
                    Toast.makeText(Room_Activity.this, "Check your Internet Connection", Toast.LENGTH_SHORT).show();
                    finish();
                }
            });
        }
    };

    private Runnable Stone3 = new Runnable() {
        @Override
        public void run() {



            final String round="Round"+Round;
            demoRef1.child(round).child("finish").addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    String value = dataSnapshot.getValue(String.class);

                    if(x==3) {
                        if (value.equals("0")) {
                            demoRef1.child(round).child("finish").setValue("0.5");
                            demoRef1.child(round).child("Sender").setValue("1");
                            Round++;
                            progressDialog2.dismiss();
                            String round="Round" + Round;
                            demoRef1.child(round).child("Waiting").setValue("0.5");
                            demoRef1.child(round).child("finish").setValue("0");
                            demoRef1.child(round).child("Sender").setValue("0");
                            handler.postDelayed(Check3, 200);
                            Round--;
                            x++;

                        } else if (value.equals("0.5")) {
                            demoRef1.child(round).child("finish").setValue("Done");
                            demoRef1.child(round).child("Sender").setValue("0");
                            Round++;
                            x++;
                            progressDialog2.dismiss();
                            String round1 = "Round" + Round;
                            demoRef1.child(round1).child("Waiting").setValue("Done");
                            demoRef1.child(round1).child("Sender").setValue("0");
                            handler.postDelayed(Check3,200);
                            Round--;
                        }
                    }

                }
                @Override
                public void onCancelled(DatabaseError databaseError) {
                    Toast.makeText(Room_Activity.this, "Check your Internet Connection", Toast.LENGTH_SHORT).show();
                    finish();
                }
            });
        }
    };



    private Runnable Check3 = new Runnable() {
        @Override
        public void run() {
            if(z==3) {
                progressDialog1.show();
                z++;
            }

            final String round="Round"+Round;
            demoRef1.child(round).child("finish").addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    String value = dataSnapshot.getValue(String.class);

                    if(y==3) {
                        if (value.equals("0.5")) {
                            handler.postDelayed(Check3, 200);

                            //progressDialog2.dismiss();
                        } else if (value.equals("Done")) {
                            progressDialog1.dismiss();

                            y++;
                            Round++;
                            y2.setText("Round Number:-" + String.valueOf(Round));


                        }

                    }
                }
                @Override
                public void onCancelled(DatabaseError databaseError) {
                    Toast.makeText(Room_Activity.this, "Check your Internet Connection", Toast.LENGTH_SHORT).show();
                    finish();
                }
            });
        }
    };

    private Runnable Stone4 = new Runnable() {
        @Override
        public void run() {
            final String round="Round"+Round;
            demoRef1.child(round).child("finish").addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    String value = dataSnapshot.getValue(String.class);

                    if(x==4) {
                        if (value.equals("0")) {
                            demoRef1.child(round).child("finish").setValue("0.5");
                            demoRef1.child(round).child("Sender").setValue("1");
                            Round++;
                            progressDialog2.dismiss();
                            String round="Round" + Round;
                            demoRef1.child(round).child("Waiting").setValue("0.5");
                            demoRef1.child(round).child("finish").setValue("0");
                            demoRef1.child(round).child("Sender").setValue("0");
                            handler.postDelayed(Check4, 200);
                            Round--;
                            x++;

                        } else if (value.equals("0.5")) {
                            demoRef1.child(round).child("finish").setValue("Done");
                            demoRef1.child(round).child("Sender").setValue("0");
                            Round++;
                            x++;
                            progressDialog2.dismiss();
                            String round1 = "Round" + Round;
                            demoRef1.child(round1).child("Waiting").setValue("Done");
                            demoRef1.child(round1).child("Sender").setValue("0");
                            handler.postDelayed(Check4,200);
                            Round--;
                        }
                    }

                }
                @Override
                public void onCancelled(DatabaseError databaseError) {
                    Toast.makeText(Room_Activity.this, "Check your Internet Connection", Toast.LENGTH_SHORT).show();
                    finish();
                }
            });
        }
    };



    private Runnable Check4 = new Runnable() {
        @Override
        public void run() {
            if(z==4) {
                progressDialog1.show();
                z++;
            }

            final String round="Round"+Round;
            demoRef1.child(round).child("finish").addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    String value = dataSnapshot.getValue(String.class);

                    if(y==4) {
                        if (value.equals("0.5")) {
                            handler.postDelayed(Check4, 200);

                            //progressDialog2.dismiss();
                        } else if (value.equals("Done")) {
                            progressDialog1.dismiss();

                            y++;
                            if(RoundActivity.ren.equals("5")) {
                                y2.setVisibility(View.GONE);
                                y1.setVisibility(View.GONE);

                                mDatabaseRef.addValueEventListener(new ValueEventListener() {
                                    @Override
                                    public void onDataChange(DataSnapshot dataSnapshot) {
                                        for (DataSnapshot postSnapshot : dataSnapshot.getChildren()) {
                                            ResultDatabase resultDatabase = postSnapshot.getValue(ResultDatabase.class);
                                            pla1=resultDatabase.getPlayer1();
                                            pla2=resultDatabase.getPlayer2();
                                            result2(pla1,pla2);
                                            mUploads.add(resultDatabase);

                                        }


                                        mAdapter = new ResultAdapter(Room_Activity.this, mUploads);
                                        t1.setText(String.valueOf(r1));
                                        t2.setText(String.valueOf(r2));
                                        t3.setText(String.valueOf(r3));

                                        mRecyclerView.setAdapter(mAdapter);
                                        //mProgressCircle.setVisibility(View.INVISIBLE);


                                    }

                                    @Override
                                    public void onCancelled(DatabaseError databaseError) {
                                        Toast.makeText(Room_Activity.this, databaseError.getMessage(), Toast.LENGTH_SHORT).show();
                                        //mProgressCircle.setVisibility(View.INVISIBLE);
                                    }
                                });
                            }

                            Round++;
                            y2.setText("Round Number:-" + String.valueOf(Round));


                        }

                    }
                }
                @Override
                public void onCancelled(DatabaseError databaseError) {
                    Toast.makeText(Room_Activity.this, "Check your Internet Connection", Toast.LENGTH_SHORT).show();
                    finish();
                }
            });
        }
    };

    private Runnable Stone5 = new Runnable() {
        @Override
        public void run() {



            final String round="Round"+Round;
            demoRef1.child(round).child("finish").addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    String value = dataSnapshot.getValue(String.class);

                    if(x==5) {
                        if (value.equals("0")) {
                            demoRef1.child(round).child("finish").setValue("0.5");
                            demoRef1.child(round).child("Sender").setValue("1");
                            Round++;
                            progressDialog2.dismiss();
                            String round="Round" + Round;
                            demoRef1.child(round).child("Waiting").setValue("0.5");
                            demoRef1.child(round).child("finish").setValue("0");
                            demoRef1.child(round).child("Sender").setValue("0");
                            handler.postDelayed(Check5, 200);
                            Round--;
                            x++;

                        } else if (value.equals("0.5")) {
                            demoRef1.child(round).child("finish").setValue("Done");
                            demoRef1.child(round).child("Sender").setValue("0");
                            Round++;
                            x++;
                            progressDialog2.dismiss();
                            String round1 = "Round" + Round;
                            demoRef1.child(round1).child("Waiting").setValue("Done");
                            demoRef1.child(round1).child("Sender").setValue("0");
                            handler.postDelayed(Check5,200);
                            Round--;
                        }
                    }

                }
                @Override
                public void onCancelled(DatabaseError databaseError) {
                    Toast.makeText(Room_Activity.this, "Check your Internet Connection", Toast.LENGTH_SHORT).show();
                    finish();
                }
            });
        }
    };



    private Runnable Check5 = new Runnable() {
        @Override
        public void run() {
            if(z==5) {
                progressDialog1.show();
                z++;
            }

            final String round="Round"+Round;
            demoRef1.child(round).child("finish").addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    String value = dataSnapshot.getValue(String.class);

                    if(y==5) {
                        if (value.equals("0.5")) {
                            handler.postDelayed(Check5, 200);

                            //progressDialog2.dismiss();
                        } else if (value.equals("Done")) {
                            progressDialog1.dismiss();

                            y++;
                            Round++;
                            y2.setText("Round Number:-" + String.valueOf(Round));


                        }

                    }
                }
                @Override
                public void onCancelled(DatabaseError databaseError) {
                    Toast.makeText(Room_Activity.this, "Check your Internet Connection", Toast.LENGTH_SHORT).show();
                    finish();
                }
            });
        }
    };

    private Runnable Stone6 = new Runnable() {
        @Override
        public void run() {



            final String round="Round"+Round;
            demoRef1.child(round).child("finish").addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    String value = dataSnapshot.getValue(String.class);

                    if(x==6) {
                        if (value.equals("0")) {
                            demoRef1.child(round).child("finish").setValue("0.5");
                            demoRef1.child(round).child("Sender").setValue("1");
                            Round++;
                            progressDialog2.dismiss();
                            String round="Round" + Round;
                            demoRef1.child(round).child("Waiting").setValue("0.5");
                            demoRef1.child(round).child("finish").setValue("0");
                            demoRef1.child(round).child("Sender").setValue("0");
                            handler.postDelayed(Check6, 200);
                            Round--;
                            x++;

                        } else if (value.equals("0.5")) {
                            demoRef1.child(round).child("finish").setValue("Done");
                            demoRef1.child(round).child("Sender").setValue("0");
                            Round++;
                            x++;
                            progressDialog2.dismiss();
                            String round1 = "Round" + Round;
                            demoRef1.child(round1).child("Waiting").setValue("Done");
                            demoRef1.child(round1).child("Sender").setValue("0");
                            handler.postDelayed(Check6,200);
                            Round--;
                        }
                    }

                }
                @Override
                public void onCancelled(DatabaseError databaseError) {
                    Toast.makeText(Room_Activity.this, "Check your Internet Connection", Toast.LENGTH_SHORT).show();
                    finish();
                }
            });
        }
    };



    private Runnable Check6 = new Runnable() {
        @Override
        public void run() {
            if(z==6) {
                progressDialog1.show();
                z++;
            }

            final String round="Round"+Round;
            demoRef1.child(round).child("finish").addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    String value = dataSnapshot.getValue(String.class);

                    if(y==6) {
                        if (value.equals("0.5")) {
                            handler.postDelayed(Check6, 200);

                            //progressDialog2.dismiss();
                        } else if (value.equals("Done")) {
                            progressDialog1.dismiss();

                            y++;
                            Round++;
                            y2.setText("Round Number:-" + String.valueOf(Round));


                        }

                    }
                }
                @Override
                public void onCancelled(DatabaseError databaseError) {
                    Toast.makeText(Room_Activity.this, "Check your Internet Connection", Toast.LENGTH_SHORT).show();
                    finish();
                }
            });
        }
    };

    private Runnable Stone7 = new Runnable() {
        @Override
        public void run() {



            final String round="Round"+Round;
            demoRef1.child(round).child("finish").addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    String value = dataSnapshot.getValue(String.class);

                    if(x==7) {
                        if (value.equals("0")) {
                            demoRef1.child(round).child("finish").setValue("0.5");
                            demoRef1.child(round).child("Sender").setValue("1");
                            Round++;
                            progressDialog2.dismiss();
                            String round="Round" + Round;
                            demoRef1.child(round).child("Waiting").setValue("0.5");
                            demoRef1.child(round).child("finish").setValue("0");
                            demoRef1.child(round).child("Sender").setValue("0");
                            handler.postDelayed(Check7, 200);
                            Round--;
                            x++;

                        } else if (value.equals("0.5")) {
                            demoRef1.child(round).child("finish").setValue("Done");
                            demoRef1.child(round).child("Sender").setValue("0");
                            Round++;
                            x++;
                            progressDialog2.dismiss();
                            String round1 = "Round" + Round;
                            demoRef1.child(round1).child("Waiting").setValue("Done");
                            demoRef1.child(round1).child("Sender").setValue("0");
                            handler.postDelayed(Check7,200);
                            Round--;
                        }
                    }

                }
                @Override
                public void onCancelled(DatabaseError databaseError) {
                    Toast.makeText(Room_Activity.this, "Check your Internet Connection", Toast.LENGTH_SHORT).show();
                    finish();
                }
            });
        }
    };



    private Runnable Check7 = new Runnable() {
        @Override
        public void run() {
            if(z==7) {
                progressDialog1.show();
                z++;
            }

            final String round="Round"+Round;
            demoRef1.child(round).child("finish").addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    String value = dataSnapshot.getValue(String.class);

                    if(y==7) {
                        if (value.equals("0.5")) {
                            handler.postDelayed(Check7, 200);

                            //progressDialog2.dismiss();
                        } else if (value.equals("Done")) {
                            progressDialog1.dismiss();

                            y++;
                            Round++;
                            y2.setText("Round Number:-" + String.valueOf(Round));

                        }

                    }
                }
                @Override
                public void onCancelled(DatabaseError databaseError) {
                    Toast.makeText(Room_Activity.this, "Check your Internet Connection", Toast.LENGTH_SHORT).show();
                    finish();
                }
            });
        }
    };

    private Runnable Stone8 = new Runnable() {
        @Override
        public void run() {



            final String round="Round"+Round;
            demoRef1.child(round).child("finish").addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    String value = dataSnapshot.getValue(String.class);

                    if(x==8) {
                        if (value.equals("0")) {
                            demoRef1.child(round).child("finish").setValue("0.5");
                            demoRef1.child(round).child("Sender").setValue("1");
                            Round++;
                            progressDialog2.dismiss();
                            String round="Round" + Round;
                            demoRef1.child(round).child("Waiting").setValue("0.5");
                            demoRef1.child(round).child("finish").setValue("0");
                            demoRef1.child(round).child("Sender").setValue("0");
                            handler.postDelayed(Check8, 200);
                            Round--;
                            x++;

                        } else if (value.equals("0.5")) {
                            demoRef1.child(round).child("finish").setValue("Done");
                            demoRef1.child(round).child("Sender").setValue("0");
                            Round++;
                            x++;
                            progressDialog2.dismiss();
                            String round1 = "Round" + Round;
                            demoRef1.child(round1).child("Waiting").setValue("Done");
                            demoRef1.child(round1).child("Sender").setValue("0");
                            handler.postDelayed(Check8,200);
                            Round--;
                        }
                    }

                }
                @Override
                public void onCancelled(DatabaseError databaseError) {
                    Toast.makeText(Room_Activity.this, "Check your Internet Connection", Toast.LENGTH_SHORT).show();
                    finish();
                }
            });
        }
    };



    private Runnable Check8 = new Runnable() {
        @Override
        public void run() {
            if(z==8) {
                progressDialog1.show();
                z++;
            }

            final String round="Round"+Round;
            demoRef1.child(round).child("finish").addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    String value = dataSnapshot.getValue(String.class);

                    if(y==8) {
                        if (value.equals("0.5")) {
                            handler.postDelayed(Check8, 200);

                            //progressDialog2.dismiss();
                        } else if (value.equals("Done")) {
                            progressDialog1.dismiss();

                            y++;
                            Round++;
                            y2.setText("Round Number:-" + String.valueOf(Round));


                        }

                    }
                }
                @Override
                public void onCancelled(DatabaseError databaseError) {
                    Toast.makeText(Room_Activity.this, "Check your Internet Connection", Toast.LENGTH_SHORT).show();
                    finish();
                }
            });
        }
    };


    private Runnable Stone9 = new Runnable() {
        @Override
        public void run() {



            final String round="Round"+Round;
            demoRef1.child(round).child("finish").addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    String value = dataSnapshot.getValue(String.class);

                    if(x==9) {
                        if (value.equals("0")) {
                            demoRef1.child(round).child("finish").setValue("0.5");
                            demoRef1.child(round).child("Sender").setValue("1");
                            Round++;
                            progressDialog2.dismiss();
                            String round="Round" + Round;
                            demoRef1.child(round).child("Waiting").setValue("0.5");
                            demoRef1.child(round).child("finish").setValue("0");
                            demoRef1.child(round).child("Sender").setValue("0");
                            handler.postDelayed(Check9, 200);
                            Round--;
                            x++;

                        } else if (value.equals("0.5")) {
                            demoRef1.child(round).child("finish").setValue("Done");
                            demoRef1.child(round).child("Sender").setValue("0");
                            Round++;
                            x++;
                            progressDialog2.dismiss();
                            String round1 = "Round" + Round;
                            demoRef1.child(round1).child("Waiting").setValue("Done");
                            demoRef1.child(round1).child("Sender").setValue("0");
                            handler.postDelayed(Check9,200);
                            Round--;
                        }
                    }

                }
                @Override
                public void onCancelled(DatabaseError databaseError) {
                    Toast.makeText(Room_Activity.this, "Check your Internet Connection", Toast.LENGTH_SHORT).show();
                    finish();
                }
            });
        }
    };



    private Runnable Check9 = new Runnable() {
        @Override
        public void run() {
            if(z==9) {
                progressDialog1.show();
                z++;
            }

            final String round="Round"+Round;
            demoRef1.child(round).child("finish").addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    String value = dataSnapshot.getValue(String.class);

                    if(y==9) {
                        if (value.equals("0.5")) {
                            handler.postDelayed(Check9, 200);

                            //progressDialog2.dismiss();
                        } else if (value.equals("Done")) {
                            progressDialog1.dismiss();

                            y++;

                            if(RoundActivity.ren.equals("10") ) {
                                y1.setVisibility(View.GONE);
                                y2.setVisibility(View.GONE);

                                mDatabaseRef.addValueEventListener(new ValueEventListener() {
                                    @Override
                                    public void onDataChange(DataSnapshot dataSnapshot) {
                                        for (DataSnapshot postSnapshot : dataSnapshot.getChildren()) {
                                            ResultDatabase resultDatabase = postSnapshot.getValue(ResultDatabase.class);
                                            pla1=resultDatabase.getPlayer1();
                                            pla2=resultDatabase.getPlayer2();
                                            result2(pla1,pla2);
                                            mUploads.add(resultDatabase);

                                        }


                                        mAdapter = new ResultAdapter(Room_Activity.this, mUploads);

                                        mRecyclerView.setAdapter(mAdapter);
                                        t1.setText(String.valueOf(r1));
                                        t2.setText(String.valueOf(r2));
                                        t3.setText(String.valueOf(r3));
                                        //mProgressCircle.setVisibility(View.INVISIBLE);


                                    }

                                    @Override
                                    public void onCancelled(DatabaseError databaseError) {
                                        Toast.makeText(Room_Activity.this, databaseError.getMessage(), Toast.LENGTH_SHORT).show();
                                        //mProgressCircle.setVisibility(View.INVISIBLE);
                                    }
                                });
                            }

                            Round++;


                        }

                    }
                }
                @Override
                public void onCancelled(DatabaseError databaseError) {
                    Toast.makeText(Room_Activity.this, "Check your Internet Connection", Toast.LENGTH_SHORT).show();
                    finish();
                }
            });
        }
    };

    @Override
    public void onBackPressed() {

            AlertDialog.Builder alert = new AlertDialog.Builder(
                    Room_Activity.this);
            alert.setTitle("Delete Memo");
            alert.setMessage("Are you sure you want delete current Memo?");
            //Toast.makeText(this,"Multiplayer",Toast.LENGTH_SHORT).show();
            alert.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {

                    try{
                        mdata = FirebaseDatabase.getInstance().getReference("Multiplayer").child(fg).child("Score");
                        a=1;
                        mdata.removeValue();
                        startActivity(new Intent(Room_Activity.this,New_Game.class));
                        finish();
                    }
                    catch (Exception e){
                        a=1;
                        startActivity(new Intent(Room_Activity.this,New_Game.class));
                        finish();
                    }

                }
            });
            alert.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.dismiss();
                }
            });
            alert.show();

    }

    public void result2(String a, String b){
        if(a.equals("1") && b.equals("1")){
            r3++;
            }
        else if(a.equals("1") && b.equals("2")){
            r2++;
        }
        else if(a.equals("1") && b.equals("3")){
            r1++;
        }
        else if(a.equals("2") && b.equals("1")){
          r1++;
        }
        else if(a.equals("2") && b.equals("2")){
            r3++;

        }else if(a.equals("2") && b.equals("3")){

            r2++;
        }
        else if(a.equals("3") && b.equals("1")){
            r2++;
        }
        else if(a.equals("3") && b.equals("2")){

            r1++;
        }
        else if(a.equals("3") && b.equals("3")){
            r3++;

        }
    }

    @Override
    protected void onUserLeaveHint() {
        super.onUserLeaveHint();


        if(a==1){

        }
        else if(New_Game.media.isPlaying()){
            New_Game.media.stop();
            b=1;
        }

        else if (About_us.medi.isPlaying()) {
            About_us.medi.stop();
            b=1;
        }




    }
    @Override
    protected void onResume(){
        super.onResume();
        if(b==1){
            New_Game.media = MediaPlayer.create(Room_Activity.this, R.raw.safe);
            New_Game.media.start();
            New_Game.media.setLooping(true);
            b=0;
        }

    }



}
