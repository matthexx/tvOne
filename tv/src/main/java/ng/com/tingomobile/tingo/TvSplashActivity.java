package ng.com.tingomobile.tingo;

import android.app.Activity;
import android.content.Intent;
import android.os.CountDownTimer;
import android.os.Bundle;

import ng.com.tingomobile.tingo.account.SignupActivity;

public class TvSplashActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tv_splash);


        new CountDownTimer(Config.SPLASH_TIME, 1000) {

            @Override
            public void onFinish() {
                Intent intent = new Intent(TvSplashActivity.this, SignupActivity.class);
                startActivity(intent);
                finish();
            }

            @Override
            public void onTick(long millisUntilFinished) {

            }
        }.start();

    }
}
