package sps_king.devesh.com.spsking;

import android.content.Context;
import android.content.Intent;
import android.nfc.Tag;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
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

import java.util.List;

public class RequestAdapter extends RecyclerView.Adapter<RequestAdapter.ImageViewHolder> {
    private Context mContext;
    private List<UserDatabase> mUploads;
    private DatabaseReference mDataBase;
    private DatabaseReference mDataBase1;
    private DatabaseReference mDataBase2;
    private DatabaseReference mDataBase3;
    private DatabaseReference mDataBase4;
    private DatabaseReference mDataBase5;
    private DatabaseReference mDataBase6;
    //private int i=1;



    public RequestAdapter(Context context, List<UserDatabase> uploads) {
        mContext = context;
        mUploads = uploads;
    }

    @Override
    public RequestAdapter.ImageViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(mContext).inflate(R.layout.user_view, parent, false);
        return new RequestAdapter.ImageViewHolder(v);
    }

    @Override
    public void onBindViewHolder(final RequestAdapter.ImageViewHolder holder, int position) {
        final UserDatabase workersdatabase = mUploads.get(position);

            holder.textViewName.setText(workersdatabase.getName());
            holder.request.setText("Accept Request");

            holder.number.setText(String.valueOf(position));

            Picasso.with(mContext).load(workersdatabase.getImage()).fit().centerCrop().into(holder.image);

            holder.request.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mDataBase = FirebaseDatabase.getInstance().getReference("Users").child(New_Game.USerID).child("Friends").child(workersdatabase.getUserID());
                    UserDatabase artist = new UserDatabase(workersdatabase.getName(), workersdatabase.getUserID(), workersdatabase.getAge());
                    String userid=workersdatabase.getUserID();

                    mDataBase.setValue(artist);
                    mDataBase.child("Image").setValue( workersdatabase.getImage());



                    mDataBase1 = FirebaseDatabase.getInstance().getReference("Users").child(New_Game.USerID).child("Request").child(workersdatabase.getUserID());
                    mDataBase1.removeValue();

                    mDataBase2 = FirebaseDatabase.getInstance().getReference("Users").child(workersdatabase.getUserID()).child("Friends").child(New_Game.USerID );
                    UserDatabase artist1 = new UserDatabase(New_Game.Username, New_Game.USerID, New_Game.USerAge);

                    mDataBase2.setValue(artist1);
                    mDataBase2.child("Image").setValue( New_Game.imageurl);

                    mDataBase3 = FirebaseDatabase.getInstance().getReference("Users").child(New_Game.USerID).child("List").child(userid);
                    mDataBase3.removeValue();

                    mDataBase4 = FirebaseDatabase.getInstance().getReference("Users").child(userid).child("List").child(New_Game.USerID);
                    mDataBase4.removeValue();

                    mDataBase5 = FirebaseDatabase.getInstance().getReference("Users").child(New_Game.USerID).child("FriendList").child(userid);
                    mDataBase5.child("Name").setValue(userid);

                    mDataBase6 = FirebaseDatabase.getInstance().getReference("Users").child(userid).child("FriendList").child(New_Game.USerID);
                    mDataBase6.child("Name").setValue(New_Game.USerID);



                    holder.card.setVisibility(View.GONE);
                    ((Friend_requestActivity)mContext).finish();
                }
            });


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




            relativeLayout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    itemView.getContext().startActivity(new Intent(itemView.getContext(),Room_Activity.class));
                }
            });





        }
    }

}
