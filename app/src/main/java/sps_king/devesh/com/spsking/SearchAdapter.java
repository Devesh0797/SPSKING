package sps_king.devesh.com.spsking;

import android.content.Context;
import android.content.Intent;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class SearchAdapter extends RecyclerView.Adapter<SearchAdapter.ImageViewHolder> {

    private Context mContext;
    private List<UserDatabase> mUploads;
    private int i=1;
    private DatabaseReference mDataBase;
    private DatabaseReference mDataBase1;
    private DatabaseReference mDataBase2;
    private DatabaseReference mDatabaseRef;
    private DatabaseReference mDatabaseRef1;




    public SearchAdapter(Context context, List<UserDatabase> uploads) {
        mContext = context;
        mUploads = uploads;
    }

    @Override
    public SearchAdapter.ImageViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(mContext).inflate(R.layout.user_view, parent, false);
        return new SearchAdapter.ImageViewHolder(v);
    }

    @Override
    public void onBindViewHolder(final SearchAdapter.ImageViewHolder holder, int position) {
        final UserDatabase workersdatabase = mUploads.get(position);
        holder.textViewName.setText(workersdatabase.getName());
        // holder.number.setText(++i);
        //i++;
        Picasso.with(mContext).load(workersdatabase.getImage()).fit().centerCrop().into(holder.image);


        mDatabaseRef=FirebaseDatabase.getInstance().getReference("Users").child(New_Game.USerID);
        mDatabaseRef1=FirebaseDatabase.getInstance().getReference("Users").child(New_Game.USerID);

        mDatabaseRef.child("FriendList").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot postSnapshot : dataSnapshot.getChildren()) {
                    FriendsDatabase workersdatabase1 = postSnapshot.getValue(FriendsDatabase.class);
                    String id=workersdatabase1.getName();
                    if(workersdatabase.getUserID().equals(workersdatabase1.getName())){
                        holder.request.setText("Friends");
                        holder.request.setEnabled(false);
                    }

                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                Toast.makeText(mContext, databaseError.getMessage(), Toast.LENGTH_SHORT).show();
              //  mProgressCircle.setVisibility(View.INVISIBLE);
            }
        });

        mDatabaseRef1.child("List").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot postSnapshot : dataSnapshot.getChildren()) {
                    FriendsDatabase workersdatabase1 = postSnapshot.getValue(FriendsDatabase.class);
                    String id=workersdatabase1.getName();
                    if(workersdatabase.getUserID().equals(workersdatabase1.getName())){
                        holder.request.setText("Cancel Request");
                        holder.request.setEnabled(false);
                    }

                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                Toast.makeText(mContext, databaseError.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });




        holder.request.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



                    String userid = workersdatabase.getUserID();
                    mDataBase = FirebaseDatabase.getInstance().getReference("Users").child(userid).child("Request").child(New_Game.USerID);

                    UserDatabase artist = new UserDatabase(New_Game.Username, New_Game.USerID, New_Game.USerAge);

                    mDataBase.setValue(artist);
                    mDataBase.child("Image").setValue(New_Game.imageurl);

                    Toast.makeText(mContext, "You clicked " + workersdatabase.getUserID(), Toast.LENGTH_SHORT).show();
                   // String id=mDataBase1.push().getKey();
                mDataBase1 = FirebaseDatabase.getInstance().getReference("Users").child(New_Game.USerID).child("List").child(userid);
                mDataBase1.child("Name").setValue(userid);

                mDataBase2 = FirebaseDatabase.getInstance().getReference("Users").child(userid).child("List").child(New_Game.USerID);
                mDataBase2.child("Name").setValue(New_Game.USerID);

                holder.request.setText("Cancel Request");
                    send(workersdatabase.getUserID(),"WELCOME TO MY APP");
                    ((Search_Activity)mContext).finish();






            }
        });


    }

    public  String send(String to,  String body) {
        try {

            final String apiKey = "AIzaSyBsY_tfCQjUSWEWuNNwQdC1Vtb0szzz";
            URL url = new URL("https://fcm.googleapis.com/fcm/send");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setDoOutput(true);
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-Type", "application/json");
            conn.setRequestProperty("Authorization", "key=" + apiKey);
            conn.setDoOutput(true);
            JSONObject message = new JSONObject();
            message.put("to", to);
            message.put("priority", "high");

            JSONObject notification = new JSONObject();
            // notification.put("title", title);
            notification.put("body", body);
            message.put("data", notification);
            OutputStream os = conn.getOutputStream();
            os.write(message.toString().getBytes());
            os.flush();
            os.close();

            int responseCode = conn.getResponseCode();
            System.out.println("\nSending 'POST' request to URL : " + url);
            System.out.println("Post parameters : " + message.toString());
            System.out.println("Response Code : " + responseCode);
            System.out.println("Response Code : " + conn.getResponseMessage());

            BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();

            // print result
            System.out.println(response.toString());
            return response.toString();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "error";
    }


    @Override
    public int getItemCount() {
        return mUploads.size();
    }

    public class ImageViewHolder extends RecyclerView.ViewHolder {
        public TextView textViewName,number;
        public ImageView image;
        public Button request;
        public RelativeLayout relativeLayout;
        public CardView card;




        public ImageViewHolder(final View itemView) {
            super(itemView);


            textViewName = itemView.findViewById(R.id.textView67);
            number = itemView.findViewById(R.id.tv_no);
            image= itemView.findViewById(R.id.iv_klj);
            request = itemView.findViewById(R.id.btn_assxc);
            relativeLayout=itemView.findViewById(R.id.Linear);
            card=itemView.findViewById(R.id.card_123);
            mDataBase=FirebaseDatabase.getInstance().getReference("Users").child(New_Game.USerID);



            request.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                   // itemView.getContext().startActivity(new Intent(itemView.getContext(),Room_Activity.class));
                }
            });





        }
    }
}
