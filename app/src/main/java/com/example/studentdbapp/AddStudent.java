package com.example.studentdbapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class AddStudent extends AppCompatActivity {
    EditText ed1,ed2,ed3,ed4;
    AppCompatButton b1,b2;
    String getName,getAddNo,getRollNo,getCollege;
    DatabaseHelper dbHelper;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_student);
        dbHelper=new DatabaseHelper(this);
        dbHelper.getWritableDatabase();
        ed1=(EditText) findViewById(R.id.name);
        ed2=(EditText) findViewById(R.id.adno);
        ed3=(EditText) findViewById(R.id.rolno);
        ed4=(EditText) findViewById(R.id.clg);
        b1=(AppCompatButton) findViewById(R.id.sub);
        b2=(AppCompatButton) findViewById(R.id.bckm);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getName=ed1.getText().toString();
                getRollNo=ed3.getText().toString();
                getAddNo=ed2.getText().toString();
                getCollege=ed4.getText().toString();
              boolean result=dbHelper.insertValue(getName,getRollNo,getAddNo,getCollege);
              if(result==true)
              {
                  ed1.setText("");
                  ed2.setText("");
                  ed3.setText("");
                  ed4.setText("");
                  Toast.makeText(getApplicationContext(),"Successfully inserted", Toast.LENGTH_SHORT).show();
              }
              else
              {
                  Toast.makeText(getApplicationContext(),"Failed to insert", Toast.LENGTH_SHORT).show();

              }

            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(getApplicationContext(),MainActivity.class);
                startActivity(i);
            }
        });
    }
}