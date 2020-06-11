package com.abhinav.retrivedata;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.ViewGroup;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    DatabaseReference ref;
    FirebaseDatabase database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView=findViewById(R.id.recyclerview);
        recyclerView.setHasFixedSize(true);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        database=FirebaseDatabase.getInstance();
        ref=database.getReference("User");



    }

    @Override
    protected void onStart() {
        super.onStart();
        FirebaseRecyclerAdapter<User,Holder>firebaseRecyclerAdapter =
                new FirebaseRecyclerAdapter<User, Holder>(
                        User.class,
                        R.layout.data,
                        Holder.class,
                        ref
                ) {
                    @Override
                    protected void onBindViewHolder(@NonNull Holder holder, int position, @NonNull User model) {
                        holder.setView(getApplicationContext(),User.getname,User.getphone,User.getsypmtoms);

                    }

                    @NonNull
                    @Override
                    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                        return null;
                    }
                };
        recyclerView.setAdapter(firebaseRecyclerAdapter);
    }
}