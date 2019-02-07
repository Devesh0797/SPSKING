package sps_king.devesh.com.spsking;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v4.widget.CircularProgressDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

public class DetailsActivity extends Activity {

    private TextView name,age;

    private ImageView img;
    private Button sign;
    private DatabaseReference rootRef,demoRef;
    private FirebaseAuth firebaseAuth;
    private StorageReference mStorageRef;
    ProgressDialog progressDialog;
    private ProgressBar pro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        name=(TextView)findViewById(R.id.et_nam);
        age=(TextView)findViewById(R.id.et_ag);
        sign=(Button)findViewById(R.id.signout);
        img=(ImageView)findViewById(R.id.im_pro);
        pro=(ProgressBar)findViewById(R.id.prophoto);

        firebaseAuth = FirebaseAuth.getInstance();
        rootRef = FirebaseDatabase.getInstance().getReference();

        String currentUser = firebaseAuth.getCurrentUser().getUid();
        mStorageRef = FirebaseStorage.getInstance().getReference(currentUser);
        demoRef = rootRef.child("Users").child(currentUser);


        progressDialog= new ProgressDialog(DetailsActivity.this);
        progressDialog.setTitle("Profile");
        progressDialog.setMessage("Retrieving Information");
        progressDialog.show();

        progressDialog.setCanceledOnTouchOutside(false);


        demoRef.child("name").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String value = dataSnapshot.getValue(String.class);
                //Log.d(TAG,"Value is"+ value);
                //Toast.makeText(Details.this,"value is"+value,Toast.LENGTH_SHORT).show();
                if(haveNetwork()) {
                    pro.setVisibility(View.VISIBLE);

                    if (value != null) {
                        name.setText(value);

                    } else {
                        startActivity(new Intent(DetailsActivity.this, Profile.class));
                        finish();
                        pro.setVisibility(View.GONE);
                        progressDialog.dismiss();

                    }
                }
                else{
                    Toast.makeText(DetailsActivity.this,"Check your Internet Connection",Toast.LENGTH_SHORT).show();
                    progressDialog.dismiss();
                }
            }
            @Override
            public void onCancelled(DatabaseError databaseError) {
                Toast.makeText(DetailsActivity.this,"Check your Internet Connection",Toast.LENGTH_SHORT).show();
            }
        });
        demoRef.child("age").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String USerAge = dataSnapshot.getValue(String.class);
                //Log.d(TAG,"Value is"+ value);
                //Toast.makeText(Details.this,"value is"+value,Toast.LENGTH_SHORT).show();
                if(haveNetwork()) {

                    if (USerAge != null) {
                        age.setText(USerAge);

                    }
                }
                else{
                    Toast.makeText(DetailsActivity.this,"Check your Internet Connection",Toast.LENGTH_SHORT).show();
                    progressDialog.dismiss();
                }
            }
            @Override
            public void onCancelled(DatabaseError databaseError) {
                Toast.makeText(DetailsActivity.this,"Check your Internet Connection",Toast.LENGTH_SHORT).show();
            }
        });
        demoRef.child("Image").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
               String imageurl = dataSnapshot.getValue(String.class);
                //Log.d(TAG,"Value is"+ value);
                //Toast.makeText(Details.this,"value is"+value,Toast.LENGTH_SHORT).show();
                if(haveNetwork()) {

                    if (imageurl != null) {
                        Picasso.with(getApplicationContext()).load(imageurl).fit().centerCrop().placeholder(R.drawable.profile).into(img , new Callback() {
                            @Override
                            public void onSuccess() {
                                pro.setVisibility(View.GONE);
                            }

                            @Override
                            public void onError() {
                            }
                        });
                        progressDialog.dismiss();


                    }
                }
                else{
                    Toast.makeText(DetailsActivity.this,"Check your Internet Connection",Toast.LENGTH_SHORT).show();
                    progressDialog.dismiss();
                }
            }
            @Override
            public void onCancelled(DatabaseError databaseError) {
                Toast.makeText(DetailsActivity.this,"Check your Internet Connection",Toast.LENGTH_SHORT).show();
            }
        });

        sign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                firebaseAuth.signOut();
                finish();
                startActivity(new Intent(DetailsActivity.this,New_Game.class));
            }
        });
    }
    private Boolean haveNetwork(){
        boolean have_WIFI=false;
        boolean have_MobileData=false;

        ConnectivityManager connectivityManager=(ConnectivityManager)getSystemService(CONNECTIVITY_SERVICE);
        NetworkInfo[] networkInfos=connectivityManager.getAllNetworkInfo();

        for (NetworkInfo info:networkInfos){
            if(info.getTypeName().equalsIgnoreCase("WIFI"))
                if(info.isConnected())
                    have_WIFI=true;
            if (info.getTypeName().equalsIgnoreCase("MOBILE"))
                if(info.isConnected())
                    have_MobileData=true;
        }
        return have_MobileData||have_WIFI;

    }
    @Override
    public void onBackPressed(){
        startActivity(new Intent(DetailsActivity.this,New_Game.class));
        finish();
    }



}
