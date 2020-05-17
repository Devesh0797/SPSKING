package sps_king.devesh.com.spsking.Adapters;

import android.content.Context;
import android.content.Intent;
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

import com.squareup.picasso.Picasso;

import java.util.List;

import sps_king.devesh.com.spsking.New_Game;
import sps_king.devesh.com.spsking.R;
import sps_king.devesh.com.spsking.Room_Activity;
import sps_king.devesh.com.spsking.Models.UserDatabase;
import sps_king.devesh.com.spsking.Userlist_Activity;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.ImageViewHolder> {

    private Context mContext;
    private List<UserDatabase> mUploads;
    //private int i=1;



    public UserAdapter(Context context, List<UserDatabase> uploads) {
        mContext = context;
        mUploads = uploads;
    }

    @Override
    public ImageViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(mContext).inflate(R.layout.user_view, parent, false);
        return new ImageViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ImageViewHolder holder, int position) {
        final UserDatabase workersdatabase = mUploads.get(position);



            holder.textViewName.setText(workersdatabase.getName());
            holder.request.setText("Create Room");

            position=position+1;
            holder.number.setText(String.valueOf(position));

            Picasso.with(mContext).load(workersdatabase.getImage()).fit().centerCrop().into(holder.image);

            holder.request.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(mContext, "You clicked " + workersdatabase.getName(), Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(mContext, Room_Activity.class);
                    New_Game.player="player1";
                    Userlist_Activity.a1=1;
                    intent.putExtra("userID", workersdatabase.getUserID());
                    mContext.startActivity(intent);
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


            request.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    itemView.getContext().startActivity(new Intent(itemView.getContext(),Room_Activity.class));
                }
            });





        }
    }
}
