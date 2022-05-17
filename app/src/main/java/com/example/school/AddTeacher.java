package com.example.school;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class AddTeacher extends AppCompatActivity {

    EditText addName;
    EditText addLastName;
    EditText addTel;
    Button Insert;

    DatabaseReference studentDbRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_person);

        addName = findViewById(R.id.addName);
        addLastName = findViewById(R.id.addLastName);
        addTel = findViewById(R.id.addTel);
        Insert = findViewById(R.id.Insert);

        studentDbRef = FirebaseDatabase.getInstance().getReference().child("Teachers");

        Insert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                insertStudentData();
            }
        });
    }

    private void insertStudentData(){

        String firstName = addName.getText().toString();
        String lastname = addLastName.getText().toString();
        String telephone = addTel.getText().toString();

        Students students = new Students(firstName , lastname, telephone);
        studentDbRef.push().setValue(students);
        Toast.makeText(AddTeacher.this, "Data Inserted", Toast.LENGTH_SHORT).show();
        startActivity(new Intent(getApplicationContext(), ProfList.class));

    };
}