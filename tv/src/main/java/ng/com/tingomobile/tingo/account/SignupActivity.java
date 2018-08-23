package ng.com.tingomobile.tingo.account;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import ng.com.tingomobile.tingo.MainActivity;
import ng.com.tingomobile.tingo.R;
import ng.com.tingomobile.tingo.VerticalGridActivity;

public class SignupActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);



    }

    public void signup(View v){
        Intent intent = new Intent(SignupActivity.this, VerticalGridActivity.class);
        startActivity(intent);
        finish();


    }
}
