package sps_king.devesh.com.spsking;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class Rules extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rules);
    }
    @Override
    public void onBackPressed(){
        startActivity(new Intent(Rules.this,New_Game.class));
        finish();
    }
}
