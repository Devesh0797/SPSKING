package sps_king.devesh.com.spsking;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class Friend_requestActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private RequestAdapter mAdapter;
    private DatabaseReference mDatabaseRef;
    private List<UserDatabase> mUploads;
    private ProgressBar mProgressCircle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_friend_request);


        mRecyclerView = (RecyclerView)findViewById(R.id.recta);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(Friend_requestActivity.this));

        // mProgressCircle = rootView.findViewById(R.id.pro);

        mUploads = new ArrayList<>();
        //mProgressCircle = (ProgressBar) findViewById(R.id.progressBar56);

        mDatabaseRef = FirebaseDatabase.getInstance().getReference("Users");

        //  Query query = mDatabaseRef.orderByChild("useremail").equalTo("worker@gmail.com");
        // query.addValueEventListener(valueEventListener);

        mDatabaseRef.child(New_Game.USerID).child("Request").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot postSnapshot : dataSnapshot.getChildren()) {
                    UserDatabase workersdatabase = postSnapshot.getValue(UserDatabase.class);
                    mUploads.add(workersdatabase);

                }


                mAdapter = new RequestAdapter(Friend_requestActivity.this, mUploads);

                mRecyclerView.setAdapter(mAdapter);
              //  mProgressCircle.setVisibility(View.INVISIBLE);



            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                Toast.makeText(Friend_requestActivity.this, databaseError.getMessage(), Toast.LENGTH_SHORT).show();
                mProgressCircle.setVisibility(View.INVISIBLE);
            }
        });







    }



}
