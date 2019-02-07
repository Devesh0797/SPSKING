package sps_king.devesh.com.spsking;

import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.VideoView;

import java.io.IOException;
import java.util.Vector;

public class About_us extends AppCompatActivity {
    VideoView vid;
    private Button b1;

    RecyclerView recyclerView;
    Vector<YouTubeVideos> youtubeVideos = new Vector<YouTubeVideos>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_us);


        vid = (VideoView)findViewById(R.id.videoView);
        b1=(Button)findViewById(R.id.btnPlay);
        New_Game.media.stop();

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playVideo();
            }
        });

        recyclerView = (RecyclerView) findViewById(R.id.rec_vid);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager( new LinearLayoutManager(this));

        youtubeVideos.add( new YouTubeVideos("<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/63v5siMWGrs\" frameborder=\"0\" allowfullscreen></iframe>") );
        youtubeVideos.add( new YouTubeVideos("<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/CGMHPdnXJc8\" frameborder=\"0\" allowfullscreen></iframe>") );

        VideoAdapter videoAdapter = new VideoAdapter(youtubeVideos);

        recyclerView.setAdapter(videoAdapter);

    }
    @Override
    public void onBackPressed(){
        startActivity(new Intent(About_us.this,New_Game.class));
        New_Game.media.start();
        finish();
    }
    public void playVideo() {
        MediaController m = new MediaController(this);
        vid.setMediaController(m);

        String path = "android.resource://"+getPackageName()+"/"+R.raw.vid;

        Uri u = Uri.parse(path);

        vid.setVideoURI(u);

        vid.start();

    }


}
