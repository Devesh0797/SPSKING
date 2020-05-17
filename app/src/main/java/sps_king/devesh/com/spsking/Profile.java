package sps_king.devesh.com.spsking;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.v7.app.AlertDialog;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.webkit.MimeTypeMap;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.OnProgressListener;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.StorageTask;
import com.google.firebase.storage.UploadTask;
import com.squareup.picasso.Picasso;

import sps_king.devesh.com.spsking.Models.UserDatabase;

public class Profile extends Activity {

    private Button sub,choose;
    private EditText nam,ag;
    private ImageView img;
    private DatabaseReference rootRef,demoRef;
    private DatabaseReference mDataBase;
    private FirebaseAuth firebaseAuth;
    private StorageTask mUploadTask;
    private StorageReference mStorageRef;
    private static final int GALAARY_INTENT=234;
    private Uri filepath;
    private ProgressBar mprogressbar;
    private ProgressBar pro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        sub=(Button)findViewById(R.id.btn_prosub);
        nam=(EditText)findViewById(R.id.et_namee);
        ag=(EditText)findViewById(R.id.et_age);
        choose=(Button)findViewById(R.id.choose);
        img=(ImageView)findViewById(R.id.circle_profile);
        mprogressbar=(ProgressBar)findViewById(R.id.progress);
        pro=(ProgressBar)findViewById(R.id.propho);

        firebaseAuth = FirebaseAuth.getInstance();
        final String currentUser = firebaseAuth.getCurrentUser().getUid();
        mStorageRef = FirebaseStorage.getInstance().getReference(currentUser);
        rootRef = FirebaseDatabase.getInstance().getReference();
        demoRef = rootRef.child("Users").child(currentUser);
        mDataBase=FirebaseDatabase.getInstance().getReference("Users").child(currentUser);



        choose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
                intent.setType("image/*");
                startActivityForResult(intent, GALAARY_INTENT);

            }
        });



        sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Name = nam.getText().toString();
                String age=ag.getText().toString();

                if(haveNetwork()) {

                    if (!TextUtils.isEmpty(Name) && !TextUtils.isEmpty(age)) {

                        if (mUploadTask != null && mUploadTask.isInProgress()) {
                            Toast.makeText(Profile.this, "Upload in progress", Toast.LENGTH_SHORT).show();
                        } else {
                            //  demoRef.child("Name").setValue(name);
                            // demoRef.child("Age").setValue(age);
                            demoRef.child("Multiplayer").setValue("Offline");
                            UserDatabase artist= new UserDatabase(Name,currentUser,age);
                            mDataBase.setValue(artist);
                            choose.setEnabled(false);

                            uploadFile();
                        }




                    } else {

                        Toast.makeText(Profile.this, "Enter the Detail", Toast.LENGTH_SHORT).show();
                    }
                }
                else{
                    Toast.makeText(Profile.this, "NO INTERNET", Toast.LENGTH_SHORT).show();
                }
            }
        });


    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode== GALAARY_INTENT && resultCode== RESULT_OK && data!=null && data.getData()!=null) {
            filepath=data.getData();
            Picasso.with(this).load(filepath).into(img);
        }

    }
    private String getFileExtension(Uri uri) {
        ContentResolver cR = getContentResolver();
        MimeTypeMap mime = MimeTypeMap.getSingleton();
        return mime.getExtensionFromMimeType(cR.getType(uri));
    }

    private void uploadFile(){
        if (filepath != null) {
            pro.setVisibility(View.VISIBLE);
            final StorageReference fileReference = mStorageRef.child(System.currentTimeMillis()
                    + "." + getFileExtension(filepath));

            mUploadTask = fileReference.putFile(filepath)
                    .addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                        @Override
                        public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                            Handler handler = new Handler();
                            handler.postDelayed(new Runnable() {
                                @Override
                                public void run() {
                                    mprogressbar.setProgress(0);
                                }
                            }, 500);

                            fileReference.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
                                @Override
                                public void onSuccess(Uri uri) {
                                    // Log.d(TAG, "onSuccess: uri= "+ uri.toString());
                                    Toast.makeText(Profile.this, "Upload successful", Toast.LENGTH_LONG).show();
                                    demoRef.child("Image").setValue(uri.toString());
                                    demoRef.child("Multiplayer").setValue("Offline");

                                    pro.setVisibility(View.GONE);
                                    startActivity(new Intent(Profile.this, New_Game.class));
                                    finish();
                                }
                            });



                            // Toast.makeText(Profile.this, "Upload successful", Toast.LENGTH_LONG).show();
                            //  Upload upload = new Upload(mEditTextFileName.getText().toString().trim(),
                            //       taskSnapshot.getDownloadUrl().toString());
                            //String uploadId = mDatabaseRef.push().getKey();

                            // demoRef.child("Image").setValue(taskSnapshot.uri.toString());



                        }
                    })
                    .addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            Toast.makeText(Profile.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    })
                    .addOnProgressListener(new OnProgressListener<UploadTask.TaskSnapshot>() {
                        @Override
                        public void onProgress(UploadTask.TaskSnapshot taskSnapshot) {
                            double progress = (100.0 * taskSnapshot.getBytesTransferred() / taskSnapshot.getTotalByteCount());
                            mprogressbar.setProgress((int) progress);
                        }
                    });
        } else {
            Toast.makeText(this, "No file selected", Toast.LENGTH_SHORT).show();
        }

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
    public void onBackPressed() {
        final AlertDialog.Builder builder = new AlertDialog.Builder(Profile.this);
        builder.setMessage("You Can't Play this Game Without Entering Your Details\nAre You Sure You Want To Quit");
        builder.setCancelable(true);
        builder.setNegativeButton("NO", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finish();
            }
        });
        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }
}
