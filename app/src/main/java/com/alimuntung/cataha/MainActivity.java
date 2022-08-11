package com.alimuntung.cataha;

import android.content.Intent;
import android.os.Handler;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.alimuntung.cataha.Presenter.AppActivity;
import com.alimuntung.cataha.auth.LoginActivity;

// Ikbar Laudza Alviansyah
// IF-7
// 10119260
public class MainActivity extends AppCompatActivity {
    private int waktu_loading=4000;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();

        setContentView(R.layout.activity_main);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if (!getPackageName().equals("com"+".al"+"imun"+"tung"+".ca"+"taha")){
                    System.exit(0);
                } else {
                Intent home=new Intent(MainActivity.this, LoginActivity.class);
                startActivity(home);
                finish();}

            }
        },waktu_loading);
    }
}