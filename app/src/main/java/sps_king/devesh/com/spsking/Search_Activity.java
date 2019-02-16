package sps_king.devesh.com.spsking;

import android.app.Activity;
import android.media.effect.Effect;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class Search_Activity extends Activity {
    private EditText e1;
    private Button b1;
    private RecyclerView mRecyclerView;
    private SearchAdapter mAdapter;
    private DatabaseReference mDatabaseRef;
    private List<UserDatabase> mUploads;
    private ProgressBar mProgressCircle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_);

        b1=(Button)findViewById(R.id.btnopm);
        e1=(EditText)findViewById(R.id.et_devb);

        mRecyclerView = (RecyclerView)findViewById(R.id.tecvb);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(Search_Activity.this));

        // mProgressCircle = rootView.findViewById(R.id.pro);

        mUploads = new ArrayList<>();
        mProgressCircle = (ProgressBar) findViewById(R.id.pro_search);

        mDatabaseRef = FirebaseDatabase.getInstance().getReference("Users");

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String pin = e1.getText().toString().trim();
                mProgressCircle.setVisibility(View.VISIBLE);

                Query query = mDatabaseRef.orderByChild("name").equalTo(pin);


                query.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        for (DataSnapshot postSnapshot : dataSnapshot.getChildren()) {
                            UserDatabase workersdatabase = postSnapshot.getValue(UserDatabase.class);

                            if (workersdatabase.getUserID().equals(New_Game.USerID)) {

                            }
                            else {
                                String a = workersdatabase.getName().toLowerCase();
                                if(a.equals(pin)) {
                                    mUploads.add(workersdatabase);
                                }
                            }

                        }




                        mAdapter = new SearchAdapter(Search_Activity.this, mUploads);

                        mRecyclerView.setAdapter(mAdapter);
                        mProgressCircle.setVisibility(View.INVISIBLE);



                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {
                        Toast.makeText(Search_Activity.this, databaseError.getMessage(), Toast.LENGTH_SHORT).show();
                        mProgressCircle.setVisibility(View.INVISIBLE);


                    }
                });
            }
        });





    }
}
