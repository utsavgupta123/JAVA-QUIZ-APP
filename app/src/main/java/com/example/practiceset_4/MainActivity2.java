package com.example.practiceset_4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {
    TextView finaltext;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        finaltext=findViewById(R.id.finalscore);
        Intent intent=getIntent();
        int k=intent.getIntExtra("ph",0);
        finaltext.setText("Your score is:"+k);
    }
}