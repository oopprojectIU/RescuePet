package linhmil.oop.hcmiu.rescuepets;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class RulesActivity extends AppCompatActivity {

    private  int WelcomeInteval = 3000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rules);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent i= new Intent(RulesActivity.this,MenuActivity.class);
                startActivity(i);

                this.finish();            }

            private void finish() {
            }
        },WelcomeInteval);
    }
}
