package com.example.mad_new;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private EditText editText5;
    private EditText editText6;
    private EditText editText7;
    private EditText editText8;
    private Button submit;
    DatabaseReference mad;
    BrighterBee brighterBee;
    ListView listView;
    ArrayList<String> arrayList = new ArrayList<>();
    ArrayAdapter<String> arrayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_himshi_1);

        editText5 = (EditText) findViewById(R.id.editText5);
        editText6 = (EditText)findViewById(R.id.editText6);
        editText7 = (EditText)findViewById(R.id.editText7);
        editText8 = (EditText)findViewById(R.id.editText8);
        submit = (Button) findViewById(R.id.submit);
        brighterBee = new BrighterBee();

         mad = FirebaseDatabase.getInstance().getReference().child("BrighterBee");
         listView=(ListView)findViewById(R.id.listView);
         arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,arrayList);
         listView.setAdapter(arrayAdapter);

                 mad.addChildEventListener(new ChildEventListener() {

                                    @Override
                                         public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

                                             String value = dataSnapshot.getValue(BrighterBee.class).toString();
                                             arrayList.add(value);
                                             arrayAdapter.notifyDataSetChanged();


                                         }

                                         @Override
                                         public void onChildChanged(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

                                         }

                                         @Override
                                         public void onChildRemoved(@NonNull DataSnapshot dataSnapshot) {

                                         }

                                         @Override
                                         public void onChildMoved(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

                                         }

                                         @Override
                                         public void onCancelled(@NonNull DatabaseError databaseError) {

                                         }
                                     });

         submit.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                openhimshi_2();

                int no = Integer.parseInt(editText5.getText().toString().trim());
                brighterBee.setSubject(editText7.getText().toString().trim());
                brighterBee.setDescription(editText8.getText().toString().trim());
                brighterBee.setDue_date(editText6.getText().toString().trim());
                brighterBee.setNo(no);

                mad.push().setValue(brighterBee);
                Toast.makeText(MainActivity.this, "data insert succesfully", Toast.LENGTH_LONG).show();

            }
        });
    }
    public void openhimshi_2(){
        Intent intent = new Intent(this,himshi_2.class);
        startActivity(intent);

    }
}
