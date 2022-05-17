package com.example.school;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class EtudiantList extends AppCompatActivity {

    RecyclerView recyclerView;
    DatabaseReference database;
    MyAdapter myAdapter;
    ArrayList<Student> list;
    FloatingActionButton fadd;
    Button btnLogOut;
    ImageButton studentsList2;
    ImageButton teacherList2;
    ImageButton homeButton2;


    FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_etudiant_list);

        fadd = findViewById(R.id.fadd);
        recyclerView = findViewById(R.id.recyclerEtudiants);
        btnLogOut = findViewById(R.id.logOut);
        studentsList2 = findViewById(R.id.studentsList2);
        teacherList2 = findViewById(R.id.teacherList2);
        homeButton2 = findViewById(R.id.homeButton2);
        database = FirebaseDatabase.getInstance().getReference("Students");
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));


        mAuth = FirebaseAuth.getInstance();
        list = new ArrayList<>();
        myAdapter = new MyAdapter(this,list);
        recyclerView.setAdapter(myAdapter);

        btnLogOut.setOnClickListener(view ->{
            mAuth.signOut();
            startActivity(new Intent(getApplicationContext(), LoginActivity.class));
        });

        homeButton2.setOnClickListener(view ->{
            startActivity(new Intent(getApplicationContext(), MainActivity.class));
        });


        studentsList2.setOnClickListener(view ->{
            startActivity(new Intent(getApplicationContext(), EtudiantList.class));
        });
        teacherList2.setOnClickListener(view ->{
            startActivity(new Intent(getApplicationContext(), ProfList.class));
        });

        database.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                for (DataSnapshot dataSnapshot : snapshot.getChildren()){

                    Student student = dataSnapshot.getValue(Student.class);
                    list.add(student);
                }
                myAdapter.notifyDataSetChanged();

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        fadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addStudent();
            }
        });
    }
    public void addStudent(){
        startActivity(new Intent(getApplicationContext(), AddPerson.class));
    }
}