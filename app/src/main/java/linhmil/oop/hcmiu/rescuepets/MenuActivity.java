package linhmil.oop.hcmiu.rescuepets;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;

public class MenuActivity extends Activity implements View.OnClickListener {

    Button bMenuPlay, bStore, bMenuSetting;
    MediaPlayer mySong,myClick;
    Button button1,button2,button3;
    Animation uptodown,downtoup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        bMenuPlay = (Button) findViewById(R.id.bMenuPlay);
        bMenuSetting = (Button) findViewById(R.id.bMenuSetting);
        bStore = (Button) findViewById(R.id.bStore);

        bMenuSetting.setOnClickListener(this);
        bMenuPlay.setOnClickListener(this);
        bStore.setOnClickListener(this);

        //sound
        mySong= MediaPlayer.create(MenuActivity.this,R.raw.song);
        myClick= MediaPlayer.create(MenuActivity.this,R.raw.click);
        //callButtono
        button1 = (Button) findViewById(R.id.bMenuPlay);
        button2 = (Button) findViewById(R.id.bStore);
        button3 = (Button) findViewById(R.id.bMenuSetting);
        //callAnimation

        uptodown= AnimationUtils.loadAnimation(this,R.anim.uptodown);
        downtoup= AnimationUtils.loadAnimation(this,R.anim.downtoup);

        button1.setAnimation(uptodown);
        button2.setAnimation(uptodown);
        button3.setAnimation(downtoup);

        //loopSound
        mySong.setLooping(true);
        mySong.start();


    }
    public void playIT(View view){
        myClick.start();
    }
    public void storeIT(View view){
        myClick.start();
    }
    public void settingIT(View view){
        myClick.start();
    }




    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.bMenuPlay:
                Intent iPlay = new Intent(this, PlayActivity.class);
                startActivity(iPlay);
                break;
            case R.id.bStore:
                //Intent iStore=new Intent(this, StoreActivity.class);
                //startActivity(iStore);
                break;
            //case R.id.bMenuSetting:
            //break;
        }
    }
}
