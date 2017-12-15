package linhmil.oop.hcmiu.rescuepets;

import android.app.Activity;
import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

public class RulesActivity extends Activity {

    private ImageView im;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rules);

        im = (ImageView) findViewById(R.id.imRule);

        im.setImageResource(R.drawable.rules);
    }
}
