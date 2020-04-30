package com.example.mad_new;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {

    private EditText editText5;
    private EditText editText6;
    private EditText editText7;
    private EditText editText8;
    private Button submit;
    DatabaseReference mad;
    BrighterBee brighterBee;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // setContentView(R.layout.activity_main);
        //setContentView(R.layout.activity_homepage);
        // setContentView(R.layout.activity_signup_page);
        // setContentView(R.layout.activity_login_page);
        // setContentView(R.layout.activity_input_marks);
        // setContentView(R.layout.activity_view_marks);
        //setContentView(R.layout.activity_class__marks__table);
        setContentView(R.layout.activity_himshi_1);
        //setContentView(R.layout.activity_himshi_2);


        editText5 = (EditText) findViewById(R.id.editText5);
        editText6 = (EditText)findViewById(R.id.editText6);
        editText7 = (EditText)findViewById(R.id.editText7);
        editText8 = (EditText)findViewById(R.id.editText8);
        submit = (Button) findViewById(R.id.submit);
        brighterBee = new BrighterBee();
        mad = FirebaseDatabase.getInstance().getReference().child("BrighterBee");

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
