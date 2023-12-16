package com.example.myapplication;// SecondaryActivity.java
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.button.MaterialButton;

public class SecondaryActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_secondary);

        EditText num1 =(EditText) findViewById(R.id.num1);
        EditText num2 =(EditText) findViewById(R.id.num2);
        Button sum = (Button) findViewById(R.id.sum);

        EditText url =(EditText) findViewById(R.id.url);
        Button link = (Button) findViewById(R.id.link);

        sum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!num1.getText().toString().equals("") && !num2.getText().toString().equals("")){
                    //correct
                    Integer sumnum = Integer.parseInt(num1.getText().toString()) + Integer.parseInt(num2.getText().toString());
                    Intent intent = new Intent(getApplicationContext(), SumActivity.class);
                    android.net.Uri data = android.net.Uri.parse(sumnum.toString());
                    intent.setData(data);
                    startActivity(intent);
                    //Toast.makeText(MainActivity.this,"LOGIN SUCCESSFUL",Toast.LENGTH_SHORT).show();
                }else
                    //incorrect
                    Toast.makeText(SecondaryActivity.this,"Error",Toast.LENGTH_SHORT).show();
            }
        });

        link.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = ((EditText) findViewById(R.id.url)).getText().toString();
                android.net.Uri uri = android.net.Uri.parse(url);
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });
    }
}
