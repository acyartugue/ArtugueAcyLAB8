package acy.artugue.com.artugueacylab8;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.FirebaseApp;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {

    private FirebaseDatabase firebaseDB;

    private static final String TAG = "MainActivity";
    private EditText eName, eAge, eGen;
    private Button btnSearch,btnSave;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        eName = (EditText) findViewById(R.id.Name);
        eAge = (EditText) findViewById(R.id.Age);
        eGen = (EditText) findViewById(R.id.Gender);
        btnSearch = (Button) findViewById(R.id.btnSearch);
        btnSave = (Button) findViewById(R.id.btnSave);


    }


}
