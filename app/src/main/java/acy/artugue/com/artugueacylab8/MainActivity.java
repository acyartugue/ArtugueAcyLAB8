package acy.artugue.com.artugueacylab8;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputType;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity implements ValueEventListener{

    private static final String TAG = "MainActivity";

    private Button btnSave, btnSearch;
    private EditText newName,newAge,newGen;


    private FirebaseDatabase firebaseDB = FirebaseDatabase.getInstance();
    private DatabaseReference myRef = firebaseDB.getReference();
    private DatabaseReference nameRef = myRef.child("Name");
    private DatabaseReference ageRef = myRef.child("Age");
    private DatabaseReference genRef = myRef.child("Gender");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        newName = (EditText)findViewById(R.id.fName);
        newAge = (EditText)findViewById(R.id.Age);
        newGen = (EditText)findViewById(R.id.Gender);
        btnSave = (Button)findViewById(R.id.btnSave);
        btnSearch = (Button)findViewById(R.id.btnSearch);



        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                Object value = dataSnapshot.getValue();
                Log.d(TAG, "Value is: " + value);
            }

            @Override
            public void onCancelled(DatabaseError error) {
                Log.w(TAG, "Failed to read value.", error.toException());
            }
        });

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG, "onClick: Adding object to database.");
                String newPerson = newName.getText().toString();
                if(!newPerson.equals("")){

                    myRef.child("Name").child("Age").child("Gender").setValue("true");
                    toastMessage("Adding " + newPerson + " to database...");
                    //newPerson.setText("");
                }
            }
        });

    }

    private void toastMessage(String s) {
        Toast.makeText(this, s, Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onStart(){
        super.onStart();
        myRef.addValueEventListener(this);
        nameRef.addValueEventListener(this);
        ageRef.addValueEventListener(this);
        genRef.addValueEventListener(this);
    }



    public void btnSave(View view) {



    }

    @Override
    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

    }

    @Override
    public void onCancelled(@NonNull DatabaseError databaseError) {

    }
}
