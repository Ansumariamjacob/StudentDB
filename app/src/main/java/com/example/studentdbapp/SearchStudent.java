package com.example.studentdbapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class SearchStudent extends AppCompatActivity {
    EditText ed1,ed2,ed3,ed4;
    AppCompatButton b1,b2;
    String getAdno,getName,getRolno,getclg;
    DatabaseHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_student);
        dbHelper=new DatabaseHelper(this);
        dbHelper.getWritableDatabase();
        ed1=(EditText) findViewById(R.id.adno);
        ed2=(EditText) findViewById(R.id.name);
        ed3=(EditText) findViewById(R.id.rolno);
        ed4=(EditText) findViewById(R.id.clg);
        b1=(AppCompatButton) findViewById(R.id.search);
        b2=(AppCompatButton) findViewById(R.id.bckm);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getAdno=ed1.getText().toString();
                Cursor c= dbHelper.Search(getAdno);
                if(c.getCount()==0)
                {
                    ed2.setText("");
                    ed3.setText("");
                    ed4.setText("");
                    Toast.makeText(getApplicationContext(), "Invalid admission number", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    while (c.moveToNext())
                    {
                        getName=c.getString(1);
                        getRolno=c.getString(3);
                        getclg=c.getString(4);

                    }
                    ed2.setText(getName);
                    ed3.setText(getRolno);
                    ed4.setText(getclg);
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