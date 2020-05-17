package sps_king.devesh.com.spsking.Adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import sps_king.devesh.com.spsking.New_Game;
import sps_king.devesh.com.spsking.R;
import sps_king.devesh.com.spsking.Models.ResultDatabase;

public class ResultAdapter extends RecyclerView.Adapter<ResultAdapter.ImageViewHolder> {

    private Context mContext;
    private List<ResultDatabase> mUploads;




    public ResultAdapter(Context context, List<ResultDatabase> ResultDatabase) {
        mContext = context;
        mUploads = ResultDatabase;
    }

    @Override
    public ImageViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.result_view, parent, false);
        return new ImageViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ResultAdapter.ImageViewHolder holder, int position) {
        final ResultDatabase resultDatabase = mUploads.get(position);

        if(resultDatabase.getPlayer1().equals("1") && resultDatabase.getPlayer2().equals("1")){

            holder.I1.setImageResource(R.drawable.hand);
            holder.I2.setImageResource(R.drawable.hand);
            holder.textViewName.setText("DRAW");

        }
        else if(resultDatabase.getPlayer1().equals("1") && resultDatabase.getPlayer2().equals("2")){

            if(New_Game.player.equals("player1")){
                holder.I1.setImageResource(R.drawable.hand);
                holder.I2.setImageResource(R.drawable.hand1);
                holder.textViewName.setText("You Loose");


            }
            else if(New_Game.player.equals("player2")){
                holder.I2.setImageResource(R.drawable.hand);
                holder.I1.setImageResource(R.drawable.hand1);
                holder.textViewName.setText("YOU WIN");

            }
        }
        else if(resultDatabase.getPlayer1().equals("1") && resultDatabase.getPlayer2().equals("3")){

            if(New_Game.player.equals("player1")){
                holder.I1.setImageResource(R.drawable.hand);
                holder.I2.setImageResource(R.drawable.hand2);
                holder.textViewName.setText("You WIN");

            }
            else if(New_Game.player.equals("player2")){
                holder.I2.setImageResource(R.drawable.hand);
                holder.I1.setImageResource(R.drawable.hand2);
                holder.textViewName.setText("YOU LOOSE");

            }
        }
        else if(resultDatabase.getPlayer1().equals("2") && resultDatabase.getPlayer2().equals("1")){
            if(New_Game.player.equals("player1")){
                holder.I1.setImageResource(R.drawable.hand1);
                holder.I2.setImageResource(R.drawable.hand);
                holder.textViewName.setText("You WIN");

            }
            else if(New_Game.player.equals("player2")){
                holder.I2.setImageResource(R.drawable.hand1);
                holder.I1.setImageResource(R.drawable.hand);
                holder.textViewName.setText("YOU LOOSE");

            }
        }
        else if(resultDatabase.getPlayer1().equals("2") && resultDatabase.getPlayer2().equals("2")){
            holder.I1.setImageResource(R.drawable.hand1);
            holder.I2.setImageResource(R.drawable.hand1);
            holder.textViewName.setText("DRAW");

        }else if(resultDatabase.getPlayer1().equals("2") && resultDatabase.getPlayer2().equals("3")){

            if(New_Game.player.equals("player1")){
                holder.I1.setImageResource(R.drawable.hand1);
                holder.I2.setImageResource(R.drawable.hand2);
                holder.textViewName.setText("You Loose");

            }
            else if(New_Game.player.equals("player2")){
                holder.I2.setImageResource(R.drawable.hand1);
                holder.I1.setImageResource(R.drawable.hand2);
                holder.textViewName.setText("YOU WIN");

            }
        }
        else if(resultDatabase.getPlayer1().equals("3") && resultDatabase.getPlayer2().equals("1")){

            if(New_Game.player.equals("player1")){
                holder.I1.setImageResource(R.drawable.hand2);
                holder.I2.setImageResource(R.drawable.hand);
                holder.textViewName.setText("You Loose");

            }
            else if(New_Game.player.equals("player2")){
                holder.I2.setImageResource(R.drawable.hand2);
                holder.I1.setImageResource(R.drawable.hand);
                holder.textViewName.setText("YOU WIN");

            }
        }
        else if(resultDatabase.getPlayer1().equals("3") && resultDatabase.getPlayer2().equals("2")){

            if(New_Game.player.equals("player1")){
                holder.I1.setImageResource(R.drawable.hand2);
                holder.I2.setImageResource(R.drawable.hand1);
                holder.textViewName.setText("You WIN");

            }
            else if(New_Game.player.equals("player2")){
                holder.I2.setImageResource(R.drawable.hand2);
                holder.I1.setImageResource(R.drawable.hand1);
                holder.textViewName.setText("YOU LOOSE");

            }
        }
        else if(resultDatabase.getPlayer1().equals("3") && resultDatabase.getPlayer2().equals("3")){
            holder.I1.setImageResource(R.drawable.hand2);
            holder.I2.setImageResource(R.drawable.hand2);

                holder.textViewName.setText("DRAW");

        }
       // holder.textViewName.setText(resultDatabase.getPlayer1());
       // holder.textViewName.setText(resultDatabase.getPlayer2());



    }

    @Override
    public int getItemCount() {
        return mUploads.size();
    }

    public class ImageViewHolder extends RecyclerView.ViewHolder {
        public TextView textViewName;
        public ImageView I1,I2;

       // public RelativeLayout relativeLayout;


        public ImageViewHolder(final View itemView) {
            super(itemView);


            I1=itemView.findViewById(R.id.img_123);
            I2=itemView.findViewById(R.id.img_234);
            textViewName = itemView.findViewById(R.id.tv_quy);
            //relativeLayout=itemView.findViewById(R.id.Linear);


        }
    }
}
