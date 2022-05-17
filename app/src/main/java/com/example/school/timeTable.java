package com.example.school;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Intent;
import android.graphics.pdf.PdfDocument;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageButton;

import com.github.barteksc.pdfviewer.PDFView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class timeTable extends AppCompatActivity {

    Button btnLogOut;
    ImageButton studentsList3;
    ImageButton teacherList3;
    ImageButton homeButton3;
    PDFView pdfView;

    FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.timetable);

        btnLogOut = findViewById(R.id.logOut3);
        studentsList3 = findViewById(R.id.studentsList3);
        teacherList3 = findViewById(R.id.teacherList3);
        homeButton3 = findViewById(R.id.homeButton3);
        pdfView = findViewById(R.id.pdfView);

        pdfView.fromAsset("timetable.pdf").load();

        mAuth = FirebaseAuth.getInstance();


        btnLogOut.setOnClickListener(view ->{
            mAuth.signOut();
            startActivity(new Intent(getApplicationContext(), LoginActivity.class));
        });

        homeButton3.setOnClickListener(view ->{
            startActivity(new Intent(getApplicationContext(), MainActivity.class));
        });


        studentsList3.setOnClickListener(view ->{
            startActivity(new Intent(getApplicationContext(), EtudiantList.class));
        });
        teacherList3.setOnClickListener(view ->{
            startActivity(new Intent(getApplicationContext(), ProfList.class));
        });
    }
}