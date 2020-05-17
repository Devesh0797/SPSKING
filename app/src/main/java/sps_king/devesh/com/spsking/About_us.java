package sps_king.devesh.com.spsking;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.MediaController;

import java.util.Vector;

import sps_king.devesh.com.spsking.Adapters.VideoAdapter;

public class About_us extends AppCompatActivity {
  //  VideoView vid;
  //  private Button b1;

    RecyclerView recyclerView;
    Vector<YouTubeVideos> youtubeVideos = new Vector<YouTubeVideos>();

    public static MediaPlayer medi;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_us);


        //vid = (VideoView)findViewById(R.id.videoView);
        //b1=(Button)findViewById(R.id.btnPlay);
        New_Game.media.stop();
        if (medi!=null){
            if (medi.isPlaying()) {
                medi.stop();
                medi = null;
            }
    }

      // b1.setOnClickListener(new View.OnClickListener() {
         //  @Override
          //  public void onClick(View v) {
            //    playVideo();
         //   }
       // });

        recyclerView = (RecyclerView) findViewById(R.id.rec_vid);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager( new LinearLayoutManager(this));

        youtubeVideos.add( new YouTubeVideos("<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/63v5siMWGrs\" frameborder=\"0\" allowfullscreen></iframe>") );
      // youtubeVideos.add( new YouTubeVideos("<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/CGMHPdnXJc8\" frameborder=\"0\" allowfullscreen></iframe>") );

        VideoAdapter videoAdapter = new VideoAdapter(youtubeVideos);

        recyclerView.setAdapter(videoAdapter);

    }
    @Override
    public void onBackPressed(){
        startActivity(new Intent(About_us.this,New_Game.class));
        if(medi==null) {
            medi = MediaPlayer.create(About_us.this, R.raw.safe);
            if (!medi.isPlaying()) {
                medi.start();
                medi.setLooping(true);
            }
        }
        finish();
    }
    public void playVideo() {
        MediaController m = new MediaController(this);
       // vid.setMediaController(m);

      //  String path = "android.resource://"+getPackageName()+"/"+R.raw.vid;

       // Uri u = Uri.parse(path);

       // vid.setVideoURI(u);

       // vid.start();

    }
    @Override
    protected void onResume(){
        super.onResume();
        if(medi!=null)
          medi=null;
        }


}
