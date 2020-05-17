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
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

import sps_king.devesh.com.spsking.Adapters.ResultAdapter;
import sps_king.devesh.com.spsking.Models.ResultDatabase;

public class Room2Activity extends Activity {

    private DatabaseReference rootRef1, demoRef1, mdata;
    private Handler handler = new Handler();
    private ImageView b1, b2, b3;
    private int Round = 1;
    private int x = 0;
    private int y = 0;
    private int z = 0;
    private int a = 0;
    public static String player;
    private String v;
    private TextView d1, d2;
    private int a1=0,b=0;

    ProgressDialog progressDialog;
    ProgressDialog progressDialog1;
    ProgressDialog progressDialog2;

    private RecyclerView mRecyclerView;
    private ResultAdapter mAdapter;
    private DatabaseReference mDatabaseRef;
    private List<ResultDatabase> mUploads;
    private String game;
    private TextView t1, t2, t3;

    private int c1 = 0, c2 = 0, c3 = 0;
    private String pla1, pla2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_room2);

        b1 = (ImageView) findViewById(R.id.rock);
        b2 = (ImageView) findViewById(R.id.paper);
        b3 = (ImageView) findViewById(R.id.scissor);

        b1.setImageResource(R.drawable.hand);
        b2.setImageResource(R.drawable.hand1);
        b3.setImageResource(R.drawable.hand2);

        t1 = (TextView) findViewById(R.id.tv_wincv);
        t2 = (TextView) findViewById(R.id.tv_loosecv);
        t3 = (TextView) findViewById(R.id.tv_drawcv);
        d1 = (TextView) findViewById(R.id.tv_lk);
        d2 = (TextView) findViewById(R.id.tv_kj);

        player = "player2";

        progressDialog = new ProgressDialog(Room2Activity.this);
        progressDialog.setTitle("Analyse");
        progressDialog.setMessage("Wait");

        progressDialog2 = new ProgressDialog(Room2Activity.this);
        progressDialog2.setTitle("Waiting");
        progressDialog2.setMessage("Storing Your choice");


        progressDialog2.setCanceledOnTouchOutside(false);
        progressDialog2.setCancelable(false);

        progressDialog.setCanceledOnTouchOutside(false);
        progressDialog.setCancelable(false);

        game = RoomRequest_Activity.comp + "-" + New_Game.USerID;
        rootRef1 = FirebaseDatabase.getInstance().getReference("Multiplayer");
        demoRef1 = rootRef1.child(game);
        demoRef1.child("Waiting").setValue("1");
        demoRef1.child("Player2").setValue("0");

        mRecyclerView = (RecyclerView) findViewById(R.id.rec_fgh);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(Room2Activity.this));
        mUploads = new ArrayList<>();
        mDatabaseRef = FirebaseDatabase.getInstance().getReference("Multiplayer").child(game).child("Score");

        d2.setText("Round No." + String.valueOf(Round));
        handler.postDelayed(mToastRunnable, 2000);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String round = "Round" + Round;
                demoRef1.child("Score").child(round).child("Player2").setValue("1");
                demoRef1.child(round).child("Player2").setValue("1");
                if (x == 0) {
                    progressDialog.show();
                    handler.postDelayed(sender, 3000);
                } else if (x == 1) {
                    progressDialog.show();
                    handler.postDelayed(sender1, 1000);
                } else if (x == 2) {
                    progressDialog.show();
                    handler.postDelayed(sender2, 1000);
                } else if (x == 3) {
                    progressDialog.show();
                    handler.postDelayed(sender3, 1000);
                } else if (x == 4) {
                    progressDialog.show();
                    handler.postDelayed(sender4, 1000);
                } else if (x == 5) {
                    progressDialog.show();
                    handler.postDelayed(sender5, 1000);
                } else if (x == 6) {
                    progressDialog.show();
                    handler.postDelayed(sender6, 1000);
                } else if (x == 7) {
                    progressDialog.show();
                    handler.postDelayed(sender7, 1000);
                } else if (x == 8) {
                    progressDialog.show();
                    handler.postDelayed(sender8, 1000);
                } else if (x == 9) {
                    progressDialog.show();
                    handler.postDelayed(sender9, 1000);
                }

            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String round = "Round" + Round;
                demoRef1.child("Score").child(round).child("Player2").setValue("2");
                demoRef1.child(round).child("Player2").setValue("2");
                if (x == 0) {
                    progressDialog.show();
                    handler.postDelayed(sender, 3000);
                } else if (x == 1) {
                    progressDialog.show();
                    handler.postDelayed(sender1, 1000);
                } else if (x == 2) {
                    progressDialog.show();
                    handler.postDelayed(sender2, 1000);
                } else if (x == 3) {
                    progressDialog.show();
                    handler.postDelayed(sender3, 1000);
                } else if (x == 4) {
                    progressDialog.show();
                    handler.postDelayed(sender4, 1000);
                } else if (x == 5) {
                    progressDialog.show();
                    handler.postDelayed(sender5, 1000);
                } else if (x == 6) {
                    progressDialog.show();
                    handler.postDelayed(sender6, 1000);
                } else if (x == 7) {
                    progressDialog.show();
                    handler.postDelayed(sender7, 1000);
                } else if (x == 8) {
                    progressDialog.show();
                    handler.postDelayed(sender8, 1000);
                } else if (x == 9) {
                    progressDialog.show();
                    handler.postDelayed(sender9, 1000);
                }
            }
        });

        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String round = "Round" + Round;
                demoRef1.child("Score").child(round).child("Player2").setValue("3");
                demoRef1.child(round).child("Player2").setValue("3");
                if (x == 0) {
                    progressDialog.show();
                    handler.postDelayed(sender, 3000);
                } else if (x == 1) {
                    progressDialog.show();
                    handler.postDelayed(sender1, 1000);
                } else if (x == 2) {
                    progressDialog.show();
                    handler.postDelayed(sender2, 1000);
                } else if (x == 3) {
                    progressDialog.show();
                    handler.postDelayed(sender3, 1000);
                } else if (x == 4) {
                    progressDialog.show();
                    handler.postDelayed(sender4, 1000);
                } else if (x == 5) {
                    progressDialog.show();
                    handler.postDelayed(sender5, 1000);
                } else if (x == 6) {
                    progressDialog.show();
                    handler.postDelayed(sender6, 1000);
                } else if (x == 7) {
                    progressDialog.show();
                    handler.postDelayed(sender7, 1000);
                } else if (x == 8) {
                    progressDialog.show();
                    handler.postDelayed(sender8, 1000);
                } else if (x == 9) {
                    progressDialog.show();
                    handler.postDelayed(sender9, 1000);
                }
            }
        });

    }

    private Runnable mToastRunnable = new Runnable() {
        @Override
        public void run() {

            String round = "Round" + Round;
            demoRef1.child(round).child("Waiting").addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    String value = dataSnapshot.getValue(String.class);

                    String round = "Round" + Round;
                    if (value.equals("0.5")) {
                        demoRef1.child(round).child("Waiting").setValue("Done");
                        demoRef1.child(round).child("finish").setValue("0");

                        demoRef1.child("Rounds").addValueEventListener(new ValueEventListener() {
                            @Override
                            public void onDataChange(DataSnapshot dataSnapshot) {
                                v = dataSnapshot.getValue(String.class);
                                d1.setText("Total Number of Rounds" + String.valueOf(v));
                                // b1.setText(v);

                            }

                            @Override
                            public void onCancelled(DatabaseError databaseError) {
                                Toast.makeText(Room2Activity.this, databaseError.getMessage(), Toast.LENGTH_SHORT).show();
                                //mProgressCircle.setVisibility(View.INVISIBLE);
                            }
                        });


                    } else if (value.equals("Done")) {

                    } else {
                        handler.postDelayed(mToastRunnable, 1000);
                    }
                }

                @Override
                public void onCancelled(DatabaseError databaseError) {
                    Toast.makeText(Room2Activity.this, "Check your Internet Connection", Toast.LENGTH_SHORT).show();
                    finish();
                }
            });
        }
    };

    private Runnable sender = new Runnable() {
        @Override
        public void run() {

            //progressDialog.show();

            final String round = "Round" + Round;
            demoRef1.child(round).child("Sender").addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    String value = dataSnapshot.getValue(String.class);

                    if (a == 0) {
                        if (value.equals("0")) {
                            handler.postDelayed(sender, 500);

                        } else if (value.equals("1")) {
                            handler.postDelayed(Stone, 3000);
                            a++;
                        }
                    }

                }

                @Override
                public void onCancelled(DatabaseError databaseError) {
                    Toast.makeText(Room2Activity.this, "Check your Internet Connection", Toast.LENGTH_SHORT).show();
                    finish();
                }
            });
        }
    };

    private Runnable Stone = new Runnable() {
        @Override
        public void run() {

            progressDialog.show();

            final String round = "Round" + Round;
            demoRef1.child(round).child("finish").addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    String value = dataSnapshot.getValue(String.class);

                    if (x == 0) {
                        if (value.equals("0")) {
                            demoRef1.child(round).child("finish").setValue("0.5");
                            Round++;
                            progressDialog.dismiss();
                            String round = "Round" + Round;
                            demoRef1.child(round).child("Waiting").setValue("0.5");
                            demoRef1.child(round).child("finish").setValue("0");
                            handler.postDelayed(Check, 1000);
                            Round--;
                            x++;

                        } else if (value.equals("0.5")) {
                            demoRef1.child(round).child("finish").setValue("Done");
                            Round++;
                            x++;
                            progressDialog.dismiss();
                            String round1 = "Round" + Round;
                            demoRef1.child(round1).child("Waiting").setValue("Done");
                            handler.postDelayed(Check, 1000);
                            Round--;
                        }
                    }

                }

                @Override
                public void onCancelled(DatabaseError databaseError) {
                    Toast.makeText(Room2Activity.this, "Check your Internet Connection", Toast.LENGTH_SHORT).show();
                    finish();
                }
            });
        }
    };

    private Runnable Check = new Runnable() {
        @Override
        public void run() {
            if (z == 0) {
                progressDialog2.show();
                z++;
            }

            final String round = "Round" + Round;
            demoRef1.child(round).child("finish").addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    String value = dataSnapshot.getValue(String.class);

                    if (y == 0) {
                        if (value.equals("0.5")) {
                            handler.postDelayed(Check, 1000);
                            //t1.setText("check1 mai pehla");

                            //progressDialog2.dismiss();
                        } else if (value.equals("Done")) {
                            progressDialog2.dismiss();
                            //  t1.setText("check1 mai dusra");
                            y++;
                            progressDialog2.dismiss();

                            Round++;
                            d2.setText("Round No." + String.valueOf(Round));
                            //handler.postDelayed(mToastRunnable,200);

                        }
                    }
                }

                @Override
                public void onCancelled(DatabaseError databaseError) {
                    Toast.makeText(Room2Activity.this, "Check your Internet Connection", Toast.LENGTH_SHORT).show();
                    finish();
                }
            });
        }
    };

    private Runnable sender1 = new Runnable() {
        @Override
        public void run() {

            //progressDialog.show();

            final String round = "Round" + Round;
            demoRef1.child(round).child("Sender").addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    String value = dataSnapshot.getValue(String.class);

                    if (a == 1) {
                        if (value.equals("0")) {
                            handler.postDelayed(sender1, 500);

                        } else if (value.equals("1")) {
                            handler.postDelayed(Stone1, 3000);
                            a++;
                        }
                    }

                }

                @Override
                public void onCancelled(DatabaseError databaseError) {
                    Toast.makeText(Room2Activity.this, "Check your Internet Connection", Toast.LENGTH_SHORT).show();
                    finish();
                }
            });
        }
    };

    private Runnable Stone1 = new Runnable() {
        @Override
        public void run() {


            final String round = "Round" + Round;
            demoRef1.child(round).child("finish").addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    String value = dataSnapshot.getValue(String.class);

                    if (x == 1) {
                        if (value.equals("0")) {
                            demoRef1.child(round).child("finish").setValue("0.5");
                            Round++;
                            progressDialog.dismiss();
                            String round = "Round" + Round;
                            demoRef1.child(round).child("Waiting").setValue("0.5");
                            demoRef1.child(round).child("finish").setValue("0");
                            handler.postDelayed(Check1, 1000);
                            Round--;
                            x++;

                        } else if (value.equals("0.5")) {
                            demoRef1.child(round).child("finish").setValue("Done");
                            Round++;
                            x++;
                            progressDialog.dismiss();
                            String round1 = "Round" + Round;
                            demoRef1.child(round1).child("Waiting").setValue("Done");
                            Round--;
                            handler.postDelayed(Check1, 1000);
                        }
                    }
                }

                @Override
                public void onCancelled(DatabaseError databaseError) {
                    Toast.makeText(Room2Activity.this, "Check your Internet Connection", Toast.LENGTH_SHORT).show();
                    finish();
                }
            });
        }
    };

    private Runnable Check1 = new Runnable() {
        @Override
        public void run() {
            if (z == 1) {
                progressDialog2.show();
                z++;
            }

            final String round = "Round" + Round;
            demoRef1.child(round).child("finish").addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    String value = dataSnapshot.getValue(String.class);

                    if (y == 1) {
                        if (value.equals("0.5")) {
                            handler.postDelayed(Check1, 500);
                            //t1.setText("check1 mai pehla");

                            //progressDialog2.dismiss();
                        } else if (value.equals("Done")) {
                            progressDialog2.dismiss();
                            //  t1.setText("check1 mai dusra");
                            y++;
                            progressDialog2.dismiss();

                            Round++;
                            d2.setText("Round No." + String.valueOf(Round));
                            //handler.postDelayed(mToastRunnable,200);

                        }

                    }
                }

                @Override
                public void onCancelled(DatabaseError databaseError) {
                    Toast.makeText(Room2Activity.this, "Check your Internet Connection", Toast.LENGTH_SHORT).show();
                    finish();
                }
            });
        }
    };

    private Runnable sender2 = new Runnable() {
        @Override
        public void run() {

            //progressDialog.show();

            final String round = "Round" + Round;
            demoRef1.child(round).child("Sender").addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    String value = dataSnapshot.getValue(String.class);

                    if (a == 2) {
                        if (value.equals("0")) {
                            handler.postDelayed(sender2, 500);

                        } else if (value.equals("1")) {

                            if (v.equals("3")) {
                                mDatabaseRef.addValueEventListener(new ValueEventListener() {
                                    @Override
                                    public void onDataChange(DataSnapshot dataSnapshot) {
                                        for (DataSnapshot postSnapshot : dataSnapshot.getChildren()) {
                                            ResultDatabase resultDatabase = postSnapshot.getValue(ResultDatabase.class);
                                            pla1 = resultDatabase.getPlayer2();
                                            pla2 = resultDatabase.getPlayer1();
                                            result2(pla1, pla2);
                                            mUploads.add(resultDatabase);

                                        }


                                        mAdapter = new ResultAdapter(Room2Activity.this, mUploads);

                                        mRecyclerView.setAdapter(mAdapter);
                                        d1.setVisibility(View.GONE);
                                        d2.setVisibility(View.GONE);
                                        t1.setText(String.valueOf(c1));
                                        t2.setText(String.valueOf(c2));
                                        t3.setText(String.valueOf(c3));
                                        //mProgressCircle.setVisibility(View.INVISIBLE);


                                    }

                                    @Override
                                    public void onCancelled(DatabaseError databaseError) {
                                        Toast.makeText(Room2Activity.this, databaseError.getMessage(), Toast.LENGTH_SHORT).show();
                                        //mProgressCircle.setVisibility(View.INVISIBLE);
                                    }
                                });
                            }
                            handler.postDelayed(Stone2, 3000);
                            a++;
                        }
                    }

                }

                @Override
                public void onCancelled(DatabaseError databaseError) {
                    Toast.makeText(Room2Activity.this, "Check your Internet Connection", Toast.LENGTH_SHORT).show();
                    finish();
                }
            });
        }
    };

    private Runnable Stone2 = new Runnable() {
        @Override
        public void run() {

            progressDialog.show();

            final String round = "Round" + Round;
            demoRef1.child(round).child("finish").addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    String value = dataSnapshot.getValue(String.class);

                    if (x == 2) {
                        if (value.equals("0")) {
                            demoRef1.child(round).child("finish").setValue("0.5");
                            Round++;
                            progressDialog.dismiss();
                            String round = "Round" + Round;
                            demoRef1.child(round).child("Waiting").setValue("0.5");
                            demoRef1.child(round).child("finish").setValue("0");
                            handler.postDelayed(Check2, 500);
                            Round--;
                            x++;

                        } else if (value.equals("0.5")) {
                            demoRef1.child(round).child("finish").setValue("Done");
                            Round++;
                            x++;
                            progressDialog.dismiss();
                            String round1 = "Round" + Round;
                            demoRef1.child(round1).child("Waiting").setValue("Done");
                            handler.postDelayed(Check2, 500);
                            Round--;
                        }
                    }

                }

                @Override
                public void onCancelled(DatabaseError databaseError) {
                    Toast.makeText(Room2Activity.this, "Check your Internet Connection", Toast.LENGTH_SHORT).show();
                    finish();
                }
            });
        }
    };


    private Runnable Check2 = new Runnable() {
        @Override
        public void run() {
            if (z == 2) {
                progressDialog2.show();
                z++;
            }

            final String round = "Round" + Round;
            demoRef1.child(round).child("finish").addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    String value = dataSnapshot.getValue(String.class);

                    if (y == 2) {
                        if (value.equals("0.5")) {
                            handler.postDelayed(Check2, 500);
                            //  t1.setText("check1 mai pehla");

                            //progressDialog2.dismiss();
                        } else if (value.equals("Done")) {
                            progressDialog2.dismiss();
                            //t1.setText("check1 mai dusra");
                            y++;
                            progressDialog2.dismiss();

                            Round++;
                            d2.setText("Round No." + String.valueOf(Round));
                            //   startActivity(new Intent(Room2Activity.this,New_Game.class));
                            //  finish();
                            //handler.postDelayed(mToastRunnable,200);

                        }

                    }
                }

                @Override
                public void onCancelled(DatabaseError databaseError) {
                    Toast.makeText(Room2Activity.this, "Check your Internet Connection", Toast.LENGTH_SHORT).show();
                    finish();
                }
            });
        }
    };


    private Runnable sender3 = new Runnable() {
        @Override
        public void run() {

            //progressDialog.show();

            final String round = "Round" + Round;
            demoRef1.child(round).child("Sender").addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    String value = dataSnapshot.getValue(String.class);

                    if (a == 3) {
                        if (value.equals("0")) {
                            handler.postDelayed(sender3, 500);

                        } else if (value.equals("1")) {

                            handler.postDelayed(Stone3, 3000);
                            a++;
                        }
                    }

                }

                @Override
                public void onCancelled(DatabaseError databaseError) {
                    Toast.makeText(Room2Activity.this, "Check your Internet Connection", Toast.LENGTH_SHORT).show();
                    finish();
                }
            });
        }
    };

    private Runnable Stone3 = new Runnable() {
        @Override
        public void run() {

            progressDialog.show();

            final String round = "Round" + Round;
            demoRef1.child(round).child("finish").addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    String value = dataSnapshot.getValue(String.class);
                    if (x == 3) {
                        if (value.equals("0")) {
                            demoRef1.child(round).child("finish").setValue("0.5");
                            Round++;
                            progressDialog.dismiss();
                            String round = "Round" + Round;
                            demoRef1.child(round).child("Waiting").setValue("0.5");
                            demoRef1.child(round).child("finish").setValue("0");
                            handler.postDelayed(Check3, 500);
                            Round--;
                            x++;

                        } else if (value.equals("0.5")) {
                            demoRef1.child(round).child("finish").setValue("Done");
                            Round++;
                            x++;
                            progressDialog.dismiss();
                            String round1 = "Round" + Round;
                            demoRef1.child(round1).child("Waiting").setValue("Done");
                            handler.postDelayed(Check3, 500);
                            Round--;
                        }
                    }

                }

                @Override
                public void onCancelled(DatabaseError databaseError) {
                    Toast.makeText(Room2Activity.this, "Check your Internet Connection", Toast.LENGTH_SHORT).show();
                    finish();
                }
            });
        }
    };
    private Runnable Check3 = new Runnable() {
        @Override
        public void run() {
            if (z == 3) {
                progressDialog2.show();
                z++;
            }

            final String round = "Round" + Round;
            demoRef1.child(round).child("finish").addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    String value = dataSnapshot.getValue(String.class);

                    if (y == 3) {
                        if (value.equals("0.5")) {
                            handler.postDelayed(Check3, 500);
                            //  t1.setText("check1 mai pehla");

                            //progressDialog2.dismiss();
                        } else if (value.equals("Done")) {
                            progressDialog2.dismiss();
                            //t1.setText("check1 mai dusra");
                            y++;
                            progressDialog2.dismiss();

                            Round++;
                            d2.setText("Round No." + String.valueOf(Round));
                            //   startActivity(new Intent(Room2Activity.this,New_Game.class));
                            //  finish();
                            //handler.postDelayed(mToastRunnable,200);

                        }

                    }
                }

                @Override
                public void onCancelled(DatabaseError databaseError) {
                    Toast.makeText(Room2Activity.this, "Check your Internet Connection", Toast.LENGTH_SHORT).show();
                    finish();
                }
            });
        }
    };

    private Runnable sender4 = new Runnable() {
        @Override
        public void run() {

            //progressDialog.show();

            final String round = "Round" + Round;
            demoRef1.child(round).child("Sender").addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    String value = dataSnapshot.getValue(String.class);

                    if (a == 4) {
                        if (value.equals("0")) {
                            handler.postDelayed(sender4, 500);

                        } else if (value.equals("1")) {

                            if (v.equals("5")) {
                                mDatabaseRef.addValueEventListener(new ValueEventListener() {
                                    @Override
                                    public void onDataChange(DataSnapshot dataSnapshot) {
                                        for (DataSnapshot postSnapshot : dataSnapshot.getChildren()) {
                                            ResultDatabase resultDatabase = postSnapshot.getValue(ResultDatabase.class);
                                            pla1 = resultDatabase.getPlayer2();
                                            pla2 = resultDatabase.getPlayer1();
                                            result2(pla1, pla2);
                                            mUploads.add(resultDatabase);

                                        }


                                        mAdapter = new ResultAdapter(Room2Activity.this, mUploads);

                                        mRecyclerView.setAdapter(mAdapter);
                                        d1.setVisibility(View.GONE);
                                        d2.setVisibility(View.GONE);
                                        t1.setText(String.valueOf(c1));
                                        t2.setText(String.valueOf(c2));
                                        t3.setText(String.valueOf(c3));
                                        //mProgressCircle.setVisibility(View.INVISIBLE);


                                    }

                                    @Override
                                    public void onCancelled(DatabaseError databaseError) {
                                        Toast.makeText(Room2Activity.this, databaseError.getMessage(), Toast.LENGTH_SHORT).show();
                                        //mProgressCircle.setVisibility(View.INVISIBLE);
                                    }
                                });
                            }
                            handler.postDelayed(Stone4, 3000);
                            a++;
                        }
                    }

                }

                @Override
                public void onCancelled(DatabaseError databaseError) {
                    Toast.makeText(Room2Activity.this, "Check your Internet Connection", Toast.LENGTH_SHORT).show();
                    finish();
                }
            });
        }
    };

    private Runnable Stone4 = new Runnable() {
        @Override
        public void run() {

            progressDialog.show();

            final String round = "Round" + Round;
            demoRef1.child(round).child("finish").addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    String value = dataSnapshot.getValue(String.class);

                    if (x == 4) {
                        if (value.equals("0")) {
                            demoRef1.child(round).child("finish").setValue("0.5");
                            Round++;
                            progressDialog.dismiss();
                            String round = "Round" + Round;
                            demoRef1.child(round).child("Waiting").setValue("0.5");
                            demoRef1.child(round).child("finish").setValue("0");
                            handler.postDelayed(Check4, 500);
                            Round--;
                            x++;

                        } else if (value.equals("0.5")) {
                            demoRef1.child(round).child("finish").setValue("Done");
                            Round++;
                            x++;
                            progressDialog.dismiss();
                            String round1 = "Round" + Round;
                            demoRef1.child(round1).child("Waiting").setValue("Done");
                            handler.postDelayed(Check4, 500);
                            Round--;
                        }
                    }

                }

                @Override
                public void onCancelled(DatabaseError databaseError) {
                    Toast.makeText(Room2Activity.this, "Check your Internet Connection", Toast.LENGTH_SHORT).show();
                    finish();
                }
            });
        }
    };


    private Runnable Check4 = new Runnable() {
        @Override
        public void run() {
            if (z == 4) {
                progressDialog2.show();
                z++;
            }

            final String round = "Round" + Round;
            demoRef1.child(round).child("finish").addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    String value = dataSnapshot.getValue(String.class);

                    if (y == 4) {
                        if (value.equals("0.5")) {
                            handler.postDelayed(Check4, 500);
                            //  t1.setText("check1 mai pehla");

                            //progressDialog2.dismiss();
                        } else if (value.equals("Done")) {
                            progressDialog2.dismiss();
                            //t1.setText("check1 mai dusra");
                            y++;
                            progressDialog2.dismiss();

                            Round++;
                            d2.setText("Round No." + String.valueOf(Round));
                            //   startActivity(new Intent(Room2Activity.this,New_Game.class));
                            //  finish();
                            //handler.postDelayed(mToastRunnable,200);

                        }

                    }
                }

                @Override
                public void onCancelled(DatabaseError databaseError) {
                    Toast.makeText(Room2Activity.this, "Check your Internet Connection", Toast.LENGTH_SHORT).show();
                    finish();
                }
            });
        }
    };

    private Runnable sender5 = new Runnable() {
        @Override
        public void run() {

            //progressDialog.show();

            final String round = "Round" + Round;
            demoRef1.child(round).child("Sender").addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    String value = dataSnapshot.getValue(String.class);

                    if (a == 5) {
                        if (value.equals("0")) {
                            handler.postDelayed(sender5, 500);

                        } else if (value.equals("1")) {

                            handler.postDelayed(Stone5, 3000);
                            a++;
                        }
                    }

                }

                @Override
                public void onCancelled(DatabaseError databaseError) {
                    Toast.makeText(Room2Activity.this, "Check your Internet Connection", Toast.LENGTH_SHORT).show();
                    finish();
                }
            });
        }
    };

    private Runnable Stone5 = new Runnable() {
        @Override
        public void run() {

            progressDialog.show();

            final String round = "Round" + Round;
            demoRef1.child(round).child("finish").addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    String value = dataSnapshot.getValue(String.class);

                    if (x == 5) {
                        if (value.equals("0")) {
                            demoRef1.child(round).child("finish").setValue("0.5");
                            Round++;
                            progressDialog.dismiss();
                            String round = "Round" + Round;
                            demoRef1.child(round).child("Waiting").setValue("0.5");
                            demoRef1.child(round).child("finish").setValue("0");
                            handler.postDelayed(Check5, 500);
                            Round--;
                            x++;

                        } else if (value.equals("0.5")) {
                            demoRef1.child(round).child("finish").setValue("Done");
                            Round++;
                            x++;
                            progressDialog.dismiss();
                            String round1 = "Round" + Round;
                            demoRef1.child(round1).child("Waiting").setValue("Done");
                            handler.postDelayed(Check5, 500);
                            Round--;
                        }
                    }

                }

                @Override
                public void onCancelled(DatabaseError databaseError) {
                    Toast.makeText(Room2Activity.this, "Check your Internet Connection", Toast.LENGTH_SHORT).show();
                    finish();
                }
            });
        }
    };


    private Runnable Check5 = new Runnable() {
        @Override
        public void run() {
            if (z == 5) {
                progressDialog2.show();
                z++;
            }

            final String round = "Round" + Round;
            demoRef1.child(round).child("finish").addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    String value = dataSnapshot.getValue(String.class);

                    if (y == 5) {
                        if (value.equals("0.5")) {
                            handler.postDelayed(Check5, 500);
                            //  t1.setText("check1 mai pehla");

                            //progressDialog2.dismiss();
                        } else if (value.equals("Done")) {
                            progressDialog2.dismiss();
                            //t1.setText("check1 mai dusra");
                            y++;
                            progressDialog2.dismiss();

                            Round++;
                            d2.setText("Round No." + String.valueOf(Round));
                            //   startActivity(new Intent(Room2Activity.this,New_Game.class));
                            //  finish();
                            //handler.postDelayed(mToastRunnable,200);

                        }

                    }
                }

                @Override
                public void onCancelled(DatabaseError databaseError) {
                    Toast.makeText(Room2Activity.this, "Check your Internet Connection", Toast.LENGTH_SHORT).show();
                    finish();
                }
            });
        }
    };

    private Runnable sender6 = new Runnable() {
        @Override
        public void run() {

            //progressDialog.show();

            final String round = "Round" + Round;
            demoRef1.child(round).child("Sender").addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    String value = dataSnapshot.getValue(String.class);

                    if (a == 6) {
                        if (value.equals("0")) {
                            handler.postDelayed(sender6, 500);

                        } else if (value.equals("1")) {

                            handler.postDelayed(Stone6, 3000);
                            a++;
                        }
                    }

                }

                @Override
                public void onCancelled(DatabaseError databaseError) {
                    Toast.makeText(Room2Activity.this, "Check your Internet Connection", Toast.LENGTH_SHORT).show();
                    finish();
                }
            });
        }
    };

    private Runnable Stone6 = new Runnable() {
        @Override
        public void run() {

            progressDialog.show();

            final String round = "Round" + Round;
            demoRef1.child(round).child("finish").addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    String value = dataSnapshot.getValue(String.class);

                    if (x == 6) {
                        if (value.equals("0")) {
                            demoRef1.child(round).child("finish").setValue("0.5");
                            Round++;
                            progressDialog.dismiss();
                            String round = "Round" + Round;
                            demoRef1.child(round).child("Waiting").setValue("0.5");
                            demoRef1.child(round).child("finish").setValue("0");
                            handler.postDelayed(Check6, 500);
                            Round--;
                            x++;

                        } else if (value.equals("0.5")) {
                            demoRef1.child(round).child("finish").setValue("Done");
                            Round++;
                            x++;
                            progressDialog.dismiss();
                            String round1 = "Round" + Round;
                            demoRef1.child(round1).child("Waiting").setValue("Done");
                            handler.postDelayed(Check6, 500);
                            Round--;
                        }
                    }

                }

                @Override
                public void onCancelled(DatabaseError databaseError) {
                    Toast.makeText(Room2Activity.this, "Check your Internet Connection", Toast.LENGTH_SHORT).show();
                    finish();
                }
            });
        }
    };


    private Runnable Check6 = new Runnable() {
        @Override
        public void run() {
            if (z == 6) {
                progressDialog2.show();
                z++;
            }

            final String round = "Round" + Round;
            demoRef1.child(round).child("finish").addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    String value = dataSnapshot.getValue(String.class);

                    if (y == 6) {
                        if (value.equals("0.5")) {
                            handler.postDelayed(Check6, 500);
                            //  t1.setText("check1 mai pehla");

                            //progressDialog2.dismiss();
                        } else if (value.equals("Done")) {
                            progressDialog2.dismiss();
                            //t1.setText("check1 mai dusra");
                            y++;
                            progressDialog2.dismiss();

                            Round++;
                            d2.setText("Round No." + String.valueOf(Round));
                            //   startActivity(new Intent(Room2Activity.this,New_Game.class));
                            //  finish();
                            //handler.postDelayed(mToastRunnable,200);

                        }

                    }
                }

                @Override
                public void onCancelled(DatabaseError databaseError) {
                    Toast.makeText(Room2Activity.this, "Check your Internet Connection", Toast.LENGTH_SHORT).show();
                    finish();
                }
            });
        }
    };

    private Runnable sender7 = new Runnable() {
        @Override
        public void run() {

            //progressDialog.show();

            final String round = "Round" + Round;
            demoRef1.child(round).child("Sender").addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    String value = dataSnapshot.getValue(String.class);

                    if (a == 7) {
                        if (value.equals("0")) {
                            handler.postDelayed(sender7, 500);

                        } else if (value.equals("1")) {

                            handler.postDelayed(Stone7, 3000);
                            a++;
                        }
                    }

                }

                @Override
                public void onCancelled(DatabaseError databaseError) {
                    Toast.makeText(Room2Activity.this, "Check your Internet Connection", Toast.LENGTH_SHORT).show();
                    finish();
                }
            });
        }
    };

    private Runnable Stone7 = new Runnable() {
        @Override
        public void run() {

            progressDialog.show();

            final String round = "Round" + Round;
            demoRef1.child(round).child("finish").addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    String value = dataSnapshot.getValue(String.class);

                    if (x == 7) {
                        if (value.equals("0")) {
                            demoRef1.child(round).child("finish").setValue("0.5");
                            Round++;
                            progressDialog.dismiss();
                            String round = "Round" + Round;
                            demoRef1.child(round).child("Waiting").setValue("0.5");
                            demoRef1.child(round).child("finish").setValue("0");
                            handler.postDelayed(Check7, 500);
                            Round--;
                            x++;

                        } else if (value.equals("0.5")) {
                            demoRef1.child(round).child("finish").setValue("Done");
                            Round++;
                            x++;
                            progressDialog.dismiss();
                            String round1 = "Round" + Round;
                            demoRef1.child(round1).child("Waiting").setValue("Done");
                            handler.postDelayed(Check7, 500);
                            Round--;
                        }
                    }

                }

                @Override
                public void onCancelled(DatabaseError databaseError) {
                    Toast.makeText(Room2Activity.this, "Check your Internet Connection", Toast.LENGTH_SHORT).show();
                    finish();
                }
            });
        }
    };


    private Runnable Check7 = new Runnable() {
        @Override
        public void run() {
            if (z == 7) {
                progressDialog2.show();
                z++;
            }

            final String round = "Round" + Round;
            demoRef1.child(round).child("finish").addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    String value = dataSnapshot.getValue(String.class);

                    if (y == 7) {
                        if (value.equals("0.5")) {
                            handler.postDelayed(Check7, 500);
                            //  t1.setText("check1 mai pehla");

                            //progressDialog2.dismiss();
                        } else if (value.equals("Done")) {
                            progressDialog2.dismiss();
                            //t1.setText("check1 mai dusra");
                            y++;
                            progressDialog2.dismiss();

                            Round++;
                            d2.setText("Round No." + String.valueOf(Round));
                            //   startActivity(new Intent(Room2Activity.this,New_Game.class));
                            //  finish();
                            //handler.postDelayed(mToastRunnable,200);

                        }

                    }
                }

                @Override
                public void onCancelled(DatabaseError databaseError) {
                    Toast.makeText(Room2Activity.this, "Check your Internet Connection", Toast.LENGTH_SHORT).show();
                    finish();
                }
            });
        }
    };

    private Runnable sender8 = new Runnable() {
        @Override
        public void run() {

            //progressDialog.show();

            final String round = "Round" + Round;
            demoRef1.child(round).child("Sender").addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    String value = dataSnapshot.getValue(String.class);

                    if (a == 8) {
                        if (value.equals("0")) {
                            handler.postDelayed(sender8, 500);

                        } else if (value.equals("1")) {

                            handler.postDelayed(Stone8, 3000);
                            a++;
                        }
                    }

                }

                @Override
                public void onCancelled(DatabaseError databaseError) {
                    Toast.makeText(Room2Activity.this, "Check your Internet Connection", Toast.LENGTH_SHORT).show();
                    finish();
                }
            });
        }
    };

    private Runnable Stone8 = new Runnable() {
        @Override
        public void run() {

            progressDialog.show();

            final String round = "Round" + Round;
            demoRef1.child(round).child("finish").addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    String value = dataSnapshot.getValue(String.class);

                    if (x == 8) {
                        if (value.equals("0")) {
                            demoRef1.child(round).child("finish").setValue("0.5");
                            Round++;
                            progressDialog.dismiss();
                            String round = "Round" + Round;
                            demoRef1.child(round).child("Waiting").setValue("0.5");
                            demoRef1.child(round).child("finish").setValue("0");
                            handler.postDelayed(Check8, 500);
                            Round--;
                            x++;

                        } else if (value.equals("0.5")) {
                            demoRef1.child(round).child("finish").setValue("Done");
                            Round++;
                            x++;
                            progressDialog.dismiss();
                            String round1 = "Round" + Round;
                            demoRef1.child(round1).child("Waiting").setValue("Done");
                            handler.postDelayed(Check8, 500);
                            Round--;
                        }
                    }

                }

                @Override
                public void onCancelled(DatabaseError databaseError) {
                    Toast.makeText(Room2Activity.this, "Check your Internet Connection", Toast.LENGTH_SHORT).show();
                    finish();
                }
            });
        }
    };


    private Runnable Check8 = new Runnable() {
        @Override
        public void run() {
            if (z == 8) {
                progressDialog2.show();
                z++;
            }

            final String round = "Round" + Round;
            demoRef1.child(round).child("finish").addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    String value = dataSnapshot.getValue(String.class);

                    if (y == 8) {
                        if (value.equals("0.5")) {
                            handler.postDelayed(Check8, 500);
                            //  t1.setText("check1 mai pehla");

                            //progressDialog2.dismiss();
                        } else if (value.equals("Done")) {
                            progressDialog2.dismiss();
                            //t1.setText("check1 mai dusra");
                            y++;
                            progressDialog2.dismiss();

                            Round++;
                            d2.setText("Round No." + String.valueOf(Round));
                            //   startActivity(new Intent(Room2Activity.this,New_Game.class));
                            //  finish();
                            //handler.postDelayed(mToastRunnable,200);

                        }

                    }
                }

                @Override
                public void onCancelled(DatabaseError databaseError) {
                    Toast.makeText(Room2Activity.this, "Check your Internet Connection", Toast.LENGTH_SHORT).show();
                    finish();
                }
            });
        }
    };

    private Runnable sender9 = new Runnable() {
        @Override
        public void run() {

            //progressDialog.show();

            final String round = "Round" + Round;
            demoRef1.child(round).child("Sender").addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    String value = dataSnapshot.getValue(String.class);

                    if (a == 9) {
                        if (value.equals("0")) {
                            handler.postDelayed(sender9, 500);

                        } else if (value.equals("1")) {

                            if (v.equals("10")) {
                                mDatabaseRef.addValueEventListener(new ValueEventListener() {
                                    @Override
                                    public void onDataChange(DataSnapshot dataSnapshot) {
                                        for (DataSnapshot postSnapshot : dataSnapshot.getChildren()) {
                                            ResultDatabase resultDatabase = postSnapshot.getValue(ResultDatabase.class);
                                            pla1 = resultDatabase.getPlayer2();
                                            pla2 = resultDatabase.getPlayer1();
                                            result2(pla1, pla2);
                                            mUploads.add(resultDatabase);

                                        }


                                        mAdapter = new ResultAdapter(Room2Activity.this, mUploads);

                                        mRecyclerView.setAdapter(mAdapter);
                                        d1.setVisibility(View.GONE);
                                        d2.setVisibility(View.GONE);
                                        t1.setText(String.valueOf(c1));
                                        t2.setText(String.valueOf(c2));
                                        t3.setText(String.valueOf(c3));

                                    }

                                    @Override
                                    public void onCancelled(DatabaseError databaseError) {
                                        Toast.makeText(Room2Activity.this, databaseError.getMessage(), Toast.LENGTH_SHORT).show();
                                        //mProgressCircle.setVisibility(View.INVISIBLE);
                                    }
                                });
                            }

                            handler.postDelayed(Stone9, 3000);
                            a++;
                        }
                    }

                }

                @Override
                public void onCancelled(DatabaseError databaseError) {
                    Toast.makeText(Room2Activity.this, "Check your Internet Connection", Toast.LENGTH_SHORT).show();
                    finish();
                }
            });
        }
    };

    private Runnable Stone9 = new Runnable() {
        @Override
        public void run() {

            progressDialog.show();

            final String round = "Round" + Round;
            demoRef1.child(round).child("finish").addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    String value = dataSnapshot.getValue(String.class);

                    if (x == 9) {
                        if (value.equals("0")) {
                            demoRef1.child(round).child("finish").setValue("0.5");
                            Round++;
                            progressDialog.dismiss();
                            String round = "Round" + Round;
                            demoRef1.child(round).child("Waiting").setValue("0.5");
                            demoRef1.child(round).child("finish").setValue("0");
                            handler.postDelayed(Check9, 500);
                            Round--;
                            x++;

                        } else if (value.equals("0.5")) {
                            demoRef1.child(round).child("finish").setValue("Done");
                            Round++;
                            x++;
                            progressDialog.dismiss();
                            String round1 = "Round" + Round;
                            demoRef1.child(round1).child("Waiting").setValue("Done");
                            handler.postDelayed(Check9, 500);
                            Round--;
                        }
                    }

                }

                @Override
                public void onCancelled(DatabaseError databaseError) {
                    Toast.makeText(Room2Activity.this, "Check your Internet Connection", Toast.LENGTH_SHORT).show();
                    finish();
                }
            });
        }
    };


    private Runnable Check9 = new Runnable() {
        @Override
        public void run() {
            if (z == 9) {
                progressDialog2.show();
                z++;
            }

            final String round = "Round" + Round;
            demoRef1.child(round).child("finish").addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    String value = dataSnapshot.getValue(String.class);

                    if (y == 9) {
                        if (value.equals("0.5")) {
                            handler.postDelayed(Check9, 500);
                            //  t1.setText("check1 mai pehla");

                            //progressDialog2.dismiss();
                        } else if (value.equals("Done")) {
                            progressDialog2.dismiss();
                            //t1.setText("check1 mai dusra");
                            y++;
                            progressDialog2.dismiss();

                            Round++;
                            d2.setText("Round No." + String.valueOf(Round));
                        }
                    }
                }

                @Override
                public void onCancelled(DatabaseError databaseError) {
                    Toast.makeText(Room2Activity.this, "Check your Internet Connection", Toast.LENGTH_SHORT).show();
                    finish();
                }
            });
        }
    };

    public void result2(String a, String b) {
        if (a.equals("1") && b.equals("1")) {
            c3++;
        } else if (a.equals("1") && b.equals("2")) {
            c2++;
        } else if (a.equals("1") && b.equals("3")) {
            c1++;
        } else if (a.equals("2") && b.equals("1")) {
            c1++;
        } else if (a.equals("2") && b.equals("2")) {
            c3++;

        } else if (a.equals("2") && b.equals("3")) {

            c2++;
        } else if (a.equals("3") && b.equals("1")) {
            c2++;
        } else if (a.equals("3") && b.equals("2")) {

            c1++;
        } else if (a.equals("3") && b.equals("3")) {
            c3++;

        }
    }

    @Override
    public void onBackPressed() {

        AlertDialog.Builder alert = new AlertDialog.Builder(
                Room2Activity.this);
        alert.setTitle("Delete Memo");
        alert.setMessage("Are you sure you want delete current Memo?");
        //Toast.makeText(this,"Multiplayer",Toast.LENGTH_SHORT).show();
        alert.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                try {
                    mdata = FirebaseDatabase.getInstance().getReference("Multiplayer").child(game).child("Score");
                    mdata.removeValue();
                    a1=1;
                    startActivity(new Intent(Room2Activity.this, New_Game.class));
                    finish();
                } catch (Exception e) {
                    a1=1;
                    startActivity(new Intent(Room2Activity.this, New_Game.class));
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
    @Override
    protected void onUserLeaveHint() {
        super.onUserLeaveHint();


        if(a1==1){

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
            New_Game.media = MediaPlayer.create(Room2Activity.this, R.raw.safe);
            New_Game.media.start();
            New_Game.media.setLooping(true);
            b=0;
        }

    }
}