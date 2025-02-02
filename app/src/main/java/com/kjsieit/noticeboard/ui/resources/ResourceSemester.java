package com.kjsieit.noticeboard.ui.resources;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.kjsieit.noticeboard.R;

public class ResourceSemester extends AppCompatActivity {

    Button btnSem1, btnSem2, btnSem3, btnSem4, btnSem5, btnSem6, btnSem7, btnSem8;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resource_semester);
        btnSem1 = findViewById(R.id.btnSem1);
        btnSem2 = findViewById(R.id.btnSem2);
        btnSem3 = findViewById(R.id.btnSem3);
        btnSem4 = findViewById(R.id.btnSem4);
        btnSem5 = findViewById(R.id.btnSem5);
        btnSem6 = findViewById(R.id.btnSem6);
        btnSem7 = findViewById(R.id.btnSem7);
        btnSem8 = findViewById(R.id.btnSem8);

        Intent i = getIntent();
        String dept = i.getStringExtra("dept");
        getSupportActionBar().setTitle("Select Semester - "+dept);

        btnSem1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(ResourceSemester.this, ResourceSubject.class);
                i.putExtra("dept", dept);
                i.putExtra("sem", "Sem 1");
                startActivity(i);
            }
        });

        btnSem2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(ResourceSemester.this, ResourceSubject.class);
                i.putExtra("dept", dept);
                i.putExtra("sem", "Sem 2");
                startActivity(i);
            }
        });

        btnSem3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(ResourceSemester.this, ResourceSubject.class);
                i.putExtra("dept", dept);
                i.putExtra("sem", "Sem 3");
                startActivity(i);
            }
        });

        btnSem4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(ResourceSemester.this, ResourceSubject.class);
                i.putExtra("dept", dept);
                i.putExtra("sem", "Sem 4");
                startActivity(i);
            }
        });

        btnSem5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(ResourceSemester.this, ResourceSubject.class);
                i.putExtra("dept", dept);
                i.putExtra("sem", "Sem 5");
                startActivity(i);
            }
        });

        btnSem6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(ResourceSemester.this, ResourceSubject.class);
                i.putExtra("dept", dept);
                i.putExtra("sem", "Sem 6");
                startActivity(i);
            }
        });

        btnSem7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(ResourceSemester.this, ResourceSubject.class);
                i.putExtra("dept", dept);
                i.putExtra("sem", "Sem 7");
                startActivity(i);
            }
        });

        btnSem8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(ResourceSemester.this, ResourceSubject.class);
                i.putExtra("dept", dept);
                i.putExtra("sem", "Sem 8");
                startActivity(i);
            }
        });
    }
}