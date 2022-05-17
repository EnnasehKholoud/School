package com.example.school;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


public class MainActivity extends AppCompatActivity {

    //    Button btnLogOut;
    Button btnLogOut;
    CardView listStudentsView;
    CardView listTeachersView;
    CardView timeTable;
    ImageButton studentsList1;
    ImageButton teacherList1;
    FirebaseAuth mAuth;
    FloatingActionButton fadd;
    DatabaseReference databaseReference;
    ImageButton homeButton1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnLogOut = findViewById(R.id.logOut);
        listStudentsView = findViewById(R.id.listStudentsView);
        listTeachersView = findViewById(R.id.listTeachersView);
        timeTable = findViewById(R.id.timeTable);
        studentsList1 = findViewById(R.id.studentsList1);
        teacherList1 = findViewById(R.id.teacherList1);
        homeButton1 = findViewById(R.id.homeButton1);


        mAuth = FirebaseAuth.getInstance();

        btnLogOut.setOnClickListener(view ->{
            mAuth.signOut();
            startActivity(new Intent(getApplicationContext(), LoginActivity.class));
        });

        homeButton1.setOnClickListener(view ->{
            startActivity(new Intent(getApplicationContext(), MainActivity.class));
        });

        studentsList1.setOnClickListener(view ->{
            startActivity(new Intent(getApplicationContext(), EtudiantList.class));
        });

        teacherList1.setOnClickListener(view ->{
            startActivity(new Intent(getApplicationContext(), ProfList.class));
        });

        listStudentsView.setOnClickListener(view ->{
            startActivity(new Intent(getApplicationContext(), EtudiantList.class));
        });

        listTeachersView.setOnClickListener(view ->{
            startActivity(new Intent(getApplicationContext(), ProfList.class));
        });
        timeTable.setOnClickListener(view -> {
            startActivity(new Intent(getApplicationContext(), timeTable.class));
        });





        FirebaseUser currentFirebaseUser = FirebaseAuth.getInstance().getCurrentUser() ;

        databaseReference= FirebaseDatabase.getInstance().getReference();
    }

    @Override
    protected void onStart() {
        super.onStart();
        FirebaseUser user = mAuth.getCurrentUser();
        if (user == null){
            startActivity(new Intent(MainActivity.this, LoginActivity.class));
        }
    }
}