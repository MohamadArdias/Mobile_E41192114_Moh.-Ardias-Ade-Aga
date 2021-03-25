package com.example.ardias3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText to, Subject, Pesan;
    Button Submit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.latihan1);

        to = findViewById(R.id.To);
        Subject = findViewById(R.id.Subject);
        Pesan = findViewById(R.id.Pesan);
        Submit = findViewById(R.id.Send);

    }
}