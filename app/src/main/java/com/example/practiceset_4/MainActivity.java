package com.example.practiceset_4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button yes;
    Button bno;
    Button next;
    public static final String EXTRA_NAME="com.example.practiceset_4.extra.NAME";
    private String[] questions = {"JAVA ia a person?", "JAVA was introduced in 1233?", "JAVA was created using Python",
            "JAVA has abstract classes?", "JAVA supports intefaces"};
    private boolean[] answers = {false, false, false, true, true};
     int score = 0;
    private int index = 0;
    TextView question;
    EditText Scoreboard;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        yes = findViewById(R.id.Yes);
        bno=findViewById(R.id.bno);
        question = findViewById(R.id.question);
        Scoreboard=findViewById(R.id.Scoreboard);
        next=findViewById(R.id.Next);
        question.setText(questions[0]);
        yes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                 if(index<=questions.length-1)
                 {
                     if (answers[index]) {
                         score += 10;
                         Scoreboard.setText("Your Current score is:"+score);
                     }
                 }
                 else
                 {
                     Toast.makeText(MainActivity.this, "QUIZ OVER", Toast.LENGTH_SHORT).show();
                     calculate(view);
                 }
                 index++;
                if(index<=questions.length-1)
                {
                    question.setText(questions[index]);
                    Toast.makeText(MainActivity.this, "Your score is:"+score, Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Toast.makeText(MainActivity.this, "QUIZ OVER", Toast.LENGTH_SHORT).show();
                    calculate(view);
                }


            }
        });
        bno.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(index<=questions.length-1)
                {
                    if (!answers[index]) {
                        score += 10;
                        Scoreboard.setText("Your Current score is:"+score);
                    }
                }
                else
                {
                    Toast.makeText(MainActivity.this, "QUIZ OVER", Toast.LENGTH_SHORT).show();
                    calculate(view);
                }
                index++;
                if(index<=questions.length-1)
                {
                    question.setText(questions[index]);
                    Toast.makeText(MainActivity.this, "Your score is:"+score, Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Toast.makeText(MainActivity.this, "QUIZ OVER", Toast.LENGTH_SHORT).show();
                    calculate(view);
                }


            }
        });



    }
    public void calculate(View v)
    {
        Toast.makeText(this, "QUIZ OVER", Toast.LENGTH_SHORT).show();
        Intent intent=new Intent(this,MainActivity2.class);
        String l=Scoreboard.getText().toString();
        intent.putExtra("ph",score);
        startActivity(intent);
    }

}

